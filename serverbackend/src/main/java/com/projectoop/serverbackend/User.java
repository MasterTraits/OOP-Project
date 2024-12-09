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
  @DocumentReference
  private List<Employee> employees;
}
