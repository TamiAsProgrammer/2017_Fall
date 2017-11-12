
/**
 * Write a description of class ChangeSolution here.
 * 
 * @author (Teng Liu - 306750) 
 * @version (Assignment.7.2.12112017)
 */
import java.util.*;

public class MagicSquare
{
    public static void main(String[] args)
    {
        int n;
        int[] numberArr;

        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a value for n: ");
        n = input.nextInt();
        input.nextLine();
        System.out.printf("Please enter %d numbers split by space: ", n*n);
        String strNumbers;                                  // for store the input long string (with numbers + space)
        strNumbers = input.nextLine();
        System.out.println("Here is what you input: " + strNumbers);
        System.out.println();
        numberArr = readNumberToArray(n, strNumbers);       // format the long string to Array of Integer
        if(numberArr != null)
        {
            System.out.println(isMagicSquare(n, numberArr) ? "***It is a magic square!" : "***Sorry! It is NOT a magic square!");
        }

        // Testing data
        // n = 3, MS = 4 9 2 3 5 7 8 1 6
        // n = 4, MS = 9 6 3 16 4 15 10 5 14 1 8 11 7 12 13 2
    }

    public static int[] readNumberToArray(int n, String numbers)
    {
        try
        {
            String[] numberArr = new String[n*n];
            numberArr = numbers.split(" ");

            int numIntArr[] = new int[n*n];
            for (int i = 0; i < numberArr.length; i++)
            {
                numIntArr[i] = Integer.parseInt(numberArr[i]);
            }
            return numIntArr;
        }
        catch (Exception ex)
        {
            return null;
        }
    }

    public static boolean isMagicSquare(int n, int[] numbers)
    {
        // check sum of a row
        // check sum of a column
        // check sum diagonal

        boolean isMC = false;

        int sumR = sumOfRow(n, numbers);                // -1 means not equal, otherwise sum is the actual equally sum. belows are same logic
        int sumC = sumOfColumn(n, numbers);             
        int sumD = sumOfDiagonal(n, numbers);           
                
        if(sumR == sumC && sumC == sumD && (sumR != -1))        
        {
            isMC = true;
            System.out.println("***Congratulations! All of the required sum are equal to: " + sumR);
        }

        return isMC;
    }

    public static int sumOfRow(int n, int[] numbers)
    {
        int sum = 0;                                    // return sum actual value if sumOfrow equal, otherwise return -1
        int sumAccount = 0;
        for (int i = 0; i < n; i++)                     // n rows
        {
            sumAccount = 0;
            for (int j = 0; j< n; j++)                  // n elements for each row
            {
                sumAccount += numbers[i*n+j];
            }
            if(i == 0)                                  // record the first row sum which used for compare other rows
            {
                sum = sumAccount;
            }
            else
            {
                if(sumAccount != sum)
                {
                    sum = -1;
                    System.out.println("Warning: Sum of Row are NOT equal!");
                    break;
                }
            }
        }
        return sum;
    }

    public static int sumOfColumn(int n, int[] numbers)
    {
        int sum = 0;                                    // return sum actual value if sumOfcolumn equal, otherwise return -1
        int sumAccount = 0;
        for (int i = 0; i<n ; i++)                      // n columns
        {
            sumAccount = 0;
            for(int j=0; j<n; j++)                      // n elements for each column
            {
                sumAccount += numbers[(i+n*j)];
            }
            if(i == 0)
            {
                sum = sumAccount;
            }
            else
            {
                if(sumAccount != sum)
                {
                    sum = -1;
                    System.out.println("Warning: Sum of Column are NOT equal!");
                    break;
                }
            }
        }
        return sum;
    }

    public static int sumOfDiagonal(int n, int[] numbers)
    {
        int sum = 0;                                    // sum = -1 if Diagonal not equal, otherwise, sum will get the value of SumOfDiagonal
        int sumOfLtoR = 0;
        int sumOfRtoL = 0;
        for (int i=0; i<n ; i++)                        // n rows
        {
            for (int j=0; j<n; j++)                     // n columns
            {
                if(i == j)                              // diagonal elements: (0,0) (1,1) (2,2)... [top-left --> bottom-right]
                {
                    sumOfLtoR += numbers[(i*n+j)];
                }
                if(i+j == (n-1))                        // diagonal elements: ... (2,0) (1,1) (0,2)  [top-right --> bottom-left]
                {
                    sumOfRtoL += numbers[(i*n+j)];
                }
            }
        }
        if(sumOfLtoR == sumOfRtoL)
        {
            sum = sumOfLtoR;
        }
        else
        {
            sum = -1;
            System.out.println("Warning: Sum of Diagonal are NOT equal!");
        }

        return sum;
    }
}
