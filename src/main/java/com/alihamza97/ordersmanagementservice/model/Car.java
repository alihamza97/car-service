package com.alihamza97.ordersmanagementservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_name")
    private String carName;

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "car_price")
    private String carPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "condition")
    private CarCondition condition;


}
