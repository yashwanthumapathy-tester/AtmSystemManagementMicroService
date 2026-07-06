# 🏦 ATM System Management - Microservices

Welcome! 👋

This project is a **Microservices-based ATM Banking System** developed using **Spring Boot**. It was built as part of my learning journey to understand how modern banking applications are designed using a microservices architecture.

The application includes essential banking operations such as customer management, account management, deposits, withdrawals, fund transfers, balance inquiries, and transaction history. All services communicate through an **API Gateway**, are registered with **Eureka Server**, and are secured using **JWT Authentication**.

---

## ✨ What This Project Can Do

* 🔐 Secure user registration and login using JWT
* 👤 Create and manage customer information
* 💳 Create bank accounts
* 💰 Deposit money
* 💸 Withdraw money
* 🔄 Transfer funds between accounts
* 📊 Check account balances
* 📝 View transaction history
* 🌐 Route all requests through an API Gateway
* 🔍 Service discovery using Eureka
* 📮 Ready-to-use Postman collection for API testing

---

# 🏗️ Microservices Overview

| Service             | Port |
| ------------------- | ---- |
| API Gateway         | 8080 |
| Auth Service        | 8081 |
| Customer Service    | 8082 |
| Account Service     | 8083 |
| Transaction Service | 8084 |
| Eureka Server       | 8761 |

---

# 🛠️ Technologies Used

* Java 17
* Spring Boot
* Spring Security
* JWT Authentication
* Spring Cloud Gateway
* Eureka Server
* OpenFeign
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Postman

---

# 📂 Project Structure

```text
ATM-System-Management/
│
├── api-gateway/
├── auth-service/
├── customer-service/
├── account-service/
├── transaction-service/
├── eureka-server/
│
├── SQL Scripts/
│   ├── banking_db_users.sql
│   ├── banking_db_customer.sql
│   ├── banking_db_account.sql
│   └── banking_db_transactions.sql
│
├── ATM_Microservices.postman_collection.json
│
└── README.md
```

---

# 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/AtmSystemManagementMicroService.git
```

### 2. Open the Project

Import the project into your preferred IDE.

* IntelliJ IDEA
* Eclipse
* VS Code

### 3. Create the Database

```sql
CREATE DATABASE banking_db;
```

### 4. Import the SQL Files

Run the following SQL scripts:

* banking_db_users.sql
* banking_db_customer.sql
* banking_db_account.sql
* banking_db_transactions.sql

### 5. Configure the Database

Update the database username and password in your `application.properties` file.

```properties
spring.datasource.username=root
spring.datasource.password=your_password
```

### 6. Start the Services

Run the applications in this order:

1. Eureka Server
2. API Gateway
3. Auth Service
4. Customer Service
5. Account Service
6. Transaction Service

---

# 🔐 Authentication

Register a new user:

```http
POST /auth/register
```

Login to receive a JWT token:

```http
POST /auth/login
```

Use the generated token in your requests:

```text
Authorization: Bearer <your_token>
```

---

# 📮 API Testing

A complete Postman collection is included with this repository.

Simply import:

```text
ATM_Microservices.postman_collection.json
```

You can test all available APIs, including:

* User Registration
* Login
* Customer Management
* Account Management
* Deposit
* Withdraw
* Fund Transfer
* Balance Inquiry
* Transaction History

---

# 🗄️ Database

The application uses four MySQL tables:

* Users
* Customer
* Account
* Transactions

The required SQL scripts are already included in the repository for quick setup.

---

# 📚 What I Learned

Building this project gave me hands-on experience with:

* Developing REST APIs using Spring Boot
* Designing applications using Microservices
* Implementing JWT Authentication
* API Gateway routing
* Eureka Service Discovery
* Inter-service communication with OpenFeign
* MySQL database integration
* Spring Data JPA and Hibernate
* Testing APIs with Postman

This project helped me understand how multiple services work together to build a secure and scalable banking application.

---

# 📁 Repository Includes

* ✅ Complete Source Code
* ✅ SQL Database Scripts
* ✅ Postman Collection
* ✅ Project Documentation (README)

---

# 🚀 Future Enhancements

Some features I would like to add in the future:

* Docker Containerization
* Kubernetes Deployment
* Swagger/OpenAPI Documentation
* Unit & Integration Testing
* CI/CD Pipeline
* Centralized Logging
* Monitoring Dashboard
* Role-Based Authorization

---
