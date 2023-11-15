package com.andersen.onlinestore.service.mapper;

import com.andersen.onlinestore.dto.request.ClientRequestDto;
import com.andersen.onlinestore.dto.response.ClientResponseDto;
import com.andersen.onlinestore.model.Client;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.UUID;

@Service
public class ClientMapper {
    public Client toModel(ClientRequestDto clientRequestDto) {
        return Client.builder()
                .id(UUID.randomUUID().toString())
                .name(clientRequestDto.name())
                .surname(clientRequestDto.surname())
                .phoneNumber(clientRequestDto.phoneNumber())
                .email(clientRequestDto.email())
                .orders(Collections.emptyList())
                .discount(false)
                .visible(true)
                .build();
    }

    public ClientResponseDto toDto(Client client) {
        return ClientResponseDto.builder()
                .name(client.getName())
                .surname(client.getSurname())
                .phoneNumber(client.getPhoneNumber())
                .email(client.getEmail())
                .discount(client.getDiscount())
                .build();
    }
}
