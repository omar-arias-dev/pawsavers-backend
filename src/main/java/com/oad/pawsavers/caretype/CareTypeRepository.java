package com.oad.pawsavers.caretype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareTypeRepository extends JpaRepository<CareType, Long> {
}
