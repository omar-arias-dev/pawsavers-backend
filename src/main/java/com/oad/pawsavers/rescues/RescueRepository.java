package com.oad.pawsavers.rescues;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RescueRepository extends JpaRepository<Rescue, Long> {

    List<Rescue> findByPetRescuerId(long petRescuerId);
}
