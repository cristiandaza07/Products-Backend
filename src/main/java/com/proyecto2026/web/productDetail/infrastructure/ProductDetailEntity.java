package com.proyecto2026.web.productDetail.infrastructure;

import com.proyecto2026.web.product.infrastructure.database.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product_details")
public class ProductDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String targetSpecies;
    private String lifeStage;
    private String brand;

    @OneToOne(mappedBy = "productDetailEntity")
    private ProductEntity productEntity;
}
