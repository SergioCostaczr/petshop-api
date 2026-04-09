package com.github.sergiocostaczr.petshopapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PetshopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetshopApiApplication.class, args);
	}

}
