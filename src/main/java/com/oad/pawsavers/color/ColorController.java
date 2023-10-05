package com.oad.pawsavers.color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/color")
public class ColorController {

    @Autowired
    private ColorService colorService;

    @GetMapping
    public ResponseEntity<List<ColorDTO>> getAllColors() {
        return new ResponseEntity<>(colorService.getAllColors(), HttpStatus.OK);
    }

    @GetMapping("/{colorId}")
    public ResponseEntity<ColorDTO> getColorById(@PathVariable("colorId") long id) {
        return colorService.getColorById(id)
                .map(colorDTO -> new ResponseEntity<>(colorDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ColorDTO> createColor(@RequestBody ColorDTO colorDTO) {
        return new ResponseEntity<>(colorService.createColor(colorDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{colorId}")
    public ResponseEntity deleteColorById(@PathVariable("colorId") long id) {
        if (colorService.deleteColorById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{colorId}")
    public ResponseEntity<ColorDTO> updateColorById(
            @PathVariable("colorId") long id,
            @RequestBody ColorDTO colorDTO
    ) {
        return new ResponseEntity<>(colorService.updateColorById(id, colorDTO), HttpStatus.OK);
    }
}
