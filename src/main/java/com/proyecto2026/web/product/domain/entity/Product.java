package com.proyecto2026.web.product.domain.entity;

import com.proyecto2026.web.category.domain.entity.Category;
import com.proyecto2026.web.productDetail.domian.ProductDetail;
import com.proyecto2026.web.review.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class Product {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String image;

    private ProductDetail productDetail;

    private List<Review> reviews;

    private List<Category> categories;

}
