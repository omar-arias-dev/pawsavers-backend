package com.oad.pawsavers.specie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/specie")
public class SpecieController {

    @Autowired
    private SpecieService specieService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    public ResponseEntity<List<SpecieDTO>> getAllSpecies() {
        return new ResponseEntity<>(specieService.getAllSpecies(), HttpStatus.OK);
    }

    @GetMapping("/{specieId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    public ResponseEntity<SpecieDTO> getSpecieById(@PathVariable("specieId") long id) {
        return specieService.getSpecieById(id)
                .map(specieDTO -> new ResponseEntity<>(specieDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity<SpecieDTO> createSpecie(@RequestBody SpecieDTO specieDTO) {
        return new ResponseEntity<>(specieService.createSpecie(specieDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{specieId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity<SpecieDTO> updateSpecieById(
            @PathVariable("specieId") long id,
            @RequestBody SpecieDTO specieDTO
    ) {
        return new ResponseEntity<>(specieService.updateSpecieById(id, specieDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{specieId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity deleteSpecieById(@PathVariable("specieId") long id) {
        if (specieService.deleteSpecieById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
