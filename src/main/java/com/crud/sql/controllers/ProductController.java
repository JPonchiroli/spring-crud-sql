package com.crud.sql.controllers;

import com.crud.sql.dto.ProductDto;
import com.crud.sql.entities.Category;
import com.crud.sql.entities.Product;
import com.crud.sql.mappers.ProductMapper;
import com.crud.sql.services.CategoryService;
import com.crud.sql.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("create-product")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto){
        Product productCreated = ProductMapper.toProduct(productDto);
        Category category = categoryService.getCategory(productDto.getCategory_id());

        if (category == null) {
            throw new IllegalArgumentException("Category not found!");
        }

        productCreated.setCategory(category);
        service.postProduct(productCreated);
        return ResponseEntity.status(201).body(productCreated);
    }

    @GetMapping("get-products")
    public ResponseEntity<List<Product>> findAllProducts(){
        List<Product> productList = service.getAllProducts();

        return ResponseEntity.ok().body(productList);
    }

    @GetMapping("get-product/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable("id") Long product_id){
        Product product = service.getProduct(product_id);

        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("delete-product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long product_id){
        service.deleteProduct(product_id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("update-product/{id}")
    public ResponseEntity<ProductDto> updateCategory(@PathVariable("id") Long product_id, @RequestBody ProductDto productDto){
        Product productUpdated = findProduct(product_id).getBody();
        productUpdated.setProduct_name(productDto.getProduct_name());
        productUpdated.setProduct_price(productDto.getProduct_price());

        service.putProduct(productUpdated);
        return ResponseEntity.ok().body(ProductMapper.toProductDto(productUpdated));
    }
}
