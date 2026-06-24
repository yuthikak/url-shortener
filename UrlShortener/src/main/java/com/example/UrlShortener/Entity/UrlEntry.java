package com.example.UrlShortener.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class UrlEntry {
    @Id
   private ObjectId id;

    private String shortcode;

    private String url;

    private int clickCount;
}
