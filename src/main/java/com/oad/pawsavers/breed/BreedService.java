package com.oad.pawsavers.breed;

import com.oad.pawsavers.specie.Specie;
import com.oad.pawsavers.specie.SpecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreedService {

    @Autowired
    private BreedRepository breedRepository;

    @Autowired
    private BreedMapper breedMapper;

    @Autowired
    private BreedViewMapper breedViewMapper;

    @Autowired
    private SpecieRepository specieRepository;

    public List<BreedViewDTO> getAllBreeds() {
        return breedViewMapper.toBreedViewDTOList(breedRepository.findAll());
    }

    public Optional<BreedViewDTO> getBreedById(long id) {
        return breedRepository.findById(id)
                .map(breedViewMapper::toBreedViewDTO);
    }

    public BreedViewDTO createBreed(BreedDTO breedDTO) {
        if (breedRepository.existsByNameAndSpecieId(breedDTO.getBreedName(), breedDTO.getSpecieId())) {
            System.out.println("This Breed with Specie already exists.");
            return null;
        } else {
            if (specieRepository.existsById(breedDTO.getSpecieId())) {
                return breedViewMapper.toBreedViewDTO(breedRepository.save(breedMapper.toBreedEntity(breedDTO)));
            } else {
                System.out.println("Specie not exists.");
                return null;
            }
        }
    }

    public BreedViewDTO updateBreedById(long id, BreedDTO breedDTO) {
        Optional<Breed> optionalBreed = breedRepository.findById(id);
        if (
                optionalBreed.isPresent() &&
                !breedRepository.existsByNameAndSpecieId(breedDTO.getBreedName(), breedDTO.getSpecieId())
        ) {
            Optional<Specie> optionalSpecie = specieRepository.findById(breedDTO.getSpecieId());
            if (optionalSpecie.isPresent()) {
                Breed breedToUpdate = optionalBreed.get();
                breedToUpdate.setName(breedDTO.getBreedName());
                breedToUpdate.setSpecie(optionalSpecie.get());
                return breedViewMapper.toBreedViewDTO(breedRepository.save(breedToUpdate));
            } else {
                System.out.println("Specie not exists.");
                return null;
            }
        } else {
            System.out.println("Breed not exist or This Breed with Specie already exists.");
            return null;
        }
    }

    public boolean deleteBreedById(long id) {
        if (breedRepository.existsById(id)) {
            breedRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
