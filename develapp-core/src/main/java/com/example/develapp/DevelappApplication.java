package com.example.develapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class DevelappApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevelappApplication.class, args);
    }


}
