package com.proyecto2026.web.product.application.command.delete;

import com.proyecto2026.web.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteProductRequest implements Request<Void> {

    private Long id;

}
