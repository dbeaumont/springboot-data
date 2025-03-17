# springboot-data

Hexagonal Architecture Demo
 - Java
 - Spring Boot
 - Angular
 - Docker
 - PostgreSQL

A full-stack demonstration project showcasing hexagonal architecture principles with Spring Boot, Angular, and PostgreSQL, all containerized with Docker.

## Overview
This project implements a simple message application that:
 - Displays existing messages from the database via Get REST API
 - Allows creating new messages via Post REST API
 - Demonstrates clean architecture principles
 - Provides a fully containerized development environment

## Architecture
System Components

```text
┌─────────────┐      ┌──────────────┐      ┌─────────────┐
│   Angular   │ ──▶  │  Spring Boot │ ──▶  │ PostgreSQL  │
│  Frontend   │ ◀──  │   Backend    │ ◀──  │  Database   │
└─────────────┘      └──────────────┘      └─────────────┘
```

### Backend Hexagonal Architecture
The backend follows the hexagonal (ports and adapters) architecture pattern:
 - Domain Layer: Core business logic and domain models
 - Application Layer: Use cases and application services
 - Infrastructure Layer: Adapters for external systems (REST, database)

### Tech Stack
 - Frontend:
   - Angular
   - TypeScript
   - HTTP Client for API communication
 - Backend:
   - Java 21
   - Spring Boot 3.3.3
   - Maven (multi-module)
   - JPA / Hibernate
 - Database:
   - PostgreSQL
- DevOps:
   - Docker
   - Docker-compose
  
### Project Structure

```text
.
├── frontend/                         # Angular application
│   ├── src/
│   └── Dockerfile
│
├── backend/                          # Spring Boot application
│   ├── domain/                       # Domain module
│   ├── application/                  # Application module
│   ├── infrastructure/               # Infrastructure module
│   ├── bootstrap/                    # SpringBoot application module
│   └── Dockerfile
│
├── docker-compose.yml
└── README.md

```

## Getting Started
Prerequisites
 - Docker and Docker Compose
 - For local development: Java 21, Node.js, Maven

Running with Docker

 1. Clone the repository
```bash
git clone https://github.com/dbeaumont/springboot-data.git
cd springboot-data
```

 2. Build the application stack
```bash
./build.sh
```

 3. Start the application stack
```bash
./start.sh
```

 5. Log containers stack
```bash
./logs.sh
```
 6. Access the application
    - Frontend: http://localhost:4200
    - Backend API: http://localhost:8080/api/data

 7. Stop the application stack
```bash
./stop.sh
```

## Local Development
Backend
```bash
cd backend
./mvnw clean install
./mvnw spring-boot:run -pl infrastructure
```
Frontend
```bash
cd frontend
npm install
npm start
```

## Key Features
1.	Hexagonal Architecture
    - Clear separation of concerns
    - Domain-driven design
    - Testable components
2.	CORS Security
    - Configurable allowed origins
    - Secure cross-domain communication
    - Backend API calls are proxified using Frontend web server as a reverse proxy
3.	Docker Integration
    - Containerized services
    - Environment-specific configuration
    - Volume persistence
4.	Multi-Module Maven Structure
    - Clean dependency management
    - Separation of layers
    - Independent testing


