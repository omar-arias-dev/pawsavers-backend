package com.oad.pawsavers.rescues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rescue")
public class RescueController {

    @Autowired
    private RescueService rescueService;


    @GetMapping("/{rescueId}")
    private ResponseEntity<RescueDetailsDTO> getRescueByRescueId(@PathVariable("rescueId") long petId) {
        return rescueService.getRescueByRescueId(petId)
                .map(rescue -> new ResponseEntity<>(rescue, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/pet/{petId}/petrescuer/{petRescuer}")
    private ResponseEntity<RescueDetailsDTO> createRescue(
            @PathVariable("petId") long petId,
            @PathVariable("petRescuer") long petRescuerId
    ) {
        return new ResponseEntity<>(rescueService.createRescue(petId, petRescuerId), HttpStatus.CREATED);
    }

    @PutMapping("/pet/{petId}/petrescuer/{petRescuer}")
    private ResponseEntity<RescueDetailsDTO> updateRescue(
            @PathVariable("petId") long petId,
            @PathVariable("petRescuer") long petRescuerId
    ) {
        return new ResponseEntity<>(rescueService.updateRescue(petId, petRescuerId), HttpStatus.OK);
    }

    @DeleteMapping("/{rescueId}")
    private ResponseEntity deleteRescueById(@PathVariable("rescueId") long rescueId) {
        if (rescueService.deleteRescueByRescueId(rescueId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("petrescuer/{petRescuerId}")
    private ResponseEntity<List<RescueDetailsDTO>> getAllRescuesByPetRescuerId(@PathVariable("petRescuerId") long petRescuerId) {
        return new ResponseEntity<>(rescueService.getRescuesByPetRescuerId(petRescuerId), HttpStatus.OK);
    }
}
