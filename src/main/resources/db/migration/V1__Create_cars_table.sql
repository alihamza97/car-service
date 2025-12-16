-- Create cars table with proper constraints
CREATE TABLE cars (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    car_name NVARCHAR(100) NOT NULL,
    car_model NVARCHAR(100) NOT NULL,
    car_price DECIMAL(10, 2) NOT NULL,
    condition NVARCHAR(10) CHECK (condition IN ('NEW', 'USED')),
    created_at DATETIME2 DEFAULT GETDATE(),
    updated_at DATETIME2
);

-- Create indexes for better query performance
CREATE INDEX idx_cars_name ON cars(car_name);
CREATE INDEX idx_cars_condition ON cars(condition);
