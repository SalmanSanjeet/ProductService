package com.shop.ProductService.service;

import com.shop.ProductService.model.ProductRequest;
import com.shop.ProductService.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long id);

    void reduceQuantity(long productId, long quantity);
}
