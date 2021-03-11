/**
 * A blueprint for Bank2 objects...
 *
 * @author Omer Basar
 * @version 3
 */

//Import libraries
import java.util.*;
import java.util.ArrayList;

public class Bank2 implements BankInterFace
{
    //Attributes
    private ArrayList<Account>accounts;
    private String nameOfBank;

    /**
     * Constructor: initializes the all of the attributes within the object.
     *
     * @param theBankName the name of the bank
     */
    public Bank2(String theBankName)
    {
        this.accounts = new ArrayList<Account>();
        this.nameOfBank = theBankName;
    }

    /**
     * addAccount: Automatically increases arraylist size in background and
     * adds the new account to the new index created and increments the number of accounts
     *
     * @param theAccount a bank account containing its attributes
     *                   ie: name, balance, id;
     */
    public void addAccount (Account theAccount)
    {
        this.accounts.add(theAccount);
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
        //for (int i = 0; i < accounts.size(); i++)
        //{
        //    Account quest = this.accounts.get(i);
        //    if (quest.getId().equals(theID))
        //    {
        //        return quest;
        //    }
        //}
        //return null;

        //Initialize variables
        int value = Integer.parseInt(theID);
        int first = 0;
        int last = this.accounts.size() - 1;

        //Sort array
        sortAccounts();

        //Search using binarySearch
        int index = binarySearch(this.accounts, first, last, value);

        //Only return account when it's index is found
        if (index != -1)
            return this.accounts.get(index);

        return null;
    }

    public static int binarySearch(ArrayList<Account> anArray, int first, int last, int value)
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

            if (value == Integer.parseInt(anArray.get(mid).getId()))
            {
                index = mid;  // value found at anArray[mid]
            }

            else if (value < Integer.parseInt(anArray.get(mid).getId()))
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
     * sortAccounts: uses a predefined method from java collection library
     * to sort the accounts in the array list
     *
     * Precondition: There is an array list of account objects and the bank exists.
     * Postcondition: The array list is sorted in ascending order.
     */
    public void sortAccounts()
    {
        Collections.sort(accounts);
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
                "Accounts in this system: " + accounts.size() + System.lineSeparator() +
                "Accounts: " + accounts.toString();
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
        return this.accounts.get(index);
    }

    /**
     * getNumOfAccounts:
     *
     * @return the number of accounts in the bank
     */
    public int getNumOfAccounts()
    {
        return this.accounts.size();
    }


}
