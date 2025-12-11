package com.alihamza97.ordersmanagementservice.controller;

import com.alihamza97.ordersmanagementservice.dto.CarRequest;
import com.alihamza97.ordersmanagementservice.model.Car;
import com.alihamza97.ordersmanagementservice.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    public ResponseEntity<Car> createOrder(@RequestBody CarRequest request) {
        Car createdCar = carService.createOrder(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllOrders() {
        return ResponseEntity.ok(carService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getOrderById(@PathVariable String id) {
        return ResponseEntity.ok(carService.getById(id));
    }

    @GetMapping("/customer/{email}")
    public ResponseEntity<List<Car>> getOrdersByEmail(@PathVariable String email) {
        return ResponseEntity.ok(carService.getByCustomerEmail(email));
    }
}
