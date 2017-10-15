
/**
 * Write a description of class ChangeSolution here.
 * 
 * @author (Teng Liu - 306750) 
 * @version (Assignment.3.BankATM.10092017)
 */
import java.util.Scanner;

public class BankATM
{
    public static void main(String[] args)
    {
        BankATM atm = new BankATM();
        atm.forATM();
    }

    public void forATM()
    {
        double balance_cke;
        double balance_save;
        int operation;           // 1 deposit, 2 withdrawal, 3 transfer
        int operation_account;   // 1 checking, 2 saving
        double operation_amount;

        Scanner input = new Scanner(System.in);
        System.out.println("------------Personal Bank Account-----------");
        System.out.print("The Balance of Checking Account is: ");
        balance_cke = input.nextDouble();
        System.out.print("The Balance of Saving Account is: ");
        balance_save = input.nextDouble();
        if(balance_cke < 0 || balance_save <0 )
        {
            System.out.println("Warning: The Balance has to be Non-negative. Please press Enter to retry.");
            if (input.nextLine() != null)
            {
                BankATM atm = new BankATM();
                atm.forATM();
                //break;
            }
        }
        
        System.out.print("Please select an operation (1 Deposit, 2 Withdrawal, 3 Transfer): ");
        operation = input.nextInt();
        System.out.print("Which account will it use? (1 Checking, 2 Saving): ");
        operation_account = input.nextInt();
        System.out.print("How much money will it be? ");
        operation_amount = input.nextDouble();
        if(operation_amount < 0)
        {
            System.out.println("Warning: The Amount has to be Non-negative. Please press Enter to retry.");
            if (input.nextLine() != null)
            {
                BankATM atm = new BankATM();
                atm.forATM();
                //break;
            }
        }

        
        switch (operation)
        {
            case 1:   // deposit
            {
                if(operation_account == 1)
                {
                    balance_cke += operation_amount;
                }
                else if (operation_account == 2)
                {
                    balance_save += operation_amount;
                }
                System.out.printf("--> Your current balance remaining: %.3f in Checking,  %.3f in Saving.", balance_cke,balance_save);
                break;
            }
            
            case 2: case 3:   // withdrawal  // transfer
            {
               if(operation_account == 1 && operation_amount <= balance_cke)
                {
                    balance_cke -= operation_amount;
                }
                else if (operation_account == 2 && operation_amount <= balance_save)
                {
                    balance_save -= operation_amount;
                }
                else
                {   
                    System.out.println("Warning: There is not enough balance for you !");
                }
                System.out.printf("--> Your current balance remaining: %.3f in Checking,  %.3f in Saving.", balance_cke,balance_save);
                break;
            }
            default:
                System.out.println("Warning: Invalid input!");
        }
        
        //allow the program continuously
        System.out.println();
        System.out.println();
        System.out.print("Press 1 to continue, 0 to exit:  ");
        Scanner in = new Scanner(System.in);
        if(in.nextLine().equals("1"))
        {
            BankATM atm = new BankATM();
            atm.forATM();
        }
        else
        {
            System.out.println("You can close now...");
        }
    }

    // here is example:
    // ------------Personal Bank Account-----------
    // The Balance of Checking Account is: 3000.98
    // The Balance of Saving Account is: 5000
    // Please select an operation (1 Deposit, 2 Withdrawal, 3 Transfer): 1
    // Which account will it use? (1 Checking, 2 Saving): 2
    // How much money will it be? 2000.66
    // --> Your current balance remaining: 3000.980 in Checking,  7000.660 in Saving.
    // 
    // Press 1 to continue, 0 to exit:  1
    // ------------Personal Bank Account-----------
    // The Balance of Checking Account is: -3000
    // The Balance of Saving Account is: 2000
    // Warning: The Balance has to be Non-negative. Please press Enter to retry.

}
