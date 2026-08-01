package com.swap.SpringKafkaDemo.service;

import com.swap.SpringKafkaDemo.entity.Book;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private KafkaTemplate<String, Book> kafkaBookTemplate;

    public BookService(KafkaTemplate<String, Book> kafkaTemplate) {
        this.kafkaBookTemplate = kafkaTemplate;
    }

    public Book publish(Book book) {
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
