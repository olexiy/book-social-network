# Book Social Network

[![00 - Main backend CI/CD Pipeline](https://github.com/olexiy/book-social-network/actions/workflows/build-backend.yml/badge.svg)](https://github.com/olexiy/book-social-network/actions/workflows/build-backend.yml)

## Overview

Book Social Network is a Java-based application that allows users to manage and share their book collections. The project uses Spring Boot for the backend and integrates with various services to provide a comprehensive book management experience.

## Overview

This project is a tutorial project designed to demonstrate and explore the following technologies and practices:

- **Spring Boot 3 Microservices**: Building and managing microservices using Spring Boot 3.
- **Angular Frontend**: Developing a modern, responsive frontend application using Angular.
- **DevSecOps with Security Services**: Integrating security practices into the DevOps pipeline to ensure secure development and deployment.
- **GitHub Actions**: Automating workflows, including CI/CD pipelines, using GitHub Actions.
- **AWS**: Deploying and managing the application on Amazon Web Services (AWS) for scalable and reliable cloud infrastructure.
## Features

- User authentication and authorization
- Book management (CRUD operations)
- Integration with external book APIs
- CI/CD pipeline for automated testing and deployment

## Technologies Used

- Java
- Spring Boot
- Maven
- Jakarta Validation
- Lombok
- Spring Security
- OpenAPI (Swagger)

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/olexiy/book-social-network.git
    cd book-social-network
    ```

2. Build the project:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

### Running Tests

To run the tests, use the following command:
```sh
mvn test
