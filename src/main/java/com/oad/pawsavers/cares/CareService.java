package com.oad.pawsavers.cares;

import com.oad.pawsavers.caretype.CareTypeRepository;
import com.oad.pawsavers.employee.EmployeeRepository;
import com.oad.pawsavers.pet.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class CareService {

    @Autowired
    private CareRepository careRepository;

    @Autowired
    private CareDetailsMapper careDetailsMapper;

    @Autowired
    private CareMapper careMapper;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private CareTypeRepository careTypeRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<CareDetailsDTO> getCareById(long careId) {
        return careRepository.findById(careId)
                .map(careDetailsMapper::toCareDetailsDTO);
    }

    public CareDetailsDTO createCare(CareDTO careDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        LocalDateTime careStarts = LocalDateTime.parse(careDTO.getCareDateTimeStart(), formatter);
        LocalDateTime careEnds = LocalDateTime.parse(careDTO.getCareDateTimeEnd(), formatter);
        if (
                petRepository.existsById(careDTO.getPetId()) &&
                careTypeRepository.existsById(careDTO.getCareTypeId()) &&
                employeeRepository.existsById(careDTO.getEmployeeId()) &&
                careEnds.isAfter(careStarts)
        ) {
            careRepository.save(careMapper.toCareEntity(careDTO));
            return null;
        } else {
            return null;
        }
    }

    public CareDetailsDTO updateCare(long careId, CareDTO careDTO) {
        Optional<Care> optionalCare = careRepository.findById(careId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        LocalDateTime careStarts = LocalDateTime.parse(careDTO.getCareDateTimeStart(), formatter);
        LocalDateTime careEnds = LocalDateTime.parse(careDTO.getCareDateTimeEnd(), formatter);
        if (
                optionalCare.isPresent() &&
                petRepository.existsById(careDTO.getPetId()) &&
                careTypeRepository.existsById(careDTO.getCareTypeId()) &&
                employeeRepository.existsById(careDTO.getEmployeeId()) &&
                careEnds.isAfter(careStarts)
        ) {
            Care careToUpdate = optionalCare.get();
            careToUpdate.setPet(petRepository.findById(careDTO.getPetId()).orElse(null));
            careToUpdate.setCareType(careTypeRepository.findById(careDTO.getCareTypeId()).orElse(null));
            careToUpdate.setEmployee(employeeRepository.findById(careDTO.getEmployeeId()).orElse(null));
            careToUpdate.setCareDateTimeStart(careStarts);
            careToUpdate.setCareDateTimeStart(careEnds);
            return careDetailsMapper.toCareDetailsDTO(careRepository.save(careToUpdate));
        } else {
            return null;
        }
    }

    public boolean deleteCare(long careId) {
        if (careRepository.existsById(careId)) {
            careRepository.deleteById(careId);
            return true;
        } else {
            return false;
        }
    }

    public List<CareDetailsDTO> getCaresByPetId(long petId) {
        return careDetailsMapper.toCareDetailsDTOList(careRepository.findByPetIdOrderByCareDateTimeStartDesc(petId));
    }

    public List<CareDetailsDTO> getCaresByEmployeeId(long employeeId) {
        return careDetailsMapper.toCareDetailsDTOList(careRepository.findByEmployeeIdOrderByCareDateTimeStartDesc(employeeId));
    }
}
