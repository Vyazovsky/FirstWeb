package com.viazovskyi.first_web.repository;

import com.viazovskyi.first_web.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
    void deleteByPrice(Double price);

    Iterable<Product> findAllByPrice(Double price);
}
