package com.crud.sql.controllers;

import com.crud.sql.dto.ProductDto;
import com.crud.sql.entities.Category;
import com.crud.sql.entities.Product;
import com.crud.sql.mappers.ProductMapper;
import com.crud.sql.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

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

    @GetMapping("get-products")
    public ResponseEntity<List<Product>> findAllProducts(){
        List<Product> productList = service.getAllProducts();

        return ResponseEntity.ok().body(productList);
    }
}
