package com.petshopsystem.petshopmessageapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.petshopsystem.petshopmessageapi.service.Schedulable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final Schedulable appointmentService;

    public AppointmentController (Schedulable appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void register (@RequestBody AppointmentRequest appointmentRequest) {

        try {
            appointmentService.create(appointmentRequest.toAppointment());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
