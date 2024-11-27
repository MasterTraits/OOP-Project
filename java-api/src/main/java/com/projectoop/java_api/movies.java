package com.projectoop.java_api;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;
import java.util.List;


@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class movies {
  @Id
  private ObjectId Id;
  private String plot;
  private String fullplot;
  @DocumentReference
  private List<String> genres;
}
