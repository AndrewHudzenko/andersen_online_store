package com.andersen.onlinestore.service.mapper;

import com.andersen.onlinestore.dto.request.ProductRequestDto;
import com.andersen.onlinestore.dto.request.SingleProductRequestDto;
import com.andersen.onlinestore.dto.response.ProductResponseDto;
import com.andersen.onlinestore.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
public class ProductMapper {
    public ProductResponseDto toDto(Product product) {
        return ProductResponseDto.builder()
                .title(product.getTitle())
                .category(product.getCategory())
                .retailPrice(product.getRetailPrice())
                .purchasePrice(product.getPurchasePrice())
                .build();
    }

    public Product toModel(ProductRequestDto productRequestDto) {
        return Product.builder()
                .id(UUID.randomUUID().toString())
                .title(productRequestDto.title())
                .category(productRequestDto.category())
                .purchasePrice(productRequestDto.purchasePrice())
                .retailPrice(productRequestDto.purchasePrice())
                .amount(productRequestDto.amount())
                .visible(true)
                .build();
    }

    public Product toModel(SingleProductRequestDto singleProductRequestDto) {
        return Product.builder()
                .id(UUID.randomUUID().toString())
                .title(singleProductRequestDto.title())
                .category(singleProductRequestDto.category())
                .purchasePrice(singleProductRequestDto.purchasePrice())
                .retailPrice(singleProductRequestDto.purchasePrice())
                .amount(1L)
                .visible(true)
                .build();
    }
}
