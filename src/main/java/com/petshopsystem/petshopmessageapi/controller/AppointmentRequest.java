package com.petshopsystem.petshopmessageapi.controller;

import com.petshopsystem.petshopmessageapi.service.Appointment;

public record AppointmentRequest (String nome) {

    Appointment toAppointment() {
        return new Appointment(this.nome);
    }
}
