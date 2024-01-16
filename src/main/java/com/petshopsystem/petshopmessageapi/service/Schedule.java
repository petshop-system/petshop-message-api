package com.petshopsystem.petshopmessageapi.service;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Schedule {

    @JsonProperty(value = "booking", required = true)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime booking;

    @JsonProperty(value = "pet_id", required = true)
    private Long petID;

    @JsonProperty(value = "service_employee_attention_id", required = true)
    private Long serviceEmployeeAttentionID;

    public Schedule() {
    }

    public Schedule(LocalDateTime booking, Long petID, Long serviceEmployeeAttentionID) {
        this.booking = booking;
        this.petID = petID;
        this.serviceEmployeeAttentionID = serviceEmployeeAttentionID;
    }

    public LocalDateTime getBooking() {
        return booking;
    }

    public void setBooking(LocalDateTime booking) {
        this.booking = booking;
    }

    public Long getPetID() {
        return petID;
    }

    public void setPetID(Long petID) {
        this.petID = petID;
    }

    public Long getServiceEmployeeAttentionID() {
        return serviceEmployeeAttentionID;
    }

    public void setServiceEmployeeAttentionID(Long serviceEmployeeAttentionID) {
        this.serviceEmployeeAttentionID = serviceEmployeeAttentionID;
    }
}
