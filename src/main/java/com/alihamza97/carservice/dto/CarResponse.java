package com.alihamza97.carservice.dto;

import com.alihamza97.carservice.model.CarCondition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarResponse {
    private Long id;
    private String carName;
    private String carModel;
    private BigDecimal carPrice;
    private CarCondition condition;
}
