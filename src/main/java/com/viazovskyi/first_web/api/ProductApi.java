package com.viazovskyi.first_web.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/product")
public class ProductApi {

    @GetMapping(value = "/get-product")
    public String getProduct() {
        return "Product1";
    }

    @GetMapping(value = "/get-product2")
    public String getProduct2() {
        return "Product2";
    }


}
