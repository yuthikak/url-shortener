# URL Shortener

A URL shortening service built using Spring Boot and MongoDB. This application generates short URLs for long URLs, redirects users to the original URL, tracks click counts, and provides URL statistics.

## Features

* Generate short URLs
* Redirect short URLs to original URLs
* Prevent duplicate URL entries
* Track click counts
* View URL statistics
* Store data in MongoDB

## Tech Stack

* Java 17
* Spring Boot
* Spring Data MongoDB
* MongoDB
* Maven
* Lombok

## Project Structure

```text
src
├── Controller
├── Services
├── Repository
├── Entity
└── dto
```

## API Endpoints

### Create Short URL

**POST** `/url`

Request:

```json
{
  "url": "https://www.youtube.com"
}
```

Response:

```json
{
  "originalUrl": "https://www.youtube.com",
  "shortUrl": "http://localhost:8081/url/abc123"
}
```

### Redirect to Original URL

**GET** `/url/{shortCode}`

Example:

```text
http://localhost:8081/url/abc123
```

This endpoint redirects the user to the original URL and increments the click count.

### Get URL Statistics

**GET** `/url/stats/{shortCode}`

Response:

```json
{
  "originalUrl": "https://www.youtube.com",
  "shortCode": "abc123",
  "clickCount": 5
}
```

## Database

MongoDB is used to store:

* Original URL
* Short Code
* Click Count

## Future Improvements

* JWT Authentication
* Custom Short Codes
* URL Expiration
* Swagger Documentation
* User-specific URLs
* QR Code Generation

## Author

Built as a Spring Boot learning project to understand:

* REST APIs
* MongoDB Integration
* DTOs
* Repository Pattern
* URL Redirection
* Git & GitHub
