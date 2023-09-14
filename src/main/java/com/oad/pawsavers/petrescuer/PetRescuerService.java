package com.oad.pawsavers.petrescuer;

import com.oad.pawsavers.common.constants.UserTypes;
import com.oad.pawsavers.user.UserDTO;
import com.oad.pawsavers.user.UserService;
import com.oad.pawsavers.usertype.UserTypeDTO;
import com.oad.pawsavers.usertype.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetRescuerService {

    @Autowired
    private PetRescuerRepository petRescuerRepository;

    @Autowired
    private PetRescuerMapper petRescuerMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserTypeService userTypeService;

    public List<PetRescuerDTO> getAllPetRescuers() {
        return petRescuerMapper.toPetRescuerDTOList(petRescuerRepository.findAll());
    }

    public Optional<PetRescuerDTO> getPetRescuerById(long id) {
        return petRescuerRepository.findById(id)
                .map(petRescuer -> petRescuerMapper.toPetRescuerDTO(petRescuer));
    }

    public PetRescuer savePetRescuer(PetRescuerDTO petRescuerDTO) {
        try {
            Optional<UserDTO> user = userService.getUserById(petRescuerDTO.getUserId());
            if (user.isPresent()) {
                Optional<UserTypeDTO> userType = userTypeService.getUserTypeById(user.get().getUserTypeId());
                if (userType.isPresent() && UserTypes.PET_RESCUER.toString().equals(userType.get().getTypeOfUser())) {
                    return petRescuerRepository.save(petRescuerMapper.toPetRescuerEntity(petRescuerDTO));
                } else {
                    throw new RuntimeException("User type doesn't exist or isn't " + UserTypes.PET_RESCUER + ".");
                }
            } else {
                throw new RuntimeException("User: Is already a Pet Rescuer / Not registered to be Pet Rescuer / No exists.");
            }
        } catch (Error error) {
            System.out.println("Error: " + error.getMessage());
            return null;
        }
    }

    public boolean deletePetRescuerById(long id) {
        return getPetRescuerById(id)
                .map(petRescuerDTO -> {
                    petRescuerRepository.deleteById(petRescuerDTO.getUserId());
                    return true;
                })
                .orElse(false);
    }

    public boolean updatePetRescuer(long id, PetRescuerDTO petRescuerDTO) {
        Optional<PetRescuer> petRescuer = petRescuerRepository.findById(id);
        if (petRescuer.isPresent()) {
            PetRescuer petRescuerToUpdate = petRescuer.get();
            petRescuerToUpdate.setRescuerLevel(petRescuerDTO.getRescuerLevel());
            petRescuerToUpdate.setRescueArea(petRescuerDTO.getRescueArea());
            petRescuerRepository.save(petRescuerToUpdate);
            return true;
        } else {
            return false;
        }
    }
}
