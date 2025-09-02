package com.example.productapi.service;

import com.example.productapi.dto.*;
import java.util.List;

public interface ProductService {
    ProductResponse create(ProductRequest request);
    ProductResponse getById(Long id);
    List<ProductResponse> getAll();
    ProductResponse update(Long id, ProductRequest request);
    void delete(Long id);
}
