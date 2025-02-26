package com.crud.sql.controllers;

import com.crud.sql.dto.CategoryDto;
import com.crud.sql.entities.Category;
import com.crud.sql.mapper.CategoryMapper;
import com.crud.sql.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public String testRequisition(){
        return "Welcome to Crud SQL";
    }

    @PostMapping("create-category")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        System.out.println(categoryDto);
        Category categoryCreated = CategoryMapper.toCategory(categoryDto);
        System.out.println(categoryCreated);

        service.postCategory(categoryCreated);
        return ResponseEntity.status(201).body(CategoryMapper.toCategoryDto(categoryCreated));
    }
}
    