/**
 * A Test class for Checking objects...
 *
 * @author Omer Basar
 * @version 2
 */

//Import libraries
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CheckingTest
{
    //Initialize private attributes
    private Money _amount, _overdraftMax;
    private Checking _checkingOne;

    /**
     * Default constructor for test class CheckingTest
     */
    public CheckingTest()
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
        _amount = new Money(100, 0);
        _overdraftMax = new Money(50,0);
        _checkingOne = new Checking("LP","999",_amount,_overdraftMax);
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
        _overdraftMax = null;
        _checkingOne = null;
    }

    /**
     * Test methods
     */

    // Test creation of Checking objects.
    @Test
    public void testCreate()
    {
        assertEquals("Error in testCreate", "LP", _checkingOne.getName());
        assertEquals("Error in testCreate", "999", _checkingOne.getId());
        assertEquals("Error in testCreate", _amount, _checkingOne.getBalance());
        assertEquals("Error in testCreate", _overdraftMax, _checkingOne.getOverdraftMaximum());
    }

    //Test regular withdrawing of an amount of money from a checking account.
    @Test
    public void testWithdraw1()
    {
        Checking actualOne = _checkingOne;
        actualOne.withdraw(new Money(25,0));
        Checking expectedOne = new Checking("LP", "999", new Money(75,0),_overdraftMax);
        assertTrue("Error in testWithdraw", actualOne.equals(expectedOne));

    }

    //Test withdrawing with overdraft money.
    @Test
    public void testWithdraw2()
    {
        Checking actualTwo = _checkingOne;
        actualTwo.withdraw(new Money(150,0));
        Checking expectedTwo = new Checking("LP", "999", new Money(-50,0),_overdraftMax);
        assertTrue("Error in testWithdraw", actualTwo.equals(expectedTwo));
    }

    //Test withdrawing prevention from overdraft protection
    @Test (expected = InsufficientFundsException.class)
    public void testOverwithdraw()
    {
        //Initialize checking account and amount of money to withdraw
        Checking actualThree = _checkingOne;
        Money amount = new Money(164,0);

        //Withdraw the amount that causes the specific exception error to be thrown
        actualThree.withdraw(amount);

    }

    //Test conversion of checking object into a string.
    @Test
    public void testToString()
    {
        Checking two = _checkingOne;
        String actual = two.toString();
        String expected = "Name:LP  ID:999  Balance:$100.00  Overdraft Maximum:$50.00";
        assertTrue("Error in testToString", actual.equals(expected));
    }

}