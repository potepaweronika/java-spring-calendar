package com.calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {      // TODO: Check if SOLID rules are not being broken

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
