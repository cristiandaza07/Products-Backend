package com.proyecto2026.web.review.infrastructure.database.entity;

import com.proyecto2026.web.product.infrastructure.database.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "reviews")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;

}
