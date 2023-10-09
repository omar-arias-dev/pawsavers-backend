package com.oad.pawsavers.pet;

import com.oad.pawsavers.breed.*;
import com.oad.pawsavers.color.Color;
import com.oad.pawsavers.color.ColorRepository;
import com.oad.pawsavers.common.constants.PetPersonality;
import com.oad.pawsavers.common.constants.PetSize;
import com.oad.pawsavers.common.constants.PetStatus;
import com.oad.pawsavers.specie.SpecieRepository;
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

    @Autowired
    private SpecieRepository specieRepository;

    @Autowired
    private BreedRepository breedRepository;

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
        if (
                specieRepository.existsById(petDTO.getSpecieId()) &&
                breedRepository.existsByIdAndSpecieId(petDTO.getBreedId(), petDTO.getSpecieId())
        ) {
            return petRepository.save(petMapper.toPetEntity(petDTO));
        } else {
            System.out.println("New Dog's specie or breed not exist, or breed is no part of specie.");
            return null;
        }
    }

    public boolean updatePet(long petId, PetDTO petDTO) {
        Optional<Pet> pet = petRepository.findById(petId);
        if (
                pet.isPresent() &&
                specieRepository.existsById(petDTO.getSpecieId()) &&
                breedRepository.existsByIdAndSpecieId(petDTO.getBreedId(), petDTO.getSpecieId())
        ) {
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
            petToUpdate.setSpecie(specieRepository.findById(petDTO.getSpecieId()).orElse(null));
            petToUpdate.setBreed(breedRepository.findById(petDTO.getBreedId()).orElse(null));
            petRepository.save(petToUpdate);
            return true;
        } else {
            System.out.println("Pet not found. Or specie or breed not exist, or breed is no part of specie.");
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

    public List<PetDTO> getPetsBySpecieId(long specieId) {
        return petMapper.toPetDTOList(petRepository.findBySpecieId(specieId));
    }

    public List<PetDTO> getPetsByBreedId(long breedId) {
        return petMapper.toPetDTOList(petRepository.findByBreedId(breedId));
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
