package org.cursospring.vanservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class VanServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VanServiceApplication.class, args);
	}

}
