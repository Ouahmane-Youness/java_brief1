package model;

public enum AccountType {

    COURANT("COURANT"),
    EPARGNE("EPARGNE");
    private final String description;

    AccountType(String description)
    {
        this.description = description;
    }
    public String getDescription()
    {
        return description;
    }

}
