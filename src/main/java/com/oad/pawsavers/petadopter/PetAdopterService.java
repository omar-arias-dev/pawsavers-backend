package com.oad.pawsavers.petadopter;

import com.oad.pawsavers.common.constants.MaritalStatus;
import com.oad.pawsavers.common.constants.Sizes;
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
public class PetAdopterService {

    @Autowired
    private PetAdopterRepository petAdopterRepository;

    @Autowired
    private PetAdopterMapper petAdopterMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserTypeService userTypeService;

    public List<PetAdopterDTO> getAllPetAdopters() {
        return petAdopterMapper.toPetAdopterDTOList(petAdopterRepository.findAll());
    }

    public Optional<PetAdopterDTO> getPetAdopterById(long id) {
        return petAdopterRepository.findById(id)
                .map(petAdopterMapper::toPetAdopterDTO);
    }

    public PetAdopter createPetAdopter(PetAdopterDTO petAdopterDTO) {
        try {
            Optional<UserDTO> user = userService.getUserById(petAdopterDTO.getPetAdopterId());
            if (user.isPresent()) {
                Optional<UserTypeDTO> userTypeDTO = userTypeService.getUserTypeById(user.get().getUserTypeId());
                if (userTypeDTO.isPresent() && UserTypes.PET_ADOPTER.toString().equals(userTypeDTO.get().getTypeOfUser())) {
                    return petAdopterRepository.save(petAdopterMapper.toPetAdopterEntity(petAdopterDTO));
                } else {
                    throw new RuntimeException("User type doesn't exist or isn't " + UserTypes.PET_ADOPTER + ".");
                }
            } else {
                throw new RuntimeException("User: Is already a " + UserTypes.PET_ADOPTER + " / Not registered to be " + UserTypes.PET_ADOPTER + " / No exists.");
            }
        } catch (Error error) {
            System.out.println("Error: " + error);
            return null;
        }
    }

    public boolean deletePetAdopterById(long id) {
        return getPetAdopterById(id)
                .map(petAdopterDTO -> {
                    petAdopterRepository.deleteById(petAdopterDTO.getPetAdopterId());
                    return true;
                }).orElse(false);
    }

    public boolean updatePetAdopterById(long id, PetAdopterDTO petAdopterDTO) {
        Optional<PetAdopter> petAdopter = petAdopterRepository.findById(id);
        if (petAdopter.isPresent()) {
            PetAdopter petAdopterToUpdate = petAdopter.get();
            petAdopterToUpdate.setNumberOfPets(petAdopterDTO.getPetsNumber());
            petAdopterToUpdate.setAvatar(petAdopterDTO.getPetAdopterAvatar());
            petAdopterToUpdate.setHomeSize(Sizes.valueOf(petAdopterDTO.getSizeOfHome()));
            petAdopterToUpdate.setMaritalStatus(MaritalStatus.valueOf(petAdopterDTO.getMaritalStatus()));
            petAdopterToUpdate.setComments(petAdopterDTO.getCommentsAboutPetAdopter());
            petAdopterRepository.save(petAdopterToUpdate);
            return true;
        } else {
            return false;
        }
    }
}
