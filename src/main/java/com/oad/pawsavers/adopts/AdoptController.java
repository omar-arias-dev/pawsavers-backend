package com.oad.pawsavers.adopts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adopt")
public class AdoptController {

    @Autowired
    private AdoptService adoptService;

    @GetMapping("/{adoptId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    public ResponseEntity<AdoptDetailsDTO> getAdoptById(@PathVariable("adoptId") long petId) {
        return adoptService.getAdoptById(petId)
                .map(adoptDetailsDTO -> new ResponseEntity<>(adoptDetailsDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity<AdoptDetailsDTO> createAdopt(@RequestBody AdoptDTO adoptDTO) {
        return new ResponseEntity<>(adoptService.createAdopt(adoptDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{adoptId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity<AdoptDetailsDTO> updateAdoptById(
            @PathVariable("adoptId") long petId,
            @RequestBody AdoptDTO adoptDTO
    ) {
        return new ResponseEntity<>(adoptService.updateAdoptById(petId, adoptDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{adoptId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity deleteAdoptById(@PathVariable("adoptId") long petId) {
        if (adoptService.deleteAdoptById(petId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/petadopter/{petAdopterId}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    public ResponseEntity<List<AdoptDetailsDTO>> getAdoptsByPetAdopterId(@PathVariable("petAdopterId") long petAdopterId) {
        return new ResponseEntity<>(adoptService.getAdoptByPetAdopterId(petAdopterId), HttpStatus.OK);
    }
}
