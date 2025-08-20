IRCTC Backend Application 🚆
Overview

This project is a Spring Boot backend service inspired by IRCTC, designed to handle user authentication, train search, booking, and ticket management. It demonstrates clean architecture, REST APIs, and integration with a relational database.

Features

User Authentication & Authorization (JWT-based login/registration)

Train Search API (by source, destination, and date)

Seat Availability & Booking

PNR Status Lookup

Admin Controls (add/update trains, schedules)

Relational Database Integration (PostgreSQL/MySQL)

Tech Stack

Java 17+

Spring Boot 3

Spring Security (JWT)

Spring Data JPA

PostgreSQL/MySQL (configurable)

Gradle/Maven (choose your build tool)

Setup Instructions
1. Clone the Repo
git clone https://github.com/AtharvaAnbhule/IRCTC_Backend-Spring-Boot.git 
cd irctc-backend

2. Configure Database

Update src/main/resources/application.yml:

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/irctc_db
    username: postgres
    password: postgres
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database-platform: org.hibernate.dialect.PostgreSQLDialect
jwt:
  secret: your-secret-key
  expiration: 86400000

3. Run the App
./gradlew bootRun

API Endpoints
Auth
POST /api/auth/register   # register new user
POST /api/auth/login      # authenticate & get JWT

Train & Booking
GET    /api/trains/search?from=DEL&to=MUM&date=2025-08-20
POST   /api/bookings       # book ticket (requires JWT)
GET    /api/bookings/{id}  # view booking
GET    /api/pnr/{pnr}      # check PNR status

Admin
POST   /api/admin/trains    # add new train
PUT    /api/admin/trains/{id} # update train schedule

Example cURL
# Register User
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{"username":"user1","password":"pass"}'

# Login
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"user1","password":"pass"}'

# Search Trains
curl -X GET "http://localhost:8080/api/trains/search?from=DEL&to=MUM&date=2025-08-20"

Folder Structure
src/main/java/com/example/irctc
│── config/         # Security & JWT config
│── controller/     # REST controllers
│── dto/            # Request/response DTOs
│── entity/         # JPA entities
│── repository/     # Spring Data repositories
│── service/        # Business logic
│── IrctcApplication.java
