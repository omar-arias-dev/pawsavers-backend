package com.oad.pawsavers.cares;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareRepository extends JpaRepository<Care, Long> {

    List<Care> findByPetIdOrderByCareDateTimeStartDesc(long petId);

    List<Care> findByEmployeeIdOrderByCareDateTimeStartDesc(long employeeId);
}
