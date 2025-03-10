package com.crud.sql.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;
    @Column(name = "product_name", nullable = false, length = 100)
    private String product_name;
    @Column(name = "product_price", nullable = false)
    private Double product_price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(){}

    public Product(Long product_id, String product_name, Double product_price, Category category) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.category = category;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(product_id, product.product_id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(product_id);
    }

    @Override
    public String toString() {
        return "Product [" +
                "product_id: " + product_id +
                ", product_name: " + product_name +
                ", product_price: " + product_price + "]";
    }
}
