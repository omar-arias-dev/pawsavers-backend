package com.oad.pawsavers.usertype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTypeService {

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Autowired
    private  UserTypeMapper userTypeMapper;

    public List<UserTypeDTO> getAllUserTypes() {
        List<UserType> userTypeList = userTypeRepository.findAll();
        return userTypeMapper.toUserTypeDTOList(userTypeList);
    }

    public Optional<UserTypeDTO> getUserTypeById(Long id) {
        return userTypeRepository.findById(id)
                .map(userTypeMapper::toUserTypeDTO);
    }

    public UserType createUserType(UserTypeDTO userTypeDTO) {
        return userTypeRepository.save(userTypeMapper.toUserTypeEntity(userTypeDTO));
    }

    public boolean deleteUserTypeById(Long id) {
        return getUserTypeById(id).map(userType -> {
            userTypeRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
