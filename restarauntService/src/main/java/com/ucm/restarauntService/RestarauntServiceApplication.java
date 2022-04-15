package com.ucm.restarauntService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestarauntServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestarauntServiceApplication.class, args);
	}

}
