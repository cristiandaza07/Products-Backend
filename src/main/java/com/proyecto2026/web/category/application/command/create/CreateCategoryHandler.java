package com.proyecto2026.web.category.application.command.create;

import com.proyecto2026.web.category.domain.entity.Category;
import com.proyecto2026.web.category.domain.exception.CategoryAlreadyExistsException;
import com.proyecto2026.web.category.domain.port.CategoryRepository;
import com.proyecto2026.web.common.application.mediator.RequestHandler;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(rollbackOn = Exception.class)
public class CreateCategoryHandler implements RequestHandler<CreateCategoryRequest, CreateCategoryResponse> {

    private final CategoryRepository categoryRepository;

    @Override
    public CreateCategoryResponse handle(CreateCategoryRequest request) {

        boolean exists = categoryRepository.findByName(request.getName()).isPresent();

        if (exists) {
            throw new CategoryAlreadyExistsException(request.getName());
        }

        Category category = Category.builder()
                .name(request.getName())
                .build();

        Category storedCategory = categoryRepository.save(category);
        log.info("Created category with id: {}", storedCategory.getId());

        return new CreateCategoryResponse(storedCategory);
    }

    @Override
    public Class<CreateCategoryRequest> getRequestType() {
        return CreateCategoryRequest.class;
    }
}
