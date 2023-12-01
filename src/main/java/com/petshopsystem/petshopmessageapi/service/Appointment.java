package com.petshopsystem.petshopmessageapi.service;

public class Appointment {

    private String nome;

    public Appointment(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
