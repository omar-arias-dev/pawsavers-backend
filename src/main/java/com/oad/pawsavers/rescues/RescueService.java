package com.oad.pawsavers.rescues;

import com.oad.pawsavers.pet.Pet;
import com.oad.pawsavers.pet.PetRepository;
import com.oad.pawsavers.petrescuer.PetRescuer;
import com.oad.pawsavers.petrescuer.PetRescuerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RescueService {

    @Autowired
    private RescueRepository rescueRepository;

    @Autowired
    private RescueDetailsMapper rescueDetailsMapper;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PetRescuerRepository petRescuerRepository;

    /*
    *
    * @Context: RescueId = PetId. PetId is Primary Key of Rescues Table.
    * */

    public Optional<RescueDetailsDTO> getRescueByRescueId(long rescuedPetId) {
        return rescueRepository.findById(rescuedPetId)
                .map(rescueDetailsMapper::toRescueDetailsDTO);
    }

    public RescueDetailsDTO createRescue(long petId, long petRescuerId) {
        try {
            Optional<Pet> optionalPet = petRepository.findById(petId);
            Optional<PetRescuer> optionalPetRescuer = petRescuerRepository.findById(petRescuerId);
            if (
                    !rescueRepository.existsById(petId) &&
                    optionalPet.isPresent() &&
                    optionalPetRescuer.isPresent()
            ) {
                Pet pet = optionalPet.get();
                PetRescuer petRescuer = optionalPetRescuer.get();
                Rescue rescueToSave = new Rescue();
                rescueToSave.setId(pet.getId());
                rescueToSave.setPet(pet);
                rescueToSave.setPetRescuer(petRescuer);
                return rescueDetailsMapper
                        .toRescueDetailsDTO(rescueRepository.save(rescueToSave));
            } else {
                return null;
            }
        } catch (Error error) {
            System.out.println(error.getMessage());
            return null;
        }
    }

    /*
    *
    * @Context: petRescuer only can be updated.
    * */
    public RescueDetailsDTO updateRescue(long petId, long petRescuerId) {
        Optional<Rescue> rescue = rescueRepository.findById(petId);
        Optional<PetRescuer> petRescuer = petRescuerRepository.findById(petRescuerId);
        if (rescue.isPresent() && petRescuer.isPresent()) {
            Rescue rescueToUpdate = rescue.get();
            rescueToUpdate.setPetRescuer(petRescuer.get());
            return rescueDetailsMapper.toRescueDetailsDTO(rescueRepository.save(rescueToUpdate));
        }
        else {
            return null;
        }
    }

    public boolean deleteRescueByRescueId(long petId) {
        if (rescueRepository.existsById(petId)) {
            rescueRepository.deleteById(petId);
            return true;
        } else {
            return false;
        }
    }

    public List<RescueDetailsDTO> getRescuesByPetRescuerId(long petRescuerId) {
        return rescueDetailsMapper.toRescueDTOList(rescueRepository.findByPetRescuerId(petRescuerId));
    }
}
