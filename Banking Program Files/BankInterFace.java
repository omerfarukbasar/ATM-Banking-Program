/**
 * An interface for Bank class objects...
 * A collection of accounts and operations based on using actions
 * such as withdrawing and depositing.
 *
 * Note: All methods are abstract in interfaces
 * Note: Interfaces specify ADT (abstract data types)
 *
 * @author Omer Basar
 * @version 2
 */

public interface BankInterFace
{
    /**
     * addAccount: Increases the size of the accounts array and adds an account
     * to the bank.
     *
     * @param theAccount a bank account containing its attributes
     *                   ie: name, balance, id;
     */
    public void addAccount (Account theAccount);

    /**
     * search: searches the accounts array and returns the one with the
     * matching ID string given in the parameter.
     *
     * @param theID the account identification string
     * @return quest the account with the matching ID number
     */
    public Account search(String theID);

    /**
     * deposit: searches for the account and deposits money into it
     * Precondition: theID exists in this bank
     *
     * @param theID the account identification string
     * @param amount the amount of money specified
     */
    public void deposit(String theID, Money amount);

    /**
     * withdraw: searches for the account and deposits money into it
     * Precondition: theID exists in this bank
     *
     * @param theID the account identification string
     * @param amount the amount of money specified
     */
    public void withdraw(String theID, Money amount);

    /**
     * toString: return String representation of this Account object
     * Precondition: this Bank object is valid
     *
     * @return a String representation of this object
     */
    public String toString();

    /**
     * sortAccounts: initializes a SortsClass object and uses it to call
     * the selctionSort method from SortsClass to sort the account objects
     * in the account array in ascending order
     *
     * Precondition: There is an array of account objects and the bank exists.
     * Postcondition: The array is sorted in ascending order.
     */
    public void sortAccounts();

    /**
     * getAccountWithIndex:
     *
     * @param index - the index number of the desired account
     * @return the account that matches the given index
     */
    public Account getAccountWithIndex(int index);

    /**
     * getNumOfAccounts:
     *
     * @return the number of accounts in the bank
     */
    public int getNumOfAccounts();


}
