package com.oad.pawsavers.breed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreedRepository extends JpaRepository<Breed, Long> {

    boolean existsByNameAndSpecieId(String name, long specieId);

    boolean existsByIdAndSpecieId(long breedId, long specieId);
}
