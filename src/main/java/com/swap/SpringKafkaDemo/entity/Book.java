package com.swap.SpringKafkaDemo.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    private String bookName;
    private String isbn;
}
