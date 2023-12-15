# Calendar Web App - Java Spring Boot

## Overview
This repository contains a Java Spring Boot web application for managing events and user profiles. The application includes features such as user registration, login, private event creation, event modification and deletion, and user profile management. The data is stored in an H2 file-based database.

## Features
- User Registration and Login
- Private Event Creation for Logged-In Users
- Modification and Deletion of Events
- User Profile Management
- H2 File-Based Database for Data Storage
- Bootstrap CSS for HTML Pages Styling

## Technologies Used
- Java 17
- Maven
- Spring Boot Starter Data JPA
- Spring Boot Starter Security
- Spring Boot Starter Thymeleaf
- Thymeleaf Extras Spring Security 5
- H2 Database (Runtime Scope)
- Spring Boot Starter Web
- Spring Boot DevTools (Runtime Scope)
- Spring Boot Starter Test (Test Scope)
- Spring Security Test (Test Scope)
- JUnit Jupiter API (Test Scope)
- JUnit Jupiter Engine (Test Scope)
- JUnit (Test Scope)

## Build and Run
1. Clone the repository: `https://github.com/potepaweronika/java-spring-calendar.git`
2. Navigate to the project directory: `cd java-spring-calendar`
3. Build the project: `mvn clean install`
4. Run the application: `mvn spring-boot:run`

## Access
- Application: [http://localhost:8080](http://localhost:8080)
- H2 Database Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console) (JDBC URL: jdbc:h2:file:./data/calendar)

## Test User Credentials
Use the following credentials for testing:

### Regular User:
- **Email:** user@mail.com
- **Password:** test

### Admin User:
- **Email:** admin@mail.com
- **Password:** test

## Usage
1. Access the application and register/login.
2. Create, modify, and delete events from your profile.
3. View and manage your profile details.

### Admin Access
- Admin credentials are required to access:
  - Show All Events: [http://localhost:8080/show-all-events](http://localhost:8080/show-all-events)
  - Show All Users: [http://localhost:8080/show-all-users](http://localhost:8080/show-all-users)

## Testing
- Run tests using: `mvn test`
