package com.viazovskyi.first_web.dto.products.transformer;

import com.viazovskyi.first_web.dto.products.ProductRequestDto;
import com.viazovskyi.first_web.dto.products.ProductResponseDto;
import com.viazovskyi.first_web.model.product.Product;
import com.viazovskyi.first_web.util.ClassUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductTransformer {
    public static Product toProduct (ProductRequestDto requestDto) {
        Product product = new Product();
        BeanUtils.copyProperties(requestDto, product);
        product.setProductInfo(
                new Product.ProductInfo()
                        .setCreatedBy("User")
                        .setCreatedOn(LocalDateTime.now()));
        return product;
    }

    public static <T extends ProductResponseDto, P extends Product> T toProductDto(P product, Class<T> targetClass) {
        T response = ClassUtils.getInstance(targetClass);
        BeanUtils.copyProperties(product, response);
        return response;
    }

    public static List<ProductResponseDto> toListPRDto (List<Product> productList, int percentage) {
        List<ProductResponseDto> productResponseDto = new ArrayList<>();
        for (Product product : productList) {
            productResponseDto.add(toProductDto(product, ProductResponseDto.class).setActualPrice(percentage));
        }
        return productResponseDto;
    }
}
