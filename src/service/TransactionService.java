package service;

import model.Account;
import model.Transaction;
import model.TransactionType;

public class TransactionService {
    private static int transactionCounter = 1000;


    public static boolean makeDeposit(Account account, double total){
        String idTransaction = "TN" + (++transactionCounter);

        Transaction transaction = new Transaction( idTransaction, TransactionType.DEPOSIT, total, null,
                account.getAccountNumber());

        account.creditAccount(total);
        account.addTransaction(transaction);
        return true;


    }

    public static boolean makeWithdrawl(Account account, double total)
    {
        String idTransaction = "TN" + (++transactionCounter);
        Transaction transaction = new Transaction(idTransaction, TransactionType.WITHDRAWL, total,
                account.getAccountNumber(), null);

        account.debitAccount(total);
        account.addTransaction(transaction);
        return true;
    }
    public static boolean processTransfer(Account sourceAccount, Account destinationAccount, double amount) {
            String transactionId = "TN" + (++transactionCounter);

            // Create single transaction record for both accounts
            Transaction transaction = new Transaction(
                    transactionId,
                    TransactionType.TRANSFER,
                    amount,
                    sourceAccount.getAccountNumber(),
                    destinationAccount.getAccountNumber()
            );

            sourceAccount.debitAccount(amount);

            destinationAccount.creditAccount(amount);

            sourceAccount.addTransaction(transaction);
            destinationAccount.addTransaction(transaction);

            return true;


    }

    public static boolean makeTransfer(Account sourceAccount, Account destinationAccount, double amount) {


            String idTransaction = "TN" + (++transactionCounter);

            // Create transaction record for both accounts
            Transaction transaction = new Transaction(
                    idTransaction,
                    TransactionType.TRANSFER,
                    amount,
                    sourceAccount.getAccountNumber(),
                    destinationAccount.getAccountNumber()
            );

            sourceAccount.debitAccount(amount);
            destinationAccount.creditAccount(amount);

            sourceAccount.addTransaction(transaction);
            destinationAccount.addTransaction(transaction);

            return true;

    }
}

