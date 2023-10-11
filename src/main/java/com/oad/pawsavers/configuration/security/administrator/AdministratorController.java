package com.oad.pawsavers.configuration.security.administrator;

import com.oad.pawsavers.common.constants.ManagerRole;
import com.oad.pawsavers.configuration.security.role.Role;
import com.oad.pawsavers.configuration.security.role.RoleRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AdministratorRepository administratorRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/test")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Test");
    }

    @PostMapping
    @PreAuthorize("hasRole('ROOT')")
    public ResponseEntity<String> createAdministrator(@Valid @RequestBody CreateAdministratorDTO administratorDTO) {

        Set<Role> roleSet = administratorDTO.getRoles()
                .stream()
                .map(role -> {
                    if (roleRepository.existsByName(ManagerRole.valueOf(role))) {
                        return roleRepository.findByName(ManagerRole.valueOf(role))
                                .orElse(null);
                    } else {
                        Role newRole = new Role(ManagerRole.valueOf(role));
                        return roleRepository.save(newRole);
                    }
                })
                .collect(Collectors.toSet());

        Administrator newAdministrator = new Administrator();
        newAdministrator.setUsername(administratorDTO.getUsername());
        newAdministrator.setEmail(administratorDTO.getEmail());
        newAdministrator.setPassword(passwordEncoder.encode(administratorDTO.getPassword()));
        newAdministrator.setRoleSet(roleSet);
        administratorRepository.save(newAdministrator);
        return ResponseEntity.ok("CREATED.");
    }

    @DeleteMapping("/{administratorId}")
    @PreAuthorize("hasRole('ROOT')")
    public ResponseEntity<String> deleteAdministrator(@PathVariable("administratorId") long id) {
        administratorRepository.deleteById(id);
        return ResponseEntity.ok("ADMINISTRATOR DELETED.");
    }
}
