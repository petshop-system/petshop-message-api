package com.petshopsystem.petshopmessageapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.petshopsystem.petshopmessageapi.repository.MessageProducible;
import com.petshopsystem.petshopmessageapi.service.ScheduleService;
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
		ObjectMapper objectMapper = new ObjectMapper();
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		return objectMapper.registerModule(javaTimeModule);
	}

	@Bean
	public Schedulable scheduleService (MessageProducible messageProducible, ObjectMapper objectMapper) {
		return new ScheduleService(messageProducible, objectMapper);
	}
}
