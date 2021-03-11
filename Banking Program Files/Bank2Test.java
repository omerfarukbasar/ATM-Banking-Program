/**
 * A Test class for Bank2 objects...
 *
 * @author Omer Basar
 * @version 1
 */

//Import libraries
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class Bank2Test
{
    //Initialize attributes
    private ArrayList<Account> accounts;
    private String nameOfBank;
    private int numOfAccounts;
    private Money _amountOne, _amountTwo, _amountThree;
    private Account _one, _two, _three;
    private Bank2 _bank;

    /**
     * Default constructor for test class MoneyTest
     */
    public void bank2Test()
    {
        System.out.println("JUnit Framework calls Constructor of test class before executing test methods");
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        _amountOne = new Money(87, 24);
        _one = new Account("AS","567",_amountOne);
        _amountTwo = new Money(243, 78);
        _two = new Account("NP","908",_amountTwo);
        _amountThree = new Money(1019, 3);
        _three = new Account("HO","121", _amountThree);
        _bank = new Bank2("Chase Bank");
        accounts = new ArrayList<Account>();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        _amountOne = null;
        _one = null;
        _amountTwo = null;
        _two = null;
        _amountThree = null;
        _three = null;
        _bank = null;
        accounts = null;
    }

    //Test adding a new account to the bank system
    @Test
    public void addAccount()
    {
        String expected = "Bank: Chase Bank" + System.lineSeparator() +
                "Accounts in this system: 3" + System.lineSeparator() +
                "Accounts: [Name:AS  ID:567  Balance:$87.24, Name:NP  ID:908  Balance:$243.78, Name:HO  ID:121  Balance:$1019.03]";

        _bank.addAccount(_one);
        _bank.addAccount(_two);
        _bank.addAccount(_three);
        System.out.println(_bank);
        String actual = _bank.toString();

        assertTrue(expected.equals(actual));
    }

    //Test searching for a bank account based on given ID in the array list
    // and returning that specific account
    @Test
    public void search()
    {
        Account expected = _three;
        _bank.addAccount(_one);
        _bank.addAccount(_two);
        _bank.addAccount(_three);
        Account actual = _bank.search("121");
        assertTrue(expected.equals(actual));
    }

    //Test searches for account in the array list and deposits money into it
    @Test
    public void deposit()
    {
        Money expectAmount = new Money(259,77);
        Account expected = new Account("NP","908",expectAmount);
        Money donation = new Money(15,99);
        _bank.addAccount(_one);
        _bank.addAccount(_two);
        _bank.addAccount(_three);
        _bank.deposit("908", donation);
        Account actual = _bank.search("908");
        assertTrue(expected.equals(actual));
    }

    //Test searches for account in the array list and withdraws money from it
    @Test
    public void withdraw()
    {
        Money expectAmount = new Money(37,74);
        Account expected = new Account("AS","567",expectAmount);
        Money bill = new Money(49,50);
        _bank.addAccount(_one);
        _bank.addAccount(_two);
        _bank.addAccount(_three);
        _bank.withdraw("567", bill);
        Account actual = _bank.search("567");
        assertTrue(expected.equals(actual));
    }

    //Test conversion of Bank2 object into a string.
    @Test
    public void testToString()
    {
        String expected = "Bank: Chase Bank" + System.lineSeparator() +
                "Accounts in this system: 0" + System.lineSeparator() +
                "Accounts: []";
        String actual = _bank.toString();
        assertTrue(expected.equals(actual));
    }

    //Test the assorting of account objects in the array list.
    @Test
    public void sortAccounts()
    {
        String expected = "Bank: Chase Bank" + System.lineSeparator() +
                "Accounts in this system: 3" + System.lineSeparator() +
                "Accounts: [Name:HO  ID:121  Balance:$1019.03, Name:AS  ID:567  Balance:$87.24, Name:NP  ID:908  Balance:$243.78]";

        _bank.addAccount(_two);
        _bank.addAccount(_three);
        _bank.addAccount(_one);
        _bank.sortAccounts();
        String actual = _bank.toString();


        assertTrue(expected.equals(actual));
    }
}