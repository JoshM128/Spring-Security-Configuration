# SpringSecurityV2
# Spring Boot Security Configuration
  A project designed to allow developers to begin instantly designing  authentication and authorization for their application.
  This Configuration has removed the required time to design the required JWT authentication process in spring.

## Table of Contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Advice](#setup)
* [API Reference](#API-Reference)


## General info
Enables JWT Authentication and Role-based Authentication for web-based applications using Spring or Spring boot.

The application is set up using a Postgres database for ease of use with ORMs. This can be used on local host or docker.

The project contains a single authentication controller used for user sign registration and authentication.

There are also 3 controllers based on example roles within a web application detailing the use of more hierarchical-based authentication for web applications. 


## Technologies
Java 17
Spring Web
Spring Data JPA
Postgres 
Docker

## Setup 

#### Required Technologies
* Java 17 JDK
* Postgres
* Maven

#### Getting started
Once you have Java 17 and maven installed along with postgres for the database you can.

1. Clone the GitHub Repo to your machine
```sh
gh repo clone JM4128/SpringSecurityV2
```
2. Modifying the `application.yml` file
```yml
spring:
    datasource:
      url: jdbc:postgresql:// #Enter your database host here
      username: username # Your database username
      password: password # Your database password
      driver-class-name: org.postgresql.Driver # Postgres Driver
    jpa:
      hibernate:
        ddl-auto: create-drop # Application is set to drop the tables upon build for ease of testing
      show-sql: false
      properties:
        hibernate:
          format_sql: true
      database: postgresql
      database-platform: org.hibernate.dialect.PostgreSQLDialect # Database dialect

application:
  security:
    jwt:
      secret-key: # Your desired JWT secret key
      expiration: # Time to expiration
      refresh-token:
        expiration: # Refresh token time to expiration
```
3. Modify the `SpringSecurityApplication.java` file `commandLineRunner` method to provide your database with example data upon building
   ```java
   var admin = RegisterRequest.builder()
					.firstname("Admin 1232")
					.lastname("admin")
					.email("admin12222@mail.com")
					.password("password")
					.role(ADMIN)
					.build();
   ```
   
#### Advice

1. When developing Spring web applications, the JWT tokens should not be stored on the metal but rather within the browser's memory in your desired method of choice. This is simply an example.
2. The example Postgres database is used because of the JPA ORM for ease of use but can be replaced very swiftly.
3. Your Authentication database should not be conjoined with your resource database for a multitude of reasons.

## API-Reference
   
  
  


