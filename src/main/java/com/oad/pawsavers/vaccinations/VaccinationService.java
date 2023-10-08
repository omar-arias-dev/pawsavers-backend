package com.oad.pawsavers.vaccinations;

import com.oad.pawsavers.pet.Pet;
import com.oad.pawsavers.pet.PetRepository;
import com.oad.pawsavers.vaccine.Vaccine;
import com.oad.pawsavers.vaccine.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class VaccinationService {

    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Autowired
    private VaccinationMapper vaccinationMapper;

    @Autowired
    private VaccinationDetailsMapper vaccinationDetailsMapper;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private VaccineRepository vaccineRepository;

    public Optional<VaccinationDetailsDTO> getVaccinationById(long id) {
        return vaccinationRepository.findById(id)
                .map(vaccinationDetailsMapper::toVaccinationDetailsDTO);
    }

    public VaccinationDetailsDTO createVaccination(VaccinationDTO vaccinationDTO) {
        Optional<Pet> optionalPet = petRepository.findById(vaccinationDTO.getPetId());
        Optional<Vaccine> optionalVaccine = vaccineRepository.findById(vaccinationDTO.getVaccineId());
        if (optionalPet.isPresent() && optionalVaccine.isPresent()) {
            if (!vaccinationRepository.existsByPetIdAndVaccineId(vaccinationDTO.getPetId(), vaccinationDTO.getVaccineId())) {
                Vaccination createdVaccination = vaccinationRepository.save(vaccinationMapper.toVaccinationEntity(vaccinationDTO));
                return vaccinationDetailsMapper.toVaccinationDetailsDTO(createdVaccination);
            } else {
                System.out.println("Pet already was vaccinated with this vaccine.");
                return null;
            }
        } else {
            System.out.println("Pet or Vaccine not exist.");
            return null;
        }
    }

    public VaccinationDetailsDTO updateVaccinationById(long vaccinationId, VaccinationDTO vaccinationDTO) {
        Optional<Vaccination> optionalVaccination = vaccinationRepository.findById(vaccinationId);
        if (optionalVaccination.isPresent()) {
            Optional<Pet> optionalPet = petRepository.findById(vaccinationDTO.getPetId());
            Optional<Vaccine> optionalVaccine = vaccineRepository.findById(vaccinationDTO.getVaccineId());
            if (
                    optionalPet.isPresent() &&
                    optionalVaccine.isPresent() &&
                    !vaccinationRepository.existsByPetIdAndVaccineId(vaccinationDTO.getPetId(), vaccinationDTO.getVaccineId())
            ) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                Vaccination vaccinationToUpdate = optionalVaccination.get();
                vaccinationToUpdate.setPet(optionalPet.get());
                vaccinationToUpdate.setVaccine(optionalVaccine.get());
                vaccinationToUpdate.setVaccinationDate(LocalDate.parse(vaccinationDTO.getVaccinationDate(), formatter));
                return vaccinationDetailsMapper.toVaccinationDetailsDTO(vaccinationRepository.save(vaccinationToUpdate));
            } else {
                System.out.println("Pet already was vaccinated with this vaccine.");
                return null;
            }
        } else {
            System.out.println("Vaccine not exist.");
            return null;
        }
    }

    public boolean deleteVaccinationById(long vaccinationId) {
        if (vaccinationRepository.existsById(vaccinationId)) {
            vaccinationRepository.deleteById(vaccinationId);
            return true;
        } else {
            return false;
        }
    }

    public List<VaccinationDetailsDTO> getAllVaccinationsByPetId(long petId) {
        return vaccinationDetailsMapper.
                toVaccinationDetailsDTOList(vaccinationRepository.findByPetIdOrderByVaccinationDateDesc(petId));
    }

    public List<VaccinationDetailsDTO> getAllVaccinationsByVaccineId(long vaccineId) {
        return vaccinationDetailsMapper.
                toVaccinationDetailsDTOList(vaccinationRepository.findByVaccineIdOrderByVaccinationDateDesc(vaccineId));
    }

}
