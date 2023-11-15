package com.andersen.onlinestore.service.impl;

import com.andersen.onlinestore.dto.request.ProductRequestDto;
import com.andersen.onlinestore.dto.request.SingleProductRequestDto;
import com.andersen.onlinestore.dto.response.ProductResponseDto;
import com.andersen.onlinestore.exception.ProductNotFoundException;
import com.andersen.onlinestore.model.Product;
import com.andersen.onlinestore.model.type.ProductCategory;
import com.andersen.onlinestore.repository.ProductRepository;
import com.andersen.onlinestore.service.mapper.ProductMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ProductServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ProductServiceImplTest {
    @MockBean
    private ProductMapper productMapper;

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Test
    void testGetById() {
        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById(Mockito.<String>any())).thenReturn(ofResult);
        BigDecimal retailPrice = new BigDecimal("2.3");
        ProductResponseDto productResponseDto = new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice,
                new BigDecimal("2.3"));

        when(productMapper.toDto(Mockito.<Product>any())).thenReturn(productResponseDto);
        ProductResponseDto actualById = productServiceImpl.getById("42");
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productRepository).findById(Mockito.<String>any());
        assertSame(productResponseDto, actualById);
    }

    @Test
    void testGetById2() {
        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById(Mockito.<String>any())).thenReturn(ofResult);
        when(productMapper.toDto(Mockito.<Product>any())).thenThrow(new ProductNotFoundException("42"));
        assertThrows(ProductNotFoundException.class, () -> productServiceImpl.getById("42"));
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productRepository).findById(Mockito.<String>any());
    }

    @Test
    void testGetById3() {
        Product product = mock(Product.class);
        when(product.getVisible()).thenReturn(true);
        doNothing().when(product).setAmount(Mockito.<Long>any());
        doNothing().when(product).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product).setId(Mockito.<String>any());
        doNothing().when(product).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setTitle(Mockito.<String>any());
        doNothing().when(product).setVisible(Mockito.<Boolean>any());
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById(Mockito.<String>any())).thenReturn(ofResult);
        BigDecimal retailPrice = new BigDecimal("2.3");
        ProductResponseDto productResponseDto = new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice,
                new BigDecimal("2.3"));

        when(productMapper.toDto(Mockito.<Product>any())).thenReturn(productResponseDto);
        ProductResponseDto actualById = productServiceImpl.getById("42");
        verify(product).getVisible();
        verify(product).setAmount(Mockito.<Long>any());
        verify(product).setCategory(Mockito.<ProductCategory>any());
        verify(product).setId(Mockito.<String>any());
        verify(product).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product).setTitle(Mockito.<String>any());
        verify(product).setVisible(Mockito.<Boolean>any());
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productRepository).findById(Mockito.<String>any());
        assertSame(productResponseDto, actualById);
    }

    @Test
    void testGetById4() {
        Product product = mock(Product.class);
        when(product.getVisible()).thenReturn(false);
        doNothing().when(product).setAmount(Mockito.<Long>any());
        doNothing().when(product).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product).setId(Mockito.<String>any());
        doNothing().when(product).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setTitle(Mockito.<String>any());
        doNothing().when(product).setVisible(Mockito.<Boolean>any());
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.findById(Mockito.<String>any())).thenReturn(ofResult);
        assertThrows(ProductNotFoundException.class, () -> productServiceImpl.getById("42"));
        verify(product).getVisible();
        verify(product).setAmount(Mockito.<Long>any());
        verify(product).setCategory(Mockito.<ProductCategory>any());
        verify(product).setId(Mockito.<String>any());
        verify(product).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product).setTitle(Mockito.<String>any());
        verify(product).setVisible(Mockito.<Boolean>any());
        verify(productRepository).findById(Mockito.<String>any());
    }

    @Test
    void testGetById5() {
        Optional<Product> emptyResult = Optional.empty();
        when(productRepository.findById(Mockito.<String>any())).thenReturn(emptyResult);
        assertThrows(ProductNotFoundException.class, () -> productServiceImpl.getById("42"));
        verify(productRepository).findById(Mockito.<String>any());
    }

    @Test
    void testGetAll() {
        when(productRepository.findAll()).thenReturn(new ArrayList<>());
        List<ProductResponseDto> actualAll = productServiceImpl.getAll();
        verify(productRepository).findAll();
        assertTrue(actualAll.isEmpty());
    }

    @Test
    void testGetAll2() {
        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productRepository.findAll()).thenReturn(productList);
        BigDecimal retailPrice = new BigDecimal("2.3");
        when(productMapper.toDto(Mockito.<Product>any()))
                .thenReturn(new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice, new BigDecimal("2.3")));
        List<ProductResponseDto> actualAll = productServiceImpl.getAll();
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productRepository).findAll();
        assertEquals(1, actualAll.size());
    }

    @Test
    void testGetAll3() {
        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);

        Product product2 = new Product();
        product2.setAmount(1L);
        product2.setCategory(ProductCategory.MOBILE_PHONE);
        product2.setId("Id");
        product2.setPurchasePrice(new BigDecimal("2.3"));
        product2.setRetailPrice(new BigDecimal("2.3"));
        product2.setTitle("Mr");
        product2.setVisible(false);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product2);
        productList.add(product);
        when(productRepository.findAll()).thenReturn(productList);
        BigDecimal retailPrice = new BigDecimal("2.3");
        when(productMapper.toDto(Mockito.<Product>any()))
                .thenReturn(new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice, new BigDecimal("2.3")));
        List<ProductResponseDto> actualAll = productServiceImpl.getAll();
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productRepository).findAll();
        assertEquals(1, actualAll.size());
    }

    @Test
    void testGetAll4() {
        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);

        ArrayList<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productRepository.findAll()).thenReturn(productList);
        when(productMapper.toDto(Mockito.<Product>any())).thenThrow(new ProductNotFoundException("42"));
        assertThrows(ProductNotFoundException.class, () -> productServiceImpl.getAll());
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productRepository).findAll();
    }

    @Test
    void testCreate() {
        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product);

        Product product2 = new Product();
        product2.setAmount(10L);
        product2.setCategory(ProductCategory.HOME_APPLIANCE);
        product2.setId("42");
        product2.setPurchasePrice(new BigDecimal("2.3"));
        product2.setRetailPrice(new BigDecimal("2.3"));
        product2.setTitle("Dr");
        product2.setVisible(true);
        BigDecimal retailPrice = new BigDecimal("2.3");
        ProductResponseDto productResponseDto = new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice,
                new BigDecimal("2.3"));

        when(productMapper.toDto(Mockito.<Product>any())).thenReturn(productResponseDto);
        when(productMapper.toModel(Mockito.<SingleProductRequestDto>any())).thenReturn(product2);
        ProductResponseDto actualCreateResult = productServiceImpl
                .create(new SingleProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3")));
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productMapper).toModel(Mockito.<SingleProductRequestDto>any());
        verify(productRepository).save(Mockito.<Product>any());
        assertSame(productResponseDto, actualCreateResult);
    }

    @Test
    void testCreate2() {
        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product);

        Product product2 = new Product();
        product2.setAmount(10L);
        product2.setCategory(ProductCategory.HOME_APPLIANCE);
        product2.setId("42");
        product2.setPurchasePrice(new BigDecimal("2.3"));
        product2.setRetailPrice(new BigDecimal("2.3"));
        product2.setTitle("Dr");
        product2.setVisible(true);
        when(productMapper.toDto(Mockito.<Product>any())).thenThrow(new ProductNotFoundException("42"));
        when(productMapper.toModel(Mockito.<SingleProductRequestDto>any())).thenReturn(product2);
        assertThrows(ProductNotFoundException.class, () -> productServiceImpl
                .create(new SingleProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3"))));
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productMapper).toModel(Mockito.<SingleProductRequestDto>any());
        verify(productRepository).save(Mockito.<Product>any());
    }

    @Test
    void testCreate3() {
        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product);
        Product product2 = mock(Product.class);
        when(product2.getAmount()).thenReturn(10L);
        when(product2.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product2.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product2).setAmount(Mockito.<Long>any());
        doNothing().when(product2).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product2).setId(Mockito.<String>any());
        doNothing().when(product2).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product2).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product2).setTitle(Mockito.<String>any());
        doNothing().when(product2).setVisible(Mockito.<Boolean>any());
        product2.setAmount(10L);
        product2.setCategory(ProductCategory.HOME_APPLIANCE);
        product2.setId("42");
        product2.setPurchasePrice(new BigDecimal("2.3"));
        product2.setRetailPrice(new BigDecimal("2.3"));
        product2.setTitle("Dr");
        product2.setVisible(true);
        BigDecimal retailPrice = new BigDecimal("2.3");
        ProductResponseDto productResponseDto = new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice,
                new BigDecimal("2.3"));

        when(productMapper.toDto(Mockito.<Product>any())).thenReturn(productResponseDto);
        when(productMapper.toModel(Mockito.<SingleProductRequestDto>any())).thenReturn(product2);
        ProductResponseDto actualCreateResult = productServiceImpl
                .create(new SingleProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3")));
        verify(product2).getAmount();
        verify(product2).getPurchasePrice();
        verify(product2).getRetailPrice();
        verify(product2).setAmount(Mockito.<Long>any());
        verify(product2).setCategory(Mockito.<ProductCategory>any());
        verify(product2).setId(Mockito.<String>any());
        verify(product2).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product2, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product2).setTitle(Mockito.<String>any());
        verify(product2).setVisible(Mockito.<Boolean>any());
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productMapper).toModel(Mockito.<SingleProductRequestDto>any());
        verify(productRepository).save(Mockito.<Product>any());
        assertSame(productResponseDto, actualCreateResult);
    }

    @Test
    void testCreate4() {
        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product);
        Product product2 = mock(Product.class);
        when(product2.getAmount()).thenReturn(99L);
        when(product2.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product2.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product2).setAmount(Mockito.<Long>any());
        doNothing().when(product2).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product2).setId(Mockito.<String>any());
        doNothing().when(product2).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product2).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product2).setTitle(Mockito.<String>any());
        doNothing().when(product2).setVisible(Mockito.<Boolean>any());
        product2.setAmount(10L);
        product2.setCategory(ProductCategory.HOME_APPLIANCE);
        product2.setId("42");
        product2.setPurchasePrice(new BigDecimal("2.3"));
        product2.setRetailPrice(new BigDecimal("2.3"));
        product2.setTitle("Dr");
        product2.setVisible(true);
        BigDecimal retailPrice = new BigDecimal("2.3");
        ProductResponseDto productResponseDto = new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice,
                new BigDecimal("2.3"));

        when(productMapper.toDto(Mockito.<Product>any())).thenReturn(productResponseDto);
        when(productMapper.toModel(Mockito.<SingleProductRequestDto>any())).thenReturn(product2);
        ProductResponseDto actualCreateResult = productServiceImpl
                .create(new SingleProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3")));
        verify(product2).getAmount();
        verify(product2).getPurchasePrice();
        verify(product2).getRetailPrice();
        verify(product2).setAmount(Mockito.<Long>any());
        verify(product2).setCategory(Mockito.<ProductCategory>any());
        verify(product2).setId(Mockito.<String>any());
        verify(product2).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product2, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product2).setTitle(Mockito.<String>any());
        verify(product2).setVisible(Mockito.<Boolean>any());
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productMapper).toModel(Mockito.<SingleProductRequestDto>any());
        verify(productRepository).save(Mockito.<Product>any());
        assertSame(productResponseDto, actualCreateResult);
    }

    @Test
    void testCreate5() {
        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product);
        Product product2 = mock(Product.class);
        when(product2.getAmount()).thenReturn(-1L);
        when(product2.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product2.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product2).setAmount(Mockito.<Long>any());
        doNothing().when(product2).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product2).setId(Mockito.<String>any());
        doNothing().when(product2).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product2).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product2).setTitle(Mockito.<String>any());
        doNothing().when(product2).setVisible(Mockito.<Boolean>any());
        product2.setAmount(10L);
        product2.setCategory(ProductCategory.HOME_APPLIANCE);
        product2.setId("42");
        product2.setPurchasePrice(new BigDecimal("2.3"));
        product2.setRetailPrice(new BigDecimal("2.3"));
        product2.setTitle("Dr");
        product2.setVisible(true);
        BigDecimal retailPrice = new BigDecimal("2.3");
        ProductResponseDto productResponseDto = new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice,
                new BigDecimal("2.3"));

        when(productMapper.toDto(Mockito.<Product>any())).thenReturn(productResponseDto);
        when(productMapper.toModel(Mockito.<SingleProductRequestDto>any())).thenReturn(product2);
        ProductResponseDto actualCreateResult = productServiceImpl
                .create(new SingleProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3")));
        verify(product2).getAmount();
        verify(product2).getPurchasePrice();
        verify(product2).getRetailPrice();
        verify(product2).setAmount(Mockito.<Long>any());
        verify(product2).setCategory(Mockito.<ProductCategory>any());
        verify(product2).setId(Mockito.<String>any());
        verify(product2).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product2, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product2).setTitle(Mockito.<String>any());
        verify(product2).setVisible(Mockito.<Boolean>any());
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productMapper).toModel(Mockito.<SingleProductRequestDto>any());
        verify(productRepository).save(Mockito.<Product>any());
        assertSame(productResponseDto, actualCreateResult);
    }

    @Test
    void testCreate6() {
        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product);
        Product product2 = mock(Product.class);
        when(product2.getAmount()).thenReturn(100L);
        when(product2.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product2.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product2).setAmount(Mockito.<Long>any());
        doNothing().when(product2).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product2).setId(Mockito.<String>any());
        doNothing().when(product2).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product2).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product2).setTitle(Mockito.<String>any());
        doNothing().when(product2).setVisible(Mockito.<Boolean>any());
        product2.setAmount(10L);
        product2.setCategory(ProductCategory.HOME_APPLIANCE);
        product2.setId("42");
        product2.setPurchasePrice(new BigDecimal("2.3"));
        product2.setRetailPrice(new BigDecimal("2.3"));
        product2.setTitle("Dr");
        product2.setVisible(true);
        BigDecimal retailPrice = new BigDecimal("2.3");
        ProductResponseDto productResponseDto = new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice,
                new BigDecimal("2.3"));

        when(productMapper.toDto(Mockito.<Product>any())).thenReturn(productResponseDto);
        when(productMapper.toModel(Mockito.<SingleProductRequestDto>any())).thenReturn(product2);
        ProductResponseDto actualCreateResult = productServiceImpl
                .create(new SingleProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3")));
        verify(product2).getAmount();
        verify(product2).getPurchasePrice();
        verify(product2).getRetailPrice();
        verify(product2).setAmount(Mockito.<Long>any());
        verify(product2).setCategory(Mockito.<ProductCategory>any());
        verify(product2).setId(Mockito.<String>any());
        verify(product2).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product2, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product2).setTitle(Mockito.<String>any());
        verify(product2).setVisible(Mockito.<Boolean>any());
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productMapper).toModel(Mockito.<SingleProductRequestDto>any());
        verify(productRepository).save(Mockito.<Product>any());
        assertSame(productResponseDto, actualCreateResult);
    }

    @Test
    void testCreate7() {
        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product);
        Product product2 = mock(Product.class);
        when(product2.getAmount()).thenReturn(1000L);
        when(product2.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product2.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product2).setAmount(Mockito.<Long>any());
        doNothing().when(product2).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product2).setId(Mockito.<String>any());
        doNothing().when(product2).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product2).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product2).setTitle(Mockito.<String>any());
        doNothing().when(product2).setVisible(Mockito.<Boolean>any());
        product2.setAmount(10L);
        product2.setCategory(ProductCategory.HOME_APPLIANCE);
        product2.setId("42");
        product2.setPurchasePrice(new BigDecimal("2.3"));
        product2.setRetailPrice(new BigDecimal("2.3"));
        product2.setTitle("Dr");
        product2.setVisible(true);
        BigDecimal retailPrice = new BigDecimal("2.3");
        ProductResponseDto productResponseDto = new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice,
                new BigDecimal("2.3"));

        when(productMapper.toDto(Mockito.<Product>any())).thenReturn(productResponseDto);
        when(productMapper.toModel(Mockito.<SingleProductRequestDto>any())).thenReturn(product2);
        ProductResponseDto actualCreateResult = productServiceImpl
                .create(new SingleProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3")));
        verify(product2).getAmount();
        verify(product2).getPurchasePrice();
        verify(product2).getRetailPrice();
        verify(product2).setAmount(Mockito.<Long>any());
        verify(product2).setCategory(Mockito.<ProductCategory>any());
        verify(product2).setId(Mockito.<String>any());
        verify(product2).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product2, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product2).setTitle(Mockito.<String>any());
        verify(product2).setVisible(Mockito.<Boolean>any());
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productMapper).toModel(Mockito.<SingleProductRequestDto>any());
        verify(productRepository).save(Mockito.<Product>any());
        assertSame(productResponseDto, actualCreateResult);
    }

    @Test
    void testCreate8() {
        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product);
        Product product2 = mock(Product.class);
        when(product2.getAmount()).thenReturn(10000L);
        when(product2.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product2.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product2).setAmount(Mockito.<Long>any());
        doNothing().when(product2).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product2).setId(Mockito.<String>any());
        doNothing().when(product2).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product2).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product2).setTitle(Mockito.<String>any());
        doNothing().when(product2).setVisible(Mockito.<Boolean>any());
        product2.setAmount(10L);
        product2.setCategory(ProductCategory.HOME_APPLIANCE);
        product2.setId("42");
        product2.setPurchasePrice(new BigDecimal("2.3"));
        product2.setRetailPrice(new BigDecimal("2.3"));
        product2.setTitle("Dr");
        product2.setVisible(true);
        BigDecimal retailPrice = new BigDecimal("2.3");
        ProductResponseDto productResponseDto = new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice,
                new BigDecimal("2.3"));

        when(productMapper.toDto(Mockito.<Product>any())).thenReturn(productResponseDto);
        when(productMapper.toModel(Mockito.<SingleProductRequestDto>any())).thenReturn(product2);
        ProductResponseDto actualCreateResult = productServiceImpl
                .create(new SingleProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3")));
        verify(product2).getAmount();
        verify(product2).getPurchasePrice();
        verify(product2).getRetailPrice();
        verify(product2).setAmount(Mockito.<Long>any());
        verify(product2).setCategory(Mockito.<ProductCategory>any());
        verify(product2).setId(Mockito.<String>any());
        verify(product2).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product2, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product2).setTitle(Mockito.<String>any());
        verify(product2).setVisible(Mockito.<Boolean>any());
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productMapper).toModel(Mockito.<SingleProductRequestDto>any());
        verify(productRepository).save(Mockito.<Product>any());
        assertSame(productResponseDto, actualCreateResult);
    }

    @Test
    void testCreateSeveral() {
        when(productRepository.saveAll(Mockito.<Iterable<Product>>any())).thenReturn(new ArrayList<>());
        List<ProductResponseDto> actualCreateSeveralResult = productServiceImpl.createSeveral(new ArrayList<>());
        verify(productRepository).saveAll(Mockito.<Iterable<Product>>any());
        assertTrue(actualCreateSeveralResult.isEmpty());
    }

    @Test
    void testCreateSeveral2() {
        when(productRepository.saveAll(Mockito.<Iterable<Product>>any())).thenReturn(new ArrayList<>());

        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        BigDecimal retailPrice = new BigDecimal("2.3");
        when(productMapper.toDto(Mockito.<Product>any()))
                .thenReturn(new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice, new BigDecimal("2.3")));
        when(productMapper.toModel(Mockito.<ProductRequestDto>any())).thenReturn(product);

        ArrayList<ProductRequestDto> productRequestDtos = new ArrayList<>();
        productRequestDtos.add(new ProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3"), 10L));
        List<ProductResponseDto> actualCreateSeveralResult = productServiceImpl.createSeveral(productRequestDtos);
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productMapper).toModel(Mockito.<ProductRequestDto>any());
        verify(productRepository).saveAll(Mockito.<Iterable<Product>>any());
        assertEquals(1, actualCreateSeveralResult.size());
    }

    @Test
    void testCreateSeveral3() {
        when(productRepository.saveAll(Mockito.<Iterable<Product>>any())).thenReturn(new ArrayList<>());

        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        when(productMapper.toDto(Mockito.<Product>any())).thenThrow(new ProductNotFoundException("42"));
        when(productMapper.toModel(Mockito.<ProductRequestDto>any())).thenReturn(product);

        ArrayList<ProductRequestDto> productRequestDtos = new ArrayList<>();
        productRequestDtos.add(new ProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3"), 10L));
        assertThrows(ProductNotFoundException.class, () -> productServiceImpl.createSeveral(productRequestDtos));
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productMapper).toModel(Mockito.<ProductRequestDto>any());
        verify(productRepository).saveAll(Mockito.<Iterable<Product>>any());
    }

    @Test
    void testCreateSeveral4() {
        when(productRepository.saveAll(Mockito.<Iterable<Product>>any())).thenReturn(new ArrayList<>());
        Product product = mock(Product.class);
        when(product.getAmount()).thenReturn(10L);
        when(product.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product).setAmount(Mockito.<Long>any());
        doNothing().when(product).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product).setId(Mockito.<String>any());
        doNothing().when(product).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setTitle(Mockito.<String>any());
        doNothing().when(product).setVisible(Mockito.<Boolean>any());
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        BigDecimal retailPrice = new BigDecimal("2.3");
        when(productMapper.toDto(Mockito.<Product>any()))
                .thenReturn(new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice, new BigDecimal("2.3")));
        when(productMapper.toModel(Mockito.<ProductRequestDto>any())).thenReturn(product);

        ArrayList<ProductRequestDto> productRequestDtos = new ArrayList<>();
        productRequestDtos.add(new ProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3"), 10L));
        List<ProductResponseDto> actualCreateSeveralResult = productServiceImpl.createSeveral(productRequestDtos);
        verify(product).getAmount();
        verify(product).getPurchasePrice();
        verify(product).getRetailPrice();
        verify(product).setAmount(Mockito.<Long>any());
        verify(product).setCategory(Mockito.<ProductCategory>any());
        verify(product).setId(Mockito.<String>any());
        verify(product).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product).setTitle(Mockito.<String>any());
        verify(product).setVisible(Mockito.<Boolean>any());
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productMapper).toModel(Mockito.<ProductRequestDto>any());
        verify(productRepository).saveAll(Mockito.<Iterable<Product>>any());
        assertEquals(1, actualCreateSeveralResult.size());
    }

    @Test
    void testCreateSeveral5() {
        when(productRepository.saveAll(Mockito.<Iterable<Product>>any())).thenReturn(new ArrayList<>());
        Product product = mock(Product.class);
        when(product.getAmount()).thenReturn(99L);
        when(product.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product).setAmount(Mockito.<Long>any());
        doNothing().when(product).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product).setId(Mockito.<String>any());
        doNothing().when(product).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setTitle(Mockito.<String>any());
        doNothing().when(product).setVisible(Mockito.<Boolean>any());
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        BigDecimal retailPrice = new BigDecimal("2.3");
        when(productMapper.toDto(Mockito.<Product>any()))
                .thenReturn(new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice, new BigDecimal("2.3")));
        when(productMapper.toModel(Mockito.<ProductRequestDto>any())).thenReturn(product);

        ArrayList<ProductRequestDto> productRequestDtos = new ArrayList<>();
        productRequestDtos.add(new ProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3"), 10L));
        List<ProductResponseDto> actualCreateSeveralResult = productServiceImpl.createSeveral(productRequestDtos);
        verify(product).getAmount();
        verify(product).getPurchasePrice();
        verify(product).getRetailPrice();
        verify(product).setAmount(Mockito.<Long>any());
        verify(product).setCategory(Mockito.<ProductCategory>any());
        verify(product).setId(Mockito.<String>any());
        verify(product).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product).setTitle(Mockito.<String>any());
        verify(product).setVisible(Mockito.<Boolean>any());
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productMapper).toModel(Mockito.<ProductRequestDto>any());
        verify(productRepository).saveAll(Mockito.<Iterable<Product>>any());
        assertEquals(1, actualCreateSeveralResult.size());
    }

    @Test
    void testCreateSeveral6() {
        when(productRepository.saveAll(Mockito.<Iterable<Product>>any())).thenReturn(new ArrayList<>());
        Product product = mock(Product.class);
        when(product.getAmount()).thenReturn(-1L);
        when(product.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product).setAmount(Mockito.<Long>any());
        doNothing().when(product).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product).setId(Mockito.<String>any());
        doNothing().when(product).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setTitle(Mockito.<String>any());
        doNothing().when(product).setVisible(Mockito.<Boolean>any());
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        BigDecimal retailPrice = new BigDecimal("2.3");
        when(productMapper.toDto(Mockito.<Product>any()))
                .thenReturn(new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice, new BigDecimal("2.3")));
        when(productMapper.toModel(Mockito.<ProductRequestDto>any())).thenReturn(product);

        ArrayList<ProductRequestDto> productRequestDtos = new ArrayList<>();
        productRequestDtos.add(new ProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3"), 10L));
        List<ProductResponseDto> actualCreateSeveralResult = productServiceImpl.createSeveral(productRequestDtos);
        verify(product).getAmount();
        verify(product).getPurchasePrice();
        verify(product).getRetailPrice();
        verify(product).setAmount(Mockito.<Long>any());
        verify(product).setCategory(Mockito.<ProductCategory>any());
        verify(product).setId(Mockito.<String>any());
        verify(product).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product).setTitle(Mockito.<String>any());
        verify(product).setVisible(Mockito.<Boolean>any());
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productMapper).toModel(Mockito.<ProductRequestDto>any());
        verify(productRepository).saveAll(Mockito.<Iterable<Product>>any());
        assertEquals(1, actualCreateSeveralResult.size());
    }

    @Test
    void testCreateSeveral7() {
        when(productRepository.saveAll(Mockito.<Iterable<Product>>any())).thenReturn(new ArrayList<>());
        Product product = mock(Product.class);
        when(product.getAmount()).thenReturn(100L);
        when(product.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product).setAmount(Mockito.<Long>any());
        doNothing().when(product).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product).setId(Mockito.<String>any());
        doNothing().when(product).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setTitle(Mockito.<String>any());
        doNothing().when(product).setVisible(Mockito.<Boolean>any());
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        BigDecimal retailPrice = new BigDecimal("2.3");
        when(productMapper.toDto(Mockito.<Product>any()))
                .thenReturn(new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice, new BigDecimal("2.3")));
        when(productMapper.toModel(Mockito.<ProductRequestDto>any())).thenReturn(product);

        ArrayList<ProductRequestDto> productRequestDtos = new ArrayList<>();
        productRequestDtos.add(new ProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3"), 10L));
        List<ProductResponseDto> actualCreateSeveralResult = productServiceImpl.createSeveral(productRequestDtos);
        verify(product).getAmount();
        verify(product).getPurchasePrice();
        verify(product).getRetailPrice();
        verify(product).setAmount(Mockito.<Long>any());
        verify(product).setCategory(Mockito.<ProductCategory>any());
        verify(product).setId(Mockito.<String>any());
        verify(product).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product).setTitle(Mockito.<String>any());
        verify(product).setVisible(Mockito.<Boolean>any());
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productMapper).toModel(Mockito.<ProductRequestDto>any());
        verify(productRepository).saveAll(Mockito.<Iterable<Product>>any());
        assertEquals(1, actualCreateSeveralResult.size());
    }

    @Test
    void testCreateSeveral8() {
        when(productRepository.saveAll(Mockito.<Iterable<Product>>any())).thenReturn(new ArrayList<>());
        Product product = mock(Product.class);
        when(product.getAmount()).thenReturn(1000L);
        when(product.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product).setAmount(Mockito.<Long>any());
        doNothing().when(product).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product).setId(Mockito.<String>any());
        doNothing().when(product).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setTitle(Mockito.<String>any());
        doNothing().when(product).setVisible(Mockito.<Boolean>any());
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        BigDecimal retailPrice = new BigDecimal("2.3");
        when(productMapper.toDto(Mockito.<Product>any()))
                .thenReturn(new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice, new BigDecimal("2.3")));
        when(productMapper.toModel(Mockito.<ProductRequestDto>any())).thenReturn(product);

        ArrayList<ProductRequestDto> productRequestDtos = new ArrayList<>();
        productRequestDtos.add(new ProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3"), 10L));
        List<ProductResponseDto> actualCreateSeveralResult = productServiceImpl.createSeveral(productRequestDtos);
        verify(product).getAmount();
        verify(product).getPurchasePrice();
        verify(product).getRetailPrice();
        verify(product).setAmount(Mockito.<Long>any());
        verify(product).setCategory(Mockito.<ProductCategory>any());
        verify(product).setId(Mockito.<String>any());
        verify(product).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product).setTitle(Mockito.<String>any());
        verify(product).setVisible(Mockito.<Boolean>any());
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productMapper).toModel(Mockito.<ProductRequestDto>any());
        verify(productRepository).saveAll(Mockito.<Iterable<Product>>any());
        assertEquals(1, actualCreateSeveralResult.size());
    }

    @Test
    void testCreateSeveral9() {
        when(productRepository.saveAll(Mockito.<Iterable<Product>>any())).thenReturn(new ArrayList<>());
        Product product = mock(Product.class);
        when(product.getAmount()).thenReturn(10000L);
        when(product.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product).setAmount(Mockito.<Long>any());
        doNothing().when(product).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product).setId(Mockito.<String>any());
        doNothing().when(product).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setTitle(Mockito.<String>any());
        doNothing().when(product).setVisible(Mockito.<Boolean>any());
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        BigDecimal retailPrice = new BigDecimal("2.3");
        when(productMapper.toDto(Mockito.<Product>any()))
                .thenReturn(new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice, new BigDecimal("2.3")));
        when(productMapper.toModel(Mockito.<ProductRequestDto>any())).thenReturn(product);

        ArrayList<ProductRequestDto> productRequestDtos = new ArrayList<>();
        productRequestDtos.add(new ProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3"), 10L));
        List<ProductResponseDto> actualCreateSeveralResult = productServiceImpl.createSeveral(productRequestDtos);
        verify(product).getAmount();
        verify(product).getPurchasePrice();
        verify(product).getRetailPrice();
        verify(product).setAmount(Mockito.<Long>any());
        verify(product).setCategory(Mockito.<ProductCategory>any());
        verify(product).setId(Mockito.<String>any());
        verify(product).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product).setTitle(Mockito.<String>any());
        verify(product).setVisible(Mockito.<Boolean>any());
        verify(productMapper).toDto(Mockito.<Product>any());
        verify(productMapper).toModel(Mockito.<ProductRequestDto>any());
        verify(productRepository).saveAll(Mockito.<Iterable<Product>>any());
        assertEquals(1, actualCreateSeveralResult.size());
    }

    @Test
    void testCreateSeveral10() {
        when(productRepository.saveAll(Mockito.<Iterable<Product>>any())).thenReturn(new ArrayList<>());
        Product product = mock(Product.class);
        when(product.getAmount()).thenReturn(10L);
        when(product.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product).setAmount(Mockito.<Long>any());
        doNothing().when(product).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product).setId(Mockito.<String>any());
        doNothing().when(product).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setTitle(Mockito.<String>any());
        doNothing().when(product).setVisible(Mockito.<Boolean>any());
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        BigDecimal retailPrice = new BigDecimal("2.3");
        when(productMapper.toDto(Mockito.<Product>any()))
                .thenReturn(new ProductResponseDto("Dr", ProductCategory.HOME_APPLIANCE, retailPrice, new BigDecimal("2.3")));
        when(productMapper.toModel(Mockito.<ProductRequestDto>any())).thenReturn(product);

        ArrayList<ProductRequestDto> productRequestDtos = new ArrayList<>();
        productRequestDtos.add(new ProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3"), 10L));
        productRequestDtos.add(new ProductRequestDto("Dr", ProductCategory.HOME_APPLIANCE, new BigDecimal("2.3"), 10L));
        List<ProductResponseDto> actualCreateSeveralResult = productServiceImpl.createSeveral(productRequestDtos);
        verify(product, atLeast(1)).getAmount();
        verify(product, atLeast(1)).getPurchasePrice();
        verify(product, atLeast(1)).getRetailPrice();
        verify(product).setAmount(Mockito.<Long>any());
        verify(product).setCategory(Mockito.<ProductCategory>any());
        verify(product).setId(Mockito.<String>any());
        verify(product).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product).setTitle(Mockito.<String>any());
        verify(product).setVisible(Mockito.<Boolean>any());
        verify(productMapper, atLeast(1)).toDto(Mockito.<Product>any());
        verify(productMapper, atLeast(1)).toModel(Mockito.<ProductRequestDto>any());
        verify(productRepository).saveAll(Mockito.<Iterable<Product>>any());
        assertEquals(2, actualCreateSeveralResult.size());
    }

    @Test
    void testDeleteById() {
        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        Optional<Product> ofResult = Optional.of(product);

        Product product2 = new Product();
        product2.setAmount(10L);
        product2.setCategory(ProductCategory.HOME_APPLIANCE);
        product2.setId("42");
        product2.setPurchasePrice(new BigDecimal("2.3"));
        product2.setRetailPrice(new BigDecimal("2.3"));
        product2.setTitle("Dr");
        product2.setVisible(true);
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product2);
        when(productRepository.findById(Mockito.<String>any())).thenReturn(ofResult);
        productServiceImpl.deleteById("42");
        verify(productRepository).findById(Mockito.<String>any());
        verify(productRepository).save(Mockito.<Product>any());
    }

    @Test
    void testDeleteById2() {
        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        Optional<Product> ofResult = Optional.of(product);
        when(productRepository.save(Mockito.<Product>any())).thenThrow(new ProductNotFoundException("42"));
        when(productRepository.findById(Mockito.<String>any())).thenReturn(ofResult);
        assertThrows(ProductNotFoundException.class, () -> productServiceImpl.deleteById("42"));
        verify(productRepository).findById(Mockito.<String>any());
        verify(productRepository).save(Mockito.<Product>any());
    }

    @Test
    void testDeleteById3() {
        Product product = mock(Product.class);
        doNothing().when(product).setAmount(Mockito.<Long>any());
        doNothing().when(product).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product).setId(Mockito.<String>any());
        doNothing().when(product).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setTitle(Mockito.<String>any());
        doNothing().when(product).setVisible(Mockito.<Boolean>any());
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        Optional<Product> ofResult = Optional.of(product);

        Product product2 = new Product();
        product2.setAmount(10L);
        product2.setCategory(ProductCategory.HOME_APPLIANCE);
        product2.setId("42");
        product2.setPurchasePrice(new BigDecimal("2.3"));
        product2.setRetailPrice(new BigDecimal("2.3"));
        product2.setTitle("Dr");
        product2.setVisible(true);
        when(productRepository.save(Mockito.<Product>any())).thenReturn(product2);
        when(productRepository.findById(Mockito.<String>any())).thenReturn(ofResult);
        productServiceImpl.deleteById("42");
        verify(product).setAmount(Mockito.<Long>any());
        verify(product).setCategory(Mockito.<ProductCategory>any());
        verify(product).setId(Mockito.<String>any());
        verify(product).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product).setTitle(Mockito.<String>any());
        verify(product, atLeast(1)).setVisible(Mockito.<Boolean>any());
        verify(productRepository).findById(Mockito.<String>any());
        verify(productRepository).save(Mockito.<Product>any());
    }

    @Test
    void testDeleteById4() {
        Optional<Product> emptyResult = Optional.empty();
        when(productRepository.findById(Mockito.<String>any())).thenReturn(emptyResult);
        assertThrows(ProductNotFoundException.class, () -> productServiceImpl.deleteById("42"));
        verify(productRepository).findById(Mockito.<String>any());
    }

    @Test
    void testCalculateRetailPrice() {
        Product product = new Product();
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        productServiceImpl.calculateRetailPrice(product);
        BigDecimal expectedRetailPrice = new BigDecimal("2.99");
        assertEquals(expectedRetailPrice, product.getRetailPrice());
    }

    @Test
    void testCalculateRetailPrice2() {
        Product product = mock(Product.class);
        when(product.getAmount()).thenReturn(10L);
        when(product.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product).setAmount(Mockito.<Long>any());
        doNothing().when(product).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product).setId(Mockito.<String>any());
        doNothing().when(product).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setTitle(Mockito.<String>any());
        doNothing().when(product).setVisible(Mockito.<Boolean>any());
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        productServiceImpl.calculateRetailPrice(product);
        verify(product).getAmount();
        verify(product).getPurchasePrice();
        verify(product).getRetailPrice();
        verify(product).setAmount(Mockito.<Long>any());
        verify(product).setCategory(Mockito.<ProductCategory>any());
        verify(product).setId(Mockito.<String>any());
        verify(product).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product).setTitle(Mockito.<String>any());
        verify(product).setVisible(Mockito.<Boolean>any());
    }

    @Test
    void testCalculateRetailPrice3() {
        Product product = mock(Product.class);
        when(product.getAmount()).thenReturn(99L);
        when(product.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product).setAmount(Mockito.<Long>any());
        doNothing().when(product).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product).setId(Mockito.<String>any());
        doNothing().when(product).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setTitle(Mockito.<String>any());
        doNothing().when(product).setVisible(Mockito.<Boolean>any());
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        productServiceImpl.calculateRetailPrice(product);
        verify(product).getAmount();
        verify(product).getPurchasePrice();
        verify(product).getRetailPrice();
        verify(product).setAmount(Mockito.<Long>any());
        verify(product).setCategory(Mockito.<ProductCategory>any());
        verify(product).setId(Mockito.<String>any());
        verify(product).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product).setTitle(Mockito.<String>any());
        verify(product).setVisible(Mockito.<Boolean>any());
    }

    @Test
    void testCalculateRetailPrice4() {
        Product product = mock(Product.class);
        when(product.getAmount()).thenReturn(-1L);
        when(product.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product).setAmount(Mockito.<Long>any());
        doNothing().when(product).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product).setId(Mockito.<String>any());
        doNothing().when(product).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setTitle(Mockito.<String>any());
        doNothing().when(product).setVisible(Mockito.<Boolean>any());
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        productServiceImpl.calculateRetailPrice(product);
        verify(product).getAmount();
        verify(product).getPurchasePrice();
        verify(product).getRetailPrice();
        verify(product).setAmount(Mockito.<Long>any());
        verify(product).setCategory(Mockito.<ProductCategory>any());
        verify(product).setId(Mockito.<String>any());
        verify(product).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product).setTitle(Mockito.<String>any());
        verify(product).setVisible(Mockito.<Boolean>any());
    }

    @Test
    void testCalculateRetailPrice5() {
        Product product = mock(Product.class);
        when(product.getAmount()).thenReturn(100L);
        when(product.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product).setAmount(Mockito.<Long>any());
        doNothing().when(product).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product).setId(Mockito.<String>any());
        doNothing().when(product).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setTitle(Mockito.<String>any());
        doNothing().when(product).setVisible(Mockito.<Boolean>any());
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        productServiceImpl.calculateRetailPrice(product);
        verify(product).getAmount();
        verify(product).getPurchasePrice();
        verify(product).getRetailPrice();
        verify(product).setAmount(Mockito.<Long>any());
        verify(product).setCategory(Mockito.<ProductCategory>any());
        verify(product).setId(Mockito.<String>any());
        verify(product).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product).setTitle(Mockito.<String>any());
        verify(product).setVisible(Mockito.<Boolean>any());
    }

    @Test
    void testCalculateRetailPrice6() {
        Product product = mock(Product.class);
        when(product.getAmount()).thenReturn(1000L);
        when(product.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product).setAmount(Mockito.<Long>any());
        doNothing().when(product).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product).setId(Mockito.<String>any());
        doNothing().when(product).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setTitle(Mockito.<String>any());
        doNothing().when(product).setVisible(Mockito.<Boolean>any());
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        productServiceImpl.calculateRetailPrice(product);
        verify(product).getAmount();
        verify(product).getPurchasePrice();
        verify(product).getRetailPrice();
        verify(product).setAmount(Mockito.<Long>any());
        verify(product).setCategory(Mockito.<ProductCategory>any());
        verify(product).setId(Mockito.<String>any());
        verify(product).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product).setTitle(Mockito.<String>any());
        verify(product).setVisible(Mockito.<Boolean>any());
    }

    @Test
    void testCalculateRetailPrice7() {
        Product product = mock(Product.class);
        when(product.getAmount()).thenReturn(10000L);
        when(product.getPurchasePrice()).thenReturn(new BigDecimal("2.3"));
        when(product.getRetailPrice()).thenReturn(new BigDecimal("2.3"));
        doNothing().when(product).setAmount(Mockito.<Long>any());
        doNothing().when(product).setCategory(Mockito.<ProductCategory>any());
        doNothing().when(product).setId(Mockito.<String>any());
        doNothing().when(product).setPurchasePrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setRetailPrice(Mockito.<BigDecimal>any());
        doNothing().when(product).setTitle(Mockito.<String>any());
        doNothing().when(product).setVisible(Mockito.<Boolean>any());
        product.setAmount(10L);
        product.setCategory(ProductCategory.HOME_APPLIANCE);
        product.setId("42");
        product.setPurchasePrice(new BigDecimal("2.3"));
        product.setRetailPrice(new BigDecimal("2.3"));
        product.setTitle("Dr");
        product.setVisible(true);
        productServiceImpl.calculateRetailPrice(product);
        verify(product).getAmount();
        verify(product).getPurchasePrice();
        verify(product).getRetailPrice();
        verify(product).setAmount(Mockito.<Long>any());
        verify(product).setCategory(Mockito.<ProductCategory>any());
        verify(product).setId(Mockito.<String>any());
        verify(product).setPurchasePrice(Mockito.<BigDecimal>any());
        verify(product, atLeast(1)).setRetailPrice(Mockito.<BigDecimal>any());
        verify(product).setTitle(Mockito.<String>any());
        verify(product).setVisible(Mockito.<Boolean>any());
    }
}
