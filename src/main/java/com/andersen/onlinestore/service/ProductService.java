package com.andersen.onlinestore.service;

import com.andersen.onlinestore.dto.request.ProductRequestDto;
import com.andersen.onlinestore.dto.request.SingleProductRequestDto;
import com.andersen.onlinestore.dto.response.ProductResponseDto;

import java.util.List;

public interface ProductService {
    ProductResponseDto getById(String id);
    List<ProductResponseDto> getAll();
    ProductResponseDto create(SingleProductRequestDto productRequestDto);
    List<ProductResponseDto> createSeveral(List<ProductRequestDto> productRequestDtos);
    void deleteById(String id);
}
