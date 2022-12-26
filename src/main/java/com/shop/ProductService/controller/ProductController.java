package com.shop.ProductService.controller;

import com.shop.ProductService.model.ProductRequest;
import com.shop.ProductService.model.ProductResponse;
import com.shop.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
        long productId = productService.addProduct(productRequest);

        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long id){
        ProductResponse productResponse = productService.getProductById(id);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
}