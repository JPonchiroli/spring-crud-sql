package com.crud.sql.services;

import com.crud.sql.dto.CategoryDto;
import com.crud.sql.entities.Category;
import com.crud.sql.exceptions.EmptyValuesException;
import com.crud.sql.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional
    public Category postCategory(Category category){
        if (category.getCategory_name().isEmpty())
            throw new EmptyValuesException("Empty values are not allowed, please insert a category name");

        return repository.save(category);
    }

    @Transactional
    public List<Category> getAllCategories(){
        return repository.findAll();
    }

    @Transactional
    public Category getCategory(Long category_id){
        return repository.findById(category_id).orElseThrow(
                () -> new EntityNotFoundException("Category not found, insert another id.")
        );
    }

    @Transactional
    public void deleteCategory(Long category_id){
        Optional<Category> category = repository.findById(category_id);

        if (category.isEmpty())
            throw new EntityNotFoundException("The category not exists or already has been deleted.");

        repository.deleteById(category_id);
    }

    @Transactional
    public Category putCategory(Category category){
        Optional<Category> categoryUpdated = repository.findById(category.getCategory_id());

        if (categoryUpdated.isEmpty())
            throw new EntityNotFoundException("Category not found, insert another id.");

        if (category.getCategory_name().isEmpty())
            throw new EmptyValuesException("Empty values are not allowed, please insert a category name");

        return repository.save(category);
    }
}
