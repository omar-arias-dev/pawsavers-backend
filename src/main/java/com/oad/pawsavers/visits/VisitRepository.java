package com.oad.pawsavers.visits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    List<Visit> findByEmployeeIdOrderByVisitDateTime(long employeeId);

    List<Visit> findByPetAdopterIdOrderByVisitDateTime(long petAdopterId);

    List<Visit> findByEmployeeIdAndPetAdopterIdOrderByVisitDateTime(long employeeId, long petAdopterId);

    List<Visit> findByEmployeeIdAndPetAdopterIdAndVisitDateTimeOrderByVisitDateTime(
            long employee,
            long petAdopter,
            LocalDateTime visitDateTime
    );
}
