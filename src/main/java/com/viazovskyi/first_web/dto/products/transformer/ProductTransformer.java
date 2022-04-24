package com.viazovskyi.first_web.dto.products.transformer;

import com.viazovskyi.first_web.dto.products.ProductRequestDto;
import com.viazovskyi.first_web.model.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductTransformer {
    public static Product toProduct(ProductRequestDto requestDto) {
//        return new Product()
//                .setCountry(requestDto.getCountry())
//                .setName(requestDto.getName())
//                .setPrice(requestDto.getPrice())
//                .setDescription(requestDto.getDescription());
        Product product = new Product();
        BeanUtils.copyProperties(requestDto, product);
        return product;

    }
}
