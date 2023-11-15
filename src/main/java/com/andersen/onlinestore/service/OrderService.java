package com.andersen.onlinestore.service;

import com.andersen.onlinestore.dto.request.OrderRequestDto;
import com.andersen.onlinestore.dto.response.OrderResponseDto;

import java.util.List;

public interface OrderService {
    OrderResponseDto getById(String id);
    List<OrderResponseDto> getAll();
    OrderResponseDto create(OrderRequestDto orderRequestDto);
    void deleteById(String id);
}
