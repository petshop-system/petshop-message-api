package com.petshopsystem.petshopmessageapi.service;

import java.time.LocalDateTime;

public class Schedule {
    private LocalDateTime booking;

    private Long petID;

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
