# 🛒 Ecommerce API

A production-style Ecommerce Backend built with **Spring Boot**, **PostgreSQL**, **Docker**, **AWS EC2**, and **CI/CD**.

Designed to simulate real-world ecommerce operations including product management, reviews, images, searching, pagination, and order processing.

---

## 🚀 Features

### 📦 Product Management

* ✅ Create Product
* ✅ Get Product By ID
* ✅ Get All Products
* ✅ Update Product
* ✅ Delete Product
* ✅ Pagination Support
* ✅ Dynamic Product Search

### ⭐ Product Reviews

* Add Reviews
* Automatic Rating Calculation
* Automatic Review Count Updates

### 🖼 Product Images

* Add Images to Products
* Multiple Images per Product

### 🛍 Order Management

* Create Orders
* Get Order By ID
* Get Order By Reference Number
* UUID Reference Number Generation
* Tax Calculation
* Total Amount Calculation

### 🔄 DTO Mapping

* Request DTOs
* Response DTOs
* Entity → DTO Conversion
* DTO → Entity Conversion

### 🗄 Database Relationships

* Product ↔ Product Images
* Product ↔ Product Reviews
* Order ↔ Order Items
* Order Item ↔ Product

---

## 🏗 Architecture

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
└── Seed
```

---

## 🔍 Search & Pagination

### Search Products

Filter using:

* Category
* Min Price
* Max Price
* Ratings
* Keyword

Example:

```http
GET /api/products/search?category=Phone&minPrice=50000&maxPrice=150000&ratings=4
```

### Pagination

```http
GET /api/products?page=0&size=5
```

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

---

### Reviews

| Method | Endpoint                 |
| ------ | ------------------------ |
| POST   | /api/products/review/add |

---

### Images

| Method | Endpoint                |
| ------ | ----------------------- |
| POST   | /api/products/image/add |

---

### Orders

| Method | Endpoint                            |
| ------ | ----------------------------------- |
| POST   | /api/orders/create                  |
| GET    | /api/orders/id/{id}                 |
| GET    | /api/orders/reference/{referenceNo} |

---

## 🛠 Tech Stack

### Backend

* Spring Boot
* Spring Data JPA
* Hibernate
* Maven

### Database

* PostgreSQL

### DevOps

* Docker
* AWS EC2
* GitHub Actions

### Language

* Java 21

---

## 🐳 Dockerized Application

Build Docker Image

```bash
docker build -t ecommerce-api .
```

Run Container

```bash
docker run -p 8080:8080 ecommerce-api
```

---

## ☁ AWS Deployment

The application is deployed on an AWS EC2 Linux instance.

```text
Developer
    │
    ▼
GitHub
    │
    ▼
Docker Image
    │
    ▼
AWS EC2
    │
    ▼
Spring Boot Application
    │
    ▼
PostgreSQL
```

---

## 🔄 CI/CD Pipeline

Automated deployment using GitHub Actions.

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
Build & Test
     │
     ▼
Docker Build
     │
     ▼
AWS EC2 Deploy
     │
     ▼
Production Ready
```

### Use Cases

* Feature Releases
* Bug Fixes
* Authentication Updates
* Payment Gateway Integration
* Performance Improvements

---

## 📚 Concepts Practiced

* REST APIs
* DTO Pattern
* Entity Relationships
* One-To-Many Mapping
* Many-To-One Mapping
* Pagination
* Dynamic Searching
* Docker
* AWS EC2
* CI/CD
* PostgreSQL
* Layered Architecture

---

## 🚀 Future Enhancements

* JWT Authentication
* Role-Based Access Control
* Shopping Cart
* Payment Gateway Integration
* Inventory Management
* Swagger Documentation
* Unit Testing
* Integration Testing

---

## 👨‍💻 Author

### Bharath

Aspiring Software Developer | Cloud & DevOps Enthusiast

GitHub: https://github.com/77Bharath
