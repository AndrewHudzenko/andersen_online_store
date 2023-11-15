package com.andersen.onlinestore.dto.request;

import com.andersen.onlinestore.model.type.ProductCategory;

import java.math.BigDecimal;

public record SingleProductRequestDto(
        String title,
        ProductCategory category,
        BigDecimal purchasePrice) {}
