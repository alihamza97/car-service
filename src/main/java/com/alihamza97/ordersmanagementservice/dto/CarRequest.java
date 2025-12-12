package com.alihamza97.ordersmanagementservice.dto;

import com.alihamza97.ordersmanagementservice.model.CarCondition;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarRequest {
    private String carName;
    private String carModel;
    private BigDecimal carPrice;
    private CarCondition condition;

}
