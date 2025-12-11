//package com.alihamza97.ordersmanagementservice;
//
//import com.azure.cosmos.CosmosAsyncClient;
//import com.azure.cosmos.CosmosClient;
//import com.azure.cosmos.CosmosClientBuilder;
//import com.azure.spring.data.cosmos.CosmosFactory;
//import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
//import com.azure.spring.data.cosmos.config.CosmosConfig;
//import com.azure.spring.data.cosmos.core.CosmosTemplate;
//import com.azure.spring.data.cosmos.core.convert.MappingCosmosConverter;
//import com.azure.spring.data.cosmos.core.mapping.CosmosMappingContext;
//import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableCosmosRepositories
//public class AzureCosmosConfiguration extends AbstractCosmosConfiguration {
//
//    @Value("${spring.data.cosmos.uri}")
//    private String uri;
//
//    @Value("${spring.data.cosmos.key}")
//    private String key;
//
//    @Value("${spring.data.cosmos.database}")
//    private String database;
//
////    @Bean
////    public com.azure.cosmos.CosmosClient cosmosClient() {
////        return new CosmosClientBuilder()
////                .endpoint(uri)
////                .key(key)
////                .directMode()
////                .buildClient();
////    }
//
//    @Bean
//    public CosmosClientBuilder getCosmosClientBuilder() {
//        return new CosmosClientBuilder()
//                .endpoint(uri)
//                .key(key);
//    }
//
//
//    @Bean
//    public CosmosConfig cosmosConfig() {
//        return CosmosConfig.builder()
//                .enableQueryMetrics(true)
//                .build();
//    }
//
////    @Bean(name = "cosmosTemplate")
////    public CosmosTemplate cosmosTemplate(CosmosAsyncClient cosmosClient,
////                                         CosmosConfig cosmosConfig,
////                                         MappingCosmosConverter mappingCosmosConverter) {
////        CosmosFactory cosmosFactory = new CosmosFactory(cosmosClient, database);
////        return new CosmosTemplate(cosmosFactory, cosmosConfig, mappingCosmosConverter);
////    }
//
//    @Override
//    protected String getDatabaseName() {
//            return database != null ? database : "cosmodb";
//
//    }
//}
