package com.viazovskyi.first_web.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Setting;

@Getter
@Setter
@Document(indexName = "product_data")
@Setting(shards = 4)
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private String description;
    private String country;
}
