# Person Management

How to run the application:

Requirements: JDK 11 & Maven 3.6 installed and configured (With the environment variables)

Option 1 - inside the IDE

I've used Eclipse to develop this application, I would recommend to import the project (as maven project) and just run the project.

Option 2 - CLI

Open Command Prompt (Windows) or Terminal (Unix) and run: mvn spring-boot:run

Project overview:

This is a very simple Spring Boot application to save, edit and delete a person and save, edit, delete an address and also link the person(s) to an address.

Database:

The application is using H2 database, so it is not required any database config. The database is created when we run the application and it is only available while the application is running. If the application restarts, the database is created again. The structure is created automatically, using the mapped Entities. The database console can be accessed in http://localhost:8080/h2-console using the URL jdbc:h2:mem:person, user "sa" and blank password.

Usage & Swagger:

For testing purposes, I've added SWAGGER UI to the project. So, it can be accessed while the application is running through the link http://localhost:8080/swagger-ui.html As a general rule, in order to insert a new person or address it is expected to have a null ID while the edit funtionality required the persisted ID.

Improvements - Things that I would do better with more time or in a "real" software.

1- DTO layer & better validations: I would use MapStruct or similar framework to not interact with the Entities. So the "DTO" could have the validations, mandatory data types and so on. I've added some validations in the service layer only but definately this is not covering most of the cases/possible exceptions.

2- More units tests and high test coverage: Instead using simple unit tests only, I would add a new folder for integration tests. These integration tests could run with an embedded in memory database and it could start the spring boot application and interact with the data. For some tests it would be benefical and more effective to achieve a good quality level. Also, I would add tests for all methods. I've only added for AddressService (It is an introduction to the tests, as requested). But I would increase the test coverage and check the coverage using a tool like SonarQube or EclEmma.

3- Think about security: In the real world, usually I would add a security layer. Probably I would add a SpringSecurity class using JWT tokens for public clients.
