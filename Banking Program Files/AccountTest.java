/**
 * A Test class for Account objects...
 *
 * @author Omer Basar
 * @version 1
 */

//Import libraries
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountTest
{
    //Initialize private attributes
    private Money _amount;
    private Account _one;

    /**
     * Default constructor for test class AccountTest
     */
    public AccountTest()
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
        _amount = new Money(67, 43);
        _one = new Account("JB","420",_amount);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        _amount = null;
        _one = null;
    }

    /**
     * Test methods
     */

    // Test creation of Account objects.
    @Test
    public void testCreate()
    {
        assertEquals("Error in testCreate", "JB", _one.getName());
        assertEquals("Error in testCreate", "420", _one.getId());
        assertEquals("Error in testCreate", _amount, _one.getBalance());
    }

    //Test depositing of an amount of money into an account.
    @Test
    public void testDeposit()
    {
        Account actual = new Account("OB", "111", new Money(50,0));
        actual.deposit(new Money(25,0));

        Account expected = new Account("OB", "111", new Money(75,0));

        assertTrue("Error in testDeposit", actual.equals(expected));
    }

    //Test withdrawing of an amount of money from an account.
    @Test
    public void testWithdraw()
    {
        Account actual = new Account("OB", "111", new Money(75,0));
        actual.withdraw(new Money(25,0));

        Account expected = new Account("OB", "111", new Money(50,0));

        assertTrue("Error in testWithdraw", actual.equals(expected));
    }

    //Test of transferring an amount of money from one account to another.
    @Test
    public void testTransfer()
    {
        Account actual = new Account("OB", "111", new Money(75,0));
        actual.transfer(new Account("JP","222", new Money(100,0)),
                new Money(50,0));

        Account expected = new Account("OB", "111", new Money(25,0));

        assertTrue("Error in testTransfer", actual.equals(expected));
    }

    //Test conversion of Account object into a string.
    @Test
    public void testToString()
    {
        Account two = new Account("OB", "111", new Money(75,0));
        String actual = two.toString();
        String expected = "Name:OB  ID:111  Balance:$75.00";
        assertTrue("Error in testToString", actual.equals(expected));
    }

    //Test equality and inequality between Account objects.
    @Test
    public void testEquals()
    {
        //Duplicate accounts
        Account Robert1 = new Account("RD", "196", new Money(56,81));
        Account Robert2 = new Account("RD", "196", new Money(56,81));
        assertTrue("Error in testEquals", Robert1.equals(Robert2));

        //Same name and balance but different ID
        Account Jill1 = new Account("JV", "197", new Money(56,81));
        Account Jill2 = new Account("JV", "198", new Money(56,81));
        assertFalse("Error in testEquals", Jill1.equals(Jill2));
    }

}