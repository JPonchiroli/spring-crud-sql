package com.crud.sql.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;
    @Column(name = "name", nullable = false, length = 100)
    private String category_name;

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
