package com.oad.pawsavers.adopts;

import com.oad.pawsavers.common.constants.PetStatus;
import com.oad.pawsavers.pet.Pet;
import com.oad.pawsavers.pet.PetRepository;
import com.oad.pawsavers.petadopter.PetAdopter;
import com.oad.pawsavers.petadopter.PetAdopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AdoptService {

    @Autowired
    private AdoptRepository adoptRepository;

    @Autowired
    private AdoptDetailsMapper adoptDetailsMapper;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetAdopterRepository petAdopterRepository;

    public Optional<AdoptDetailsDTO> getAdoptById(long petId) {
        return adoptRepository.findById(petId)
                .map(adoptDetailsMapper::toAdoptDetailsDTO);
    }

    public AdoptDetailsDTO createAdopt(AdoptDTO adoptDTO) {
        Optional<Pet> optionalPet = petRepository.findById(adoptDTO.getPetId());
        if (optionalPet.isPresent() && !adoptRepository.existsById(adoptDTO.getAdoptId())) {
            Optional<PetAdopter> optionalPetAdopter = petAdopterRepository.findById(adoptDTO.getPetAdopterId());
            if (optionalPetAdopter.isPresent()) {
                Pet pet = optionalPet.get();
                PetAdopter petAdopter = optionalPetAdopter.get();
                if (pet.getStatus().toString().equals(PetStatus.ALIVE.name())) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    Adopt adopt = new Adopt();
                    adopt.setId(adoptDTO.getPetId());
                    adopt.setPetAdopter(petAdopter);
                    adopt.setAdoptDate(LocalDate.parse(adoptDTO.getAdoptDate(), formatter));
                    adopt.setNotes(adoptDTO.getAdoptNotes());
                    pet.setStatus(PetStatus.ADOPTED);
                    adopt.setPet(pet);
                    petRepository.save(pet);
                    return adoptDetailsMapper.toAdoptDetailsDTO(adoptRepository.save(adopt));
                } else {
                    System.out.println("Pet is not in condition to be adopted.");
                    return null;
                }
            } else {
                System.out.println("Pet Adopter not exists");
                return null;
            }
        } else {
            System.out.println("Pet is already adopted Or Pet not exists");
            return null;
        }
    }

    public AdoptDetailsDTO updateAdoptById(long petId, AdoptDTO adoptDTO) {
        Optional<Adopt> optionalAdopt = adoptRepository.findById(petId);
        Optional<PetAdopter> optionalPetAdopter = petAdopterRepository.findById(adoptDTO.getPetAdopterId());
        if (
                petRepository.existsById(petId)
                && optionalAdopt.isPresent()
                && optionalPetAdopter.isPresent()
        ) {
            Adopt adoptToUpdate = optionalAdopt.get();
            PetAdopter petAdopter = optionalPetAdopter.get();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            adoptToUpdate.setPetAdopter(petAdopter);
            adoptToUpdate.setAdoptDate(LocalDate.parse(adoptDTO.getAdoptDate(), formatter));
            adoptToUpdate.setNotes(adoptDTO.getAdoptNotes());
            return adoptDetailsMapper.toAdoptDetailsDTO(adoptRepository.save(adoptToUpdate));
        } else {
            return null;
        }
    }

    public boolean deleteAdoptById(long id) {
        if (adoptRepository.existsById(id)) {
            adoptRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<AdoptDetailsDTO> getAdoptByPetAdopterId(long petAdopterId) {
        return adoptDetailsMapper.toAdoptDetailsDTOList(adoptRepository.findByPetAdopterIdOrderByAdoptDateDesc(petAdopterId));
    }
}
