# URL Shortener

A URL shortening service built with Spring Boot and MongoDB.

## Features

* Generate short URLs
* Redirect to original URLs
* Prevent duplicate URL entries
* Track click counts
* View URL statistics

## Tech Stack

* Java 17
* Spring Boot
* Spring Data MongoDB
* MongoDB
* Maven

## API Endpoints

### Create Short URL

POST /url

Request:

{
"url": "https://www.youtube.com/"
}

Response:

{
"originalUrl": "https://www.youtube.com/",
"shortUrl": "http://localhost:8081/url/abc123"
}

### Redirect

GET /url/{shortCode}

Redirects the user to the original URL.

### URL Statistics

GET /url/stats/{shortCode}

Response:

{
"originalUrl": "https://www.youtube.com/",
"shortCode": "abc123",
"clickCount": 5
}
