package com.alihamza97.ordersmanagementservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Car {

    @Id
    private String id;

    private String carName;

    private String carModel;

    private String carPrice;

    private CarCondition condition;


}
