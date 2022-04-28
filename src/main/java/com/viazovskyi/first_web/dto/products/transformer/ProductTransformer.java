package com.viazovskyi.first_web.dto.products.transformer;

import com.viazovskyi.first_web.dto.products.CustomerProductDetailResponse;
import com.viazovskyi.first_web.dto.products.ProductRequestDto;
import com.viazovskyi.first_web.dto.products.ProductResponseDto;
import com.viazovskyi.first_web.model.product.Product;
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

    public static ProductResponseDto toRequiredFieldsProduct (Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        BeanUtils.copyProperties(product, productResponseDto);
        return productResponseDto;
    }

    public static CustomerProductDetailResponse toCustomerProductDetail(Product product){
        CustomerProductDetailResponse customerProductDetailResponse =
                new CustomerProductDetailResponse();
        BeanUtils.copyProperties(product, customerProductDetailResponse);
        return customerProductDetailResponse;
    }

    public static List<ProductResponseDto> toListPRDto (List<Product> productList) {
        List<ProductResponseDto> productResponseDto = new ArrayList<>();
        for (Product product : productList) {
            productResponseDto.add(toRequiredFieldsProduct(product));
        }
        return productResponseDto;
    }
}
