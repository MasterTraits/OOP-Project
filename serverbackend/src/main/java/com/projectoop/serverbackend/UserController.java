package com.projectoop.serverbackend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.bson.types.ObjectId;
import java.util.Optional;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth/users")
public class UserController {
  @Autowired
  private UserService userService;
  @GetMapping
  public ResponseEntity<List<User>> Allusers() {
    return new ResponseEntity<List<User>>(userService.Allusers(), HttpStatus.OK);
  }  

  @GetMapping("/login/{id}")
  public ResponseEntity<Optional<User>> getSingleUser(@PathVariable ObjectId id) {
    return new ResponseEntity<Optional<User>>(userService.singleUser(id), HttpStatus.OK);
  } 

  
}
