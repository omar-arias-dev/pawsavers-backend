package com.oad.pawsavers.visits;

import com.oad.pawsavers.common.Requestbodies.DateAsStringRequestBody;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
            @RequestBody DateAsStringRequestBody visitDateTime
    ) {
        return new ResponseEntity<>(visitService
                .getVisitByEmployeeIdAndPetAdopterIdAndVisitDateTime(employeeId, petAdopterId, visitDateTime.getDatetime()),
                HttpStatus.OK
        );
    }

    @ApiResponses({
            @ApiResponse(responseCode = "404", description = "employee o petAdopter not found", content = {@Content(schema = @Schema)}),
    })
    @PostMapping
    public ResponseEntity<Visit> createVisit(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Id of visit is no required on request body.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(
                                            value = "{\"visitNotes\" : \"Notes\", \"visitDate\" : \"yyyy-MM-dd HH-mm-ss\", \"employeeId\" : 0, \"petAdopterId\" : 0}"
                                    ),
                            }
                    )
            )
            @RequestBody VisitDTO visitDTO
    ) {
        return new ResponseEntity<>(visitService.createVisit(visitDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{visitId}")
    public ResponseEntity updateVisit(
            @PathVariable("visitId")  long visitId,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Id of visit is no required on request body.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(
                                            value = "{\"visitNotes\" : \"Notes\", \"visitDate\" : \"yyyy-MM-dd HH-mm-ss\", \"employeeId\" : 0, \"petAdopterId\" : 0}"
                                    ),
                            }
                    )
            )
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
