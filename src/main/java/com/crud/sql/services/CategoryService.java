package com.crud.sql.services;

import com.crud.sql.dto.CategoryDto;
import com.crud.sql.entities.Category;
import com.crud.sql.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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
        return repository.save(category);
    }

    @Transactional
    public List<Category> getAllCategories(){
        return repository.findAll();
    }

    @Transactional
    public Category getCategory(Long category_id){
        return repository.findById(category_id).orElseThrow(
                () -> new EntityNotFoundException("Category Not Found")
        );
    }

    @Transactional
    public void deleteCategory(Long category_id){
        repository.deleteById(category_id);
    }
}
