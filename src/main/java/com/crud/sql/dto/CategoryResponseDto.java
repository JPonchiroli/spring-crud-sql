package com.crud.sql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryResponseDto {

    private String category_name;

    @Override
    public String toString() {
        return "CategoryResponseDto [" +
                "category_name: " + category_name + "]";
    }
}
