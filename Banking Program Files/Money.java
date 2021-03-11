/**
 * A blueprint for Money objects...
 *
 * @author Omer Basar
 * @version 1
 */

public class Money
{
    // attributes = state variables
    private long totalCents;

    /**
     * Constructor: initializes all attributes (i.e. totalCents)
     * based on the given dollars and cents.
     *
     * @param theDollars the number of dollars
     * @param theCents   the number of cents
     */
    public Money(int theDollars, int theCents)
    {
        this.totalCents = theDollars * 100L + theCents;
    }

    /**
     * Constructor: initializes all attributes (i.e. totalCents)
     * based on the given total cents.
     *
     * @param theCents  the total number of cents
     */
    public Money(long theCents)
    {
        this.totalCents = theCents;
    }

    /**
     * getDollars: getter for dollar amount
     *
     * @return the number of dollars
     */
    public int getDollars()
    {
        return (int) (this.totalCents / 100);
    }

    /**
     * getCents: getter for cents amount
     *
     * @return the number of cents (between 0 and 99, inclusive)
     */
    public int getCents()
    {
        return (int) (this.totalCents % 100);
    }

    /**
     * add: adds two money values
     *
     * Precondition: two Money amounts are created and valid
     * Postcondition: the amount in this Money object is added to the Money amount given as parameter; the result is returned.
     * Neither the calling object nor the parameter are changed.
     *
     * @param theMoney, the Money amount to add to the calling object (this)
     * @return Money, the sum
     */
    public Money add (Money theMoney)
    {
        return new Money (this.totalCents + theMoney.totalCents);
    }

    /**
     * add: adds two money values
     *
     * Precondition: two Money amounts are created and valid
     * Postcondition: the amount in this Money object is subtracted from the Money amount given as parameter; the result is returned.
     * Neither the calling object nor the parameter are changed.
     *
     * @param theMoney, the Money amount to subtract from the calling object (this)
     * @return Money, the sum
     */
    public Money subtract (Money theMoney)
    {
        return new Money (this.totalCents - theMoney.totalCents);
    }

    /**
     * toString: return String representation of this Money object
     * Precondition: this Money object is valid
     *
     * @return a String representation of this object
     */
    public String toString()
    {
        String result = "$" + this.getDollars() + ".";

        if (this.getCents() < 10) {
            result += "0";
        }

        result += this.getCents();
        return result;
    }

    /**
     * compareTo: compares two Money objects
     *
     * @param other a Money object
     * @return result an integer depending on if the first object is greater
     * than, less than, or equal to the second object.
     */
    public int compareTo(Money other)
    {
        int result;

        if (this.totalCents == other.totalCents)
            result = 0;
        else if (this.totalCents > other.totalCents)
            result = 1;
        else
            result = -1;
        return result;
    }
    /**
     * equals: compare the status of two money objects.
     *
     * @param other a Money object
     * @return true if calling object (this) is in the same state as the Money object received as a parameter, and false otherwise.
     */
    public boolean equals (Money other)
    {
        return (this.totalCents == other.totalCents);
    }
}


