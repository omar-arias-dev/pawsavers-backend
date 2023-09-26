package com.oad.pawsavers.pet;

import com.oad.pawsavers.common.constants.PetSize;
import com.oad.pawsavers.common.constants.PetStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<PetDTO>> getAllPets() {
        return new ResponseEntity<>(petService.getAllPets(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> getPetById(@PathVariable("id") long id) {
        return petService.getPetById(id)
                .map(petDTO -> new ResponseEntity<>(petDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody PetDTO petDTO) {
        return new ResponseEntity<>(petService.createPet(petDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePetById(@PathVariable("id") long id, @RequestBody PetDTO petDTO) {
        if (petService.updatePet(id, petDTO)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletePetById(@PathVariable("id") long id) {
        if (petService.deletePetById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/halfname/{halfname}")
    public ResponseEntity<List<PetDTO>> getPetsByHalfName(@PathVariable("halfname") String halfname) {
        return new ResponseEntity<>(petService.getPetsByHalfName(halfname), HttpStatus.OK);
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<List<PetDTO>> getPetsByAge(@PathVariable("age") int age) {
        return new ResponseEntity<>(petService.getPetsByAge(age), HttpStatus.OK);
    }

    @GetMapping("/size/{petSize}")
    public ResponseEntity<List<PetDTO>> getPetsBySize(@PathVariable("petSize") PetSize petSize) {
        return new ResponseEntity<>(petService.getPetsBySize(petSize), HttpStatus.OK);
    }

    @GetMapping("status/{petStatus}")
    public ResponseEntity<List<PetDTO>> getPetsByStatus(@PathVariable("petStatus") PetStatus petStatus) {
        return new ResponseEntity<>(petService.getPetsByStatus(petStatus), HttpStatus.OK);
    }

    /*
    *
    * @Param rescueDate format: yyyy-MM-dd.
    * */
    @GetMapping("/rescuedate/{rescuedate}")
    public ResponseEntity<List<PetDTO>> getPetsByRescueDate(@PathVariable("rescuedate") String rescueDate) {
        return new ResponseEntity<>(petService.getPetsByRescueDate(rescueDate), HttpStatus.OK);
    }
}
