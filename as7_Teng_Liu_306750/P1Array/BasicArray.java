
/**
 * Write a description of class ChangeSolution here.
 * 
 * @author (Teng Liu - 306750) 
 * @version (Assignment.7.1.11112017)
 */
import java.util.*;

public class BasicArray
{
    public static void main(String[] args)
    {
        String[] userCollection = new String[1000];
        System.out.print("Input your word followed by an Enter (type ZZZ to finish): \n");
        Scanner input = new Scanner(System.in);

        int currentSize = 0;      // current size
        while(input.hasNextLine())
        {
            String item = input.nextLine();
            if(currentSize < userCollection.length && !item.equals("ZZZ"))
            {
                userCollection[currentSize] = item;
                currentSize++;
            }
            else
            {
                System.out.println("Collecting finished!\n");
                break;
            }
        }
        for(int i=0;i<currentSize + 1; i++)     // loop each elements in the currentSize and print on the screen
        {
            if(userCollection[i] != null)       // just to make sure the array element is not null
            {
                System.out.printf("index: %d -  %s \n", i, userCollection[i]);
            }   
        }
    }
}
