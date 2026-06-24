package com.example.UrlShortener.Repository;

import com.example.UrlShortener.Entity.UrlEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UrlRepo extends MongoRepository<UrlEntry,ObjectId> {



    Optional<UrlEntry> findByShortcode(String shortcode);
    Optional<UrlEntry> findByUrl(String url);
}
