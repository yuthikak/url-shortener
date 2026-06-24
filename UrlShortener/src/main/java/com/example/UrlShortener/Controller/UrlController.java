package com.example.UrlShortener.Controller;

import com.example.UrlShortener.Entity.UrlEntry;
import com.example.UrlShortener.Services.UrlService;
import com.example.UrlShortener.dto.UrlStatsResponse;
import com.example.UrlShortener.dto.shortUrlResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/url")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @PostMapping
    public shortUrlResponse posturl(@RequestBody UrlEntry urlentry) {

        UrlEntry saved = urlService.saveUrl(urlentry);


        shortUrlResponse response = new shortUrlResponse();

        response.setOriginalUrl(saved.getUrl());

        response.setShortUrl(
                "http://localhost:8081/url/" + saved.getShortcode()
        );


        return response;
    }

    @GetMapping("/{shortCode}")
    public void findAndIncreement(@PathVariable String shortCode,
                                  HttpServletResponse response) throws IOException {
        System.out.println("Redirect endpoint hit: " + shortCode);
        Optional<UrlEntry> urlEntry = urlService.findAndIncrement(shortCode);

        if (urlEntry.isPresent()) {
            response.sendRedirect(urlEntry.get().getUrl());
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @GetMapping("/stats/{shortcode}")
    public ResponseEntity<UrlStatsResponse> getstats(@PathVariable String shortcode)
    {
      Optional<UrlEntry> urlEntry = urlService.findbyshortcode(shortcode);

        UrlStatsResponse response = new UrlStatsResponse();
        if (urlEntry.isPresent()) {

        response.setOriginalUrl(urlEntry.get().getUrl());
        response.setShortCode(urlEntry.get().getShortcode());
        response.setClickCount(urlEntry.get().getClickCount());

        return ResponseEntity.ok(response);
    }

    return ResponseEntity.notFound().build();
}

}
