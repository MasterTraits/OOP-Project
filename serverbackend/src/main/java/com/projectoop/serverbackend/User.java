package com.projectoop.serverbackend;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;
import java.util.List;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  // Every field name must be accurate
  private ObjectId id;
  private String email;
  private String password;
  private boolean employer;
  private String first_name;
  private String last_name;
  private String ein;
  private String birthday;
  @DocumentReference
  private List<Employee> employees;

  public User(String email, String password, boolean employer, String first_name, String last_name, String ein, String birthday) {
    this.email = email;
    this.password = password;
    this.employer = employer;
    this.first_name = first_name;
    this.last_name = last_name;
    this.ein = ein;
    this.birthday = birthday;
  }
}
