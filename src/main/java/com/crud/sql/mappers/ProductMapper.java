package com.crud.sql.mappers;

import com.crud.sql.dto.ProductDto;
import com.crud.sql.entities.Product;
import org.modelmapper.ModelMapper;

public class ProductMapper {

    public ProductMapper(){}

    public static Product toProduct(ProductDto productDto){
        return new ModelMapper().map(productDto, Product.class);
    }

    public static ProductDto toProductDto(Product product){
        return new ModelMapper().map(product, ProductDto.class);
    }
}
