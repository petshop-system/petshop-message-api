package com.petshopsystem.petshopmessageapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petshopsystem.petshopmessageapi.repository.MessageProducible;
import com.petshopsystem.petshopmessageapi.service.AppointmentService;
import com.petshopsystem.petshopmessageapi.service.Schedulable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PetshopMessageApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetshopMessageApiApplication.class, args);
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public Schedulable appointmentService (MessageProducible messageProducible, ObjectMapper objectMapper) {
		return new AppointmentService(messageProducible, objectMapper);
	}
}
