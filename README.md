# 🚀 CommerceCore Cloud Platform

### Cloud-Native Ecommerce Backend with AWS, Docker & CI/CD

CommerceCore Cloud Platform is a production-style Ecommerce Backend built using **Spring Boot**, **PostgreSQL**, **Docker**, **AWS EC2**, and **GitHub Actions CI/CD**.

The project demonstrates the complete software delivery lifecycle—from backend development and database design to containerization, cloud deployment, and automated CI/CD pipelines.

---

## 🌟 Key Highlights

✅ RESTful Ecommerce Backend

✅ PostgreSQL Database Integration

✅ Dockerized Application

✅ Docker Compose Multi-Container Setup

✅ AWS EC2 Cloud Deployment

✅ GitHub Actions CI/CD Pipeline

✅ Automated Build & Deployment

✅ Dynamic Product Search & Pagination

✅ Order Processing System

✅ Product Reviews & Image Management

---

## 🏗 Solution Architecture

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

## 📦 Core Features

### Product Management

* Create Product
* Get Product By ID
* Get All Products
* Update Product
* Delete Product
* Pagination Support
* Dynamic Search

### Product Reviews

* Add Reviews
* Automatic Rating Calculation
* Automatic Review Count Updates

### Product Images

* Add Product Images
* Multiple Images Per Product

### Order Management

* Create Orders
* Get Orders By ID
* Get Orders By Reference Number
* UUID Reference Generation
* Tax Calculation
* Total Price Calculation

### DTO Mapping

* Request DTOs
* Response DTOs
* Entity ↔ DTO Conversion

---

## 🔍 Search & Pagination

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

## 🗄 Database Relationships

```text
Product
 ├── Images
 └── Reviews

Order
 └── Order Items
          └── Product
```

Implemented using:

* One-To-Many Mapping
* Many-To-One Mapping
* JPA/Hibernate Relationships
* Cascade Operations

---

## 📋 API Endpoints

### Products

| Method | Endpoint             |
| ------ | -------------------- |
| POST   | /api/products/create |
| GET    | /api/products        |
| GET    | /api/products/{id}   |
| PUT    | /api/products/{id}   |
| DELETE | /api/products/{id}   |
| GET    | /api/products/search |

### Reviews

| Method | Endpoint                 |
| ------ | ------------------------ |
| POST   | /api/products/review/add |

### Images

| Method | Endpoint                |
| ------ | ----------------------- |
| POST   | /api/products/image/add |

### Orders

| Method | Endpoint                            |
| ------ | ----------------------------------- |
| POST   | /api/orders/create                  |
| GET    | /api/orders/id/{id}                 |
| GET    | /api/orders/reference/{referenceNo} |

---

## 📂 Project Structure

```text
src/main/java/com/bharath/Ecommerce

├── Controller
├── Service
├── Repository
├── Entity
├── Dto
├── Specification
├── Config
└── Seed
```

---

## 🛠 Technology Stack

### Backend

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* Maven

### Database

* PostgreSQL

### DevOps & Cloud

* Docker
* Docker Compose
* AWS EC2
* GitHub Actions
* Linux (Ubuntu)

### API Documentation

* Swagger / OpenAPI

---

## 🐳 Docker Deployment

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

## ☁ AWS Cloud Deployment

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
AWS EC2
    │
    ▼
Docker Compose
    │
    ▼
Spring Boot + PostgreSQL
```

---

## 🔄 CI/CD Pipeline

Automated deployment implemented using GitHub Actions.

### Workflow

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

### Automated Tasks

* Pull Latest Source Code
* Build Spring Boot Application
* Rebuild Docker Image
* Restart Containers
* Deploy Latest Version

---

## 🎯 Concepts Demonstrated

### Backend Engineering

* REST API Development
* DTO Pattern
* Layered Architecture
* Dynamic Searching
* Pagination

### Database Design

* PostgreSQL
* JPA/Hibernate
* Entity Relationships

### DevOps

* Docker
* Docker Compose
* Linux
* AWS EC2
* GitHub Actions
* CI/CD Automation

### Cloud Computing

* EC2 Instance Management
* Security Groups
* SSH Authentication
* Environment Configuration

---

## 🚀 Future Enhancements

* JWT Authentication
* Role-Based Access Control
* Shopping Cart
* Payment Gateway Integration
* Redis Caching
* Unit Testing
* Integration Testing
* AWS RDS Migration
* AWS ECR Deployment

---

## 👨‍💻 Author

**Bharath**

Aspiring Software Developer | Cloud & DevOps Enthusiast

GitHub: https://github.com/77Bharath
