package com.andersen.onlinestore.controller;

import com.andersen.onlinestore.dto.request.ClientRequestDto;
import com.andersen.onlinestore.dto.response.ClientResponseDto;
import com.andersen.onlinestore.model.Client;
import com.andersen.onlinestore.service.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/clients")
@Tag(name = "Client Controller")
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public List<ClientResponseDto> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/top-customers")
    public List<ClientResponseDto> getTopCustomers() {
        return clientService.findTopClients();
    }

    @PostMapping
    public ClientResponseDto create(@RequestBody ClientRequestDto clientRequestDto) {
        return clientService.create(clientRequestDto);
    }

    /**
     * DELETE TODO
     */
}
