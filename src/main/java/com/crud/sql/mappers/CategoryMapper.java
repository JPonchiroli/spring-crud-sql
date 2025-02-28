package com.crud.sql.mappers;

import com.crud.sql.dto.CategoryDto;
import com.crud.sql.entities.Category;
import org.modelmapper.ModelMapper;

public class CategoryMapper {

    public CategoryMapper(){}

    public static Category toCategory(CategoryDto categoryDto){
        return new ModelMapper().map(categoryDto, Category.class);
    }

    public static CategoryDto toCategoryDto(Category category){
        return new ModelMapper().map(category, CategoryDto.class);
    }
}
