package com.swap.SpringKafkaDemo;

import com.swap.SpringKafkaDemo.entity.Book;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "swaptopic",
            groupId = "swap-group")
   public void listener(String data) {
        System.out.println("Listener received : " + data + " :) ");
    }

    @KafkaListener(topics = "booktopic",
            groupId = "book-group",
            containerFactory = "kafkaListenerBookContainerFactory")
    public void bookListener(Book data) {
        System.out.println("Listener received : " + data + " :) ");
    }
}
