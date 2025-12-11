package com.alihamza97.ordersmanagementservice.mapper;

import com.alihamza97.ordersmanagementservice.dto.CarRequest;
import com.alihamza97.ordersmanagementservice.dto.CarResponse;
import com.alihamza97.ordersmanagementservice.model.Car;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Mapper
public interface CarMapper {

    Car toEntity(CarRequest req);

    CarResponse toResponse(Car car);
}
