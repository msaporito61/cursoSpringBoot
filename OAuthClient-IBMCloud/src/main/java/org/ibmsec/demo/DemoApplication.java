package org.ibmsec.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

@SpringBootApplication
@EnableOAuth2Sso
public class DemoApplication {

	// Using generated security password: 2ccf0171-e566-412c-bc37-7d13037ad793
	// Using generated security password: e7e7cb7a-8e73-4dfd-8e6a-b761b6cbc0d0

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
