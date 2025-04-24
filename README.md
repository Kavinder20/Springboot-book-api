# Spring Boot Book API

A simple CRUD REST API for managing books, built with Spring Boot, Spring Data JPA, and an in-memory H2 database.

## Features

- Add a new book
- View all books
- View a book by ID
- Update existing book details
- Delete a book

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- H2 Database

## Running the Project

1. Clone the repo
2. Import as Maven project
3. Run `BookapiApplication.java`
4. Access H2 Console: `http://localhost:8080/h2-console`  
   - JDBC URL: `jdbc:h2:mem:bookdb`  
   - Username: `sa`  
   - Password: 

## API Endpoints

| Method | Endpoint        | Description        |
|--------|------------------|--------------------|
| POST   | `/books`         | Add a new book     |
| GET    | `/books`         | List all books     |
| GET    | `/books/{id}`    | Get book by ID     |
| PUT    | `/books/{id}`    | Update book        |
| DELETE | `/books/{id}`    | Delete book        |

---


