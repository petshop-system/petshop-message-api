package com.petshopsystem.petshopmessageapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.petshopsystem.petshopmessageapi.service.Schedulable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    private final Schedulable scheduleService;

    public ScheduleController(Schedulable scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping(path = "/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void register (@RequestBody ScheduleRequest scheduleRequest) {

        try {
            scheduleService.create(scheduleRequest.toSchedule());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
