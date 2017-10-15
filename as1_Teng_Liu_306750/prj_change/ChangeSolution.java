
/**
 * Write a description of class ChangeSolution here.
 * 
 * @author (Teng Liu - 306750) 
 * @version (Assignment.1.Change.09252017)
 */
import java.util.Scanner;

public class ChangeSolution{

    public static void main(String[] args){
        ChangeSolution change = new ChangeSolution();
        change.getChange();
    }

    public void getChange(){
        // variables that needed
        double price; 
        double due;
        double pay;
        double changeInTotal;
        final double HST = 0.15;
        Scanner input = new Scanner(System.in);

        //1. get price, due and pay
        System.out.print("The item price is:  ");
        price = input.nextDouble();
        due = 1.15*price;
        System.out.printf("Then, the Total due is:  $%.2f + $%.2f(HST) = $%.2f", price, price*HST, due);
        System.out.println();  //empty line
        System.out.println();  //empty line
        System.out.print("Payment amount is:  ");
        pay = input.nextDouble();
        
        //2. then calculate the ChangeInTotal *100
        //3. then calculate from the largest coin 200, then 100, 25,10,5 and 1 in the last
        System.out.println();
        System.out.println("----Here is your change information-----");
        changeInTotal = (pay - due)*100;
        int coinNumber;
        coinNumber = (int)(changeInTotal/200);
        System.out.println(coinNumber + " Toonies");
        changeInTotal = changeInTotal - coinNumber*200;
        coinNumber = (int)(changeInTotal/100);
        System.out.println(coinNumber + " Loonies");
        changeInTotal = changeInTotal - coinNumber*100;
        coinNumber = (int)(changeInTotal/25);
        System.out.println(coinNumber + " Quarters");
        changeInTotal = changeInTotal - coinNumber*25;
        coinNumber = (int)(changeInTotal/10);
        System.out.println(coinNumber + " Dimes");
        changeInTotal = changeInTotal - coinNumber*10;
        coinNumber = (int)(changeInTotal/5);
        System.out.println(coinNumber + " Nickels");
        changeInTotal = changeInTotal - coinNumber*5;
        coinNumber = (int)(changeInTotal);
        System.out.println(coinNumber + " Pennies");
    }

    // --------here is an example of the result:---------------
    // The item price is:  20.99
    // Then, the Total due is:  $20.99 + $3.15(HST) = $24.14
    // 
    // Payment amount is:  30
    // 
    // ----Here is your change information-----
    // 2 Toonies
    // 1 Loonies
    // 3 Quarters
    // 1 Dimes
    // 0 Nickels
    // 1 Pennies
    // 
}
