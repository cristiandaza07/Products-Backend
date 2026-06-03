package com.proyecto2026.web.product.application.command.create;

import com.proyecto2026.web.common.application.mediator.RequestHandler;
import com.proyecto2026.web.common.infrastructure.util.FileUtils;
import com.proyecto2026.web.product.domain.entity.Product;
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
public class CreateProductHandler implements RequestHandler<CreateProductRequest, CreateProductResponse> {

    private final ProductRepository productRepository;
    private final FileUtils fileUtils;

    @Override
    public CreateProductResponse handle(CreateProductRequest request) {

        String uniqueFileName = fileUtils.saveProductImage(request.getFile());

        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .image(uniqueFileName)
                .build();

        ProductDetail detail = ProductDetail.builder()
                .provider(request.getProvider())
                .warranty(request.getWarranty())
                .specifications(request.getSpecifications())
                .build();

        product.setProductDetail(detail);

        Product storedProduct = productRepository.save(product);
        log.info("Created product with id: {}", storedProduct.getId());

        return new CreateProductResponse(storedProduct);
    }

    @Override
    public Class<CreateProductRequest> getRequestType() {

        return CreateProductRequest.class;
    }
}
