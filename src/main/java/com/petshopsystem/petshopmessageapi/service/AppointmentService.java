package com.petshopsystem.petshopmessageapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petshopsystem.petshopmessageapi.repository.MessageProducible;
import org.springframework.beans.factory.annotation.Value;

public class AppointmentService implements Schedulable {

    @Value("${message.appointment.topic-name:}")
    private String APPOINTMENT_TOPIC;

    private final MessageProducible messageProducible;

    private final ObjectMapper objectMapper;

    public AppointmentService(MessageProducible messageProducible, ObjectMapper objectMapper) {
        this.messageProducible = messageProducible;
        this.objectMapper = objectMapper;
    }

    @Override
    public void create(Appointment appointment) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(appointment);
        messageProducible.sendMessage(APPOINTMENT_TOPIC, message);
    }
}
