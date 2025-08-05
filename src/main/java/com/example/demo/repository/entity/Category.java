package com.example.demo.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class Category extends AggregateRoot{
    private Long id;
    private String name;

}
