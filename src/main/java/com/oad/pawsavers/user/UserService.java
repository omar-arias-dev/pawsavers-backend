package com.oad.pawsavers.user;

import com.oad.pawsavers.common.constants.Gender;
import com.oad.pawsavers.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public List<UserDTO> getAllUsers() {
        return userMapper.toUserDTOList(userRepository.findAll());
    }

    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toUserDTO);
    }

    public User saveUser(UserDTO userDTO) {
        return userRepository.save(userMapper.toUserEntity(userDTO));
    }

    public boolean deleteUserById(Long id) {
        return getUserById(id).map(user -> {
            userRepository.deleteById(id);
            return true;
        }).orElse(false);
    }

    public boolean updateUserById(long id, UserDTO updatedUserDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
            UserType toGetIdUserType = new UserType();
            toGetIdUserType.setId(updatedUserDTO.getUserTypeId());
            User user = optionalUser.get();
            user.setName(updatedUserDTO.getUserName());
            user.setLastname(updatedUserDTO.getUserLastname());
            user.setSecondLastname(updatedUserDTO.getUserSecondLastname());
            user.setCurp(updatedUserDTO.getCurp());
            user.setGender(Gender.valueOf(updatedUserDTO.getUserGender()));
            user.setCellphoneNumber(updatedUserDTO.getCellphoneNumber());
            user.setHouseNumber(updatedUserDTO.getHouseNumber());
            user.setPostalCode(updatedUserDTO.getPostalCode());
            user.setRegistrationDate(LocalDateTime.parse(updatedUserDTO.getRegistrationDate(), formatter));
            user.setOccupation(updatedUserDTO.getUserOccupation());
            user.setUserType(toGetIdUserType);
            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }
}
