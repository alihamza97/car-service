package com.alihamza97.ordersmanagementservice.repository;

import com.alihamza97.ordersmanagementservice.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<Car, String> {

}
