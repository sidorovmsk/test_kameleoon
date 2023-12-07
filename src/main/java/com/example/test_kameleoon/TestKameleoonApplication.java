package com.example.test_kameleoon;

import com.example.test_kameleoon.config.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AppConfig.class)
public class TestKameleoonApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestKameleoonApplication.class, args);
    }

}
