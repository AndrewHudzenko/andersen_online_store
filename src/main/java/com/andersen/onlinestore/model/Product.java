package com.andersen.onlinestore.model;

import com.andersen.onlinestore.model.type.ProductCategory;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    private String id;
    private String title;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    private BigDecimal purchase_price;
    private BigDecimal retail_price;
    private Long amount;
    private Boolean visible;
}
