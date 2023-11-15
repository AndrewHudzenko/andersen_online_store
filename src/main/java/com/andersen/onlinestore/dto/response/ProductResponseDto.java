package com.andersen.onlinestore.dto.response;

import com.andersen.onlinestore.model.type.ProductCategory;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductResponseDto(
        String title,
        ProductCategory category,
        BigDecimal retailPrice,
        BigDecimal purchasePrice) {}
