package com.crud.sql.services;

import com.crud.sql.entities.Category;
import com.crud.sql.entities.Product;
import com.crud.sql.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional
    public Product postProduct(Product product){
        return repository.save(product);
    }

    @Transactional
    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    @Transactional
    public Product getProduct(Long product_id){
        return repository.findById(product_id).orElseThrow(
                () -> new EntityNotFoundException("Product not found, insert another id.")
        );
    }
}
