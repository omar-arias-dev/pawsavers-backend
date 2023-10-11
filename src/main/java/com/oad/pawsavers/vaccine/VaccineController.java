package com.oad.pawsavers.vaccine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    public ResponseEntity<List<VaccineDTO>> getAllVaccines() {
        return new ResponseEntity<>(vaccineService.getAllVaccines(), HttpStatus.OK);
    }

    @GetMapping("/{vaccineId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    public ResponseEntity<VaccineDTO> getVaccineById(@PathVariable("vaccineId") long id) {
        return vaccineService.getVaccineById(id)
                .map(vaccineDTO -> new ResponseEntity<>(vaccineDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity<Vaccine> createVaccine(@RequestBody VaccineDTO vaccineDTO) {
        return new ResponseEntity<>(vaccineService.createVaccine(vaccineDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{vaccineId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity<VaccineDTO> updateVaccineById(
        @PathVariable("vaccineId") long id,
        @RequestBody VaccineDTO vaccineDTO
    ) {
        return new ResponseEntity<>(vaccineService.updateVaccineById(id, vaccineDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{vaccineId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity deleteVaccineById(@PathVariable("vaccineId") long id) {
        if (vaccineService.deleteVaccineById(id)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
