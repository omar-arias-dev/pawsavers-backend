package com.oad.pawsavers.petrescuer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRescuerRepository extends JpaRepository<PetRescuer, Long> {
}
