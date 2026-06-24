# 🚀 CommerceCore – Cloud-Native Ecommerce Backend Platform

### Production-Style Ecommerce Backend with Spring Boot, PostgreSQL, AWS, Docker & CI/CD

CommerceCore is a production-style Ecommerce Backend Platform built to demonstrate modern backend engineering, cloud deployment, security, and DevOps practices.

The project evolved beyond a traditional CRUD application by incorporating authentication, authorization, order ownership, validation, exception handling, containerization, cloud deployment, and automated CI/CD pipelines.

---

# 🌟 Key Highlights

✅ RESTful Ecommerce Backend

✅ PostgreSQL Database Integration

✅ JWT Authentication

✅ Role-Based Authorization (USER / ADMIN)

✅ Order Ownership & Resource Security

✅ Product Reviews & Image Management

✅ Request Validation

✅ Global Exception Handling

✅ Audit Fields (createdAt / updatedAt)

✅ Dockerized Application

✅ Docker Compose Multi-Container Setup

✅ AWS EC2 Cloud Deployment

✅ GitHub Actions CI/CD Pipeline

✅ Automated Build & Deployment

---

# 🏗 Solution Architecture

```text
Developer
    │
    ▼
GitHub Repository
    │
    ▼
GitHub Actions CI/CD
    │
    ▼
AWS EC2 (Ubuntu)
    │
    ▼
Docker Compose
 ┌───────────────┐
 │ Spring Boot   │
 │ Application   │
 └───────────────┘
         │
         ▼
 ┌───────────────┐
 │ PostgreSQL    │
 │ Database      │
 └───────────────┘
```

---

# 🏛 Application Architecture

```text
Client
   │
   ▼
Controller Layer
   │
   ▼
Service Layer
   │
   ▼
Repository Layer
   │
   ▼
PostgreSQL Database
```

Security Flow:

```text
JWT Token
     │
     ▼
JwtFilter
     │
     ▼
Spring Security
     │
     ▼
Security Context
     │
     ▼
Protected Controllers
```

---

# 📦 Core Features

## Product Management

* Create Product
* Get Product By ID
* Get All Products
* Update Product
* Delete Product
* Pagination Support
* Dynamic Search

---

## Product Reviews

* Add Reviews
* Automatic Rating Calculation
* Automatic Review Count Updates
* Reviewer Ownership Tracking
* Reviewer Name Display

---

## Product Images

* Add Product Images
* Multiple Images Per Product

---

## Order Management

* Create Orders
* Get Orders By ID
* Get Orders By Reference Number
* Get My Orders
* Admin View All Orders
* UUID Reference Generation
* Tax Calculation
* Total Price Calculation
* Customer Ownership Tracking

---

## DTO Architecture

Implemented DTO Pattern throughout the application.

Examples:

* CreateProductDto
* ProductDto
* RegisterRequestDto
* RegisterResponseDto
* LoginRequestDto
* LoginResponseDto
* OrderDto
* OrderSummaryDto

Benefits:

* Prevents Entity Exposure
* Cleaner APIs
* Better Maintainability
* Separation of Concerns

---

# 🔍 Search & Pagination

Filter Products By:

* Category
* Price Range
* Rating
* Keywords

Example:

```http
GET /api/products/search?category=Phone&minPrice=50000&maxPrice=150000&ratings=4
```

Pagination:

```http
GET /api/products?page=0&size=5
```

---

# 🔐 Authentication & Authorization

CommerceCore implements JWT-based Authentication and Role-Based Authorization using Spring Security.

## Authentication Features

* User Registration
* User Login
* BCrypt Password Encryption
* JWT Token Generation
* JWT Token Validation
* Protected API Access

---

## Roles

### USER

Allowed:

* Register
* Login
* View Products
* Search Products
* Create Orders
* View Own Orders
* Add Reviews
* Add Product Images

Restricted:

* Create Product
* Update Product
* Delete Product

---

### ADMIN

Allowed:

* Full Product Management
* View All Orders
* View Any Order
* All USER Permissions

---

## Security Components

* SecurityConfig
* JwtFilter
* JwtService
* AuthenticationManager
* CustomUserDetailsService
* BCryptPasswordEncoder

---

# 📦 Order Ownership System

A complete order ownership system was implemented.

## Features

* Orders linked to authenticated users
* Customer Name Snapshot
* Customer Email Snapshot
* User-Specific Order Retrieval
* Ownership Validation
* Admin Override Access

### Security Rules

```text
USER
 ├── Can access own orders only

ADMIN
 ├── Can access all orders
```

---

# ⭐ Review Ownership

Product reviews are associated with authenticated users.

## Features

* Reviewer Ownership Tracking
* Reviewer Name Snapshot Storage
* Reviewer Name Returned in Product Responses

Example:

```json
{
  "reviewerName": "Bharath",
  "rating": 5,
  "comment": "Excellent Product"
}
```

---

# 🗄 Database Relationships

```text
Users
 ├── Orders
 │      └── OrderItems
 │              └── Product
 │
 └── ProductReviews
         └── Product

Product
 ├── Images
 └── Reviews
```

Implemented using:

* One-To-Many Mapping
* Many-To-One Mapping
* Bidirectional Relationships
* Cascade Operations
* JPA/Hibernate Relationships

---

# 📋 API Endpoints

## Authentication

| Method | Endpoint           |
| ------ | ------------------ |
| POST   | /api/auth/register |
| POST   | /api/auth/login    |

---

## Products

