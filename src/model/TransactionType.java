package model;

public enum TransactionType {
    DEPOSIT("deposit"),
    WITHDRAWL("withdrawl"),
    TRANSFER("transfer");

    private final String description;

    TransactionType(String description){
     this.description = description;
    }
    public String getDescription()
    {
        return description;
    }
}
