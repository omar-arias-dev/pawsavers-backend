package com.oad.pawsavers.vaccinations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {

    List<Vaccination> findByPetIdOrderByVaccinationDateDesc(long petId);

    List<Vaccination> findByVaccineIdOrderByVaccinationDateDesc(long vaccineId);

    boolean existsByPetIdAndVaccineId(long petId, long vaccineId);
}
