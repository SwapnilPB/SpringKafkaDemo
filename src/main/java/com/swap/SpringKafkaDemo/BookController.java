package com.swap.SpringKafkaDemo;

import com.swap.SpringKafkaDemo.entity.Book;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    private KafkaTemplate<String, Book> kafkaBookTemplate;

    public BookController(KafkaTemplate<String, Book> kafkaTemplate) {
        this.kafkaBookTemplate = kafkaTemplate;
    }

    @PostMapping("/publish")
    public Book publish(@RequestBody Book book) {
        kafkaBookTemplate.send("booktopic", book)
        .whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Published Successfully");
            } else {
                ex.printStackTrace();
            }
        });
        return book;
    }
}
