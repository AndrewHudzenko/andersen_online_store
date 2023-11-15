package com.andersen.onlinestore.service.impl;

import com.andersen.onlinestore.dto.request.ClientRequestDto;
import com.andersen.onlinestore.dto.response.ClientResponseDto;
import com.andersen.onlinestore.model.Client;
import com.andersen.onlinestore.model.Order;
import com.andersen.onlinestore.repository.ClientRepository;
import com.andersen.onlinestore.service.mapper.ClientMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ClientServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ClientServiceImplTest {
    @MockBean
    private ClientMapper clientMapper;

    @MockBean
    private ClientRepository clientRepository;

    @Autowired
    private ClientServiceImpl clientServiceImpl;

    @Test
    void testGetById() {
        Client client = new Client();
        client.setDiscount(true);
        client.setEmail("jane.doe@example.org");
        client.setId("42");
        client.setName("Name");
        client.setOrders(new ArrayList<>());
        client.setPhoneNumber("6625550144");
        client.setSurname("Doe");
        client.setVisible(true);
        Optional<Client> ofResult = Optional.of(client);
        when(clientRepository.findById(Mockito.<String>any())).thenReturn(ofResult);
        ClientResponseDto clientResponseDto = new ClientResponseDto("Name", "Doe", "6625550144", "jane.doe@example.org",
                true);

        when(clientMapper.toDto(Mockito.<Client>any())).thenReturn(clientResponseDto);
        ClientResponseDto actualById = clientServiceImpl.getById("42");
        verify(clientMapper).toDto(Mockito.<Client>any());
        verify(clientRepository).findById(Mockito.<String>any());
        assertSame(clientResponseDto, actualById);
    }

    @Test
    void testGetAll() {
        when(clientRepository.findAll()).thenReturn(new ArrayList<>());
        List<ClientResponseDto> actualAll = clientServiceImpl.getAll();
        verify(clientRepository).findAll();
        assertTrue(actualAll.isEmpty());
    }

    @Test
    void testCreate() {
        Client client = new Client();
        client.setDiscount(true);
        client.setEmail("jane.doe@example.org");
        client.setId("42");
        client.setName("Name");
        client.setOrders(new ArrayList<>());
        client.setPhoneNumber("6625550144");
        client.setSurname("Doe");
        client.setVisible(true);
        when(clientRepository.save(Mockito.<Client>any())).thenReturn(client);

        Client client2 = new Client();
        client2.setDiscount(true);
        client2.setEmail("jane.doe@example.org");
        client2.setId("42");
        client2.setName("Name");
        client2.setOrders(new ArrayList<>());
        client2.setPhoneNumber("6625550144");
        client2.setSurname("Doe");
        client2.setVisible(true);
        ClientResponseDto clientResponseDto = new ClientResponseDto("Name", "Doe", "6625550144", "jane.doe@example.org",
                true);

        when(clientMapper.toDto(Mockito.<Client>any())).thenReturn(clientResponseDto);
        when(clientMapper.toModel(Mockito.<ClientRequestDto>any())).thenReturn(client2);
        ClientResponseDto actualCreateResult = clientServiceImpl
                .create(new ClientRequestDto("Name", "Doe", "6625550144", "jane.doe@example.org"));
        verify(clientMapper).toDto(Mockito.<Client>any());
        verify(clientMapper).toModel(Mockito.<ClientRequestDto>any());
        verify(clientRepository).save(Mockito.<Client>any());
        assertSame(clientResponseDto, actualCreateResult);
    }

    @Test
    void testCreate2() {
        Client client = new Client();
        client.setDiscount(true);
        client.setEmail("jane.doe@example.org");
        client.setId("42");
        client.setName("Name");
        client.setOrders(new ArrayList<>());
        client.setPhoneNumber("6625550144");
        client.setSurname("Doe");
        client.setVisible(true);
        when(clientRepository.save(Mockito.<Client>any())).thenReturn(client);
        Client client2 = mock(Client.class);
        when(client2.getPhoneNumber()).thenReturn("6625550144");
        doNothing().when(client2).setDiscount(Mockito.<Boolean>any());
        doNothing().when(client2).setEmail(Mockito.<String>any());
        doNothing().when(client2).setId(Mockito.<String>any());
        doNothing().when(client2).setName(Mockito.<String>any());
        doNothing().when(client2).setOrders(Mockito.<List<Order>>any());
        doNothing().when(client2).setPhoneNumber(Mockito.<String>any());
        doNothing().when(client2).setSurname(Mockito.<String>any());
        doNothing().when(client2).setVisible(Mockito.<Boolean>any());
        client2.setDiscount(true);
        client2.setEmail("jane.doe@example.org");
        client2.setId("42");
        client2.setName("Name");
        client2.setOrders(new ArrayList<>());
        client2.setPhoneNumber("6625550144");
        client2.setSurname("Doe");
        client2.setVisible(true);
        ClientResponseDto clientResponseDto = new ClientResponseDto("Name", "Doe", "6625550144", "jane.doe@example.org",
                true);

        when(clientMapper.toDto(Mockito.<Client>any())).thenReturn(clientResponseDto);
        when(clientMapper.toModel(Mockito.<ClientRequestDto>any())).thenReturn(client2);
        ClientResponseDto actualCreateResult = clientServiceImpl
                .create(new ClientRequestDto("Name", "Doe", "6625550144", "jane.doe@example.org"));
        verify(client2).getPhoneNumber();
        verify(client2, atLeast(1)).setDiscount(Mockito.<Boolean>any());
        verify(client2).setEmail(Mockito.<String>any());
        verify(client2).setId(Mockito.<String>any());
        verify(client2).setName(Mockito.<String>any());
        verify(client2).setOrders(Mockito.<List<Order>>any());
        verify(client2).setPhoneNumber(Mockito.<String>any());
        verify(client2).setSurname(Mockito.<String>any());
        verify(client2).setVisible(Mockito.<Boolean>any());
        verify(clientMapper).toDto(Mockito.<Client>any());
        verify(clientMapper).toModel(Mockito.<ClientRequestDto>any());
        verify(clientRepository).save(Mockito.<Client>any());
        assertSame(clientResponseDto, actualCreateResult);
    }

    @Test
    void testCreate3() {
        Client client = new Client();
        client.setDiscount(true);
        client.setEmail("jane.doe@example.org");
        client.setId("42");
        client.setName("Name");
        client.setOrders(new ArrayList<>());
        client.setPhoneNumber("6625550144");
        client.setSurname("Doe");
        client.setVisible(true);
        when(clientRepository.save(Mockito.<Client>any())).thenReturn(client);
        Client client2 = mock(Client.class);
        when(client2.getPhoneNumber()).thenReturn("");
        doNothing().when(client2).setDiscount(Mockito.<Boolean>any());
        doNothing().when(client2).setEmail(Mockito.<String>any());
        doNothing().when(client2).setId(Mockito.<String>any());
        doNothing().when(client2).setName(Mockito.<String>any());
        doNothing().when(client2).setOrders(Mockito.<List<Order>>any());
        doNothing().when(client2).setPhoneNumber(Mockito.<String>any());
        doNothing().when(client2).setSurname(Mockito.<String>any());
        doNothing().when(client2).setVisible(Mockito.<Boolean>any());
        client2.setDiscount(true);
        client2.setEmail("jane.doe@example.org");
        client2.setId("42");
        client2.setName("Name");
        client2.setOrders(new ArrayList<>());
        client2.setPhoneNumber("6625550144");
        client2.setSurname("Doe");
        client2.setVisible(true);
        ClientResponseDto clientResponseDto = new ClientResponseDto("Name", "Doe", "6625550144", "jane.doe@example.org",
                true);

        when(clientMapper.toDto(Mockito.<Client>any())).thenReturn(clientResponseDto);
        when(clientMapper.toModel(Mockito.<ClientRequestDto>any())).thenReturn(client2);
        ClientResponseDto actualCreateResult = clientServiceImpl
                .create(new ClientRequestDto("Name", "Doe", "6625550144", "jane.doe@example.org"));
        verify(client2).getPhoneNumber();
        verify(client2).setDiscount(Mockito.<Boolean>any());
        verify(client2).setEmail(Mockito.<String>any());
        verify(client2).setId(Mockito.<String>any());
        verify(client2).setName(Mockito.<String>any());
        verify(client2).setOrders(Mockito.<List<Order>>any());
        verify(client2).setPhoneNumber(Mockito.<String>any());
        verify(client2).setSurname(Mockito.<String>any());
        verify(client2).setVisible(Mockito.<Boolean>any());
        verify(clientMapper).toDto(Mockito.<Client>any());
        verify(clientMapper).toModel(Mockito.<ClientRequestDto>any());
        verify(clientRepository).save(Mockito.<Client>any());
        assertSame(clientResponseDto, actualCreateResult);
    }

    @Test
    void testFindTopClients() {
        Client client = new Client();
        client.setDiscount(true);
        client.setEmail("jane.doe@example.org");
        client.setId("42");
        client.setName("Name");
        client.setOrders(new ArrayList<>());
        client.setPhoneNumber("6625550144");
        client.setSurname("Doe");
        client.setVisible(true);

        ArrayList<Client> clientList = new ArrayList<>();
        clientList.add(client);
        when(clientRepository.findAll()).thenReturn(clientList);
        List<ClientResponseDto> actualFindTopClientsResult = clientServiceImpl.findTopClients();
        verify(clientRepository).findAll();
        assertTrue(actualFindTopClientsResult.isEmpty());
    }

    @Test
    void testFindTopClients2() {
        Client client = new Client();
        client.setDiscount(true);
        client.setEmail("jane.doe@example.org");
        client.setId("42");
        client.setName("Name");
        client.setOrders(new ArrayList<>());
        client.setPhoneNumber("6625550144");
        client.setSurname("Doe");
        client.setVisible(true);

        Client client2 = new Client();
        client2.setDiscount(false);
        client2.setEmail("john.smith@example.org");
        client2.setId("Id");
        client2.setName("42");
        client2.setOrders(new ArrayList<>());
        client2.setPhoneNumber("8605550118");
        client2.setSurname("Surname");
        client2.setVisible(false);

        ArrayList<Client> clientList = new ArrayList<>();
        clientList.add(client2);
        clientList.add(client);
        when(clientRepository.findAll()).thenReturn(clientList);
        List<ClientResponseDto> actualFindTopClientsResult = clientServiceImpl.findTopClients();
        verify(clientRepository).findAll();
        assertTrue(actualFindTopClientsResult.isEmpty());
    }

    @Test
    void testFindTopClients3() {
        Client client = mock(Client.class);
        when(client.getOrders()).thenReturn(new ArrayList<>());
        doNothing().when(client).setDiscount(Mockito.<Boolean>any());
        doNothing().when(client).setEmail(Mockito.<String>any());
        doNothing().when(client).setId(Mockito.<String>any());
        doNothing().when(client).setName(Mockito.<String>any());
        doNothing().when(client).setOrders(Mockito.<List<Order>>any());
        doNothing().when(client).setPhoneNumber(Mockito.<String>any());
        doNothing().when(client).setSurname(Mockito.<String>any());
        doNothing().when(client).setVisible(Mockito.<Boolean>any());
        client.setDiscount(true);
        client.setEmail("jane.doe@example.org");
        client.setId("42");
        client.setName("Name");
        client.setOrders(new ArrayList<>());
        client.setPhoneNumber("6625550144");
        client.setSurname("Doe");
        client.setVisible(true);

        ArrayList<Client> clientList = new ArrayList<>();
        clientList.add(client);
        when(clientRepository.findAll()).thenReturn(clientList);
        List<ClientResponseDto> actualFindTopClientsResult = clientServiceImpl.findTopClients();
        verify(client, atLeast(1)).getOrders();
        verify(client).setDiscount(Mockito.<Boolean>any());
        verify(client).setEmail(Mockito.<String>any());
        verify(client).setId(Mockito.<String>any());
        verify(client).setName(Mockito.<String>any());
        verify(client).setOrders(Mockito.<List<Order>>any());
        verify(client).setPhoneNumber(Mockito.<String>any());
        verify(client).setSurname(Mockito.<String>any());
        verify(client).setVisible(Mockito.<Boolean>any());
        verify(clientRepository).findAll();
        assertTrue(actualFindTopClientsResult.isEmpty());
    }

    @Test
    void testFindTopClients4() {
        Client client = new Client();
        client.setDiscount(true);
        client.setEmail("jane.doe@example.org");
        client.setId("42");
        client.setName("Name");
        client.setOrders(new ArrayList<>());
        client.setPhoneNumber("6625550144");
        client.setSurname("Doe");
        client.setVisible(true);

        Order order = new Order();
        order.setClient(client);
        order.setCreatingTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        order.setId("42");
        order.setProducts(new ArrayList<>());
        order.setVisible(true);

        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(order);
        Client client2 = mock(Client.class);
        when(client2.getOrders()).thenReturn(orderList);
        doNothing().when(client2).setDiscount(Mockito.<Boolean>any());
        doNothing().when(client2).setEmail(Mockito.<String>any());
        doNothing().when(client2).setId(Mockito.<String>any());
        doNothing().when(client2).setName(Mockito.<String>any());
        doNothing().when(client2).setOrders(Mockito.<List<Order>>any());
        doNothing().when(client2).setPhoneNumber(Mockito.<String>any());
        doNothing().when(client2).setSurname(Mockito.<String>any());
        doNothing().when(client2).setVisible(Mockito.<Boolean>any());
        client2.setDiscount(true);
        client2.setEmail("jane.doe@example.org");
        client2.setId("42");
        client2.setName("Name");
        client2.setOrders(new ArrayList<>());
        client2.setPhoneNumber("6625550144");
        client2.setSurname("Doe");
        client2.setVisible(true);

        ArrayList<Client> clientList = new ArrayList<>();
        clientList.add(client2);
        when(clientRepository.findAll()).thenReturn(clientList);
        List<ClientResponseDto> actualFindTopClientsResult = clientServiceImpl.findTopClients();
        verify(client2, atLeast(1)).getOrders();
        verify(client2).setDiscount(Mockito.<Boolean>any());
        verify(client2).setEmail(Mockito.<String>any());
        verify(client2).setId(Mockito.<String>any());
        verify(client2).setName(Mockito.<String>any());
        verify(client2).setOrders(Mockito.<List<Order>>any());
        verify(client2).setPhoneNumber(Mockito.<String>any());
        verify(client2).setSurname(Mockito.<String>any());
        verify(client2).setVisible(Mockito.<Boolean>any());
        verify(clientRepository).findAll();
        assertTrue(actualFindTopClientsResult.isEmpty());
    }

    @Test
    void testFindTopClients5() {
        Client client = new Client();
        client.setDiscount(true);
        client.setEmail("jane.doe@example.org");
        client.setId("42");
        client.setName("Name");
        client.setOrders(new ArrayList<>());
        client.setPhoneNumber("6625550144");
        client.setSurname("Doe");
        client.setVisible(true);

        Order order = new Order();
        order.setClient(client);
        order.setCreatingTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        order.setId("42");
        order.setProducts(new ArrayList<>());
        order.setVisible(true);

        Client client2 = new Client();
        client2.setDiscount(false);
        client2.setEmail("john.smith@example.org");
        client2.setId("Id");
        client2.setName("42");
        client2.setOrders(new ArrayList<>());
        client2.setPhoneNumber("8605550118");
        client2.setSurname("Surname");
        client2.setVisible(false);

        Order order2 = new Order();
        order2.setClient(client2);
        order2.setCreatingTime(LocalDate.of(1970, 1, 1).atStartOfDay());
        order2.setId("Id");
        order2.setProducts(new ArrayList<>());
        order2.setVisible(false);

        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(order2);
        orderList.add(order);
        Client client3 = mock(Client.class);
        when(client3.getOrders()).thenReturn(orderList);
        doNothing().when(client3).setDiscount(Mockito.<Boolean>any());
        doNothing().when(client3).setEmail(Mockito.<String>any());
        doNothing().when(client3).setId(Mockito.<String>any());
        doNothing().when(client3).setName(Mockito.<String>any());
        doNothing().when(client3).setOrders(Mockito.<List<Order>>any());
        doNothing().when(client3).setPhoneNumber(Mockito.<String>any());
        doNothing().when(client3).setSurname(Mockito.<String>any());
        doNothing().when(client3).setVisible(Mockito.<Boolean>any());
        client3.setDiscount(true);
        client3.setEmail("jane.doe@example.org");
        client3.setId("42");
        client3.setName("Name");
        client3.setOrders(new ArrayList<>());
        client3.setPhoneNumber("6625550144");
        client3.setSurname("Doe");
        client3.setVisible(true);

        ArrayList<Client> clientList = new ArrayList<>();
        clientList.add(client3);
        when(clientRepository.findAll()).thenReturn(clientList);
        List<ClientResponseDto> actualFindTopClientsResult = clientServiceImpl.findTopClients();
        verify(client3, atLeast(1)).getOrders();
        verify(client3).setDiscount(Mockito.<Boolean>any());
        verify(client3).setEmail(Mockito.<String>any());
        verify(client3).setId(Mockito.<String>any());
        verify(client3).setName(Mockito.<String>any());
        verify(client3).setOrders(Mockito.<List<Order>>any());
        verify(client3).setPhoneNumber(Mockito.<String>any());
        verify(client3).setSurname(Mockito.<String>any());
        verify(client3).setVisible(Mockito.<Boolean>any());
        verify(clientRepository).findAll();
        assertTrue(actualFindTopClientsResult.isEmpty());
    }
}
