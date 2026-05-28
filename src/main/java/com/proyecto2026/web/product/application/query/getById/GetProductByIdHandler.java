package com.proyecto2026.web.product.application.query.getById;

import com.proyecto2026.web.common.application.mediator.RequestHandler;
import com.proyecto2026.web.product.domain.entity.Product;
import com.proyecto2026.web.product.domain.exception.ProductNotFoundException;
import com.proyecto2026.web.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProductByIdHandler implements RequestHandler<GetProductByIdRequest, GetProductByIdResponse> {

    private final ProductRepository productRepository;

    @Override
    public GetProductByIdResponse handle(GetProductByIdRequest request) {

        Product product = productRepository.findById(request.getId()).orElseThrow(() -> new ProductNotFoundException(request.getId()));

        return new GetProductByIdResponse(product);

    }

    @Override
    public Class<GetProductByIdRequest> getRequestType() {
        return GetProductByIdRequest.class;
    }
}
