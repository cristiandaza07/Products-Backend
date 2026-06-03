package com.proyecto2026.web.category.infrastructure.api.mapper;

import com.proyecto2026.web.category.application.command.create.CreateCategoryRequest;
import com.proyecto2026.web.category.infrastructure.api.dto.CreateCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CategoryMapper {
    CreateCategoryRequest mapToCreateCategoryRequest(CreateCategoryDto createCategoryDto);

}
