package com.andersen.onlinestore.service;

import com.andersen.onlinestore.dto.request.ClientRequestDto;
import com.andersen.onlinestore.dto.response.ClientResponseDto;
import com.andersen.onlinestore.model.Client;

import java.util.List;

public interface ClientService {
    ClientResponseDto getById(String id);
    List<ClientResponseDto> getAll();
    ClientResponseDto create(ClientRequestDto clientRequestDto);
    void deleteById(String id);
    List<ClientResponseDto> findTopClients();
}
