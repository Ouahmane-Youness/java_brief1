package model;

import java.util.HashSet;

public class Account{
    private String accountNumber;
    private double sold;
    private String accountType;
    private HashSet<Transaction> transactionsHistory;

    public Account(String accountNumber, double sold, String accountType)
    {
        this.accountNumber = accountNumber;
        this.sold = sold;
        this.accountType = accountType;
    }

    public void creditAccount(double total)
    {
        this.sold += total;
    }

    public void debitAccount(double total)
    {
        sold -= total;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }
    public double getSold()
    {
        return sold;
    }
    public String getAccountType()
    {
        return accountType;
    }
    public void addTransaction(Transaction transaction) {
        transactionsHistory.add(transaction);
    }





}
