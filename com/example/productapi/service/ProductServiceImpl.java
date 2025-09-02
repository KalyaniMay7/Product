package com.example.productapi.service;

import com.example.productapi.dto.*;
import com.example.productapi.entity.Product;
import com.example.productapi.exception.ResourceNotFoundException;
import com.example.productapi.mapper.ProductMapper;
import com.example.productapi.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public ProductResponse create(ProductRequest request) {
        Product saved = repo.save(ProductMapper.toEntity(request));
        return ProductMapper.toResponse(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponse getById(Long id) {
        Product p = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", id));
        return ProductMapper.toResponse(p);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> getAll() {
        return repo.findAll().stream()
                .map(ProductMapper::toResponse)
                .collect(Collectors.toList());  // ✅ Java 8 style
    }

    @Override
    public ProductResponse update(Long id, ProductRequest request) {
        Product p = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", id));
        ProductMapper.updateEntity(p, request);
        return ProductMapper.toResponse(p);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("Product", id);
        repo.deleteById(id);
    }
}
