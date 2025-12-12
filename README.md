# Car Service Application

A Spring Boot microservice for managing car inventory using MongoDB as the database.

## Technology Stack

- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data MongoDB** - ODM (Object-Document Mapping)
- **Lombok** - Reduces boilerplate code
- **Maven** - Dependency management
- **MongoDB** - NoSQL document database
- **SLF4J** - Logging framework

## 📋 Project Overview

This service provides RESTful APIs for car management operations including:
- Retrieve all cars
- Get car by ID
- Create new car entries

## 🏗️ Architecture

```
Controller Layer
       ↓
Service Layer (Business Logic)
       ↓
Repository Layer (Spring Data MongoDB)
       ↓
MongoDB Database
```

### Key Components

- **CarService** - Business logic and transaction management
- **CarRepository** - MongoDB data access using `MongoRepository`
- **CarMapper** - Maps between DTOs and entities
- **Car** - Domain entity (MongoDB document)
- **CarRequest** - DTO for creating cars

## 🗄️ Database

**MongoDB** is used instead of traditional SQL databases because:

- **Schema Flexibility** - Easy to add/modify fields without migrations
- **Document Model** - Maps naturally to Java objects
- **Horizontal Scaling** - Built-in sharding support
- **Performance** - Fast reads with embedded documents (no JOINs)
- **ACID Support** - Full transactions with replica sets (MongoDB 4.0+)

### How Spring Data MongoDB Works

```
Your Code
    ↓
Spring Data MongoDB (generates repository implementations)
    ↓
MongoTemplate (ODM - translates to MongoDB queries)
    ↓
MongoDB Java Driver (converts to BSON)
    ↓
MongoDB Database
```

## 🛠️ Setup & Installation

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- MongoDB 4.0+ (local or cloud instance)

### Configuration

Update `application.properties` or `application.yml`:

```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/car-service
      # For MongoDB Atlas (cloud):
      # uri: mongodb+srv://username:password@cluster.mongodb.net/car-service
```

### Run the Application

```bash
# Clone the repository
git clone https://github.com/alihamza97/car-service.git
cd car-service

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start on `http://localhost:8080` (default port).

## 📡 API Endpoints

### Get All Cars
```http
GET /api/cars
```

**Response:**
```json
[
  {
    "id": "507f1f77bcf86cd799439011",
    "carName": "Tesla Model 3",
    "carModel": "2023"
  }
]
```

### Get Car by ID
```http
GET /api/cars/{id}
```

**Response:**
```json
{
  "id": "507f1f77bcf86cd799439011",
  "carName": "Tesla Model 3",
  "carModel": "2023"
}
```

### Create Car
```http
POST /api/cars
Content-Type: application/json
```

**Request Body:**
```json
{
  "carName": "Tesla Model 3",
  "carModel": "2023"
}
```

**Response:**
```json
{
  "id": "507f1f77bcf86cd799439011",
  "carName": "Tesla Model 3",
  "carModel": "2023"
}
```

## 🔍 Code Structure

```
src/main/java/com/alihamza97/ordersmanagementservice/
├── controller/          # REST endpoints
├── service/            # Business logic
│   └── CarService.java
├── repository/         # MongoDB repositories
│   └── CarRepository.java
├── model/             # Domain entities
│   └── Car.java
├── dto/               # Data Transfer Objects
│   └── CarRequest.java
└── mapper/            # Entity-DTO mappers
    └── CarMapper.java
```

## 🧪 Testing

```bash
# Run tests
mvn test

# Run with coverage
mvn clean test jacoco:report
```

## 📝 Key Concepts

### MongoDB vs SQL Comparison

| Feature | SQL (Hibernate/JPA) | MongoDB (Spring Data) |
|---------|--------------------|-----------------------|
| **Mapping** | ORM (Object-Relational) | ODM (Object-Document) |
| **Query Language** | JPQL/SQL | MongoDB Query API |
| **Schema** | Fixed (tables/columns) | Flexible (documents) |
| **Transactions** | ACID by default | ACID (with replica sets) |
| **Scaling** | Vertical (bigger server) | Horizontal (sharding) |
| **Caching** | L1/L2 cache (Hibernate) | Database-level cache |

### Optional Pattern

The service uses Java's `Optional` to handle missing data safely:

```java
Car car = carRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("Car not found"));
```

This prevents `NullPointerException` and makes absence explicit.

## 🔧 Dependencies

```xml
<dependencies>
    <!-- Spring Boot Starter -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>
    
    <!-- Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 👤 Author

**Ali Hamza**


For issues or questions, please open an issue on the [GitHub repository](https://github.com/alihamza97/car-service/issues).

---

**Note:** This is a learning project demonstrating Spring Boot with MongoDB integration.
