package com.projectoop.serverbackend;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;
// import java.util.List;

@Document(collection = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
  @Id
  ObjectId id;
  String first_name;
  String last_name;
  String contact;
  String email;
  String employment_type;
  String job_title;
  String dateString;
  String payType;

  public Employee(String first_name, String last_name, String contact, String email, String employment_type, String job_title, String dateString, String payType) {
    this.first_name = first_name;
    this.last_name = last_name;
    this.contact = contact;
    this.email = email;
    this.employment_type = employment_type;
    this.job_title = job_title;
    this.dateString = dateString;
    this.payType = payType;
  }
  
}
