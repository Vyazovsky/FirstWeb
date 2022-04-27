package com.viazovskyi.first_web.exception.product;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String id){
        super("Product not found with id - " + id);
    }
}
