package com.oad.pawsavers.vaccine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VaccineService {

    @Autowired
    private VaccineRepository vaccineRepository;

    @Autowired
    private VaccineMapper vaccineMapper;

    public List<VaccineDTO> getAllVaccines() {
        return vaccineMapper.toVaccineDTOList(vaccineRepository.findAll());
    }

    public Optional<VaccineDTO> getVaccineById(long id) {
        return vaccineRepository.findById(id)
                .map(vaccineMapper::toVaccineDTO);
    }

    public Vaccine createVaccine(VaccineDTO vaccineDTO) {
        return vaccineRepository.save(vaccineMapper.toVaccineEntity(vaccineDTO));
    }

    public VaccineDTO updateVaccineById(long vaccineId, VaccineDTO vaccineDTO) {
        Optional<Vaccine> optionalVaccine = vaccineRepository.findById(vaccineId);
        if (optionalVaccine.isPresent()) {
            Vaccine vaccineToUpdate = optionalVaccine.get();
            vaccineToUpdate.setName(vaccineDTO.getVaccineName());
            return vaccineMapper.toVaccineDTO(vaccineRepository.save(vaccineToUpdate));
        } else {
            System.out.println("Vaccine not Exists.");
            return null;
        }
    }

    public boolean deleteVaccineById(long id) {
        if (vaccineRepository.existsById(id)) {
            vaccineRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
