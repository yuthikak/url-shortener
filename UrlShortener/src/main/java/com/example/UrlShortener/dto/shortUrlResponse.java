package com.example.UrlShortener.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class shortUrlResponse {

    private String shortUrl;
    private String originalUrl;



}
