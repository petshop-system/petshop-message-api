package com.petshopsystem.petshopmessageapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.petshopsystem.petshopmessageapi.repository.MessageProducible;
import org.springframework.beans.factory.annotation.Value;

public class ScheduleService implements Schedulable {

    @Value("${message.schedule.topic-name:}")
    private String SCHEDULE_TOPIC;

    private final MessageProducible messageProducible;

    private final ObjectMapper objectMapper;

    public ScheduleService(MessageProducible messageProducible, ObjectMapper objectMapper) {
        this.messageProducible = messageProducible;
        this.objectMapper = objectMapper;
    }

    @Override
    public void create(Schedule schedule) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(schedule);
        messageProducible.sendMessage(SCHEDULE_TOPIC, message);
    }
}
