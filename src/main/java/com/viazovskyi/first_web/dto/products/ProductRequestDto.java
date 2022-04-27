package com.viazovskyi.first_web.dto.products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDto {
    private String name;
    private double price;
    private String description;
    private String country;
}
