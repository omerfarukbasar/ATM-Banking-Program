/**
 * A blueprint for ATMhelperMethods objects...
 * Was moved from the driver class to here
 * due to taking up large amounts of lines.
 *
 * @author Omer Basar
 * @version 1
 */

//Import libraries
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ATMhelperMethods
{
    /**
     * readFromFile: reads input from a text file and adds the accounts to
     * the bank system.
     * Precondition: A text file with accounts exists and is provided in the same folder/directory
     * Postcondition: the bank is returned with the accounts integrated into it.
     *
     * @param fileName the text file's name
     * @return myBank the bank object with accounts in them
     */
    public static BankInterFace readFromFile (String fileName) throws IOException
    {
        // Create a a bank.
        BankInterFace myBank = new Bank2("Bank of America");

        // Open a file for reading.
        Scanner inputSource = new Scanner (new File("sample_accounts.txt"));

        // while there are more tokens to read from the input source...
        while (inputSource.hasNext())
        {
            // Read one line of input from the file into an Account object
            Account acct = InputManager.readOneAccountFrom (inputSource);

            // Store the account info in the bank.
            myBank.addAccount(acct);

        } // end while

        return myBank;

    } // end readFromFile

    /**
     * outputTextFile: reads accounts from the bank and writes them to an output file.
     * Precondition: A text file exists and is provided in the same folder/directory
     * Postcondition: All of the accounts are displayed in ascending order with
     * their updated information.
     *
     * @param outputFileName the output text file's name
     */
    public static void outputTextFile(BankInterFace myBank, String outputFileName)
    {
        // ---------------------------------------------------------
        // Makes a duplicate copy of a text file.
        // Precondition: originalFileName is the name of an existing
        // external text file, and copyFileName is the name of the
        // text file to be created.
        // Postcondition: The text file named copyFileName is a
        // duplicate of the file named originalFileName.
        // ---------------------------------------------------------
        PrintWriter ofStream = null; // declare an output file stream
        try {

            // Initialize the output file stream, based on the name of the output file, stored in copyFileName
            ofStream = new PrintWriter(new FileWriter("output_accounts.txt"));

            String line;


            for (int i = 0; i < myBank.getNumOfAccounts(); i++ )
            {
                ofStream.println(myBank.getAccountWithIndex(i));  // Write a line to the output file.
            }

            ofStream.close(); // close the files

        } // end try
        catch (IOException e) {
            System.out.println("Error copying bank to file");
        } // end catch
        finally {
            if (ofStream != null) {
                ofStream.close();
            } // end if

        } // end finally
    } // end copyTextFile

    /**
     * readUserID: asks the user for an ID string of numbers and validates
     * Postcondition: String is used to check if it's in the banking system
     *
     * @param: IOHandlerInterface ioh
     * @return String id read from user.
     * or returns "þ" if the user hits the cancel button
     */
    public static String readUserID(IOHandlerInterface ioh)
    {
        String result = null;
        boolean digits = false;
        while (!digits)
        {
            result = ioh.get("Please enter your ID number:");

            if (result.equals("þ"))
            {
                digits = true;
                return "þ";
            }
            else
            {
                digits = idChecker.isId(result);
                if (!digits)
                {
                    ioh.put("Invalid ID format. Please enter digits only.");
                }
            }
        }
        return result;
    }

    /**
     * readMoneyString: asks the user for the amount of money they wish to
     * deposit or withdraw to/from their account.
     * Precondition: the user's account was found in the banking system and
     * chose to deposit or withdraw.
     * Postcondition: returns the amount of money in String form
     *
     * @param: IOHandlerInterface ioh
     * @return String result which is the money amount read from user.
     * or returns "þ" if the user hits the cancel button
     */
    public static String readMoneyString(IOHandlerInterface ioh)
    {
        String result = null;
        boolean digits = false;
        while (!digits)
        {
            result = ioh.get("How much money are you depositing/withdrawing?"
            + " Enter the numbers in the format: Total Cents");

            if (result.equals("þ"))
            {
                digits = true;
                return "þ";
            }
            else
            {
                digits = idChecker.isId(result);
                if (!digits)
                {
                    ioh.put("Invalid money format. Please enter digits only with no spaces.");
                }
            }
        }
        return result;
    }

    /**
     * readUserTransaction: asks the user for a transaction type and validates
     * Precondition: the user previously entered their ID
     * Postcondition: returns the user's desired transaction type
     *
     * @param: IOHandlerInterface ioh
     * @return String transactionType read from user.
     * or returns "þ" if the user hits the cancel button
     */
    public static String readUserTransaction(IOHandlerInterface ioh)
    {
        //Initialize array
        ArrayList<String > myArrayResult = new ArrayList<String>();

        String result;
        boolean validChoice = false;
        while (!validChoice)
        {
            result = ioh.get("Welcome, please enter your transaction: Check Balance/Deposit/Withdraw");
            if (result.equals("þ") )
            {
                validChoice = true;
                myArrayResult.add(result);
            }

            result = result.toLowerCase();

            if (result.equals("check balance") || result.equals("deposit") || result.equals("withdraw") || result.equals("þ"))
            {
                validChoice = true;
                myArrayResult.add(result);
            }

            else
                ioh.put("Invalid transaction type. Please enter one of the choices provided.");
        }

        return myArrayResult.get(0);
    }

    /**
     * isValid: checks if the input ID is in the bank system and returns a boolean
     * Precondition: A bank exists and an ID string is provided
     * Postcondition: returns the boolean depending on if the ID was in the bank system
     *
     * @param theBank: a Bank object
     * @param id the account identification string
     * @return boolean true or false
     */
    public static boolean isValid(BankInterFace theBank, String id)
    {
        //Initialize variables
        boolean result;
        Account validSearch;

        //Search for matching ID in system
        validSearch = theBank.search(id);
        if (validSearch == null)
            result = false;
        else
            result = true;

        return result;
    }
}
