package com.andersen.onlinestore.service.impl;

import com.andersen.onlinestore.dto.request.OrderRequestDto;
import com.andersen.onlinestore.dto.response.OrderResponseDto;
import com.andersen.onlinestore.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public OrderResponseDto getById(String id) {
        return null;
    }

    @Override
    public List<OrderResponseDto> getAll() {
        return null;
    }

    @Override
    public OrderResponseDto create(OrderRequestDto orderRequestDto) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
