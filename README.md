Here's the corrected README file for your car service:

```markdown
# Car Service

A Spring Boot application for managing cars with MongoDB integration.

## Technologies Used

- Java 17
- Spring Boot 3.5.6
- Maven
- MongoDB
- Lombok
- MapStruct
- Spring DotEnv

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- MongoDB

## Getting Started

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd car-service
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

## Project Structure

- `src/main/java` - Java source files
- `src/main/resources` - Configuration files
- `src/test/java` - Test files

## Models

- **Car** - Represents a car entity with properties like name, model, price, and condition

## Configuration

Create a `.env` file or update `application.properties` with your MongoDB connection details.

```
