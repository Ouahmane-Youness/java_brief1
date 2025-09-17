class Account{
    private String accountNumber;
    private double sold;
    private String accountType;

    public Account(String accountNumber, double sold, String accountType)
    {
        this.accountNumber = accountNumber;
        this.sold = sold;
        this.accountType = accountType;
    }

    public void creditAccount(double total) throws Exception
    {
        if(total < 0)
        {
            throw new Exception("total has to be positive");
        }
        this.sold += total;
    }

    public void debitAccount(double total) throws Exception
    {
        if(total < 0)
        {
            throw new Exception("total has to be positive");
        }
        if(total > sold)
        {
            throw new Exception("sold is insufficient");
        }
        sold -= total;
    }
}
