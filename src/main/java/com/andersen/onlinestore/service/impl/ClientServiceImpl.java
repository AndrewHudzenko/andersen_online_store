package com.andersen.onlinestore.service.impl;

import com.andersen.onlinestore.dto.request.ClientRequestDto;
import com.andersen.onlinestore.dto.response.ClientResponseDto;
import com.andersen.onlinestore.model.Client;
import com.andersen.onlinestore.model.Product;
import com.andersen.onlinestore.repository.ClientRepository;
import com.andersen.onlinestore.service.ClientService;
import com.andersen.onlinestore.service.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    @Override
    public ClientResponseDto getById(String id) {
        return clientMapper.toDto(clientRepository.findById(id)
                /**
                 * Create NOT_FOUND
                 */
                .orElseThrow());
    }

    @Override
    public List<ClientResponseDto> getAll() {
        return clientRepository.findAll().stream()
                .map(clientMapper::toDto)
                .toList();
    }

    @Override
    public ClientResponseDto create(ClientRequestDto clientRequestDto) {
        Client client = clientMapper.toModel(clientRequestDto);
        if (!client.getPhoneNumber().isEmpty()) {
            client.setDiscount(true);
        }
        return clientMapper.toDto(clientRepository.save(client));
    }

    @Override
    public void deleteById(String id) {
        /**
         * TODO
         */
    }

    @Override
    public List<ClientResponseDto> findTopClients() {
        List<Client> clients = clientRepository.findAll();
        // total sum of all orders by all clients
        BigDecimal totalAmountAllUsers = clients.stream()
                .flatMap(client -> client.getOrders().stream())
                .flatMap(order -> order.getProducts().stream())
                .map(Product::getRetailPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // avg sum of orders for one user
        BigDecimal averageAmountPerUser = totalAmountAllUsers
                .divide(BigDecimal.valueOf(clients.size()), 2, BigDecimal.ROUND_HALF_UP);

        // filer clients, when total sum more than avg
        return clients.stream()
                .filter(client -> calculateTotalAmount(client).compareTo(averageAmountPerUser) > 0)
                .map(clientMapper::toDto)
                .collect(Collectors.toList());

    }

    private BigDecimal calculateTotalAmount(Client client) {
        // calculate total sum of all orders by specific client
        return client.getOrders().stream()
                .flatMap(order -> order.getProducts().stream())
                .map(Product::getRetailPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
