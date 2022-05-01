package com.viazovskyi.first_web.service.product;

import com.viazovskyi.first_web.exception.product.ProductNotFoundException;
import com.viazovskyi.first_web.model.product.Product;
import com.viazovskyi.first_web.repository.product.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(String productId) {
        productRepository.deleteById(productId);
    }

    public void deleteProductByPrice(Double price) {
        productRepository.deleteByPrice(price);
    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        for(Product product : productRepository.findAll()){
            productList.add(product);
        }
        return productList;
    }

    public List<Product> getProductByPrice(Double price){
        return StreamSupport.stream(productRepository.findAllByPrice(price).spliterator(), false)
                .collect(Collectors.toList());
    }

    public Product getProductById(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException(id);
        }
        return optionalProduct.get();

//        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }
}
