package com.oad.pawsavers.petrescuer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/petrescuer")
public class PetRescuerController {

    @Autowired
    private PetRescuerService petRescuerService;

    @GetMapping
    public ResponseEntity<List<PetRescuerDTO>> getAllPetRescuers() {
        return new ResponseEntity<>(petRescuerService.getAllPetRescuers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetRescuerDTO> getPetRescuerById(@PathVariable("id") long id) {
        return petRescuerService.getPetRescuerById(id)
                .map(petRescuerDTO -> new ResponseEntity<>(petRescuerDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PetRescuer> createPetRescuer(@RequestBody PetRescuerDTO petRescuerDTO) {
        return new ResponseEntity<>(petRescuerService.savePetRescuer(petRescuerDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePetRescuer(@PathVariable("id") long id, @RequestBody PetRescuerDTO petRescuerDTO) {
        if (petRescuerService.updatePetRescuer(id, petRescuerDTO)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePetSaverById(@PathVariable("id") long id) {
        if (petRescuerService.deletePetRescuerById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
