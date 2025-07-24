#  Employee Management System - Spring Boot

A simple and robust **Spring Boot** application to manage employee records with full **CRUD** functionality, **input validation**, **global exception handling**, **Swagger API documentation**, and **unit/integration testing**.

 **GitHub Repo**: [khushii-code/employe-managment](https://github.com/khushii-code/employe-managment)

---

##  Features

- Create, Read, Update, Delete (CRUD) operations on employees  
-  Input validation with informative error messages  
-  Global exception handling  
-  Interactive API docs using **Swagger UI (SpringDoc OpenAPI)**  
-  Unit and integration testing (JUnit 5 + Mockito)  

---

##  Tech Stack

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA** + Hibernate
- **MySQL** / H2 (in-memory, configurable)
- **Swagger** via SpringDoc OpenAPI
- **JUnit 5**, **Mockito**
- **Maven**

---

##  Design Decisions

- **Layered architecture (Controller-Service-Repository)** for better separation of concerns.
- **DTOs** used to decouple entity models from API contracts.
- **GlobalExceptionHandler** to centralize error responses and maintain consistency.
- **Validation annotations** to enforce field rules and constraints at input level.
- **Swagger UI** automatically generated for convenient API testing and documentation.
- **Unit & Integration Tests** to maintain code quality and catch regressions early.

---

##  Setup Instructions

###  Prerequisites

- Java 17+
- Maven 3.6+
- MySQL or H2
- (Optional) Docker

###  Clone the Repository

```bash
git clone https://github.com/khushii-code/employe-managment.git
cd employe-managment
