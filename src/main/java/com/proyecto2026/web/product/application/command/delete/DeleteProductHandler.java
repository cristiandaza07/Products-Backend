package com.proyecto2026.web.product.application.command.delete;

import com.proyecto2026.web.common.application.mediator.RequestHandler;
import com.proyecto2026.web.product.domain.port.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProductHandler implements RequestHandler<DeleteProductRequest, Void> {

    private final ProductRepository productRepository;

    @Override
    public Void handle(DeleteProductRequest request) {

        productRepository.deleteById(request.getId());
        return null;
    }

    @Override
    public Class<DeleteProductRequest> getRequestType() {

        return DeleteProductRequest.class;
    }
}
