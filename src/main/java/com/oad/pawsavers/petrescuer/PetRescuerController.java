package com.oad.pawsavers.petrescuer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petrescuer")
public class PetRescuerController {

    @Autowired
    private PetRescuerService petRescuerService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    public ResponseEntity<List<PetRescuerDTO>> getAllPetRescuers() {
        return new ResponseEntity<>(petRescuerService.getAllPetRescuers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    public ResponseEntity<PetRescuerDTO> getPetRescuerById(@PathVariable("id") long id) {
        return petRescuerService.getPetRescuerById(id)
                .map(petRescuerDTO -> new ResponseEntity<>(petRescuerDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity<PetRescuer> createPetRescuer(@RequestBody PetRescuerDTO petRescuerDTO) {
        return new ResponseEntity<>(petRescuerService.savePetRescuer(petRescuerDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity updatePetRescuer(@PathVariable("id") long id, @RequestBody PetRescuerDTO petRescuerDTO) {
        if (petRescuerService.updatePetRescuer(id, petRescuerDTO)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity deletePetSaverById(@PathVariable("id") long id) {
        if (petRescuerService.deletePetRescuerById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
