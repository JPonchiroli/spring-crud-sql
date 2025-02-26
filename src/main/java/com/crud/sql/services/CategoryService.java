package com.crud.sql.services;

import com.crud.sql.dto.CategoryDto;
import com.crud.sql.entities.Category;
import com.crud.sql.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

}
