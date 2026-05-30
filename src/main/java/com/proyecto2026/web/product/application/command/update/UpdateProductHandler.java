package com.proyecto2026.web.product.application.command.update;

import com.proyecto2026.web.category.domain.entity.Category;
import com.proyecto2026.web.category.domain.port.CategoryRepository;
import com.proyecto2026.web.category.infrastructure.database.mapper.CategoryEntityMapper;
import com.proyecto2026.web.common.application.mediator.RequestHandler;
import com.proyecto2026.web.product.domain.entity.Product;
import com.proyecto2026.web.product.domain.exception.ProductNotFoundException;
import com.proyecto2026.web.product.domain.port.ProductRepository;
import com.proyecto2026.web.productDetail.domian.ProductDetail;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class UpdateProductHandler implements RequestHandler<UpdateProductRequest, Void> {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public Void handle(UpdateProductRequest request) {

        Product product = productRepository.findById(request.getId()).orElseThrow(() -> new ProductNotFoundException(request.getId()));

        ProductDetail productDetail = product.getProductDetail();

        productDetail.setProvider(request.getProvider());

        product.getReviews().add(request.getReview());

        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));

        product.getCategories().add(category);

        productRepository.save(product);

        return null;
    }

    @Override
    public Class<UpdateProductRequest> getRequestType() {
        return UpdateProductRequest.class;
    }
}
