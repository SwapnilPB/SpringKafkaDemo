package com.swap.SpringKafkaDemo.service;

import com.swap.SpringKafkaDemo.entity.Book;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String publish(String data) {
        kafkaTemplate.send("swaptopic", data)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        System.out.println("Message sent");
                    } else {
                        ex.printStackTrace();
                    }
                });
        return "Published successfully";
    }
}
