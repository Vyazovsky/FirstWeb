package com.viazovskyi.first_web.api.product;

import com.viazovskyi.first_web.dto.products.ProductRequestDto;
import com.viazovskyi.first_web.dto.products.ProductResponseDto;
import com.viazovskyi.first_web.model.product.Product;
import com.viazovskyi.first_web.service.FacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductApi {

    @Autowired
    private FacadeService facadeService;

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody ProductRequestDto requestDto) {
        return facadeService.saveProduct(requestDto);
    }


    @GetMapping
    public List<ProductResponseDto> getRequiredFieldsProducts(){
        return facadeService.getRequiredFieldsProducts();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteProductById(@RequestParam (name = "productId") String id) {
       return facadeService.deleteProductById(id);
    }

    @CrossOrigin
    @GetMapping(value = "/get-by-price/{price}")
    public List<Product> getProductByPrice(@PathVariable Double price){
        return facadeService.getProductByPrice(price);
    }

}
