package com.andersen.onlinestore.service.mapper;

import com.andersen.onlinestore.dto.request.ProductRequestDto;
import com.andersen.onlinestore.dto.response.ProductResponseDto;
import com.andersen.onlinestore.model.Product;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProductMapper {
    public ProductResponseDto toDto(Product product) {
        return ProductResponseDto.builder()
                .title(product.getTitle())
                .category(product.getCategory())
                .price(product.getPurchase_price())
                .build();
    }

    public Product toModel(ProductRequestDto productRequestDto) {
        return Product.builder()
                .id(UUID.randomUUID().toString())
                .title(productRequestDto.title())
                .category(productRequestDto.category())
                .purchase_price(productRequestDto.price())
//                .retailPrice(productRequestDto.)
                /**
                 * SET AMOUNT SOMEHOW
                 */
                .visible(true)
                .build();
    }
}
