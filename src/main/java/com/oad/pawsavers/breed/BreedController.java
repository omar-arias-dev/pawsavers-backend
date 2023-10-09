package com.oad.pawsavers.breed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/breed")
public class BreedController {

    @Autowired
    private BreedService breedService;

    @GetMapping
    public ResponseEntity<List<BreedViewDTO>> getAllBreeds() {
        return new ResponseEntity<>(breedService.getAllBreeds(), HttpStatus.OK);
    }

    @GetMapping("/{breedId}")
    public ResponseEntity<BreedViewDTO> getBreedById(@PathVariable("breedId") long id) {
        return breedService.getBreedById(id)
                .map(breedViewDTO -> new ResponseEntity<>(breedViewDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<BreedViewDTO> createBreed(@RequestBody BreedDTO breedDTO) {
        return new ResponseEntity<>(breedService.createBreed(breedDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{breedId}")
    public ResponseEntity<BreedViewDTO> updateBreedById(
            @PathVariable("breedId") long id,
            @RequestBody BreedDTO breedDTO
    ) {
        return new ResponseEntity<>(breedService.updateBreedById(id, breedDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{breedId}")
    public ResponseEntity deleteBreedById(@PathVariable("breedId") long id) {
        if (breedService.deleteBreedById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
