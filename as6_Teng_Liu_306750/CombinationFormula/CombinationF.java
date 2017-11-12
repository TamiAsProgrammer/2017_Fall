
/**
 * Write a description of class ChangeSolution here.
 * 
 * @author (Teng Liu - 306750) 
 * @version (Assignment.6.1.11102017)
 */
import java.util.Scanner;

public class CombinationF
{
    public static void main(String[] args)
    {
        int setSizeN;
        int comResult;
        System.out.print("Please enter a set size n:  ");
        Scanner input = new Scanner(System.in);
        setSizeN = input.nextInt();
        
        for (int i = 1; i < setSizeN; i++)               //find all the even subset(to n-1), and call getCombination
        {
            if(i%2 == 0)
            {
                comResult = getCombination(setSizeN, i);
                System.out.printf("%d  choose  %d, combination is : %d\n", setSizeN, i, comResult);
            }
        }
    }

    public static int getCombination(int n, int k)      // get combination by getting n and k.
    {
        int result = getFactural(n)/(getFactural(k)*getFactural(n - k));
        return result;
    }

    public static int getFactural(int num)              // get factural by getting a number
    {
        int fact = num;
        for (int i = num; i > 1; i--)
        {
            fact*= i - 1;
        }
        //System.out.printf("---factural: %d  -->  %d\n\n",num, fact);
        return fact;
    }






}
