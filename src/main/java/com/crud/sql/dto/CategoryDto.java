package com.crud.sql.dto;

public class CategoryDto {

    private String category_name;

    public CategoryDto(){}

    public CategoryDto(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "category_name='" + category_name + '\'' +
                '}';
    }
}
