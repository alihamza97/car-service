package com.alihamza97.carservice.dto;

import com.alihamza97.carservice.model.CarCondition;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarRequest {
    private String carName;
    private String carModel;
    private BigDecimal carPrice;
    private CarCondition condition;

}
