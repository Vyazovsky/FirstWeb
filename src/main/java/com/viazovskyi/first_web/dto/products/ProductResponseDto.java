package com.viazovskyi.first_web.dto.products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private String id;
    private String name;
    private double price;
    private double actualPrice;

    public ProductResponseDto setActualPrice(int percentage) {
        actualPrice = price - (price / 100 * percentage);
        return this;
    }
}
