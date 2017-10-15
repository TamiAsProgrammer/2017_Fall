
/**
 * Write a description of class ChangeSolution here.
 * 
 * @author (Teng Liu - 306750) 
 * @version (Assignment.2.1FillingCubeProblem.09302017)
 */

import java.util.Scanner;

public class CubeTrayProblem
{
    public static void main(String[] args)
    {
        CubeTrayProblem cubeTray = new CubeTrayProblem();
        cubeTray.getCube();
    }

    public void getCube()
    {
        int across,down,total;
        double radius, liters;

        Scanner input = new Scanner(System.in);
        System.out.println("Filling an ice cube tray ...");
        System.out.println();
        System.out.print("How many ice cubes across?  ");
        across = input.nextInt();
        System.out.print("How many ice cubes down?  ");
        down = input.nextInt();
        total = across*down;                                 // get total cube number
        System.out.print("what is the diameter of each ice cube (cm)?  ");
        radius = input.nextDouble()/2;
        liters = (4*Math.PI*radius*radius*radius)/3;        // for each cube(a whole)
        liters = (total*liters) / 1000;                     // for total number cubes, and transfer the unit
        liters = liters / 2;                                // for getting half of the cubes
        System.out.printf("You will need %.3f Liters of water.\n", liters);
    }
    // ---------the result example----------
    //Filling an ice cube tray ...

    //How many ice cubes across?  3
    //How many ice cubes down?  6
    //what is the diameter of each ice cube (cm)?  3.5
    //You will need 0.202 Liters of water.

}
