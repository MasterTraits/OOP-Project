package com.projectoop.serverbackend;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;
import java.util.List;

@Document(collection = "sessions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ployer {
  @Id
  // Every field name must be accurate
  private ObjectId id;
  private String plot;
  private String fullplot;
  private List<String> genres;
}
