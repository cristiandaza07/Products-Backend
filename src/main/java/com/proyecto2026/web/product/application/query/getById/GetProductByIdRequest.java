package com.proyecto2026.web.product.application.query.getById;

import com.proyecto2026.web.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetProductByIdRequest implements Request<GetProductByIdResponse> {
    private Long id;

}
