package com.swap.SpringKafkaDemo.controller;

import com.swap.SpringKafkaDemo.entity.MessageRequest;
import com.swap.SpringKafkaDemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/messages")
    public String publish(@RequestBody MessageRequest request) {
        return messageService.publish(request.message());
    }
}
