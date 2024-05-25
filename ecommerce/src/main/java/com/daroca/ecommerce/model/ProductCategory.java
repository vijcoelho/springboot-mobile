package com.daroca.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @Column(length = 50, nullable = false)
    private String name;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory(Integer productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                '}';
    }
}
