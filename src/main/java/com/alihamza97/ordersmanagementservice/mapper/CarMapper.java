package com.alihamza97.ordersmanagementservice.mapper;

import com.alihamza97.ordersmanagementservice.dto.CarRequest;
import com.alihamza97.ordersmanagementservice.dto.CarResponse;
import com.alihamza97.ordersmanagementservice.model.Car;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
public class CarMapper {

    public Car toEntity(CarRequest req) {
        if (req == null) {
            return null;
        }

        Car car = new Car();
        car.setId(UUID.randomUUID().toString());
        car.setCarName(req.getCarName());
        car.setCarModel(req.getCarModel());
        car.setCarPrice(req.getCarPrice());
        car.setCondition(req.getCondition());

        return car;
    }

    public CarResponse toResponse(Car car) {
        if (car == null) {
            return null;
        }

        CarResponse response = new CarResponse();
        response.setId(car.getId());
        response.setCarName(car.getCarName());
        response.setCarModel(car.getCarModel());
        response.setCarPrice(car.getCarPrice());
        response.setCondition(car.getCondition());

        return response;
    }
}
