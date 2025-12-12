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



##(SQL ONLY)


## Run the curl to post data via rest endpoint in bulk to database or you can add it manually

# Array of car names
car_names=("Toyota Camry" "Honda Civic" "Ford Mustang" "BMW 3 Series" "Mercedes C-Class" 
           "Audi A4" "Tesla Model 3" "Chevrolet Malibu" "Nissan Altima" "Mazda 6"
           "Hyundai Sonata" "Kia Optima" "Volkswagen Passat" "Subaru Legacy" "Lexus ES")

car_models=("LX" "EX" "GT" "Sport" "Premium" "Base" "Deluxe" "Standard")

for i in {1..100}
do
  # Pick random car name and model
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
  echo ""
done

