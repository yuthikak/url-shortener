package com.example.UrlShortener.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlStatsResponse {

    private String originalUrl;
    private String shortCode;
    private int clickCount;
}