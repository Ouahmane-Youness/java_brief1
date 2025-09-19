package model;

import java.util.HashSet;

public class Account{
    private String accountNumber;
    private double sold;
    private AccountType accountType;
    private HashSet<Transaction> transactionsHistory;

    public Account(String accountNumber, double sold, AccountType accountType)
    {
        this.accountNumber = accountNumber;
        this.sold = sold;
        this.accountType = accountType;
        this.transactionsHistory = new HashSet<>();
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
    public AccountType getAccountType()
    {
        return accountType;
    }
    public void addTransaction(Transaction transaction) {
        transactionsHistory.add(transaction);
    }



    @Override
    public String toString() {
        return String.format("Account %s (%s) - Balance: %.2f DH",
                accountNumber,
                accountType.getDescription(),
                sold);
    }


}
