package lab01.example.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleBankAccountWithAtmTest extends SimpleBankAccountTest{
    private final static double FEE = 1;

    @BeforeEach
    void beforeEach(){
        setAccountHolder(new AccountHolder("Mario", "Rossi", 1));
        setBankAccount(new SimpleBankAccountWithAtm(getAccountHolder(), 0));
    }

    @Test
    void testAtmDeposit() {
        ((SimpleBankAccountWithAtm)getBankAccount()).atmDeposit(getAccountHolder().getId(), 100);
        assertEquals(99, getBankAccount().getBalance());
    }

    @Test
    void testWrongAtmDeposit() {
        ((SimpleBankAccountWithAtm)getBankAccount()).atmDeposit(getAccountHolder().getId(), 100);
        ((SimpleBankAccountWithAtm) getBankAccount()).atmDeposit(2, 50);
        assertEquals(99, getBankAccount().getBalance());
    }

    @Test
    void testAtmWithdraw() {
        getBankAccount().deposit(getAccountHolder().getId(), 100);
        ((SimpleBankAccountWithAtm)getBankAccount()).atmWithdraw(getAccountHolder().getId(), 70);
        assertEquals(29, getBankAccount().getBalance());
    }

    @Test
    void testWrongAtmWithdraw() {
        getBankAccount().deposit(getAccountHolder().getId(), 100);
        ((SimpleBankAccountWithAtm)getBankAccount()).atmWithdraw(2, 70);
        assertEquals(100, getBankAccount().getBalance());
    }

}