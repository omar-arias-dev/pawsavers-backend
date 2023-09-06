package com.oad.pawsavers.usertype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usertype")
public class UserTypeController {

    @Autowired
    UserTypeService userTypeService;

    @GetMapping
    public ResponseEntity<List<UserTypeDTO>> getAllUserTypes() {
        return new ResponseEntity<>(userTypeService.getAllUserTypes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserTypeDTO> getUserTypeById(@PathVariable("id") long id) {
        return userTypeService.getUserTypeById(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<UserType> saveUserType(@RequestBody UserTypeDTO userTypeDTO) {
        return new ResponseEntity<>(userTypeService.createUserType(userTypeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserType(@PathVariable("id") long id) {
        if (userTypeService.deleteUserTypeById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
