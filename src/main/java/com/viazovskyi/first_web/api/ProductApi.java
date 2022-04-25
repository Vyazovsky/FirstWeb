package com.viazovskyi.first_web.api;

import com.viazovskyi.first_web.dto.products.ProductRequestDto;
import com.viazovskyi.first_web.dto.products.ProductResponseDto;
import com.viazovskyi.first_web.dto.products.transformer.ProductTransformer;
import com.viazovskyi.first_web.model.Product;
import com.viazovskyi.first_web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductApi {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody ProductRequestDto requestDto) {
        return new ResponseEntity<>(productService.saveProduct(ProductTransformer.toProduct(requestDto)), HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/get-all-products-two-fields")
    public List<ProductResponseDto> getAllProductsTwoFields(){
        return ProductTransformer.toListPRDto(productService.getAllProducts());
    }

    @DeleteMapping
    public ResponseEntity<?> deleteProductById(@RequestParam (name = "productId") String id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/get-by-price/{price}")
    public List<Product> getProductByPrice(@PathVariable Double price){
        return productService.getProductByPrice(price);
    }

}
