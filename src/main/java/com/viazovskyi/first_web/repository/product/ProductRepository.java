package com.viazovskyi.first_web.repository.product;

import com.viazovskyi.first_web.model.product.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
    void deleteByPrice(Double price);

    Iterable<Product> findAllByPrice(Double price);
}
