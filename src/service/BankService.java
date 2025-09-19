package service;

import model.Account;
import model.AccountType;
import model.Administrator;
import model.Client;

import java.util.HashMap;
import java.util.Scanner;

public class BankService {
    private static HashMap<String, Client> clients = new HashMap<>();
    private static HashMap<String, Administrator> administrators = new HashMap<>();
    private static int accountCounter = 1000;

    public static Client authenticateClient(String clientId, String password) {
        Client client = clients.get(clientId);
        if (client != null && client.getPassword().equals(password)) {
            return client;
        }
        return null;
    }

    static {
        Client client1 = new Client("ouahmane100", "ouahmane", "youness", "youness@gmail.com", "123");
        clients.put(client1.getIdClient(), client1);

        Account account1 = new Account("ACC" + (++accountCounter), 1500.0, AccountType.COURANT);
        client1.addAccount(account1);
    }

    public static Administrator authenticateManager(String managerId, String password) {
        Administrator administrator = administrators.get(managerId);
        if (administrator != null && administrator.getPassword().equals(password)) {
            return administrator;
        }
        return null; // Authentication failed
    }


    public static boolean createAccount(String clientId, AccountType accountType, double initialBalance) {
        Client client = clients.get(clientId);
        if (client == null) {
            System.out.println("Client not found!");
            return false;
        }

        // Generate new account number
        String accountNumber = "ACC" + (++accountCounter);

        // Create and add account
        Account newAccount = new Account(accountNumber, initialBalance, accountType);
        client.addAccount(newAccount);

        System.out.println("Account created: " + newAccount);
        return true;
    }


    public static void manageClient(Client client, Scanner scanner)
    {
        boolean continueSession = true;

        while(continueSession)
        {
            client.displayMenu();
            int choice = scanner.nextInt();

            switch(choice)
            {
                case 1:
                    checkBalance(client, scanner);
                    break;
                case 2:
                    makeDeposit(client, scanner);
                    break;
                case 3:
                    makeWithdrawal(client, scanner);
                case 4:
                    //transferMoney(client, scanner);
                    break;
                case 5:
                    //viewStatement(client, scanner);
                    break;
                case 6:
                    continueSession = false;
                    System.out.println("Logout successful. Goodbye " + client.getFirstName() + "!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }


    private static void checkBalance(Client client, Scanner scanner)
    {
        System.out.println("Your accounts");
        int index = 1;
        for(Account account : client.getAccountsCollection())
        {
            System.out.println(index + "." + account);
            index++;
            {
            }
        }
        if(client.getAccountsCollection().isEmpty())
        {
            System.out.println("no accounts found");
        }
    }

    private static void makeDeposit(Client client, Scanner scanner)
    {
        Account account = selectAccount(client, scanner);
        if (account == null) return; // User cancelled or no accounts

        System.out.print("Amount to deposit: ");

            double amount = scanner.nextDouble();

            if (TransactionService.makeDeposit(account, amount)) {
                System.out.println("Deposit successful!");
                System.out.println("New balance: " + account.getSold() + " $");
            } else {
                System.out.println("Deposit failed.");
            }
    }

    private static void makeWithdrawal(Client client, Scanner scanner) {
        Account account = selectAccount(client, scanner);
        if (account == null) return;

        System.out.print("Amount to withdraw: ");
            double amount = scanner.nextDouble();

            if (TransactionService.makeWithdrawl(account, amount)) {
                System.out.println("Withdrawal successful!");
                System.out.println("New balance: " + account.getSold() + " $");
            } else {
                System.out.println("Withdrawal failed.");
            }
    }





    private static Account selectAccount(Client client, Scanner scanner) {
        Account[] accountsArray = client.getAccountsCollection().toArray(new Account[0]);

        if (accountsArray.length == 0) {
            System.out.println("No accounts available.");
            return null;
        }

        System.out.println("Select an account:");
        for (int i = 0; i < accountsArray.length; i++) {
            System.out.println((i + 1) + ". " + accountsArray[i]);
        }


            System.out.print("Your choice (0 to cancel): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                return null; // User cancelled
            }

            if (choice >= 1 && choice <= accountsArray.length) {
                return accountsArray[choice - 1]; // Convert to 0-based index
            } else {
                System.out.println("Invalid choice!");
                return null;
            }

    }
}
