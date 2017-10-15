
/**
 * Write a description of class ChangeSolution here.
 * 
 * @author (Teng Liu - 306750) 
 * @version (Assignment.3.CarOpenDoor.10092017)
 */
import java.util.Scanner;

public class CarDashboard
{
   public static void main(String[] args)
   {
        CarDashboard carControl = new CarDashboard();
        carControl.carDash();
   }

   public void carDash()
   {
        // display board -  0 off,  1 activatded
        boolean sw_left_door_on = false;
        boolean sw_right_door_on = false;
        boolean sw_child_lock_on = false;
        boolean sw_master_unlock_on = false;
        // handles
        boolean handle_left_in_open = false;
        boolean handle_left_out_open = false;
        boolean handle_right_in_open = false;
        boolean handle_right_out_open = false;

        char gear_status;        // P N D 1 2 3 R
        String command;
        boolean neitherOpen = true;

        System.out.println("-----------------------Instructions------------------------------");
        System.out.println("4 Swithes status: Left Right Child Master (0 for off, 1 for on)");
        System.out.println("4 Door-handles:   L-in L-out R-in R-out (0 for close, 1 for open)");
        System.out.println("1 Gear Shift set: P N D 1 2 3 R");
        System.out.println("-----------------------------------------------------------------");

        System.out.print("Please input a command code: ");
        Scanner input = new Scanner(System.in);
        command = input.nextLine();

        sw_left_door_on = (command.charAt(0)=='1')? true:false;
        sw_right_door_on = (command.charAt(1)=='1')? true:false;
        sw_child_lock_on = (command.charAt(2)=='1')? true:false;
        sw_master_unlock_on = (command.charAt(3)=='1')? true:false;

        handle_left_in_open = (command.charAt(4)=='1')? true:false;
        handle_left_out_open = (command.charAt(5)=='1')? true:false;
        handle_right_in_open = (command.charAt(6)=='1')? true:false;
        handle_right_out_open = (command.charAt(7)=='1')? true:false;
        gear_status = command.charAt(8);
       try{
        System.out.println();
        if ((gear_status == 'P' || gear_status == 'p') && sw_master_unlock_on)
        {
            System.out.println("***Information: Gear is P, and Master unlock is Activated.");
            if (sw_child_lock_on)
            {
                System.out.println("***Warnning: The Child Lock is on.");
                if (handle_left_in_open || handle_right_in_open)
                {
                    System.out.println("***Warnning: The Child Lock is on. You can not open the door from inside. Please try outside.");
                    neitherOpen = true;
                }
                if (handle_left_out_open || sw_left_door_on)
                {
                    System.out.println("Left Door opens. (opened from outside)");
                    neitherOpen = false;
                }
                if (handle_right_out_open || sw_right_door_on)
                {
                    System.out.println("Right Door opens. (opened from outside)");
                    neitherOpen = false;
                }
                
            }
            else if(!sw_child_lock_on)
            {
                System.out.println("***Information: The Child Lock is OFF.");
                if(handle_left_in_open || handle_left_out_open || sw_left_door_on)
                {
                    System.out.println("Left Door opens. (from inside or outside)");
                    neitherOpen = false;
                }
                if(handle_right_in_open || handle_right_out_open || sw_right_door_on)
                {
                    System.out.println("Right Door opens. (from inside or outside)");
                    neitherOpen = false;
                }
                
            }

        }
        else
        {
            System.out.println("***Warnning: The door can not open. \nPlease make sure Both the Gear = P and Master unlock is activated.");
            neitherOpen = true;
        }

        if (neitherOpen)
        {
            System.out.println("Neither door opens.");
        }
        
        // enable the program continuously performed
        System.out.println();
        System.out.print("Press 1 to continue, 0 to exit:  ");
        if(input.nextLine().equals("1"))
        {
            CarDashboard carControl = new CarDashboard();
            carControl.carDash();
        }
        else
        {
            System.out.println("You can close now...");
        }
      }
      catch(Exception e)
      {
          //exception
      }
   }

    // here is an example of output
    //-----------------------Instructions------------------------------
    //4 Swithes status: Left Right Child Master (0 for off, 1 for on)
    //4 Door-handles:   L-in L-out R-in R-out (0 for close, 1 for open)
    //1 Gear Shift set: P N D 1 2 3 R
    //-----------------------------------------------------------------
    //Please input a command code: 00010100P
    //
    //***Information: Gear is P, and Master unlock is Activated.
    //***Information: The Child Lock is OFF.
    //Left Door open. (from inside or outside)
    //
    //Press 1 to continue, 0 to exit:  
}
