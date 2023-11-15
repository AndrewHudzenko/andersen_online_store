package com.andersen.onlinestore.service.impl;

import com.andersen.onlinestore.dto.request.ClientRequestDto;
import com.andersen.onlinestore.dto.response.ClientResponseDto;
import com.andersen.onlinestore.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    @Override
    public ClientResponseDto getById(String id) {
        return null;
    }

    @Override
    public List<ClientResponseDto> getAll() {
        return null;
    }

    @Override
    public ClientResponseDto create(ClientRequestDto clientRequestDto) {
        return null;
    }

    @Override
    public void deleteById(String id) {

    }
}
