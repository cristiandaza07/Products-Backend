package com.proyecto2026.web.product.application.query.getAll;

import com.proyecto2026.web.common.application.mediator.Request;
import com.proyecto2026.web.common.domain.PaginationQuery;
import com.proyecto2026.web.product.domain.entity.ProductFilter;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAllProductRequest implements Request<GetAllProductResponse> {
    PaginationQuery paginationQuery;

    ProductFilter productFilter;
}
