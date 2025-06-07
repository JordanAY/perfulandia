package com.soporte.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.soporte"})
public class SoporteTicketApiSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoporteTicketApiSpringBootApplication.class, args);
    }
}
