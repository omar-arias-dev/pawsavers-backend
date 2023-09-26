package com.oad.pawsavers.caretype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caretype")
public class CareTypeController {

    @Autowired
    private CareTypeService careTypeService;

    @GetMapping
    public ResponseEntity<List<CareTypeDTO>> getAllCareTypes() {
        return new ResponseEntity<>(careTypeService.getAllCareTypes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CareTypeDTO> getCareTypeById(@PathVariable("id") long id) {
        return careTypeService.getCareTypeById(id)
                .map(careTypeDTO -> new ResponseEntity<>(careTypeDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<CareType> createCareType(@RequestBody CareTypeDTO careTypeDTO) {
        return new ResponseEntity<>(careTypeService.createCareType(careTypeDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCareType(@PathVariable("id") long id, @RequestBody CareTypeDTO careTypeDTO) {
        if (careTypeService.updateCareTypeById(id, careTypeDTO)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/id")
    public ResponseEntity deleteCareType(@PathVariable("id") long id) {
        if (careTypeService.deleteCareTypeById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
