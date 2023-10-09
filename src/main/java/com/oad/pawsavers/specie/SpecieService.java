package com.oad.pawsavers.specie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecieService {

    @Autowired
    private SpecieRepository specieRepository;

    @Autowired
    private SpecieMapper specieMapper;

    public List<SpecieDTO> getAllSpecies() {
        return specieMapper.toSpecieDTOList(specieRepository.findAll());
    }

    public Optional<SpecieDTO> getSpecieById(long id) {
        return specieRepository.findById(id)
                .map(specieMapper::toSpecieDTO);
    }

    public SpecieDTO createSpecie(SpecieDTO specieDTO) {
        if (specieRepository.existsByName(specieDTO.getSpecieName())) {
            return null;
        } else {
            return specieMapper.toSpecieDTO(specieRepository.save(specieMapper.toSpecieEntity(specieDTO)));
        }
    }

    public SpecieDTO updateSpecieById(long specieId, SpecieDTO specieDTO) {
        Optional<Specie> optionalSpecie = specieRepository.findById(specieId);
        if (
                optionalSpecie.isPresent() &&
                !specieRepository.existsByName(specieDTO.getSpecieName())
        ) {
            Specie specieToUpdate = optionalSpecie.get();
            specieToUpdate.setName(specieDTO.getSpecieName());
            return specieMapper.toSpecieDTO(specieRepository.save(specieToUpdate));
        } else {
            System.out.println("Specie not exists.");
            return null;
        }
    }

    public boolean deleteSpecieById(long specieId) {
        return getSpecieById(specieId)
                .map(specieDTO -> {
                    specieRepository.deleteById(specieDTO.getSpecieId());
                    return true;
                })
                .orElse(false);
    }
}
