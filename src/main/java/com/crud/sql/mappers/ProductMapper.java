package com.crud.sql.mappers;

import com.crud.sql.dto.ProductDto;
import com.crud.sql.entities.Category;
import com.crud.sql.entities.Product;
import com.crud.sql.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductMapper() {
    }

    public static Product toProduct(ProductDto productDto){
        Product product = new Product();
        product.setProduct_name(productDto.getProduct_name());
        product.setProduct_price(productDto.getProduct_price());
        return product;
    }

    public static ProductDto toProductDto(Product product){
        return new ModelMapper().map(product, ProductDto.class);
    }
}
