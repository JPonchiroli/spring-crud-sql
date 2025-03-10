package com.crud.sql.controllers;

import com.crud.sql.dto.ProductDto;
import com.crud.sql.entities.Product;
import com.crud.sql.mappers.ProductMapper;
import com.crud.sql.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("create-product")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        Product productCreated = ProductMapper.toProduct(productDto);

        service.postProduct(productCreated);
        return ResponseEntity.status(201).body(ProductMapper.toProductDto(productCreated));
    }
}
