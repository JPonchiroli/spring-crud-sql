package com.crud.sql.controllers;

import com.crud.sql.dto.CategoryDto;
import com.crud.sql.entities.Category;
import com.crud.sql.mappers.CategoryMapper;
import com.crud.sql.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        Category categoryCreated = CategoryMapper.toCategory(categoryDto);

        service.postCategory(categoryCreated);
        return ResponseEntity.status(201).body(CategoryMapper.toCategoryDto(categoryCreated));
    }

    @GetMapping("get-categories")
    public ResponseEntity<List<Category>> findAllCategories(){
        List<Category> categoryList = service.getAllCategories();

        return ResponseEntity.ok().body(categoryList);
    }

    @GetMapping("get-category/{id}")
    public ResponseEntity<Category> findCategory(@PathVariable("id") Long category_id){
        Category category = service.getCategory(category_id);

        return ResponseEntity.ok().body(category);
    }

    @DeleteMapping("delete-category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long category_id){
        service.deleteCategory(category_id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("update-category/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long category_id, @RequestBody CategoryDto categoryDto){
        Category categoryUpdated = findCategory(category_id).getBody();
        categoryUpdated.setCategory_name(categoryDto.getCategory_name());

        service.putCategory(categoryUpdated);
        return ResponseEntity.ok().body(CategoryMapper.toCategoryDto(categoryUpdated));
    }

}
    