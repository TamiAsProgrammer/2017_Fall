/**
 * Write a description of class ChangeSolution here.
 * 
 * @author (Teng Liu - 306750) 
 * @version (Assignment.5.2.11022017)
 */
import java.util.Scanner;

public class RPSsimulate
{
    public static void main(String[] args)
    {
        // for getting input RPS number
        int userChoose;
        int computerChoose;

        // count win numbers
        int numOfuserWin = 0;
        int numOfcomputerIwin = 0;
        int numOfweTied = 0;

        boolean playAgain = true;       // play again?

        Scanner input = new Scanner(System.in);
        while (playAgain)
        {
            System.out.println("\nLet's play...");
            System.out.print("      Your turn, (ROCK=1, PAPER=2, SCISSORS=3): ");
            userChoose = input.nextInt();
            if (userChoose > 3 || userChoose < 1)
            {
                System.out.print("      Your turn, (ROCK=1, PAPER=2, SCISSORS=3): ");
                userChoose = input.nextInt();
            }
            computerChoose = (int)(Math.random() * 3) + 1;
            
            // 1. turn the RPS number to string-Name -- ROCK=1, PAPER=2, SCISSORS=3
            String nameOfRPS = "invalid";
            switch (computerChoose)
            {
                case 1:
                    nameOfRPS = "ROCK"; break;
                case 2:
                    nameOfRPS = "PAPER"; break;
                case 3:
                    nameOfRPS = "SCISSORS"; break;
                default: 
                    nameOfRPS = "invalid"; break;
            }
            
            // 2. determine who wins and count++
            // Rock 1 breaks 3 scissors - 1 rock wins
            // Scissors 3 cut 2 Paper - 3 scissors win
            // Paper 2 covers 1 Rock - 2 paper wins

            int difference = userChoose - computerChoose;
            if(difference == 1 ||difference == -2)  // User win (you win)
            {
                numOfuserWin ++;
                System.out.printf("      I picked %d %s,  you win!", computerChoose, nameOfRPS);
            }
            else if(difference == 0)                // we tied
            {
                numOfweTied ++;
                System.out.printf("      I picked %d %s,  we tied!", computerChoose, nameOfRPS);
            }
            else                                    // computer win (I win)
            {
                numOfcomputerIwin ++;
                System.out.printf("      I picked %d %s,  I win!", computerChoose, nameOfRPS);
            }

            // 3. play again logic & generate summary
            input.nextLine();
            System.out.print("\nPlay again (y/n)? ");
            playAgain = input.nextLine().equals("y");
            if(!playAgain)                               
            {
                System.out.println("Here are the states: ");
                System.out.printf("      You win %d times\n", numOfuserWin);
                System.out.printf("      You lost %d times\n", numOfcomputerIwin);
                System.out.printf("      We tied %d times\n", numOfweTied);
                System.out.printf("That was fun !!\n");
                System.out.println();
            }
        }
        
    }
}
