package model;

import java.util.Collection;
import java.util.HashMap;

public class Client extends Person{
    private String idClient;
    private HashMap<String, Account> accounts;


    public Client(String idClient, String lastName, String firstName, String email, String password)
    {
        super(lastName, firstName, email, password);
        this.idClient = idClient;
        this.accounts = new HashMap<>();
    }

    public void addAccount(Account account)
    {
        accounts.put(account.getAccountNumber(), account );
    }

    public Account getAccount(String accountNumber)
    {
        return accounts.get(accountNumber);
    }

    public boolean deleteAccount(String accountNumber)
    {
        return accounts.remove(accountNumber) != null;
    }

    public String getIdClient()
    {
        return idClient;
    }
    public void setIdClient(String idClient)
    {
        this.idClient = idClient;
    }
    public HashMap<String, Account> getComptes()
    {
        return accounts;
    }
    public Collection<Account> getAccountsCollection()
    {
        return accounts.values();
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== CLIENT MENU ===");
        System.out.println("1. Check your balance");
        System.out.println("2. Make a deposit");
        System.out.println("3. Make a withdrawal");
        System.out.println("4. Make a transfer");
        System.out.println("5. View bank statement");
        System.out.println("6. Logout");
        System.out.print("Your choice: ");
    }

}

