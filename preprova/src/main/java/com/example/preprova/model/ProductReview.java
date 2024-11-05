package com.example.preprova.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_review")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productReviewId;
    private Integer productId;
    private String reviewerName;
    private LocalDateTime reviewDate;
    private Integer rating;
    private String comments;
}
