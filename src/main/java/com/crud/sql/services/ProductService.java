package com.crud.sql.services;

import com.crud.sql.entities.Product;
import com.crud.sql.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional
    public Product postProduct(Product product){
        return repository.save(product);
    }
}
