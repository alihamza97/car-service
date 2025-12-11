package com.alihamza97.ordersmanagementservice.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

//@Entity
//@Table(name = "orders")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Container(containerName = "orders")
public class Car {

    //    NoSQL Cosmos DB Version:
    @Id                     // Cosmos document id (string!)
    private String id;

    private String carName;

    @PartitionKey           // <- will be /customerEmail in Cosmos
    private String carModel;

    private String carPrice;

    private CarCondition condition;


}
