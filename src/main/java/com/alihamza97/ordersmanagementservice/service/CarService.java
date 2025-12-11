package com.alihamza97.ordersmanagementservice.service;

import com.alihamza97.ordersmanagementservice.dto.CarRequest;
import com.alihamza97.ordersmanagementservice.mapper.CarMapper;
import com.alihamza97.ordersmanagementservice.model.Car;
import com.alihamza97.ordersmanagementservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public List<Car> getAll() {
        log.debug("Retrieving all cars from database");
        List<Car> cars = carRepository.findAll();
        log.debug("Found {} cars", cars.size());
        return cars;
    }

    public Car getById(String id) {
        log.debug("Searching for car with id: {}", id);
        Car car = carRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Car not found with id: {}", id);
                    return new RuntimeException("Car not found");
                });
        log.debug("Successfully found car with id: {}", id);
        return car;
    }

    public Car createCar(CarRequest req) {
        log.debug("Mapping CarRequest to entity: {}", req);
        Car carEntity = carMapper.toEntity(req);
        log.debug("Saving car entity to database");
        Car savedCar = carRepository.save(carEntity);
        log.info("Successfully created car with id: {}", savedCar.getId());
        return savedCar;
    }
}
