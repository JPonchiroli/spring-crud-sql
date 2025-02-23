package com.crud.sql.mapper;

import com.crud.sql.dto.CategoryCreateDto;
import com.crud.sql.dto.CategoryResponseDto;
import com.crud.sql.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryResponseDto toCategoryResponseDto(Category category);

    Category toCategory(CategoryCreateDto categoryCreateDto);
}
