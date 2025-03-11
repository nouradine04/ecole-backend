package com.ecole.emploidutemps.emploi_du_temps_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EmploiDuTempsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmploiDuTempsServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
