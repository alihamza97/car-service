package com.alihamza97.carservice.mapper;

import com.alihamza97.carservice.dto.CarRequest;
import com.alihamza97.carservice.dto.CarResponse;
import com.alihamza97.carservice.model.Car;
import org.springframework.stereotype.Component;


@Component
public class CarMapper {

    public Car toEntity(CarRequest req) {
        if (req == null) {
            return null;
        }

        Car car = new Car();
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
