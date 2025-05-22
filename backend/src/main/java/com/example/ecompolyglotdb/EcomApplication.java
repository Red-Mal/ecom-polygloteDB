package com.example.ecompolyglotdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.example.ecompolyglotdb.repository.mongo")
@EnableJpaRepositories(basePackages = "com.example.ecompolyglotdb.repository.postgres")
public class EcomApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcomApplication.class, args);
    }
} 