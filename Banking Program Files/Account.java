/**
 * A blueprint for Account objects...
 *
 * @author Omer Basar
 * @version 3
 *
 * Assistance: Debugging the new overidden compare to
 */

public class Account implements Comparable
{
    protected Money balance;
    //Attributes
    private String name;
    private String id;

    /**
     * Constructor: initializes all attributes
     * based on the given name, ID, and balance.
     *
     * @param theName the name of the account owner
     * @param theID   the account identification string
     * @param theBalance the amount of money in the account
     */
    public Account(String theName, String theID, Money theBalance)
    {
        this.name = theName;
        this.id = theID;
        this.balance = theBalance;
    }

    /**
     * getName: getter for name attribute
     *
     * @return the name of the account owner
     */
    public String getName()
    { return this.name; }

    /**
     * getID: getter for ID attribute
     *
     * @return the identification string of the account
     */
    public String getId()
    { return this.id; }

    /**
     * getBalance: getter for balance attribute
     *
     * @return the amount of money in the account
     */
    public Money getBalance()
    { return this.balance; }

    /**
     * deposit: adds the given money to the balance
     *
     * @param amount a money object
     */
    public void deposit(Money amount)
    {
        this.setBalance(this.balance.add(amount));
    }

    /**
     * setBalance: updates the balance to the new amount of money
     *
     * @param newAmount the new amount of money
     */
    public void setBalance(Money newAmount)
    {
        this.balance = newAmount;
    }

    /**
     * withdraw: subtracts the given money from the balance
     * only if the desired amount does not exceed the balance
     * since this is not a checking account
     *
     * @param amount a money object
     */
    public void withdraw(Money amount)
    {
        Money temp1 = this.balance.subtract(amount);
        Money temp2 = new Money(0);
        int lessThanZero = temp1.compareTo(temp2);
        if (lessThanZero != -1)
            this.setBalance(this.balance.subtract(amount));
    }

    /**
     * transfer: takes the given amount of money from this account
     * and deposits it to other
     *
     * @param other an Account object
     * @param amount a Money object
     */
    public void transfer(Account other, Money amount)
    {
        if (this.balance.compareTo(amount) == 0 || this.balance.compareTo(amount) == 1 )
        {
            withdraw(amount);
            other.deposit(amount);
        }
    }

    /**
     * toString: return String representation of this Account object
     * Precondition: this Account object is valid
     *
     * @return a String representation of this object
     */
    public String toString()
    {
        String result = "Name:" + this.getName() + "  ID:" + this.getId()
                + "  Balance:" + this.getBalance();
        return result;
    }

    /**
     * equals: compares the status of two money objects
     *
     * @param other an Account object
     * @return true if all attributes from both objects match, false otherwise
     */
    public boolean equals(Account other)
    {
        return (this.name.equals(other.name) &&
                this.id.equals(other.id) &&
                this.balance.equals(other.balance));
    }

    /**
     * compareTo: compare two Account objects.
     * @param o an object
     * Precondition: parameter o is an Object (of type Account)
     * Postcondition: return 0 if this.id is the same as o.id,
     * -1 if this.id < o.id, 1 if this.id > o.id.
     */
    @Override
    public int compareTo(Object o)
    {
        //Initialize attribute
        int result;

        if(o instanceof Account)
        {
            if (this.id.equals(((Account) o).id))
            {
                result = 0;
            }
            else if((this.id.compareTo(((Account) o).id) > 0))
            {
                result = 1;
            }
            else
                result = -1;
        }
        //When it's not an account
        else
            {
                result = 123456789;
            }

        return result;

    }
}