| Method | Endpoint                  |
| ------ | ------------------------- |
| POST   | /api/products/add         |
| GET    | /api/products             |
| GET    | /api/products/{id}        |
| PUT    | /api/products/update/{id} |
| DELETE | /api/products/delete/{id} |
| GET    | /api/products/search      |

---

## Reviews

| Method | Endpoint                 |
| ------ | ------------------------ |
| POST   | /api/products/review/add |

---

## Images

| Method | Endpoint                |
| ------ | ----------------------- |
| POST   | /api/products/image/add |

---

## Orders

| Method | Endpoint                            |
| ------ | ----------------------------------- |
| POST   | /api/orders/create                  |
| GET    | /api/orders/my-orders               |
| GET    | /api/orders/id/{id}                 |
| GET    | /api/orders/reference/{referenceNo} |
| GET    | /api/admin/orders                   |

---

# ✅ Request Validation

Request validation implemented using Jakarta Validation.

Validation annotations used:

* @NotBlank
* @NotNull
* @PositiveOrZero
* @Email
* @Valid

Benefits:

* Prevents Invalid Data
* Protects Business Logic
* Cleaner API Responses

---

# 🚨 Global Exception Handling

Centralized exception handling implemented using:

```java
@RestControllerAdvice
```

Features:

* Runtime Exception Handling
* Validation Exception Handling
* Consistent Error Responses
* Cleaner API Design

Example Response:

```json
{
  "message": "Product not found",
  "status": 404,
  "timestamp": "2026-06-23T10:30:00"
}
```

---

# 🕒 Audit Fields

Automatic auditing implemented across core entities.

## Fields

* createdAt
* updatedAt

Implemented using:

* @MappedSuperclass
* @PrePersist
* @PreUpdate

Tracks:

* Record Creation Time
* Record Modification Time

Applied To:

* Product
* Order
* ProductReview

---

# 📂 Project Structure

```text
src/main/java/com/bharath/Ecommerce

├── Controller
├── Service
├── Repository
├── Entity
├── Dto
├── Specification
├── Security
├── Config
├── Exception
└── Seed
```

---

# 🛠 Technology Stack

## Backend

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven

## Database

* PostgreSQL

## Security

* Spring Security
* JWT Authentication
* BCrypt Password Encryption

## DevOps & Cloud

* Docker
* Docker Compose
* AWS EC2
* GitHub Actions
* Linux (Ubuntu)

## API Documentation

* Swagger / OpenAPI

---

# 🐳 Docker Deployment

Build Image:

```bash
docker build -t commercecore .
```

Run Container:

```bash
docker run -p 8080:8080 commercecore
```

Run Full Stack:

```bash
docker compose up -d
```

---

# ☁ AWS Cloud Deployment

Application deployed on:

* AWS EC2 (Ubuntu)
* Docker Containers
* PostgreSQL Container
* Security Groups
* SSH Key Authentication

Deployment Flow:

```text
Developer
    │
    ▼
GitHub
    │
    ▼
GitHub Actions
    │
    ▼
AWS EC2
    │
    ▼
Docker Compose
    │
    ▼
Spring Boot + PostgreSQL
```

---

# 🔄 CI/CD Pipeline

Automated deployment implemented using GitHub Actions.

## Workflow

```text
Code Change
      │
      ▼
Git Push
      │
      ▼
GitHub Actions
      │
      ▼
SSH into EC2
      │
      ▼
Git Pull
      │
      ▼
Maven Build
      │
      ▼
Docker Rebuild
      │
      ▼
Container Restart
      │
      ▼
Production Deployment
```

## Automated Tasks

* Pull Latest Source Code
* Build Spring Boot Application
* Rebuild Docker Image
* Restart Containers
* Deploy Latest Version

---

# 🎓 Concepts Demonstrated

## Backend Engineering

* REST API Design
* DTO Pattern
* Layered Architecture
* Dynamic Searching
* Pagination
* Authentication
* Authorization
* Resource Ownership
* Validation
* Exception Handling

## Database Design

* PostgreSQL
* JPA/Hibernate
* Bidirectional Relationships
* Cascade Operations
* Entity Auditing

## Security

* JWT Authentication
* Spring Security
* BCrypt Password Hashing
* Role-Based Access Control
* Ownership-Based Authorization

## DevOps

* Docker
* Docker Compose
* Linux
* AWS EC2
* GitHub Actions
* CI/CD Automation

## Cloud Computing

* EC2 Deployment
* Security Groups
* SSH Authentication
* Environment Configuration

---

# 📊 Project Status

```text
Authentication      ✅ Completed
Authorization       ✅ Completed
Order Ownership     ✅ Completed
Review Ownership    ✅ Completed
Validation          ✅ Completed
Exception Handling  ✅ Completed
Audit Fields        ✅ Completed
Docker              ✅ Completed
AWS Deployment      ✅ Completed
CI/CD Pipeline      ✅ Completed
```

CommerceCore successfully evolved from a CRUD Ecommerce API into a production-style cloud-native backend platform demonstrating backend engineering, security, cloud deployment, DevOps automation, and modern software architecture practices.

---

# 🚀 Future Roadmap

Potential future enhancements:

* Redis Caching
* Payment Gateway Integration
* Shopping Cart Service
* AWS RDS Migration
* AWS ECR Deployment
* Microservices Architecture
* API Gateway
* Service Discovery
* Kubernetes Deployment

---

# 👨‍💻 Author

**Bharath**

Aspiring Software Developer | Backend Engineering | Cloud & DevOps Enthusiast

GitHub: https://github.com/77Bharath
