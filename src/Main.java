// File: src/Main.java
// ===================
import service.BankService;
import model.*;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("    SOLUTIONS BANKING SYSTEM");
        System.out.println("========================================");

        Scanner scanner = new Scanner(System.in);

        boolean continueRunning = true;
        while (continueRunning) {

            displayMainMenu();

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        clientLogin(scanner);
                        break;

                    case 2:
                      //  managerLogin(scanner);
                        break;

                    case 3:
                        continueRunning = false;
                        System.out.println("Thank you for using FinBank Solutions!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please select 1, 2, or 3.");
                }

            } catch (Exception e) {
                System.out.println("Input error: " + e.getMessage());
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Clear invalid input from scanner buffer
            }
        }

        scanner.close();
        System.out.println("Application closed.");
    }


    private static void displayMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Client Login");
        System.out.println("2. Manager Login");
        System.out.println("3. Exit");
        System.out.print("Your choice: ");
    }

    private static void clientLogin(Scanner scanner) {
        System.out.println("\n=== CLIENT LOGIN ===");

        System.out.print("Client ID: ");
        String clientId = scanner.next();

        System.out.print("Password: ");
        String password = scanner.next();

        Client client = BankService.authenticateClient(clientId, password);

        if (client != null) {
            System.out.println("Login successful! Welcome " + client.getFirstName() + "!");
            BankService.manageClient(client, scanner);
        } else {
            System.out.println("Login failed. Please check your credentials.");
            System.out.println("(Try: ID=CLI001, Password=123456)");
        }
    }

}