/**
 * Driver program with a few additional helper methods
 * that have been moved to ATMhelperMethods.java
 *
 * @author Omer Basar
 * @version 1
 */

//Import libraries
import java.util.ArrayList;
import java.io.IOException;

// Driver class for Bank project
public class ATM
{
   public static void main (String[] args)
   {
       try
       {
           //Initialize array
           ArrayList <String > myArray = new ArrayList<String>();
           // Read data from a file into a Bank.
           // Each line of the file has info for one account.
           BankInterFace myBank = ATMhelperMethods.readFromFile("sample_accounts.txt");

           // Print all the data stored in the bank.
           System.out.println (myBank);

           // Create an object ioh to handle input and output.
           IOHandlerInterface ioh = new IOHandlerDialog();
           // or IOHandlerInterface ioh = new IOHandlerStandard();

           //Ask for user's ID
           boolean validCheck;
           do
               {
                   //Read user input.
                   String id = ATMhelperMethods.readUserID(ioh);

                   //If user attempts to hit cancel button, exits program
                   if (id.equals("þ"))
                   {
                       throw new UserCancelException("User hit cancel button");
                   }

                   //Check if user ID is valid
                   validCheck = ATMhelperMethods.isValid(myBank,id);

                   if (validCheck)
                       myArray.add(id);

                   //Echo user input.
                   ioh.put("The ID you entered " + id + ((validCheck)?
                           " was found in the bank" : " was not found in the bank"));

               }while (!validCheck);


           //Ask for user's transactions and validate.
           //Once they are done with transactions and hit cancel,
           //the program will stop asking for transactions and
           //continue to the next portion.
           boolean continueTransactions;
           do {

               //Asks for transaction and validates
               String transactionType = ATMhelperMethods.readUserTransaction(ioh);

               //If user attempts to cancel
               if (transactionType.equals("þ"))
               {
                   continueTransactions = false;
                   ioh.put("You chose to cancel making subsequent transactions. Exiting banking system.");
               }

               //When user wants to still make transactions
               else
               {
                   continueTransactions = true;
                   ioh.put("The chosen transaction was: " + transactionType);

                   //Checks the balance
                   if (transactionType.equals("check balance"))
                   {
                       ioh.put("" + myBank.search(myArray.get(0)).toString());
                   }

                   //Deposits money into account
                   else if(transactionType.equals("deposit"))
                   {
                       String userMoneyGive = ATMhelperMethods.readMoneyString(ioh);
                       if (userMoneyGive.equals("þ"))
                       {
                           ioh.put("You chose to cancel the deposit");
                       }
                       else
                           {
                           int userMoney = Integer.parseInt(userMoneyGive);
                           Money depositAmount = new Money(userMoney);
                           myBank.deposit(myArray.get(0), depositAmount);
                           ioh.put("Deposit operation was successful. New Balance: "
                                   + myBank.search(myArray.get(0)).getBalance());
                           }
                   }

                   //Withdraws money from account
                   else if(transactionType.equals("withdraw"))
                   {
                       String userMoneyTake = ATMhelperMethods.readMoneyString(ioh);
                       if (userMoneyTake.equals("þ"))
                       {
                           ioh.put("You chose to cancel the withdrawal");
                       }
                       else
                       {
                           //Convert user's money string to Money object
                           int userMoney = Integer.parseInt(userMoneyTake);
                           Money withdrawalAmount = new Money(userMoney);

                           //Initialize temp for comparison
                           Money tempAccountBalance = myBank.search(myArray.get(0)).getBalance();

                           //Execute withdrawal
                           myBank.withdraw(myArray.get(0), withdrawalAmount);

                           //Compares accounts before and after transaction for if withdrawal failed
                           //due to attempting to withdraw too much.
                           boolean checkWithdrawal = tempAccountBalance.equals(myBank.search(myArray.get(0)).getBalance());
                           ioh.put("Withdrawal operation was " + ((checkWithdrawal)?
                                   "not successful. Attempting to withdraw too much"
                                   : "successful. New Balance: " + myBank.search(myArray.get(0)).getBalance()));
                       }
                   }
               }
           } while (continueTransactions);
           
           //Writes updated bank information to output file only if the user has entered their ID
           // and then hit cancel when finished with making their transactions
           ATMhelperMethods.outputTextFile(myBank,"output_accounts.txt");

       } // end try

       catch (IOException ioe)
       {
           System.out.println("IOException in main: " + ioe.getMessage());
           ioe.printStackTrace();
       } // end catch

       catch (UserCancelException e)
       {
           System.out.println("UserCancelException in main: " + e.getMessage());
           e.printStackTrace();
       } // end catch

       catch (Exception e)
       {
           System.out.println("Exception in main: " + e.getMessage());
           e.printStackTrace();
       } // end catch

   } // end main


} // end ATM
