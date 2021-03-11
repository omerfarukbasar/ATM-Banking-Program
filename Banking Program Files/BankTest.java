/**
 * A Test class for Bank objects...
 *
 * @author Omer Basar
 * @version 2
 */

//Import libraries
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BankTest
{
    //Initialize attributes
    private String nameOfBank;
    private Account[] accounts;
    private int numOfAccounts;
    private static int MAX_SIZE = 1000;
    private Money _amountOne, _amountTwo, _amountThree;
    private Account _one, _two, _three;
    private Bank _bank;
    /**
     * Default constructor for test class MoneyTest
     */
    public void bankTest()
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
        _amountOne = new Money(67, 43);
        _one = new Account("JB","420",_amountOne);
        _amountTwo = new Money(54, 21);
        _two = new Account("TY","777",_amountTwo);
        _amountThree = new Money(101, 99);
        _three = new Account("SH","221", _amountThree);
        _bank = new Bank("Bank of America");
        accounts = new Account[numOfAccounts];

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

    }

    //Test adding a new account to the bank system
    @Test
    public void addAccount()
    {
        String expected = "Bank: Bank of America" + System.lineSeparator() +
                "Accounts in this system: 3" + System.lineSeparator() +
                "Accounts: [Name:JB  ID:420  Balance:$67.43, Name:TY  ID:777  Balance:$54.21, Name:SH  ID:221  Balance:$101.99]";

        _bank.addAccount(_one);
        _bank.addAccount(_two);
        _bank.addAccount(_three);
        String actual = _bank.toString();

        assertTrue(expected.equals(actual));
    }

    //Test searching for a bank account based on given ID and returning that
    //specific account
    @Test
    public void search()
    {
        Account expected = _three;
        _bank.addAccount(_one);
        _bank.addAccount(_two);
        _bank.addAccount(_three);
        Account actual = _bank.search("221");
        assertTrue(expected.equals(actual));
    }

    //Test searches for account and deposits money into it
    @Test
    public void deposit()
    {
        Money expectAmount = new Money(104,23);
        Account expected = new Account("TY","777",expectAmount);
        Money donation = new Money(50,2);
        _bank.addAccount(_one);
        _bank.addAccount(_two);
        _bank.addAccount(_three);
        _bank.deposit("777", donation);
        Account actual = _bank.search("777");
        System.out.println(actual);
        assertTrue(expected.equals(actual));

    }

    //Test searches for account and withdraws money from it
    @Test
    public void withdraw()
    {
        Money expectAmount = new Money(32,73);
        Account expected = new Account("JB","420",expectAmount);
        Money bill = new Money(34,70);
        _bank.addAccount(_one);
        _bank.addAccount(_two);
        _bank.addAccount(_three);
        _bank.withdraw("420",bill);
        Account actual = _bank.search("420");
        assertTrue(expected.equals(actual));
    }

    //Test conversion of Bank object into a string.
    @Test
    public void testToString()
    {
        String expected = "Bank: Bank of America" + System.lineSeparator() +
                "Accounts in this system: 0" + System.lineSeparator() +
                "Accounts: []";
        String actual = _bank.toString();
        assertTrue(expected.equals(actual));
    }

    //Test the assorting of account array objects.
    @Test
    public void sortAccounts()
    {
        String expected = "Bank: Bank of America" + System.lineSeparator() +
                "Accounts in this system: 3" + System.lineSeparator() +
                "Accounts: [Name:SH  ID:221  Balance:$101.99, Name:JB  ID:420  Balance:$67.43, Name:TY  ID:777  Balance:$54.21]";

        _bank.addAccount(_two);
        _bank.addAccount(_three);
        _bank.addAccount(_one);
        _bank.sortAccounts();
        String actual = _bank.toString();


        assertTrue(expected.equals(actual));


    }
}