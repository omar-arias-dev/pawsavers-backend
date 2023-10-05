package com.oad.pawsavers.pet;

import com.oad.pawsavers.color.Color;
import com.oad.pawsavers.color.ColorRepository;
import com.oad.pawsavers.common.constants.PetPersonality;
import com.oad.pawsavers.common.constants.PetSize;
import com.oad.pawsavers.common.constants.PetStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetMapper petMapper;

    @Autowired
    private PetDetailsMapper petDetailsMapper;

    @Autowired
    private ColorRepository colorRepository;

    public List<PetDTO> getAllPets() {
        return petMapper.toPetDTOList(petRepository.findAll());
    }

    public Optional<PetDTO> getPetById(long id) {
        return petRepository.findById(id)
                .map(pet -> petMapper.toPetDTO(pet));
    }

    public Optional<PetDetailsDTO> getPetWithDetailsById(long id) {
        return petRepository.findById(id)
                .map(pet -> petDetailsMapper.toPetDetailsDTO(pet));
    }

    public Pet createPet(PetDTO petDTO) {
        return petRepository.save(petMapper.toPetEntity(petDTO));
    }

    public boolean updatePet(long petId, PetDTO petDTO) {
        Optional<Pet> pet = petRepository.findById(petId);
        if (pet.isPresent()) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            Pet petToUpdate = pet.get();
            petToUpdate.setName(petDTO.getPetName());
            petToUpdate.setAge(petDTO.getPetAge());
            petToUpdate.setSize(PetSize.valueOf(petDTO.getPetSize()));
            petToUpdate.setPersonality(PetPersonality.valueOf(petDTO.getPetPersonality()));
            petToUpdate.setStatus(PetStatus.valueOf(petDTO.getPetStatus()));
            petToUpdate.setRescueDate(LocalDate.parse(petDTO.getRescueDate(), formatter));
            petToUpdate.setRescueHistory(petDTO.getRescueHistory());
            petToUpdate.setAvatar(petDTO.getPetAvatar());
            petToUpdate.setSpecialFeatures(petDTO.getSpecialFeatures());
            petRepository.save(petToUpdate);
            return true;
        } else {
            System.out.println("Pet not found.");
            return false;
        }
    }

    public boolean deletePetById(long petId) {
        if (petRepository.existsById(petId)) {
            petRepository.deleteById(petId);
            return true;
        } else {
            System.out.println("Pet not exists");
            return false;
        }
    }

    public List<PetDTO> getPetsByHalfName(String halfName) {
        return petMapper.toPetDTOList(petRepository.findByNameContains(halfName));
    }

    public List<PetDTO> getPetsByAge(int age) {
        return petMapper.toPetDTOList(petRepository.findByAgeOrderByNameAsc(age));
    }

    public List<PetDTO> getPetsBySize(PetSize petSize) {
        return petMapper.toPetDTOList(petRepository.findBySizeOrderByNameAsc(petSize));
    }

    public List<PetDTO> getPetsByStatus(PetStatus status) {
        return petMapper.toPetDTOList(petRepository.findByStatusOrderByNameAsc(status));
    }

    public List<PetDTO> getPetsByRescueDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return petMapper.toPetDTOList(petRepository
                .findByRescueDateOrderByNameAsc(LocalDate.parse(date, formatter)));
    }

    public PetDetailsDTO setPetColorsByPetId(long petId, List<Color> colorList) {
        Optional<Pet> optionalPet = petRepository.findById(petId);
        if (optionalPet.isPresent()) {
            Pet petToUpdate = optionalPet.get();
            boolean colorsExist = colorList.stream()
                    .allMatch(color -> colorRepository.existsColorByNameAndHex(color.getName(), color.getHex()));
            if (colorsExist) {
                petToUpdate.setColorList(colorList);
                return petDetailsMapper.toPetDetailsDTO(petRepository.save(petToUpdate));
            } else {
                System.out.println("Color(s) not exist");
                return null;
            }
        } else {
            System.out.println("Pet not exist.");
            return null;
        }
    }
}
