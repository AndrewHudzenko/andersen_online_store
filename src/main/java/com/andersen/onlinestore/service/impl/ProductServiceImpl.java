package com.andersen.onlinestore.service.impl;

import com.andersen.onlinestore.dto.request.ProductRequestDto;
import com.andersen.onlinestore.dto.response.ProductResponseDto;
import com.andersen.onlinestore.exception.ProductNotFoundException;
import com.andersen.onlinestore.model.Product;
import com.andersen.onlinestore.repository.ProductRepository;
import com.andersen.onlinestore.service.ProductService;
import com.andersen.onlinestore.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public ProductResponseDto getById(String id) {
        return productMapper.toDto(productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id)));
    }

    @Override
    public List<ProductResponseDto> getAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductResponseDto create(ProductRequestDto productRequestDto) {
        return productMapper.toDto(productRepository
                .save(productMapper.toModel(productRequestDto)));
    }

    @Override
    public void deleteById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        product.setVisible(false);
        productRepository.save(product);
    }
}
