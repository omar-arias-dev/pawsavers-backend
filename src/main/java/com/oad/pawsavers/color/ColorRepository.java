package com.oad.pawsavers.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {

    boolean existsColorByNameOrHex(String name, String hex);

    boolean existsColorByNameAndHex(String name, String hex);
}
