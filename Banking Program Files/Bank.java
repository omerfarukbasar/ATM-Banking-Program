/**
 * A blueprint for Bank objects...
 *
 * @author Omer Basar
 * @version 4
 */

//Import libraries
import java.util.Arrays;

public class Bank implements BankInterFace
{

    private static int MAX_SIZE = 1000;

    //Attributes
    private String nameOfBank;
    private Account[] accounts;
    private int numOfAccounts;


    /**
     * Constructor: initializes the all of the attributes within the object.
     *
     * @param theBankName the name of the bank
     */
    public Bank(String theBankName)
    {
        this.nameOfBank = theBankName;
        this.accounts = new Account[0];
        this.numOfAccounts = 0;
    }

    /**
     * addAccount: Increases the size of the accounts array and adds an account
     * to the bank.
     *
     * @param theAccount a bank account containing its attributes
     *                   ie: name, balance, id;
     */
    public void addAccount (Account theAccount)
    {
        //Creates a new array that is one size bigger than the previous with all old data copied
        Account[] temp = new Account[accounts.length+1];

        for (int i = 0; i < numOfAccounts; i++)
            temp[i] = accounts[i];

        accounts = temp;

        //Adds the new account to the array
        accounts[numOfAccounts] = theAccount;
        numOfAccounts++;
    }

    /**
     * search: searches the accounts array and returns the one with the
     * matching ID string given in the parameter.
     *
     * @param theID the account identification string
     * @return quest: the account with the matching ID number
     */
    public Account search(String theID)
    {
        //Linear search method from legacy code
        //for (int i = 0; i < this.accounts.length; i++)
        //{
        //    Account quest = this.accounts[i];
        //    if (quest.getId().equals(theID))
        //    {
        //        return quest;
        //    }
        //}
        //return null;

        //Initialize variables
        int value = Integer.parseInt(theID);
        int first = 0;
        int last = accounts.length - 1;

        //Sort array
        sortAccounts();

        //Search using binarySearch
        int index = binarySearch(accounts, first, last, value);

        //Only return account when it's index is found
        if (index != -1)
            return accounts[index];

        return null;
    }

    public static int binarySearch(Account[] anArray, int first, int last, int value)
    {
        // Searches the array items anArray[first] through
        // anArray[last] for value by using a binary search.
        // Precondition: 0 <= first, last <= SIZE-1, where
        // SIZE is the maximum size of the array, and
        // anArray[first] <= anArray[first+1] <= ... <= anArray[last].
        // Postcondition: If value is in the array, the method
        // returns the index of the array item that equals value;
        // otherwise the method returns -1.

        int index;

        if (first > last)
        {
            index = -1;      // value not in original array
        }

        else
        {
            // Invariant: If value is in anArray,
            // anArray[first] <= value <= anArray[last]
            int mid = (first + last)/2;

            if (value == Integer.parseInt(anArray[mid].getId()))
            {
                index = mid;  // value found at anArray[mid]
            }

            else if (value < Integer.parseInt(anArray[mid].getId()))
            {
                index = binarySearch(anArray, first, mid-1, value);   // point X
            }

            else
            {
                index = binarySearch(anArray, mid+1, last, value);    // point Y
            }  // end if

        }  // end if

        return index;
    }  // end binarySearch

    /**
     * deposit: searches for the account and deposits money into it
     * Precondition: theID exists in this bank
     *
     * @param theID the account identification string
     * @param amount the amount of money specified
     */
    public void deposit(String theID, Money amount)
    {
        if (search(theID) != null)
           search(theID).deposit(amount);
    }

    /**
     * withdraw: searches for the account and deposits money into it
     * Precondition: theID exists in this bank
     *
     * @param theID the account identification string
     * @param amount the amount of money specified
     */
    public void withdraw(String theID, Money amount)
    {
        if (search(theID) != null)
            search(theID).withdraw(amount);
    }

    /**
     * sortAccounts: initializes a SortsClass object and uses it to call
     * the selctionSort method from SortsClass to sort the account objects
     * in the account array in ascending order
     *
     * Precondition: There is an array of account objects and the bank exists.
     * Postcondition: The array is sorted in ascending order.
     */
    public void sortAccounts()
    {
        SortsClass.selectionSort(accounts, numOfAccounts);
    }

    /**
     * toString: return String representation of this Account object
     * Precondition: this Bank object is valid
     *
     * @return a String representation of this object
     */
    public String toString()
    {
        String result = "Bank: " + nameOfBank + System.lineSeparator() +
                "Accounts in this system: " + numOfAccounts + System.lineSeparator() +
                "Accounts: " + Arrays.toString(accounts);
        return result;
    }

    /**
     * getAccountWithIndex:
     *
     * @param index - the index number of the desired account
     * @return the account that matches the given index
     */
    public Account getAccountWithIndex(int index)
    {
        return this.accounts[index];
    }

    /**
     * getNumOfAccounts:
     *
     * @return the number of accounts in the bank
     */
    public int getNumOfAccounts()
    {
        return this.numOfAccounts;
    }

}
