package com.viazovskyi.first_web.dto.products.transformer;

import com.viazovskyi.first_web.dto.products.ProductRequestDto;
import com.viazovskyi.first_web.dto.products.ProductResponseDto;
import com.viazovskyi.first_web.model.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

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

    public static ProductResponseDto toProductTwoField(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        BeanUtils.copyProperties(product, productResponseDto);
        return productResponseDto;

    }

    public static List<ProductResponseDto> toListPRDto(List<Product> productList) {
        List<ProductResponseDto> productResponseDto = new ArrayList<>();
        for(Product product : productList){
            productResponseDto.add(toProductTwoField(product));


        }

        return productResponseDto;
    }
}
