package com.projectoop.serverbackend;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
  @Autowired
  private EmployeeRepository moviesRepository;
  
  public List<Employee> Allmovies() {
    return moviesRepository.findAll();
  }

  public Optional<Employee> singleMovie(ObjectId id) {
    return moviesRepository.findById(id);
  }

}

