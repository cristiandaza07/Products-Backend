package com.proyecto2026.web.product.application.query.getAll;

import com.proyecto2026.web.common.application.mediator.RequestHandler;
import com.proyecto2026.web.common.domain.PaginationResult;
import com.proyecto2026.web.product.domain.entity.Product;
import com.proyecto2026.web.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllProductHandler implements RequestHandler<GetAllProductRequest, GetAllProductResponse> {

    private final ProductRepository productRepository;

    @Override
    public GetAllProductResponse handle(GetAllProductRequest request) {
        PaginationResult<Product> products = productRepository.findAll(request.paginationQuery, request.productFilter);
        return new GetAllProductResponse(products);
    }

    @Override
    public Class<GetAllProductRequest> getRequestType() {
        return GetAllProductRequest.class;
    }
}

