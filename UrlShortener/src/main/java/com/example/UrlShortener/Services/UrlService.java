package com.example.UrlShortener.Services;

import com.example.UrlShortener.Entity.UrlEntry;
import com.example.UrlShortener.Repository.UrlRepo;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
@Data
@Service
public class UrlService {

    @Autowired
    private UrlRepo urlrepo;

    public UrlEntry saveUrl(UrlEntry urlEntry) {
        if (urlEntry.getUrl() == null || urlEntry.getUrl().isBlank()) {
            throw new RuntimeException("URL cannot be empty");
        }
        Optional<UrlEntry> existing = urlrepo.findByUrl(urlEntry.getUrl());
        if(existing.isPresent())
        {
            return existing.get();
        }
        else {
        String shortCode = generateShortCode();

        urlEntry.setShortcode(shortCode);

        return urlrepo.save(urlEntry);
    }
        }



    public String generateShortCode() {

        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        Random random = new Random();

        StringBuilder shortCode = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(chars.length());
            shortCode.append(chars.charAt(index));
        }

        return shortCode.toString();
    }


    public Optional<UrlEntry> findAndIncrement(String shortCode) {
        System.out.println("Incrementing count");
        Optional<UrlEntry> urlEntry = urlrepo.findByShortcode(shortCode);

        if(urlEntry.isPresent()) {
            UrlEntry entry = urlEntry.get();

            entry.setClickCount(entry.getClickCount() + 1);

            urlrepo.save(entry);
        }

        return urlEntry;
    }

    public Optional<UrlEntry> findbyshortcode(String shortcode) {
        return urlrepo.findByShortcode(shortcode);

    }
}
