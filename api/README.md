# Easy Budget API

A Spring Boot REST API for managing personal finances and transactions.

## Project Structure

```
api/
├── src/
│   ├── main/
│   │   ├── java/easy_budget/
│   │   │   ├── EasyBudgetApiApplication.java
│   │   │   ├── controller/     # REST controllers
│   │   │   ├── model/          # JPA entities
│   │   │   ├── repository/     # Data access layer
│   │   │   └── service/        # Business logic layer
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/easy_budget/
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites
- Java 21
- Maven
- PostgreSQL

### Running the Application

1. Start PostgreSQL database
2. Update `application.properties` with your database configuration
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

### Building the Application

```bash
mvn clean package
```

## API Endpoints

- `GET /api/health` - Health check endpoint
- `GET /api/transactions` - Get all transactions
- `POST /api/transactions` - Create a new transaction
- `GET /api/insights` - Get financial insights

## Technologies Used

- Spring Boot 3.5.3
- Spring Data JPA
- PostgreSQL
- Lombok 