package com.oad.pawsavers.specie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specie")
public class SpecieController {

    @Autowired
    private SpecieService specieService;

    @GetMapping
    public ResponseEntity<List<SpecieDTO>> getAllSpecies() {
        return new ResponseEntity<>(specieService.getAllSpecies(), HttpStatus.OK);
    }

    @GetMapping("/{specieId}")
    public ResponseEntity<SpecieDTO> getSpecieById(@PathVariable("specieId") long id) {
        return specieService.getSpecieById(id)
                .map(specieDTO -> new ResponseEntity<>(specieDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<SpecieDTO> createSpecie(@RequestBody SpecieDTO specieDTO) {
        return new ResponseEntity<>(specieService.createSpecie(specieDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{specieId}")
    public ResponseEntity<SpecieDTO> updateSpecieById(
            @PathVariable("specieId") long id,
            @RequestBody SpecieDTO specieDTO
    ) {
        return new ResponseEntity<>(specieService.updateSpecieById(id, specieDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{specieId}")
    public ResponseEntity deleteSpecieById(@PathVariable("specieId") long id) {
        if (specieService.deleteSpecieById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
