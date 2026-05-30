package com.proyecto2026.web.category.infrastructure.database.mapper;

import com.proyecto2026.web.category.domain.entity.Category;
import com.proyecto2026.web.category.infrastructure.database.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CategoryEntityMapper {

    @Mapping(target = "products", ignore = true)
    Category mapToCategory(CategoryEntity categoryEntity);

    //@Mapping(target = "productDetailEntity", source = "productDetail")
    @Mapping(target = "products", ignore = true)
    CategoryEntity mapToCategoryEntity(Category category);

}
