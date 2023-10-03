package com.oad.pawsavers.adopts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptRepository extends JpaRepository<Adopt, Long> {

    List<Adopt> findByPetAdopterIdOrderByAdoptDateDesc(long petAdopterId);
}
