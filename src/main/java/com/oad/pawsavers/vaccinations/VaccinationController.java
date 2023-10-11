package com.oad.pawsavers.vaccinations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccination")
public class VaccinationController {

    @Autowired
    private VaccinationService vaccinationService;

    @GetMapping("/{vaccinationId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    public ResponseEntity<VaccinationDetailsDTO> getVaccinationById(@PathVariable("vaccinationId") long id) {
        return vaccinationService.getVaccinationById(id)
                .map(vaccinationDetailsDTO -> new ResponseEntity<>(vaccinationDetailsDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity<VaccinationDetailsDTO> createVaccination(@RequestBody VaccinationDTO vaccinationDTO) {
        return new ResponseEntity<>(vaccinationService.createVaccination(vaccinationDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{vaccinationId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity<VaccinationDetailsDTO> updateVaccinationById(
            @PathVariable("vaccinationId") long id,
            @RequestBody VaccinationDTO vaccinationDTO
    ) {
        return new ResponseEntity<>(vaccinationService.updateVaccinationById(id, vaccinationDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{vaccinationId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity deleteVaccinationById(@PathVariable("vaccinationId") long id) {
        if (vaccinationService.deleteVaccinationById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pet/{petId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    public ResponseEntity<List<VaccinationDetailsDTO>> getAllVaccinationsByPetId(@PathVariable("petId") long id) {
        return new ResponseEntity<>(vaccinationService.getAllVaccinationsByPetId(id), HttpStatus.OK);
    }

    @GetMapping("/vaccine/{vaccineId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    public ResponseEntity<List<VaccinationDetailsDTO>> getAllVaccinationsByVaccineId(@PathVariable("vaccineId") long id) {
        return new ResponseEntity<>(vaccinationService.getAllVaccinationsByVaccineId(id), HttpStatus.OK);
    }
}
