/**
 * A Test class for Money objects...
 *
 * @author Omer Basar
 * @version 1
 */

//Import libraries
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// Test the Money class.
public class MoneyTest
{
    private Money _amount;

    /**
     * Default constructor for test class MoneyTest
     */
    public MoneyTest()
    {
        System.out.println("JUnit Framework calls Constructor of test class before executing test methods");
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        _amount = new Money(0, 0);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
        _amount = null;
    }

    /**
     * Test methods
     */

    // Test creation of Money objects.
    @Test
    public void testCreate()
    {
        assertEquals("Error in testCreate", 0, _amount.getDollars());
        assertEquals("Error in testCreate", 0, _amount.getCents());

        Money amount2 = new Money (4, 50);

        assertEquals("Error in testCreate", 4, amount2.getDollars());
        assertEquals("Error in testCreate", 50, amount2.getCents());

        Money amount3 = new Money (-4, -50);

        assertEquals("Error in testCreate", -4, amount3.getDollars());
        assertEquals("Error in testCreate", -50, amount3.getCents());

    }

    // Test conversion of Money object to String.
    @Test
    public void testToString()
    {
        // First test: cents is two digits
        Money amount = new Money (7, 55);
        String actual = amount.toString();
        String expected = "$7.55";
        assertTrue("Error in testToString", actual.equals(expected));

        // Second test: cents is one digit
        Money amount2 = new Money (7, 5);
        String actual2 = amount2.toString();
        String expected2 = "$7.05";
        assertTrue("Error in testToString", actual2.equals(expected2));
    }

    // Test equality of money values that are the same.
    @Test
    public void testEquality()
    {
        Money myCash = new Money (3, 75);
        Money yourCash = new Money (3, 75);

        assertTrue ("Error in testEquality", myCash.equals(yourCash));

        Money myAmount = new Money (50, 0);
        Money yourAmount = new Money (50, 0);

        assertTrue ("Error in testEquality", myAmount.equals(yourAmount));
    }

    // Test inequality of money values that are different.
    @Test
    public void testInequality()
    {
        Money myCash = new Money (3, 75);
        Money difftDollarsSameCents = new Money (4, 75);
        Money difftDollarsDifftCents = new Money (4, 80);
        Money sameDollarsDifftCents = new Money (3, 80);

        assertFalse ("Error in testInequality", myCash.equals(difftDollarsSameCents));
        assertFalse ("Error in testInequality", myCash.equals(difftDollarsDifftCents));
        assertFalse ("Error in testInequality", myCash.equals(sameDollarsDifftCents));
    }

    // Test addition of money values such that the sum of the cents do not exceed 99.
    @Test
    public void testSimpleAdd()
    {
        Money amount2 = new Money (2, 30);
        Money amount3 = new Money (3, 50);

        Money actualAmount = amount2.add (amount3);
        // actualAmount now has the sum of amount2 + amount 3

        // Expected result is $5.80
        Money expectedAmount = new Money (5, 80);

        assertTrue ("Error in testSimpleAdd", actualAmount.equals(expectedAmount));
        //assertEquals("Error in testSimpleAdd", 5, actualAmount.getDollars());
        //assertEquals("Error in testSimpleAdd", 80, actualAmount.getCents());
    }

    // Test complex addition  of two money values, i.e. sum of cents is greater than or equal to 100.
    @Test
    public void testComplexAdd1()
    {
        // First test: sum of cents is 100.

        Money myCash = new Money (3, 50);
        Money yourCash = new Money (4, 50);

        // Expected result is $8.00
        Money expectedAmount = new Money (8, 0);

        Money actualAmount = myCash.add(yourCash);

        //System.out.println (actualAmount.toString()); // just for tracing purposes

        assertTrue ("Error in testComplexAdd", actualAmount.equals(expectedAmount));

        // Second test: sum of cents is greater than 100...

    }
    // Test complex addition  of two money values, i.e. sum of cents is greater than or equal to 100.
    @Test
    public void testComplexAdd2()
    {
        // Second test: sum of cents is 101.

        Money myCash = new Money (3, 50);
        Money yourCash = new Money (4, 51);

        // Expected result is $8.01
        Money expectedAmount = new Money (8, 1);

        Money actualAmount = myCash.add(yourCash);

        //System.out.println (actualAmount.toString()); // just for tracing purposes

        assertTrue ("Error in testComplexAdd", actualAmount.equals(expectedAmount));


    }
    // Test of simple subtraction between two values.
    @Test
    public void testSimpleSubtract()
    {

        Money myCash = new Money (5, 0);
        Money yourCash = new Money (4, 51);

        // Expected result is $0.49
        Money expectedAmount = new Money (0, 49);

        Money actualAmount = myCash.subtract(yourCash);

        //System.out.println (actualAmount.toString()); // just for tracing purposes

        assertTrue ("Error in testSubtract", actualAmount.equals(expectedAmount));


    }
    // Test of complex subtraction between two values.
    @Test
    public void testComplexSubtract()
    {

        Money myCash = new Money (6, 39);
        Money yourCash = new Money (3, 51);

        // Expected result is $0.49
        Money expectedAmount = new Money (2, 88);

        Money actualAmount = myCash.subtract(yourCash);

        //System.out.println (actualAmount.toString()); // just for tracing purposes

        assertTrue ("Error in testSubtract", actualAmount.equals(expectedAmount));

    }
    //Test of two values being equal.
    @Test
    public void testCompareTo1()
    {

        Money myCash = new Money (3, 50);
        Money yourCash = new Money (3, 50);

        // Expected result is 0
        int expected = 0;

        int actual = myCash.compareTo(yourCash);

        //System.out.println (actualAmount.toString()); // just for tracing purposes

        assertTrue ("Error in testCompareTo1", actual==expected);
    }
    //Test of two values, parameter being greater than.
    @Test
    public void testCompareTo2()
    {

        Money myCash = new Money (3, 51);
        Money yourCash = new Money (3, 50);

        // Expected result is 0
        int expected = 1;

        int actual = myCash.compareTo(yourCash);

        //System.out.println (actualAmount.toString()); // just for tracing purposes

        assertTrue ("Error in testCompareTo2", actual==expected);
    }
    //Test of two values, parameter being less than.
    @Test
    public void testCompareTo3()
    {

        Money myCash = new Money (3, 50);
        Money yourCash = new Money (3, 51);

        // Expected result is 0
        int expected = -1;

        int actual = myCash.compareTo(yourCash);

        //System.out.println (actualAmount.toString()); // just for tracing purposes

        assertTrue ("Error in testCompareTo3", actual==expected);
    }
}




