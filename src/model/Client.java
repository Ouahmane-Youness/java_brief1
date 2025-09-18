package model;

public class Client extends Person{
    private int id;
    private String lastName;
    private String firstName;
    private String password;
    private Account[] accounts;
    private int accountNumber = 0;


    public Client(int id, String last_name, String first_name, String password)
    {
        this.lastName = last_name;
        this.firstName = first_name;
        this.password = password;
        this.id = id;
        this.accounts = new Account[10];
    }

    public void addAccount(Account account)
    {
        if(accountNumber < accounts.length)
        {
            accounts[accountNumber] = account;
            accountNumber++;
        }
    }

    public String getLastName()
    {
        return lastName;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public int getID()
    {
        return id;
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

