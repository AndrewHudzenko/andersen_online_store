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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    @Override
    public ProductResponseDto getById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        if (product.getVisible()) {
            return productMapper.toDto(product);
        }
        throw new ProductNotFoundException(id);
    }

    @Override
    public List<ProductResponseDto> getAll() {
        return productRepository.findAll().stream()
                .filter(Product::getVisible)
                .map(productMapper::toDto)
                .toList();
    }

    @Override
    public ProductResponseDto create(ProductRequestDto productRequestDto) {
        return productMapper.toDto(productRepository
                .save(productMapper.toModel(productRequestDto)));
    }

    @Override
    public List<ProductResponseDto> createSeveral(List<ProductRequestDto> productRequestDtos) {
        List<Product> products = productRequestDtos.stream().map(productMapper::toModel).toList();
        productRepository.saveAll(products);
        return products.stream().map(productMapper::toDto).toList();
    }

    @Override
    public void deleteById(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
        product.setVisible(false);
        productRepository.save(product);
    }
}
