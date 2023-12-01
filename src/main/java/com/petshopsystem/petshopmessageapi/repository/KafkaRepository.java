package com.petshopsystem.petshopmessageapi.repository;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

public class KafkaRepository implements MessageProducible {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaRepository (KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String topicName, String msg) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, msg);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + msg +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        msg + "] due to : " + ex.getMessage());
            }
        });
    }

}
