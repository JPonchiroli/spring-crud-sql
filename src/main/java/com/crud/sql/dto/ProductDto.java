package com.crud.sql.dto;

import com.crud.sql.entities.Product;

public class ProductDto {

    private String product_name;
    private Double product_price;
    private Long category_id;

    public ProductDto(){}

    public ProductDto(String product_name, Double product_price, Long category_id) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.category_id = category_id;
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

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

}
