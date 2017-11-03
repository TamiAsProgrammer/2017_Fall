/**
 * Write a description of class ChangeSolution here.
 * 
 * @author (Teng Liu - 306750) 
 * @version (Assignment.5.1.10282017)
 */

import java.util.Scanner;

public class WordToPattern
{
    public static void main(String args[])
    {
        WordToPattern pattern = new WordToPattern();
        pattern.genPattern();
    }   

    public void genPattern()
    {
        String word;
        String direction;  // L or R

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a word: ");
        word = input.nextLine();
        System.out.print("Justification (L for Left, R for Right): ");
        direction = input.nextLine(); 

        if(direction.equals("L"))                 
        {
            for(int i = 0; i < word.length(); i++)          // outer loop --> number of rows
            {
                char ch = word.charAt(i);
                for (int j = 0; j < i + 1; j++)             // inner loop - each row --> letter number 
                {
                    System.out.print(ch);
                }
                System.out.println();
            }
        }
        
        if(direction.equals("R"))
        {
            for(int i = 0; i < word.length(); i++)          // outer loop --> number of rows
            {
                char ch = word.charAt(i);
                for(int j = 0; j < word.length()-i; j++)    // 1st inner loop --> row - space
                {
                    System.out.print(" ");                  
                }
                for (int k = 0; k <= i; k++)                // 2nd inner loop --> row - letter
                {
                    System.out.print(ch);
                }
                System.out.println();
            }
        }

        //allow the program continuously
        System.out.println();
        System.out.println();
        System.out.print("Press 1 to continue, 0 to exit:  ");
        Scanner in = new Scanner(System.in);
        if(in.nextLine().equals("1"))
        {
            WordToPattern pattern = new WordToPattern();
            pattern.genPattern();
        }
        else
        {
            System.out.println("You can close now...");
        }
   }
}
