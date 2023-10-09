package com.oad.pawsavers.pet;

import com.oad.pawsavers.common.constants.PetSize;
import com.oad.pawsavers.common.constants.PetStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByNameContains(String halfName);

    List<Pet> findByAgeOrderByNameAsc(int age);

    List<Pet> findBySizeOrderByNameAsc(PetSize size);

    List<Pet> findByStatusOrderByNameAsc(PetStatus status);

    List<Pet> findByRescueDateOrderByNameAsc(LocalDate date);

    List<Pet> findBySpecieId(long specieId);

    List<Pet> findByBreedId(long breedId);
}
