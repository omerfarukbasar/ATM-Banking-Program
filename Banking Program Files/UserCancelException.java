/**
 * A new exception that is a subtype of Runtime Exception
 *
 * @author Omer Basar
 * @version 1
 */
public class UserCancelException extends RuntimeException
{
    public UserCancelException(String message)
    {
        super(message);
    } // end constructor
}
