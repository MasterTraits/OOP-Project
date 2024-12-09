package com.projectoop.serverbackend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.bson.types.ObjectId;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class EmployeeController {
  @Autowired
  private EmployeeService movieService;
  @GetMapping
  public ResponseEntity<List<Employee>> Allmovies() {
    return new ResponseEntity<List<Employee>>(movieService.Allmovies(), HttpStatus.OK);
  }  

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Employee>> getSingleMovie(@PathVariable ObjectId id) {
    return new ResponseEntity<Optional<Employee>>(movieService.singleMovie(id), HttpStatus.OK);
  } 

}
