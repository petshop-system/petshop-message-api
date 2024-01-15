package com.petshopsystem.petshopmessageapi.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.petshopsystem.petshopmessageapi.service.Schedule;

import java.time.LocalDateTime;

public record ScheduleRequest(
        @JsonProperty(value = "booking", required = true)
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime booking,

        @JsonProperty(value = "pet_id", required = true)
        Long petID,

        @JsonProperty(value = "service_employee_attention_id", required = true)
        Long serviceEmployeeAttentionID) {

    Schedule toSchedule() {
        return new Schedule(booking, petID, serviceEmployeeAttentionID);
    }
}
