
/**
 * Write a description of class ChangeSolution here.
 * 
 * @author (Teng Liu - 306750) 
 * @version (Assignment.2.GrowthRate.10022017)
 */

import java.util.Scanner;

public class GrowthRate
{
    public static void main(String[] args)
    {
        GrowthRate growthR = new GrowthRate();
        growthR.getGrowthRate();
    }

    public void getGrowthRate()
    {
        double startPop, finalPop;  // Math.log requires the parameter is double
        int timeOfYears;
        double rate;
        
        try
       {
            Scanner input = new Scanner(System.in);
            System.out.print("Starting population is:  ");
            startPop = input.nextLong();
            System.out.print("Final population is:  ");
            finalPop = input.nextLong();
            System.out.print("Time between measurements:  ");
            timeOfYears = input.nextInt();
            rate = (Math.log(finalPop/startPop))/timeOfYears;
            rate = rate*100;     // become the percentage
            System.out.println();
            System.out.printf("The rate of growth is:  %.3f %%", rate);
       }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
            //------an example of the result------
            //Starting population is:  6066867391
            //Final population is:  7550262101
            //Time between measurements:  18
            //
            //The rate of growth is:  1.215 %

    }
}
