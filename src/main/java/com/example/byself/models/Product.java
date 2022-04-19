package com.example.byself.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    Long id;
    private String title;
    private String description;
    private int price;
    private String city;
    private String author;
}
