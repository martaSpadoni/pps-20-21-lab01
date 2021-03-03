package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount {

    private final static double FEE = 1.0;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    public void atmDeposit(final int usrID, final double amount) {
        deposit(usrID, amount-FEE);
    }

    public void atmWithdraw(final int usrID, final double amount) {
        withdraw(usrID, amount+FEE);
    }
}
