package com.exemplo.model;

public class CheckingAccount extends Account{

    private Double overdraft = -500.00;

    public CheckingAccount(String owner) {
        super(owner);
    }

    public CheckingAccount(String owner, Double balance) {
        super(owner, balance);
    }
}
