package com.crud.sql.dto;

import com.crud.sql.entities.Product;

public class ProductDto {

    private String product_name;
    private Double product_price;

    public ProductDto(){}

    public ProductDto(String product_name, Double product_price) {
        this.product_name = product_name;
        this.product_price = product_price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Double product_price) {
        this.product_price = product_price;
    }
}
