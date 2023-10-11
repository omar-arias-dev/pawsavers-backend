package com.oad.pawsavers.cares;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/care")
public class CareController {

    @Autowired
    private CareService careService;

    @GetMapping("/{careId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    private ResponseEntity<CareDetailsDTO> getCareById(@PathVariable("careId") long careId) {
        return careService.getCareById(careId)
                .map(careDetailsDTO -> new ResponseEntity<>(careDetailsDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    private ResponseEntity<CareDetailsDTO> createCare(@RequestBody CareDTO careDTO) {
        return new ResponseEntity<>(careService.createCare(careDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{careId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    private ResponseEntity<CareDetailsDTO> updateCareById(@PathVariable("careId") long careId, @RequestBody CareDTO careDTO) {
        return new ResponseEntity<>(careService.updateCare(careId, careDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{careId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    private ResponseEntity deleteCareById(@PathVariable("careId") long careId) {
        if (careService.deleteCare(careId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pet/{petId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    private ResponseEntity<List<CareDetailsDTO>> getCaresByPetId(@PathVariable("petId") long petId) {
        return new ResponseEntity<>(careService.getCaresByPetId(petId), HttpStatus.OK);
    }

    @GetMapping("/employee/{employeeId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    private ResponseEntity<List<CareDetailsDTO>> getCaresByEmployeeId(@PathVariable("employeeId") long employeeId) {
        return new ResponseEntity<>(careService.getCaresByEmployeeId(employeeId), HttpStatus.OK);
    }
}
