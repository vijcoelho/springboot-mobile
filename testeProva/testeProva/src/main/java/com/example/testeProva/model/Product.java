package com.example.testeProva.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @ManyToOne
    @JoinColumn(name = "supplierId", referencedColumnName = "supplierId")
    private Integer supplier;

    @OneToMany
    @JoinColumn(name = "productCategoryId", referencedColumnName = "productCategoryId")
    private Integer productCategory;

    private String name;
    private Double unitPrice;
    private Integer unitsInStock;
    private Boolean discounted;
}
