# CRUD Bank App 🏦

## Description

The CRUD Bank App is a banking application that allows users to manage various types of accounts, make deposits, withdrawals, earn yield, and perform transfers between accounts.

## Class Diagram

![Class Diagram](link_to_class_diagram_image)

## Setup

To set up and run the project locally, follow these steps:

1. Clone the repository.
2. Configure your database settings in the `application.properties` file.
3. Build and run the application using your preferred IDE or the command line.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database

## Controllers and Routes Structure

The project follows a RESTful API structure with the following main controllers and routes:

### Account Controller

- GET `/api/accounts/checking`: Get all checking accounts.
- GET `/api/accounts/checking/{accountNumber}`: Get a checking account by account number.
- GET `/api/accounts/checking/owner/{name}`: Get a checking account by owner.
- POST `/api/accounts/checking`: Create a new checking account.
- PUT `/api/accounts/checking/{accountNumber}`: Update a checking account.
- PATCH `/api/accounts/checking/transfer/{fromId}/{destinationId}/{amount}`: Transfer funds between accounts.
- DELETE `/api/accounts/checking/{accountNumber}`: Delete a checking account.

## Future Work

Some potential future enhancements for the project include:

- Adding user authentication and authorization.
- Implementing additional account types (e.g., savings, credit).
- Enhancing error handling and validation.
- Adding more advanced transaction features.

## Resources

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Hibernate Documentation](https://docs.jboss.org/hibernate/orm/current/userguide/html_single/Hibernate_User_Guide.html)

## Code Examples

### Account.java

```java
// Your Account class code here
