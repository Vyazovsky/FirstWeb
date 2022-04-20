package com.viazovskyi.first_web.service;

import com.viazovskyi.first_web.model.Product;
import com.viazovskyi.first_web.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(String productId) {
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
//        List<Product> productList = new ArrayList<>();
//
//        productRepository.findAllByPrice(price).forEach(productList::add);
//
//        for(Product product : productRepository.findAllByPrice(price)){
//            productList.add(product);
//        }
//        return productList;

        return StreamSupport.stream(productRepository.findAllByPrice(price).spliterator(), false)
                .collect(Collectors.toList());
    }


}
