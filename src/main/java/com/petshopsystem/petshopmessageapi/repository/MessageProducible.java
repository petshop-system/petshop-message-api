package com.petshopsystem.petshopmessageapi.repository;

public interface MessageProducible {

    void sendMessage(String topicName, String msg);

}
