package com.alihamza97.ordersmanagementservice.dto;

import com.alihamza97.ordersmanagementservice.model.CarCondition;
import lombok.Data;

@Data
public class CarRequest {
    private String carName;
    private String carModel;
    private String carPrice;
    private CarCondition condition;

}
