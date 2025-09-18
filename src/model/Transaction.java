package model;

import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;
    private TransactionType type;
    private double total;
    private LocalDateTime date;
    private String sourceAccount;
    private String destinationAccount;


    public Transaction(String transactionId, TransactionType type, double total,
                       String sourceAccount, String destinationAccount)
    {
        this.transactionId = transactionId;
        this.type = type;
        this.total = total;
        this.date = LocalDateTime.now();
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }

    public String getTransactionId()
    {
        return transactionId;
    }
    public TransactionType getTransactionType()
    {
        return type;
    }
    public double getTotal()
    {
        return total;
    }
    public String getSourceAccount()
    {
        return sourceAccount;
    }
    public String getDestinationAccount()
    {
        return  destinationAccount;
    }
    public LocalDateTime date()
    {
        return date;
    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }


}
