package com.alihamza97.ordersmanagementservice.mapper;

import com.alihamza97.ordersmanagementservice.dto.CarRequest;
import com.alihamza97.ordersmanagementservice.dto.CarResponse;
import com.alihamza97.ordersmanagementservice.model.Car;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CarMapper {

    public Car toEntity(CarRequest req) {
        Car car = new Car();
        car.setId(UUID.randomUUID().toString());   // Cosmos id must be String
        car.setCarModel(req.getCarModel());
        car.setCarPrice(req.getCarPrice());
        car.setCarName(req.getCarName());

        return car;
    }

    public CarResponse toResponse(Car car) {
        CarResponse response = new CarResponse();
        response.setId(car.getId());
        response.setCarName(car.getCarName());
        response.setCarPrice(car.getCarPrice());
        response.setCarModel(car.getCarModel());
        response.setCondition(car.getCondition());
        return response;
    }
}
