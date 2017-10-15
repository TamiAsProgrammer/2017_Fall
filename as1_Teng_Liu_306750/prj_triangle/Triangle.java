
/**
 * Write a description of class Triangle here.
 * 
 * @author (Teng Liu - 306750) 
 * @version (Assignment.1.triangle.09182017)
 */
import java.util.Scanner;

public class Triangle{
   
    public static void main(String[] args){
         Triangle trian = new Triangle();
         trian.getTriangleDone();
    }

    public void getTriangleDone(){
       
        //!!! Please note that the Angle B and Angle C in the Assignment doc screenshot seems they are reversed

        double ax, ay, bx, by, cx, cy;           // coordinates of each point A,B,C
        double a, b, c;                          // length of each side a,b,c
        double peri, area;                       // perimeter and area
        double angleA, angleB, angleC;           // Angle of each corner A,B,C

        // initialize, with testing data
        ax = 4;
        ay = 4;
        bx = 23;
        by = 4;
        cx = 20;
        cy = 17;

        // 0. geting all the coordinates from user inputd
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the x,y coordinate and press Enter to continue...");
        System.out.println("");                // an empty row
        System.out.print("For point A, x=");
        ax = scan.nextDouble();
        System.out.print("For point A, y=");
        ay = scan.nextDouble();
        System.out.println("");   // an empty row
        System.out.print("For point B, x=");
        bx = scan.nextDouble();
        System.out.print("For point B, y=");
        by = scan.nextDouble();
        System.out.println("");   // an empty row
        System.out.print("For point C, x=");
        cx = scan.nextDouble();
        System.out.print("For point C, y=");
        cy = scan.nextDouble();
        System.out.println("");   // an empty row
        System.out.println("A(" + ax + ", " + ay + "), B(" + bx + ", " + by + "), C("+ cx + ", " + cy + ")");

        //1. calculating the length of each side
        a = Math.hypot(bx-cx, cy-by);
        b = Math.hypot(cx-ax, cy-ay);
        c = Math.hypot(bx-ax, by-ay);

        //2. calculating the perimeter
        peri = a + b + c;

        //3. calculating the Area, from Heron's formula --> s=peri/2, sqrt(s(s-a)(s-b)(s-c))
        area = Math.sqrt(peri/2*(peri/2-a)*(peri/2-b)*(peri/2-c)); 

        //4. calculating the radians of A,B,C, and the Angles is during the print line.
        angleA = Math.acos((b*b + c*c - a*a)/(2*b*c));
        angleB = Math.acos((a*a + c*c - b*b)/(2*a*c));
        angleC = Math.acos((a*a + b*b - c*c)/(2*a*b));

        //5. print part I
        System.out.println("---------TRIANGLE MEASUREMENTS-----------");
        System.out.printf("Length of side a = %.2f\n", a);
        System.out.printf("Length of side b = %.2f\n", b);
        System.out.printf("Length of side c = %.2f\n", c);
        System.out.printf("       Perimeter = %.2f\n", peri);
        System.out.printf("            Area = %.2f\n", area);
        System.out.println("");   // an empty row

        //6. print part II   -  radians and angles
        System.out.printf("Angle A: %.2f radians   (%.2f degrees)\n", angleA, ((180*angleA)/Math.PI));
        System.out.printf("Angle B: %.2f radians   (%.2f degrees)\n", angleB, ((180*angleB)/Math.PI));
        System.out.printf("Angle C: %.2f radians   (%.2f degrees)\n", angleC, ((180*angleC)/Math.PI));
        System.out.println("------------------------------------------");
    }
    
    // ------here is an example of output results------
    //Enter the x,y coordinate and press Enter to continue...
    //
    //For point A, x=4
    //For point A, y=4
    //
    //For point B, x=23
    //For point B, y=4
    //
    //For point C, x=20
    //For point C, y=17
    //
    //A(4.0, 4.0), B(23.0, 4.0), C(20.0, 17.0)
    //---------TRIANGLE MEASUREMENTS-----------
    //Length of side a = 13.34
    //Length of side b = 20.62
    //Length of side c = 19.00
    //       Perimeter = 52.96
    //            Area = 123.50
    //
    //Angle A: 0.68 radians   (39.09 degrees)
    //Angle B: 1.34 radians   (77.01 degrees)
    //Angle C: 1.12 radians   (63.90 degrees)
    //------------------------------------------
    
}
