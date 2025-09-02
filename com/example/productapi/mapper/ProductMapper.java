package com.example.productapi.mapper;

import com.example.productapi.dto.*;
import com.example.productapi.entity.Product;

public class ProductMapper {
    public static Product toEntity(ProductRequest req) {
        return new Product(null, req.getName(), req.getDescription(), req.getPrice());
    }

    public static void updateEntity(Product entity, ProductRequest req) {
        entity.setName(req.getName());
        entity.setDescription(req.getDescription());
        entity.setPrice(req.getPrice());
    }

    public static ProductResponse toResponse(Product p) {
        ProductResponse r = new ProductResponse();
        r.setId(p.getId());
        r.setName(p.getName());
        r.setDescription(p.getDescription());
        r.setPrice(p.getPrice());
        return r;
    }
}
