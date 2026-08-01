package com.swap.SpringKafkaDemo.controller;

import com.swap.SpringKafkaDemo.entity.Book;
import com.swap.SpringKafkaDemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
   private BookService bookService;

    @PostMapping("/publish")
    public Book publish(@RequestBody Book book) {
        return bookService.publish(book);
    }
}
