package com.swap.SpringKafkaDemo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "swaptopic",
            groupId = "swap-group")
   public void listener(String data) {
        System.out.println("Listener received : " + data + " :) ");
    }
}
