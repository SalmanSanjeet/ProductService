package com.shop.ProductService.service;

import com.shop.ProductService.Exception.ProductServiceCustomException;
import com.shop.ProductService.entity.Product;
import com.shop.ProductService.model.ProductRequest;
import com.shop.ProductService.model.ProductResponse;
import com.shop.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product..");

        Product product =  Product.builder()
                            .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();
        productRepository.save(product);
        log.info("Product Created");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long id) {
        log.info("get the product for product id : {}", id);

        Product  product = productRepository.findById(id)
                .orElseThrow(()->new ProductServiceCustomException("Product with Given Id is not available","PRODUCT_NOT_FOUND"));

        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }
}
