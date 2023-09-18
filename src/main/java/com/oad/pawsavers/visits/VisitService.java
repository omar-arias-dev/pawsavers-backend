package com.oad.pawsavers.visits;

import com.oad.pawsavers.employee.Employee;
import com.oad.pawsavers.employee.EmployeeRepository;
import com.oad.pawsavers.petadopter.PetAdopter;
import com.oad.pawsavers.petadopter.PetAdopterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private VisitMapper visitMapper;

    @Autowired
    private VisitDetailsMapper visitDetailsMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PetAdopterRepository petAdopterRepository;

    public List<VisitDetailsDTO> getVisitsByEmployeeId(long id) {
        return visitDetailsMapper
                .toVisitDetailsDTOList(visitRepository.findByEmployeeIdOrderByVisitDateTime(id));
    }

    public List<VisitDetailsDTO> getVisitByPetAdopterId(long id) {
        return visitDetailsMapper
                .toVisitDetailsDTOList(visitRepository.
                        findByPetAdopterIdOrderByVisitDateTime(id));
    }

    public List<VisitDetailsDTO> getVisitByEmployeeIdAndPetAdopterId(long employeeId, long petAdopterId) {
        return visitDetailsMapper
                .toVisitDetailsDTOList(visitRepository.
                        findByEmployeeIdAndPetAdopterIdOrderByVisitDateTime(employeeId, petAdopterId));
    }

    public List<VisitDetailsDTO> getVisitByEmployeeIdAndPetAdopterIdAndVisitDateTime(
            long employeeId,
            long petAdopterId,
            String visitDate
    ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        return visitDetailsMapper
                .toVisitDetailsDTOList(visitRepository
                        .findByEmployeeIdAndPetAdopterIdAndVisitDateTimeOrderByVisitDateTime(
                                employeeId,
                                petAdopterId,
                                LocalDateTime.parse(visitDate, formatter)
                        ));
    }

    public Visit createVisit(VisitDTO visitDTO) {
        return visitRepository.save(visitMapper.toVisitEntity(visitDTO));
    }

    public boolean updateVisit(long visitId, VisitDTO visitDTO) {
        Optional<Visit> visit = visitRepository.findById(visitId);
        Optional<Employee> employee = employeeRepository.findById(visitDTO.getEmployeeId());
        Optional<PetAdopter> petAdopter = petAdopterRepository.findById(visitDTO.getPetAdopterId());
        if (visit.isPresent() && employee.isPresent() && petAdopter.isPresent()) {
            Visit visitToUpdate = visit.get();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
            visitToUpdate.setNotes(visitDTO.getVisitNotes());
            visitToUpdate.setVisitDateTime(LocalDateTime.parse(visitDTO.getVisitDate(), formatter));
            visitToUpdate.setEmployee(employee.get());
            visitToUpdate.setPetAdopter(petAdopter.get());
            visitRepository.save(visitToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteVisit(long visitId) {
        if (visitRepository.existsById(visitId)) {
            visitRepository.deleteById(visitId);
            return true;
        } else {
            return false;
        }
    }
}

