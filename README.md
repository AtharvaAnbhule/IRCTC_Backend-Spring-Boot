# 🚆 IRCTC Backend Application

[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.oracle.com/java/)  
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green.svg)](https://spring.io/projects/spring-boot)  
[![PostgreSQL](https://img.shields.io/badge/Database-PostgreSQL-blue)](https://www.postgresql.org/)  
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)  

A **Spring Boot backend service** inspired by **IRCTC**, designed for **train ticket booking, authentication, and PNR management**.  
This project demonstrates **clean architecture, REST APIs, JWT authentication, and relational database integration**.  

---

## ✨ Features
- 🔑 User Authentication & Authorization (JWT-based login/registration)  
- 🚉 Train Search API (search by source, destination, date)  
- 🎟 Seat Availability & Booking  
- 📄 PNR Status Lookup  
- 🛠 Admin Controls (add/update trains & schedules)  
- 🗄 Relational Database Integration (PostgreSQL/MySQL)  

---

## 🏗 Tech Stack
- Java 17+  
- Spring Boot 3  
- Spring Security (JWT)  
- Spring Data JPA  
- PostgreSQL/MySQL  
- Gradle/Maven  

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/AtharvaAnbhule/IRCTC_Backend-Spring-Boot.git
cd irctc-backend

2️⃣ Configure Database

Edit src/main/resources/application.yml:

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

3️⃣ Run the Application

./gradlew bootRun




📡 API Endpoints

| Method | Endpoint             | Description            | Auth |
| ------ | -------------------- | ---------------------- | ---- |
| POST   | `/api/auth/register` | Register new user      | ❌    |
| POST   | `/api/auth/login`    | Authenticate & get JWT | ❌    |


🚆 Trains & Bookings

| Method | Endpoint                                             | Description      | Auth |
| ------ | ---------------------------------------------------- | ---------------- | ---- |
| GET    | `/api/trains/search?from=DEL&to=MUM&date=2025-08-20` | Search trains    | ❌    |
| POST   | `/api/bookings`                                      | Book ticket      | ✅    |
| GET    | `/api/bookings/{id}`                                 | View booking     | ✅    |
| GET    | `/api/pnr/{pnr}`                                     | Check PNR status | ❌    |


🛠 Admin

| Method | Endpoint                 | Description           | Auth      |
| ------ | ------------------------ | --------------------- | --------- |
| POST   | `/api/admin/trains`      | Add new train         | ✅ (Admin) |
| PUT    | `/api/admin/trains/{id}` | Update train schedule | ✅ (Admin) |


💻 Example cURL
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

📂 Folder Structure
src/main/java/com/example/irctc
│── config/         # Security & JWT configuration
│── controller/     # REST controllers
│── dto/            # Request/Response DTOs
│── entity/         # JPA entities
│── repository/     # Spring Data repositories
│── service/        # Business logic
│── IrctcApplication.java

🚀 Future Enhancements

✅ Train waitlist system

✅ Ticket cancellation & refund flow

✅ Payment gateway integration (mock)

✅ Swagger API documentation

✅ Docker Compose for easy deployment

