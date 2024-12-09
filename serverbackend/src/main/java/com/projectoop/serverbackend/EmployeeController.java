package com.projectoop.serverbackend;

// import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/users/employees")
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;

  @PostMapping
  public ResponseEntity<Employee> createEmployee(@RequestBody Map<String, String> payload) {
    return new ResponseEntity<Employee>(employeeService.createEmployee(payload.get("first_name"),
        payload.get("last_name"), payload.get("contact"), payload.get("email"), payload.get("employment_type"),
        payload.get("job_title"), payload.get("dateString"), payload.get("payType"), payload.get("id")),
        HttpStatus.CREATED);
    // return ResponseEntity.ok(employeeService.createEmployee(first_name,
    // last_name, contact, email, employment_type, job_title, dateString, payType,
    // id));
  }

  // @DeleteMapping("/{employeeId}")
  // public ResponseEntity<Void> deleteEmployee(@PathVariable ObjectId employeeId, @RequestParam String userId) {
  //   employeeService.deleteEmployee(employeeId, userId);
  //   return ResponseEntity.noContent().build();
  // }

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