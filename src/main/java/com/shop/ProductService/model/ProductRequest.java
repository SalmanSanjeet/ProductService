package com.shop.ProductService.model;

import lombok.Data;

@Data
public class ProductRequest {
    public String Name;
    public long price;
    public long quantity;
}
