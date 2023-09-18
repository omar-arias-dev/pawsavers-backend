package com.oad.pawsavers.visits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visit")
public class VisitController {

    @Autowired
    private VisitService visitService;

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<VisitDetailsDTO>> getVisitsByEmployeeId(@PathVariable("employeeId") long id) {
        return new ResponseEntity<>(visitService.getVisitsByEmployeeId(id), HttpStatus.OK);
    }

    @GetMapping("/petadopter/{petAdopterId}")
    public ResponseEntity<List<VisitDetailsDTO>> getVisitsByPetAdopterId(@PathVariable("petAdopterId") long id) {
        return new ResponseEntity<>(visitService.getVisitByPetAdopterId(id), HttpStatus.OK);
    }

    @GetMapping("/employee/{employeeId}/petadopter/{petAdopterId}")
    public ResponseEntity<List<VisitDetailsDTO>> getVisitByPetAdopterIdAndEmployeeId(
            @PathVariable("employeeId") long employeeId,
            @PathVariable("petAdopterId") long petAdopterId
    ) {
        return new ResponseEntity<>(visitService
                .getVisitByEmployeeIdAndPetAdopterId(employeeId, petAdopterId),
                HttpStatus.OK
        );
    }

    @GetMapping("/employee/{employeeId}/petadopter/{petAdopterId}/datetime")
    public ResponseEntity<List<VisitDetailsDTO>> getVisitByPetAdopterIdAndEmployeeIdAndVisitDateTime(
            @PathVariable("employeeId") long employeeId,
            @PathVariable("petAdopterId") long petAdopterId,
            @RequestBody DateBody visitDateTime
    ) {
        return new ResponseEntity<>(visitService
                .getVisitByEmployeeIdAndPetAdopterIdAndVisitDateTime(employeeId, petAdopterId, visitDateTime.getDatetime()),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<Visit> createVisit(@RequestBody VisitDTO visitDTO) {
        return new ResponseEntity<>(visitService.createVisit(visitDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{visitId}")
    public ResponseEntity updateVisit(
            @PathVariable("visitId")  long visitId,
            @RequestBody VisitDTO visitDTO
    ) {
        if (visitService.updateVisit(visitId, visitDTO)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVisit(@PathVariable("id") long id) {
        if (visitService.deleteVisit(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
