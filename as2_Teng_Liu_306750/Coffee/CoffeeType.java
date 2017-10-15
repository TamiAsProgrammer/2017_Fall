/**
 * Write a description of class ChangeSolution here.
 * 
 * @author (Teng Liu - 306750) 
 * @version (Assignment.2.CoffeeType.10022017)
 */

import java.util.Scanner;

 public class CoffeeType
{
    public static void main(String[] args)
    {
        CoffeeType coffee = new CoffeeType();
        coffee.getCoffeeType();
    }

    public void getCoffeeType()
    {
        // define all the ingredients as boolean, and default value is false
        boolean steamedMilk = false;
        boolean milkFoam  = false;
        boolean chocolate = false;
        boolean steamedHHF = false ;
        boolean whippedCream = false;
        boolean water = false ;

        Scanner input = new Scanner(System.in);

        System.out.print("Does the drink have  Steamed Milk  (yes/no)?  ");
        steamedMilk= (input.nextLine()).equals("yes")?true:false;

        if (steamedMilk)           //steamedMilk is true
        {
            System.out.print("Does the drink have  Milk Foam  (yes/no)?  ");
            milkFoam= (input.nextLine()).equals("yes")?true:false;
            if (milkFoam)          //milkFoam is true
            {
               System.out.println("The type of drink is:  CAFFE LATTE or CAPPUCCINO");
            }
            else 
            {
                System.out.print("Does the drink have  Chocolate  (yes/no)?  ");
                chocolate= (input.nextLine()).equals("yes")?true:false;
                if(chocolate)     //chocolate is true
                {
                   System.out.println("The type of drink is:  MOCHA");
                }
                else
                {
                  System.out.println("The type of drink is:  FLAT WHITE");
                }
            }
        }
        else                      //steamedMilk is false
        {
            System.out.print("Does the drink have  Milk Foam  (yes/no)?  ");
            milkFoam= (input.nextLine()).equals("yes")?true:false;
            if (milkFoam)         //milkFoam is true
            {
                System.out.print("Does the drink have  Steamed Half-and-Half  (yes/no)?  ");
                steamedHHF = (input.nextLine()).equals("yes")?true:false;
                if (steamedHHF)    //steamedHHF is true
                {
                    System.out.println("The type of drink is:  BREVE");
                }
                else
                {
                   System.out.println("The type of drink is:  MACCHIATO");           
                }
            }
        
            else 
            {
                System.out.print("Does the drink have  whipped Cream  (yes/no)?  ");
                whippedCream  = (input.nextLine()).equals("yes")?true:false;
                if(whippedCream)       //whippedCream is true
                {
                     System.out.println("The type of drink is:  CON PANNA");
                }
                else 
                {
                    System.out.print("Does the drink have  Water  (yes/no)?  ");
                    water = (input.nextLine()).equals("yes")?true:false;
                    if(water)         //water is true
                    {
                        System.out.println("The type of drink is:  AMERICANO");  
                    }
                    else
                    {
                        System.out.println("The type of drink is:  ESPRESSO");
                    }
                } 
                
            }
        }

        System.out.println();
        System.out.print("Press 1 to continue...");
        System.out.print("Press 0 to exit...  ");
        if (input.nextLine().equals("1"))                   // calling the same method to continue
        {
            CoffeeType coffee = new CoffeeType();
            coffee.getCoffeeType();
        }
        else
        {
            System.out.println("You can close now...");
        }
         //---------here are reslut examples---------------------
         //Does the drink have  Steamed Milk  (yes/no)?  yes
         //Does the drink have  Milk Foam  (yes/no)?  no
         //Does the drink have  Chocolate  (yes/no)?  yes
         //The type of drink is:  MOCHA
         //
         //Press 1 to continue...Press 0 to exit...  1
         //Does the drink have  Steamed Milk  (yes/no)?  no
         //Does the drink have  Milk Foam  (yes/no)?  no
         //Does the drink have  whipped Cream  (yes/no)?  no
         //Does the drink have  Water  (yes/no)?  no
         //The type of drink is:  ESPRESSO
         //
         //Press 1 to continue...Press 0 to exit...  1
         //Does the drink have  Steamed Milk  (yes/no)?  yes
         //Does the drink have  Milk Foam  (yes/no)?  yes
         //The type of drink is:  CAFFE LATTE or CAPPUCCINO
         //
         //Press 1 to continue...Press 0 to exit...

    }
}
