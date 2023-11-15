package com.andersen.onlinestore.controller;

import com.andersen.onlinestore.dto.request.ProductRequestDto;
import com.andersen.onlinestore.dto.request.SingleProductRequestDto;
import com.andersen.onlinestore.dto.response.ProductResponseDto;
import com.andersen.onlinestore.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/products")
@Tag(name = "Product Controller")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponseDto getById(@PathVariable String id) {
        log.info("GET /api/v1/product/" + id);
        return productService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getAll() {
        log.info("GET /api/v1/books/");
        return productService.getAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create product")
    public ProductResponseDto create(@Valid @RequestBody SingleProductRequestDto productRequestDto) {
        log.info("POST /api/v1/products");
        return productService.create(productRequestDto);
    }

    @PostMapping("/create/several")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create several products")
    public List<ProductResponseDto> createSeveral(@Valid @RequestBody List<ProductRequestDto> productRequestDtos) {
        log.info("POST /api/v1/products/several");
        return productService.createSeveral(productRequestDtos);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete account")
    public void deleteById(@PathVariable String id) {
        log.info("PUT /api/v1/products/" + id);
        productService.deleteById(id);
    }
}
