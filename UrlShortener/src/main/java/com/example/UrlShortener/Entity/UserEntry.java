package com.example.UrlShortener.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class UserEntry {

    @Id
    private ObjectId id;
   private String username;
    private String password;

}
