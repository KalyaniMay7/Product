# Product Management System

This is a Spring Boot application for managing products.  
It provides REST APIs for basic product operations like creating, updating, retrieving, and deleting products.  
The project uses MySQL as the database and follows layered architecture with controller, service, repository, and entity packages.

## Features
- Add a new product  
- Get product by ID  
- Get all products  
- Update product details  
- Delete a product  
- Exception handling with proper error messages  


## Tech Stack
- Java 8  
- Spring Boot 2.x  
- Spring Data JPA  
- MySQL 8  
- Maven  
- Swagger (for API documentation)  


## Database Setup

1. Install MySQL (8.0 or compatible).  
2. Create a database:
   ```sql
   CREATE DATABASE productdb;

