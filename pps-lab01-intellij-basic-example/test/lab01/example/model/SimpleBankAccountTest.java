package lab01.example.model;

import lab01.example.model.AccountHolder;
import lab01.example.model.BankAccount;
import lab01.example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest extends BankAccountTest<SimpleBankAccount> {


    @BeforeEach
    void beforeEach(){
        setAccountHolder(new AccountHolder("Mario", "Rossi", 1));
        setBankAccount(new SimpleBankAccount(getAccountHolder(), 0));
    }


}
