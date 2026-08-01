package com.swap.SpringKafkaDemo.listner;

import com.swap.SpringKafkaDemo.entity.Book;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaBookListeners {

    @KafkaListener(topics = "booktopic",
            groupId = "book-group",
            containerFactory = "kafkaListenerBookContainerFactory")
    public void bookListener(Book data) {
        System.out.println("Listener received : " + data + " :) ");
    }
}
