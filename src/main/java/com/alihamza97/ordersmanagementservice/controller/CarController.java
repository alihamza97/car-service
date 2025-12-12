package com.alihamza97.ordersmanagementservice.controller;

import com.alihamza97.ordersmanagementservice.dto.CarRequest;
import com.alihamza97.ordersmanagementservice.model.Car;
import com.alihamza97.ordersmanagementservice.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@RequiredArgsConstructor
@Slf4j
public class CarController {

    private final CarService carService;

    @PostMapping
    public ResponseEntity<Car> createOrder(@Valid @RequestBody CarRequest request) {
        log.info("Creating new car order with request: {}", request);
        Car createdCar = carService.createCar(request);
        log.info("Successfully created car with id: {}", createdCar.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        log.info("Fetching all cars");
        List<Car> cars = carService.getAll();
        log.info("Retrieved {} cars", cars.size());
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        log.info("Fetching car with id: {}", id);
        Car car = carService.getById(id);
        log.info("Successfully retrieved car with id: {}", id);
        return ResponseEntity.ok(car);
    }

}
