/**
 * A test class for idChecker objects
 *
 * @author Omer Basar
 * @version 2
 */

//Import libraries
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class idCheckerTest
{
    //Initialize attribute
    private String stringOne,stringTwo,stringThree;

    /**
     * Default constructor for test class idCheckerTest
     */
    public idCheckerTest()
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
        stringOne = "345678";
        stringTwo = "5Code";
        stringThree = "vG():jk7";
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        stringOne = null;
        stringTwo = null;
        stringThree = null;
    }

    //Test checking if string is legal java identifier
    @Test
    public void isId()
    {
        //Test 1
        boolean expected = true;
        boolean actual = idChecker.isId(stringOne);

        assertTrue ("Error in test 1 of isID", actual == expected);

        //Test 2
        boolean expected2 = false;
        boolean actual2 = idChecker.isId(stringTwo);

        assertTrue ("Error in test 2 of isID", actual2 == expected2);

        //Test 3
        boolean expected3 = false;
        boolean actual3 = idChecker.isId(stringThree);

        assertTrue ("Error in test 3 of isID", actual3 == expected3);
    }

    //Test extraction of last character in a string
    @Test
    public void lastChar()
    {
        String expected = "8";
        String actual = idChecker.lastChar(stringOne);

        assertTrue("Error in test lastChar",expected.equals(actual));
    }


    //Test searching of string in digit array
    @Test
    public void digitSearch()
    {
        //Test 1
        boolean expected1 = true;
        boolean actual1 = idChecker.digitSearch("5");
        assertTrue("Error in test 1 of digitSearch", expected1 == actual1);

        //Test 2
        boolean expected2 = false;
        boolean actual2 = idChecker.digitSearch("h");
        assertTrue("Error in test 2 of digitSearch", expected2 == actual2);
    }

}