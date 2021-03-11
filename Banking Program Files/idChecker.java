/**
 * Blueprint class for idChecker objects
 *
 * @author Omer Basar
 * @version 2
 */
public class idChecker
{
    /**
     * isID: checks if input string uses legal java identifiers.
     * Precondition: String w is provided
     * Postcondition: returns boolean value
     *
     * @param w a String
     * @return true if w is a legal Java identifier
     * Otherwise returns false.
     */
    public static boolean isId(String w)
    {
        if (w.length() == 1)
        { // base case
            return digitSearch(w);
        }
        else if (w.length() > 1 && digitSearch(lastChar(w)))
        {
            return isId (w.substring(0, w.length()-1));  // Point X
        }
        else
            {
            return false;
            } // end if
    }

    /**
     * lastChar: takes the provided string and extracts the final character
     *
     * @param w a String
     * @return a substring with only the last character from String W
     */
    public static String lastChar(String w)
    {
        return w.substring(w.length() - 1);
    }

    /**
     * digitSearch: Searches if the String is in the digit array
     *
     * @param w a String
     * @return true if w is a legal Java digit
     * Otherwise returns false
     */
    public static boolean digitSearch(String w)
    {
        //Initialize variables
        boolean value = false;
        String[] javaDigits = new String[]{"0","1","2","3","4","5","6","7","8","9"};

        //Search in array for match
        for (int i = 0; i < javaDigits.length; i++)
        {
            String quest = javaDigits[i];
            if (quest.equals(w))
            {
                value = true;
                break;
            }
        }
        return value;
    }


}
