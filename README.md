Here's the updated README for your project:

```markdown
# Car Service

A Spring Boot application for managing cars with Azure SQL Database integration.

## Technologies Used

- Java 17
- Spring Boot 3.5.6
- Maven
- Azure SQL Database
- Flyway (Database Migration)
- Lombok
- MapStruct
- Spring DotEnv

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- Azure SQL Database instance

## Getting Started

### Installation

1. Clone the repository:
```bash
git clone <repository-url>
cd car-service
```

2. Configure your environment:

Create a `.env` file in the root directory with your Azure SQL Database credentials:
```properties
DB_URL=jdbc:sqlserver://<your-server>.database.windows.net:1433;database=<your-database>;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;
DB_USERNAME=<your-username>
DB_PASSWORD=<your-password>
```

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Project Structure

```
car-service/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/carservice/
│   │   │       ├── controller/     # REST API endpoints
│   │   │       ├── service/        # Business logic
│   │   │       ├── repository/     # Data access layer
│   │   │       ├── model/          # Domain entities
│   │   │       ├── dto/            # Data transfer objects
│   │   │       └── mapper/         # MapStruct mappers
│   │   └── resources/
│   │       ├── db/migration/       # Flyway migration scripts
│   │       └── application.properties
│   └── test/
│       └── java/                   # Test files
├── .env                            # Environment variables
└── pom.xml                         # Maven configuration
```

## Database Schema

### Cars Table

| Column | Type | Description |
|--------|------|-------------|
| id | BIGINT (PK) | Auto-generated unique identifier |
| car_name | NVARCHAR(255) | Name of the car |
| car_model | NVARCHAR(100) | Model of the car |
| car_price | DECIMAL(10,2) | Price of the car |
| condition | NVARCHAR(10) | Condition (NEW or USED) |
| created_at | DATETIME2 | Timestamp of creation |
| updated_at | DATETIME2 | Timestamp of last update |

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/cars` | Create a new car |
| GET | `/api/cars` | Get all cars |
| GET | `/api/cars/{id}` | Get car by ID |
| PUT | `/api/cars/{id}` | Update car |
| DELETE | `/api/cars/{id}` | Delete car |

## Database Migration

This project uses Flyway for database version control. Migration scripts are located in `src/main/resources/db/migration/`.

The initial migration (`V1__Create_cars_table.sql`) creates:
- The `cars` table with all necessary columns
- Indexes for optimized queries
- Check constraints for data validation

Flyway automatically runs migrations on application startup.

## Bulk Data Import

You can populate the database with sample data using the following bash script:

```bash
#!/bin/bash

# Array of car names
```
car_names=("Toyota Camry" "Honda Civic" "Ford Mustang" "BMW 3 Series" "Mercedes C-Class"
           "Audi A4" "Tesla Model 3" "Chevrolet Malibu" "Nissan Altima" "Mazda 6"
           "Hyundai Sonata" "Kia Optima" "Volkswagen Passat" "Subaru Legacy" "Lexus ES")

car_models=("LX" "EX" "GT" "Sport" "Premium" "Base" "Deluxe" "Standard")

for i in {1..100}
do
  car_name="${car_names[$((RANDOM % ${#car_names[@]}))]}"
  car_model="${car_models[$((RANDOM % ${#car_models[@]}))]} $(date +%Y)"

  curl -X POST http://localhost:8080/api/cars \
    -H "Content-Type: application/json" \
    -d "{
      \"carName\": \"$car_name\",
      \"carModel\": \"$car_model\",
      \"carPrice\": $((RANDOM % 50000 + 10000)),
      \"condition\": \"$([ $((RANDOM % 2)) -eq 0 ] && echo 'NEW' || echo 'USED')\"
    }"
  echo "Inserted car $i"
done

echo "Successfully inserted 100 cars!"
```

### To run the script:

1. Save the script as `insert_cars.sh`
2. Make it executable: `chmod +x insert_cars.sh`
3. Ensure your application is running
4. Execute: `./insert_cars.sh`

This will insert 100 random car records into your database.

## Testing

Run all tests:
```bash
mvn test
```

Run tests with coverage:
```bash
mvn clean test jacoco:report
```

## Building for Production

Create a production build:
```bash
mvn clean package -DskipTests
```

The JAR file will be created in the `target/` directory.

## Running in Production

```bash
java -jar target/car-service-0.0.1-SNAPSHOT.jar
```

## Troubleshooting

### Database Connection Issues
- Verify your `.env` file has correct credentials
- Ensure your Azure SQL Database firewall allows your IP address
- Check if the database server is running

### Flyway Migration Errors
- Check migration scripts in `src/main/resources/db/migration/`
- Ensure migration files follow naming convention: `V<version>__<description>.sql`
- Verify database user has necessary permissions
