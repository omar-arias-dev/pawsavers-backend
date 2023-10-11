package com.oad.pawsavers.configuration.security.role;

import com.oad.pawsavers.common.constants.ManagerRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ManagerRole name);
    boolean existsByName(ManagerRole name);
}
