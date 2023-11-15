package com.andersen.onlinestore.dto.request;

import com.andersen.onlinestore.model.type.ProductCategory;

import java.math.BigDecimal;

public record ProductRequestDto(
        String title,
        ProductCategory category,
        BigDecimal price,
        Long amount) {}
