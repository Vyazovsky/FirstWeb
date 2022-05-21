package com.viazovskyi.first_web.service;

import com.viazovskyi.first_web.dto.products.CustomerProductDetailResponse;
import com.viazovskyi.first_web.dto.products.ProductRequestDto;
import com.viazovskyi.first_web.dto.products.ProductResponseDto;
import com.viazovskyi.first_web.dto.products.transformer.ProductTransformer;
import com.viazovskyi.first_web.exception.product.ProductNotFoundException;
import com.viazovskyi.first_web.model.product.Product;
import com.viazovskyi.first_web.service.product.ProductService;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class FacadeService {

    @Autowired
    private ProductService productService;

    public ResponseEntity<Product> saveProduct(ProductRequestDto requestDto) {
        return new ResponseEntity<>(productService.saveProduct(ProductTransformer.toProduct(requestDto)), HttpStatus.CREATED);
    }

    public List<ProductResponseDto> getRequiredFieldsProducts(){
        return ProductTransformer.toListPRDto(productService.getAllProducts(), 10);
    }

    public ResponseEntity<?> deleteProductById(String id) {
        try {
            productService.getProductById(id);
            productService.deleteProductById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ProductNotFoundException e){
            log.info(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    public List<Product> getProductByPrice(Double price){
        return productService.getProductByPrice(price);
    }

    public ResponseEntity<?> getCustomerProductDetailById(String id) {
        try {
            Product product = productService.getProductById(id);
            return ResponseEntity.ok(ProductTransformer
                    .toProductDto(product, CustomerProductDetailResponse.class)
                    .setActualPrice(10));
        } catch (ProductNotFoundException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getAdminProductById(String id) {
        try {
            return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getDimonProductById(String id) {
        try {
            Product product = productService.getProductById(id);
            return new ResponseEntity<>(ProductTransformer.byProduct(product), HttpStatus.OK);
        } catch (ProductNotFoundException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



}
