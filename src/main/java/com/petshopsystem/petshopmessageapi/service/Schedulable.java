package com.petshopsystem.petshopmessageapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Schedulable {

    void create(Schedule appointment) throws JsonProcessingException;
}
