package com.proyecto2026.web.productDetail.domian;

import com.proyecto2026.web.product.domain.entity.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDetail {

    private Long id;
    private TargetSpecies targetSpecies;
    private LifeStage lifeStage;
    private String brand;

    private Product product;

}
