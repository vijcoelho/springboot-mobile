package com.example.preprova.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")
    private Integer supplierId;

    @OneToMany
    @JoinColumn(name = "product_category_id", referencedColumnName = "product_category_id")
    private Integer productCategoryId;

    private String name;
    private Float unitPrice;
    private Integer unitsInStock;
    private Boolean discounted;
}
