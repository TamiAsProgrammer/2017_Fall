
/**
 * Write a description of class ChangeSolution here.
 * 
 * @author (Teng Liu - 306750) 
 * @version (Assignment.5.2.11032017)
 */
public class MontyHallSimulation
{
    public static void main(String[] args)
    {
        final int TRIALS = 10000;

        int placeCar;
        int firstGuess;
        int finalGuess = -1;
        String goatInDoors = "";
        int hostOpen;

        int trySwap = 0;
        int tryStay = 0;
        int strategeRandom;
        int numOfSwapWin = 0;
        int numOfStayWin = 0;

        for(int i=0; i<TRIALS; i++)
        {
            System.out.println();
            System.out.printf("---------------%d-------------------\n", i);
            // 1. place the car randomly
            placeCar = (int)(Math.random()*3+1);                    
            System.out.println("1. Car placed in: " + placeCar);

            // 2. get the other two doors of Goats --> put in a string like 12,23..
            goatInDoors = "";
            for(int j=1; j<4; j++)      // j = 1,2,3
            {
                if(j!=placeCar)
                {
                    goatInDoors += j;
                }
            }
            System.out.println("2. Goat in: " + goatInDoors );

            // 3. user first guess
            firstGuess = (int)(Math.random()*3+1);
            System.out.println("3. First Guess is: " + firstGuess);

            //4. host open a door with Goat
            int r = (int)(Math.random()*2);
            String ch = "" + goatInDoors.charAt(r);
            hostOpen = Integer.parseInt(ch);

            if(hostOpen == firstGuess)
            {
                for (int j = 0; j < goatInDoors.length(); j++)
                {
                    String ch1 = "" + goatInDoors.charAt(j);
                    int current = Integer.parseInt(ch1);
                    if(hostOpen!=current)
                    {
                        hostOpen = current;
                        break;
                    }
                }
            }
            System.out.println("4. HostOpenGoat at door: " + hostOpen);

            // 5. pick stratege randomly
            strategeRandom = (int)(Math.random()*2+1);       // 1 for swap, 2 for stay
            
            if (strategeRandom == 1)
            {
                trySwap ++;  
                for(int j=1; j<4; j++)       // find the last one and swap to it, update to firstGuess     
                {
                    if(j!=firstGuess && j!=hostOpen)
                    {
                        finalGuess = j;
                        System.out.println("5. swap to: " + finalGuess);
                        break;
                    }
                }
                if (finalGuess == placeCar)
                {
                    numOfSwapWin ++;
                }       
            }
            else if (strategeRandom == 2)
            {
                tryStay ++;
                if(firstGuess == placeCar)
                {
                    numOfStayWin ++;
                }
            }
        }

        //caculate percentage
        double percentStay = ((double)numOfStayWin/(double)tryStay)*100.;
        double percentSwap = ((double)numOfSwapWin/(double)trySwap)*100.;
        System.out.println();
        System.out.printf("==========> Stay: %d / %d (percentage:  %.2f%%)\n", numOfStayWin, tryStay,percentStay);
        System.out.printf("==========> Swap: %d / %d (percentage:  %.2f%%)\n", numOfSwapWin, trySwap,percentSwap);
    }
}
