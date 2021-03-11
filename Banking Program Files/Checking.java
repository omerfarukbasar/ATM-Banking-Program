/**
 * A blueprint for checking objects which are also
 * a sub class of account objects
 *
 * @author Omer Basar
 * @version 2
 */

public class Checking extends Account {

    //Instantiate variable
    Money overdraftMaximum;
    /**
     * Constructor: initializes all attributes
     * based on the given name, ID, and balance.
     *
     * @param theName    the name of the account owner
     * @param theID      the account identification string
     * @param theBalance the amount of money in the account
     * @param theOverdraftMaximum the maximum amount of extra money that can be withdrawn
     *                            after the account balance reaches zero.
     */
    public Checking(String theName, String theID, Money theBalance, Money theOverdraftMaximum)
    {
        super(theName,theID,theBalance);
        this.overdraftMaximum = theOverdraftMaximum;

    }

    /**
     * @Overide: overides the withdraw method when from the account super
     * class if the object is a checking account.
     * withdraw: subtracts the given money from the balance
     *
     * @param amount a money object
     *
     */
    @Override
    public void withdraw(Money amount)
    {
        Money temp = this.overdraftMaximum.add(this.balance);
        int outcome = amount.compareTo(temp);
        if (outcome != 1)
            this.setBalance(this.balance.subtract(amount));
        else
            {
                //try
                //{
                throw new InsufficientFundsException("Attempting to withdraw too much: " + amount);
                //}
//                catch (InsufficientFundsException e)
//                {
//                    System.out.println("InsufficientFundsException was caught");
//                    e.printStackTrace();
//                }
//                catch (Exception e)
//                {
//                    System.out.println("Something else was caught");
//                    e.printStackTrace();
//                }
            }
    }

    /**
     * getOverdraftMaximum: getter for overdraft protection attribute
     *
     * @return the maximum amount of extra money that can be withdrawn
     *      *  after the account balance reaches zero.
     */
    public Money getOverdraftMaximum()
    { return this.overdraftMaximum; }

    /**
     * @Overide
     * toString: return String representation of a Checking object
     * Precondition: this Checking object is valid
     *
     * @return a String representation of this object
     */
    @Override
    public String toString()
    {
        String result = "Name:" + this.getName() + "  ID:" + this.getId()
                + "  Balance:" + this.getBalance() + "  Overdraft Maximum:" + getOverdraftMaximum();
        return result;
    }
}
