package com.exemplo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@Entity
@Table
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Account {

    private String number;
    private String owner;
    private Double balance;

    private List<Transaction> transactions;

    public Account() {

    }

    public Account(String owner) {
        this(owner,(0.0));
    }

    public Account(String owner, Double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void makeDeposit(Double amount, LocalDateTime date, String notes) {
        if (amount <= 0) throw new IllegalArgumentException();
        this.transactions.add(new Transaction(amount, date, notes));
        this.balance += amount;
    }

    public void makeWithdrawl(Double amount, LocalDateTime date, String notes) {
        if (amount <= 0) throw new IllegalArgumentException();
        if (amount > this.balance) throw new IllegalStateException();
        this.transactions.add(new Transaction(amount, date, notes));
        this.balance -= amount;
    }

    public String getAccountHistory() {
        StringBuilder report = new StringBuilder();
        report.append("Date\tAmount\tBalance\tNotes");
        Double balance = 0.0;

        for (Transaction transaction: this.transactions) {
            balance += transaction.getAmount();
            report.append(transaction.getDate() +  " " +
                          transaction.getAmount() + " " + 0.0 +
                          transaction.getNotes());
        }
        return report.toString();
    }
}
