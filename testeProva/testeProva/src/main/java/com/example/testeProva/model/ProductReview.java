package com.example.testeProva.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productReviewId;

    @OneToMany
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private Integer product;

    private String reviewerName;
    private LocalDateTime reviewDate;
    private Integer rating;
    private String comments;
}
