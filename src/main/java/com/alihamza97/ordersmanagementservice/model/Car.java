package com.alihamza97.ordersmanagementservice.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cars")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_name", nullable = false, length = 100)
    private String carName;

    @Column(name = "car_model", nullable = false, length = 100)
    private String carModel;

    @Column(name = "car_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal carPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "condition", length = 10)
    private CarCondition condition;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
