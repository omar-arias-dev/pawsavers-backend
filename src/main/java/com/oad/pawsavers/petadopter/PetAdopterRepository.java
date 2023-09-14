package com.oad.pawsavers.petadopter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetAdopterRepository extends JpaRepository<PetAdopter, Long> {
}
