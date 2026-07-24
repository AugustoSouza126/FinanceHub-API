# 💰 FinanceHub API

A RESTful API built with **Spring Boot** for personal finance management.

FinanceHub allows users to securely manage their income and expenses, organize transactions using categories, and track their financial balance through a dashboard.

---

# 🚀 Features

### Authentication

- User registration
- User login
- JWT authentication
- Protected endpoints

### Categories

- Create category
- List categories
- Get category by ID
- Update category
- Delete category

Each category belongs exclusively to the authenticated user.

### Transactions

- Create transaction
- List transactions
- Get transaction by ID
- Update transaction
- Delete transaction
- Pagination support

Each transaction belongs exclusively to the authenticated user.

### Dashboard

Financial summary including:

- Total income
- Total expenses
- Current balance

### Validation

- Bean Validation
- Global exception handling
- Standardized error responses

### Documentation

- Swagger / OpenAPI

---

# 🛠 Tech Stack

- Java 21
- Spring Boot 3
- Spring Security
- Spring Data JPA
- JWT Authentication
- PostgreSQL
- Flyway
- Maven
- Swagger / OpenAPI
- Lombok

---

# 🏗 Architecture

The project follows a layered architecture:

```
Controller
    ↓
Service
    ↓
Repository
    ↓
PostgreSQL
```

Project structure:

```
src/main/java
│
├── auth
├── category
├── common
├── config
├── dashboard
├── transaction
└── user
```

---

# 📚 API Endpoints

## Authentication

| Method | Endpoint |
|--------|----------|
| POST | /auth/register |
| POST | /auth/login |

---

## User

| Method | Endpoint |
|--------|----------|
| GET | /users/me |

---

## Categories

| Method | Endpoint |
|--------|----------|
| GET | /categories |
| GET | /categories/{id} |
| POST | /categories |
| PUT | /categories/{id} |
| DELETE | /categories/{id} |

---

## Transactions

| Method | Endpoint |
|--------|----------|
| GET | /transactions |
| GET | /transactions/{id} |
| POST | /transactions |
| PUT | /transactions/{id} |
| DELETE | /transactions/{id} |

Pagination:

```
GET /transactions?page=0&size=10
```

---

## Dashboard

| Method | Endpoint |
|--------|----------|
| GET | /dashboard |

---

# 🔒 Authentication

FinanceHub uses **JWT (JSON Web Token)** for authentication.

Flow:

```
Login
    ↓
JWT Token
    ↓
Bearer Token
    ↓
Protected Endpoints
```

---

# ▶️ Getting Started

## Clone the repository

```bash
git clone https://github.com/AugustoSouza126/FinanceHub-API.git

cd FinanceHub-API
```

---

## Configure PostgreSQL

Update the database credentials in:

```
application.properties
```

---

## Run the application

Using Maven:

```bash
./mvnw spring-boot:run
```

Or run the project directly from your IDE.

---

# 📖 API Documentation

After starting the application:

```
http://localhost:8081/swagger-ui/index.html
```

---

# 📌 Roadmap

- Angular Frontend
- Docker support
- Cloud deployment
- Dashboard charts
- Automated tests

---

# 👨‍💻 Author

**Augusto Souza**

GitHub

https://github.com/AugustoSouza126

LinkedIn

https://www.linkedin.com/in/augusto-souza-795324313/

---

## ⭐ If you found this project useful, consider giving it a star.