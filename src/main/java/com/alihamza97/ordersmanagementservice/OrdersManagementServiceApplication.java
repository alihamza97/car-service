package com.alihamza97.ordersmanagementservice;

import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableCosmosRepositories(basePackages = "com.alihamza97.ordersmanagementservice.repository")

public class OrdersManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdersManagementServiceApplication.class, args);
    }

}
