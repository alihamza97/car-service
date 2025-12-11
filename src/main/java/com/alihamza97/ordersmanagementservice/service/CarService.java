package com.alihamza97.ordersmanagementservice.service;

import com.alihamza97.ordersmanagementservice.dto.CarRequest;
import com.alihamza97.ordersmanagementservice.mapper.CarMapper;
import com.alihamza97.ordersmanagementservice.model.Car;
import com.alihamza97.ordersmanagementservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public List<Car> getAll() {
        return (List<Car>) carRepository.findAll();
    }

    public Car getById(String id) {
        return carRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public List<Car> getByCustomerEmail(String email) {
        return carRepository.findByCustomerEmail(email);
    }

    public Car createCar(CarRequest req) {
        return carRepository.save(carMapper.toEntity(req));
    }
}
