package com.ventas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.ventas"})
public class VentasApiSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(VentasApiSpringBootApplication.class, args);
	}

}
