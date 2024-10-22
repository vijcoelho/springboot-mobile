package com.cotuca.account.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Account {
    @Id
    private Integer number;

    @Column(nullable = false, length = 100)
    private String owner;

    @Column(nullable = false)
    private Double balance;
}
