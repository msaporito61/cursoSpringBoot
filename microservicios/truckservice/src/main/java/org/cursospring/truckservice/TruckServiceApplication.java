package org.cursospring.truckservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TruckServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruckServiceApplication.class, args);
	}

}
