package com.alihamza97.ordersmanagementservice.repository;

import com.alihamza97.ordersmanagementservice.model.Car;
import com.azure.spring.data.cosmos.repository.CosmosRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CosmosRepository<Car, String> {

    List<Car> findByCustomerEmail(String customerEmail);
}
