package com.andersen.onlinestore.service.mapper;

import com.andersen.onlinestore.dto.request.ClientRequestDto;
import com.andersen.onlinestore.dto.response.ClientResponseDto;
import com.andersen.onlinestore.model.Client;
import com.andersen.onlinestore.model.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ClientMapper.class})
@ExtendWith(SpringExtension.class)
class ClientMapperTest {
    @Autowired
    private ClientMapper clientMapper;

    @Test
    void testToModel() {
        Client actualToModelResult = clientMapper
                .toModel(new ClientRequestDto("Name", "Doe", "6625550144", "jane.doe@example.org"));
        assertEquals("6625550144", actualToModelResult.getPhoneNumber());
        assertEquals("Doe", actualToModelResult.getSurname());
        assertEquals("Name", actualToModelResult.getName());
        assertEquals("jane.doe@example.org", actualToModelResult.getEmail());
        assertFalse(actualToModelResult.getDiscount());
        assertTrue(actualToModelResult.getVisible());
        assertTrue(actualToModelResult.getOrders().isEmpty());
    }

    @Test
    void testToDto() {
        Client client = Client.builder()
                .id("6ba7b810-9dad-11d1-80b4-00c04fd430c8")
                .name("Name")
                .surname("Doe")
                .email("jane.doe@example.org")
                .phoneNumber("6625550144")
                .orders(new ArrayList<>())
                .discount(true)
                .visible(true)
                .build();
        ClientResponseDto actualToDtoResult = clientMapper.toDto(client);
        assertEquals("6625550144", actualToDtoResult.phoneNumber());
        assertEquals("Doe", actualToDtoResult.surname());
        assertEquals("Name", actualToDtoResult.name());
        assertEquals("jane.doe@example.org", actualToDtoResult.email());
        assertTrue(actualToDtoResult.discount());
    }

    @Test
    void testToDtoCallingEachField() {
        Client client = mock(Client.class);
        when(client.getDiscount()).thenReturn(true);
        when(client.getEmail()).thenReturn("jane.doe@example.org");
        when(client.getName()).thenReturn("Name");
        when(client.getPhoneNumber()).thenReturn("6625550144");
        when(client.getSurname()).thenReturn("Doe");
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
        client.setId("6ba7b810-9dad-11d1-80b4-00c04fd430c8");
        client.setName("Name");
        client.setOrders(new ArrayList<>());
        client.setPhoneNumber("6625550144");
        client.setSurname("Doe");
        client.setVisible(true);
        ClientResponseDto actualToDtoResult = clientMapper.toDto(client);
        verify(client).getDiscount();
        verify(client).getEmail();
        verify(client).getName();
        verify(client).getPhoneNumber();
        verify(client).getSurname();
        verify(client).setDiscount(Mockito.<Boolean>any());
        verify(client).setEmail(Mockito.<String>any());
        verify(client).setId(Mockito.<String>any());
        verify(client).setName(Mockito.<String>any());
        verify(client).setOrders(Mockito.<List<Order>>any());
        verify(client).setPhoneNumber(Mockito.<String>any());
        verify(client).setSurname(Mockito.<String>any());
        verify(client).setVisible(Mockito.<Boolean>any());
        assertEquals("6625550144", actualToDtoResult.phoneNumber());
        assertEquals("Doe", actualToDtoResult.surname());
        assertEquals("Name", actualToDtoResult.name());
        assertEquals("jane.doe@example.org", actualToDtoResult.email());
        assertTrue(actualToDtoResult.discount());
    }
}
