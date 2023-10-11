package com.oad.pawsavers.petadopter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petadopter")
public class PetAdopterController {

    @Autowired
    private PetAdopterService petAdopterService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    public ResponseEntity<List<PetAdopterDTO>> getAllPetAdopters() {
        return new ResponseEntity<>(petAdopterService.getAllPetAdopters(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    public ResponseEntity<PetAdopterDTO> getPetAdopterById(@PathVariable long id) {
        return petAdopterService.getPetAdopterById(id)
                .map(petAdopterDTO -> new ResponseEntity<>(petAdopterDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity<PetAdopter> createPetAdopter(@RequestBody PetAdopterDTO petAdopterDTO) {
        return new ResponseEntity<>(petAdopterService.createPetAdopter(petAdopterDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity deletePetAdopterById(long id) {
        if (petAdopterService.deletePetAdopterById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity updatePetAdopterById(@PathVariable long id, @RequestBody PetAdopterDTO petAdopterDTO) {
        if (petAdopterService.updatePetAdopterById(id, petAdopterDTO)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
