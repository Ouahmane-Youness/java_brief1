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
    }

}
