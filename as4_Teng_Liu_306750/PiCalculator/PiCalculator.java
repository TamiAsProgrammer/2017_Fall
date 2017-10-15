
/**
 * Write a description of class PiCalculator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.math.BigDecimal;
public class PiCalculator
{
    public static void main(String[] args)
    {
        PiCalculator pi = new PiCalculator();
        pi.getPi();

    }

    public void getPi()
    {
        // pi/4 = 1-1/3+1/5-1/7+1/9+1/11+...200

        double pi = 1.;
        double deno = 1.;    
        double sign = 1.;     // for - and + 

        for (int i=1;i<=200;i++)
        {
            sign *= -1.;
            deno += 2.;
            pi = pi + sign/deno;
            System.out.printf("i= %d   Pi %.12f   deno %2.0f/%2.0f \n",i,pi*4.,sign,deno);     
        }
        pi = pi*4.;
        System.out.printf("----Final Pi is %.12f----\n",pi); 
   } 
    // ------------here is an example of the result------------
    // i= 1   Pi 2.666666666667   deno -1/ 3 
    // i= 2   Pi 3.466666666667   deno  1/ 5 
    // i= 3   Pi 2.895238095238   deno -1/ 7 
    // ......
    // i= 199   Pi 3.136592684839   deno -1/399 
    // i= 200   Pi 3.146567747183   deno  1/401 
    // ----Final Pi is 3.146567747183----
    // 
}
