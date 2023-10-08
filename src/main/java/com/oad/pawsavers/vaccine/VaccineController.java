package com.oad.pawsavers.vaccine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaccine")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @GetMapping
    public ResponseEntity<List<VaccineDTO>> getAllVaccines() {
        return new ResponseEntity<>(vaccineService.getAllVaccines(), HttpStatus.OK);
    }

    @GetMapping("/{vaccineId}")
    public ResponseEntity<VaccineDTO> getVaccineById(@PathVariable("vaccineId") long id) {
        return vaccineService.getVaccineById(id)
                .map(vaccineDTO -> new ResponseEntity<>(vaccineDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Vaccine> createVaccine(@RequestBody VaccineDTO vaccineDTO) {
        return new ResponseEntity<>(vaccineService.createVaccine(vaccineDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{vaccineId}")
    public ResponseEntity<VaccineDTO> updateVaccineById(
        @PathVariable("vaccineId") long id,
        @RequestBody VaccineDTO vaccineDTO
    ) {
        return new ResponseEntity<>(vaccineService.updateVaccineById(id, vaccineDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{vaccineId}")
    public ResponseEntity deleteVaccineById(@PathVariable("vaccineId") long id) {
        if (vaccineService.deleteVaccineById(id)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
