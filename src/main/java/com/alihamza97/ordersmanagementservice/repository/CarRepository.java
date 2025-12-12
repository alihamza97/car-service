package com.alihamza97.ordersmanagementservice.repository;

import com.alihamza97.ordersmanagementservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
