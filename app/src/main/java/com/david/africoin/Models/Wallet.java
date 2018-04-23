package com.david.africoin.Models;

public class Wallet {
    private String currencyName;
    private double balance;
    private double available;

    public Wallet() {
        this.currencyName = "";
        this.balance = 0.0;
        this.available = 0.0;
    }

    public Wallet(String currencyName, double balance, double available) {
        this.currencyName = currencyName;
        this.balance = balance;
        this.available = available;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAvailable() {
        return available;
    }

    public void setAvailable(double available) {
        this.available = available;
    }
}
