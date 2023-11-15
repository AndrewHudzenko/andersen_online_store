package com.andersen.onlinestore.service.impl;

import com.andersen.onlinestore.dto.request.ProductRequestDto;
import com.andersen.onlinestore.dto.request.SingleProductRequestDto;
import com.andersen.onlinestore.dto.response.ProductResponseDto;
import com.andersen.onlinestore.exception.ProductNotFoundException;
import com.andersen.onlinestore.model.Product;
import com.andersen.onlinestore.repository.ProductRepository;
import com.andersen.onlinestore.service.ProductService;
import com.andersen.onlinestore.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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
    public ProductResponseDto create(SingleProductRequestDto singleProductRequestDto) {
        Product product = productMapper.toModel(singleProductRequestDto);
        calculateRetailPrice(product);
        return productMapper.toDto(productRepository
                .save(product));
    }

    @Override
    public List<ProductResponseDto> createSeveral(List<ProductRequestDto> productRequestDtos) {
        List<Product> products = productRequestDtos.stream().map(productMapper::toModel).toList();
        products.forEach(this::calculateRetailPrice);
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

    public void calculateRetailPrice(Product product) {
        Long amount = product.getAmount();
        BigDecimal purchasePrice = product.getPurchasePrice();
        BigDecimal retailPrice = product.getRetailPrice();
        BigDecimal markup = BigDecimal.ZERO;

        if (amount >= 0 && amount < 99) {
            markup = purchasePrice.multiply(BigDecimal.valueOf(0.3));
        }
        if (amount >= 100 && amount < 999) {
            markup = purchasePrice.multiply(BigDecimal.valueOf(0.25));
        }
        if (amount >=1000  && amount <= 9999) {
            markup = purchasePrice.multiply(BigDecimal.valueOf(0.2));
        }
        if (amount >= 10000) {
            markup = purchasePrice.multiply(BigDecimal.valueOf(0.05));
        }

        product.setRetailPrice(retailPrice.add(markup));
    }
}
