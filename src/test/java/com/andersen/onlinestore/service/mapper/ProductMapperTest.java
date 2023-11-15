package com.andersen.onlinestore.service.mapper;

import com.andersen.onlinestore.dto.request.ProductRequestDto;
import com.andersen.onlinestore.dto.response.ProductResponseDto;
import com.andersen.onlinestore.model.Product;
import com.andersen.onlinestore.model.type.ProductCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ProductMapper.class})
@ExtendWith(SpringExtension.class)
class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    void testToDto() {
        Product product = Product.builder()
                .id("6ba7b812-9dad-11d1-80b4-00c04fd430c8")
                .title("Drill")
                .category(ProductCategory.HOME_APPLIANCE)
                .retailPrice(new BigDecimal("230"))
                .purchasePrice(new BigDecimal("230"))
                .amount(10L)
                .visible(true)
                .build();
        ProductResponseDto actualToDtoResult = productMapper.toDto(product);
        assertEquals("Drill", actualToDtoResult.title());
        assertEquals(ProductCategory.HOME_APPLIANCE, actualToDtoResult.category());
        BigDecimal expectedPurchasePriceResult = new BigDecimal("230");
        assertEquals(expectedPurchasePriceResult, actualToDtoResult.purchasePrice());
        BigDecimal expectedRetailPriceResult = new BigDecimal("230");
        assertEquals(expectedRetailPriceResult, actualToDtoResult.retailPrice());
    }

    @Test
    void testToDtoCallingEachField() {
        Product product = mock(Product.class);
        when(product.getCategory()).thenReturn(ProductCategory.HOME_APPLIANCE);
        when(product.getTitle()).thenReturn("Drill");
        when(product.getPurchasePrice()).thenReturn(new BigDecimal("230"));
        when(product.getRetailPrice()).thenReturn(new BigDecimal("230"));
        doNothing().when(product).setAmount(Mockito.<Long>any());
        doNothing().when(product).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product).setId(Mockito.<String>any());
        doNothing().when(product).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setTitle(Mockito.<String>any());
        doNothing().when(product).setVisible(Mockito.<Boolean>any());
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("6ba7b812-9dad-11d1-80b4-00c04fd430c8");
        product.setPurchasePrice(new BigDecimal("230"));
        product.setRetailPrice(new BigDecimal("230"));
        product.setTitle("Drill");
        product.setVisible(true);
        ProductResponseDto actualToDtoResult = productMapper.toDto(product);
        verify(product).getCategory();
        verify(product).getPurchasePrice();
        verify(product).getRetailPrice();
        verify(product).getTitle();
        verify(product).setAmount(Mockito.<Long>any());
        verify(product).setCategory(Mockito.<ProductCategory>any());
        verify(product).setId(Mockito.<String>any());
        verify(product).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product).setTitle(Mockito.<String>any());
        verify(product).setVisible(Mockito.<Boolean>any());
        assertEquals("Drill", actualToDtoResult.title());
        assertEquals(ProductCategory.HOME_APPLIANCE, actualToDtoResult.category());
        BigDecimal expectedPurchasePriceResult = new BigDecimal("230");
        assertEquals(expectedPurchasePriceResult, actualToDtoResult.purchasePrice());
        BigDecimal expectedRetailPriceResult = new BigDecimal("230");
        assertEquals(expectedRetailPriceResult, actualToDtoResult.retailPrice());
    }

    @Test
    void testToModel() {
        BigDecimal purchasePrice = new BigDecimal("230");
        Product actualToModelResult = productMapper
                .toModel(new ProductRequestDto("Drill", ProductCategory.HOME_APPLIANCE, purchasePrice, 10L));
        assertEquals("Drill", actualToModelResult.getTitle());
        assertEquals(10L, actualToModelResult.getAmount().longValue());
        assertEquals(ProductCategory.HOME_APPLIANCE, actualToModelResult.getCategory());
        assertTrue(actualToModelResult.getVisible());
        BigDecimal expectedRetailPrice = new BigDecimal("230");
        assertEquals(expectedRetailPrice, actualToModelResult.getRetailPrice());
        assertSame(purchasePrice, actualToModelResult.getPurchasePrice());
    }
}
