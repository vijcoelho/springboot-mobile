package com.exemplo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class Transaction {

    private Double amount;
    private LocalDateTime date;
    private String notes;

    public Transaction(Double amount, LocalDateTime date, String notes) {
        this.amount = amount;
        this.date = date;
        this.notes = notes;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getNotes() {
        return notes;
    }
}
