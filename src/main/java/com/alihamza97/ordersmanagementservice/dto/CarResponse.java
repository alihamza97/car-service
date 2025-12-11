package com.alihamza97.ordersmanagementservice.dto;

import com.alihamza97.ordersmanagementservice.model.CarCondition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {
    private String id;
    private String carName;
    private String carModel;
    private String carPrice;
    private CarCondition condition;
}
