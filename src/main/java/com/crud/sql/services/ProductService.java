package com.crud.sql.services;

import com.crud.sql.entities.Category;
import com.crud.sql.entities.Product;
import com.crud.sql.exceptions.EmptyValuesException;
import com.crud.sql.repositories.CategoryRepository;
import com.crud.sql.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

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

    @Transactional
    public void deleteProduct(Long product_id){
        Optional<Product> product = repository.findById(product_id);

        if (product.isEmpty())
            throw new EntityNotFoundException("The product not exists or already has been deleted.");

        repository.deleteById(product_id);
    }

    @Transactional
    public Product putProduct(Product product){
        Optional<Product> productUpdated = repository.findById(product.getProduct_id());

        if (productUpdated.isEmpty())
            throw new EntityNotFoundException("Category not found, insert another id.");

        if (product.getProduct_name().isEmpty())
            throw new EmptyValuesException("Empty values are not allowed, please insert a product name");

        if (product.getProduct_price() == 0.00)
            throw new EmptyValuesException("The must be more than 0, please insert a product price");

        return repository.save(product);
    }
}
