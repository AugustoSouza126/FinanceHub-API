# 💰 FinanceHub API

A RESTful API for personal finance management built with **Spring Boot**.

This project is being developed to strengthen my backend skills using modern Java technologies and best development practices.

## 🚀 Technologies

- Java 21
- Spring Boot 3.5
- Spring Security
- Spring Data JPA
- PostgreSQL
- Flyway
- Lombok
- Maven

## 📂 Project Structure

```
src/main/java/com/augustosouza/financehub

├── auth
├── category
├── common
├── config
├── transaction
└── user
```

## ✅ Implemented Features

### Infrastructure
- Spring Boot project configuration
- PostgreSQL integration
- Flyway database migrations
- Layered project architecture
- Spring Security configuration

### Authentication
- User registration endpoint
- Password encryption with BCrypt
- Request validation
- Global exception handling

### Database
- Initial migration (users table)
- User entity mapping with JPA
- User repository

## 🛠️ Running the project

Clone the repository:

```bash
git clone https://github.com/AugustoSouza126/FinanceHub-API.git
```

Enter the project directory:

```bash
cd FinanceHub-API
```

Run the application:

```bash
./mvnw spring-boot:run
```

## 📌 Project Status

🚧 Under development.

The next step is implementing:

- User authentication (JWT)
- Login endpoint
- Categories
- Transactions
- Financial dashboard

## 📄 License

This project was developed for educational purposes and portfolio demonstration.
