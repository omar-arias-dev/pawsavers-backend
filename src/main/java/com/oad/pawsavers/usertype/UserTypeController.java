package com.oad.pawsavers.usertype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usertype")
public class UserTypeController {

    @Autowired
    UserTypeService userTypeService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    public ResponseEntity<List<UserTypeDTO>> getAllUserTypes() {
        return new ResponseEntity<>(userTypeService.getAllUserTypes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN', 'VIEWER')")
    public ResponseEntity<UserTypeDTO> getUserTypeById(@PathVariable("id") long id) {
        return userTypeService.getUserTypeById(id)
                .map(userType -> new ResponseEntity<>(userType, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity<UserType> saveUserType(@RequestBody UserTypeDTO userTypeDTO) {
        return new ResponseEntity<>(userTypeService.createUserType(userTypeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROOT', 'ADMIN')")
    public ResponseEntity deleteUserType(@PathVariable("id") long id) {
        if (userTypeService.deleteUserTypeById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
