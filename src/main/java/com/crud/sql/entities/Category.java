package com.crud.sql.entities;

import com.crud.sql.dto.CategoryDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;
    @Column(name = "category_name", nullable = false, length = 100)
    private String category_name;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products;

    public Category(){}

    public Category(Long category_id, String category_name, List<Product> products) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.products = products;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(category_id, category.category_id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(category_id);
    }

    @Override
    public String toString() {
        return "Category [ " +
                "category_id: " + category_id +
                ", category_name: " + category_name + " ]";
    }
}
