package com.exemplo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class SavingsAccount extends Account{

    private Double annualRate = 0.001;

    public SavingsAccount(String owner, Double balance, Double annualRate) {
        super(owner, balance);

        if (annualRate > 0.0) this.annualRate = annualRate;
    }
}
