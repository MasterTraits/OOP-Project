package com.projectoop.serverbackend;

// import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth/users/employees")
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;

  @GetMapping
  public ResponseEntity<List<Employee>> getAllEmployees() {
    return ResponseEntity.ok(employeeService.getAllEmployees());
  }

  @GetMapping("/{employeeId}")
  public ResponseEntity<Employee> getEmployee(@PathVariable ObjectId employeeId) {
    return ResponseEntity.ok(employeeService.getEmployee(employeeId));
  }

  @PostMapping
  public ResponseEntity<Employee> createEmployee(@RequestBody Map<String, String> payload) {
    return new ResponseEntity<Employee>(employeeService.createEmployee(payload.get("first_name"),
        payload.get("last_name"), payload.get("contact"), payload.get("email"), payload.get("employment_type"),
        payload.get("job_title"), payload.get("dateString"), payload.get("payType"), payload.get("id"), payload.get("uniqueId")),
        HttpStatus.CREATED);
  }

  @PutMapping("/{employeeId}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable ObjectId employeeId, @RequestBody Map<String, String> payload) {
    Employee updatedEmployee = employeeService.updateEmployee(employeeId, payload.get("first_name"),
      payload.get("last_name"), payload.get("contact"), payload.get("email"), payload.get("employment_type"),
      payload.get("job_title"), payload.get("dateString"), payload.get("payType"));
    return ResponseEntity.ok(updatedEmployee);
  }

  @DeleteMapping("/{employeeId}")
  public ResponseEntity<Void> deleteEmployee(@PathVariable ObjectId employeeId) {
    employeeService.deleteEmployee(employeeId);
    return ResponseEntity.noContent().build();
  }
}