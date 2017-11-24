/**
 * Write a description of class ChangeSolution here.
 * 
 * @author (Teng Liu - 306750) 
 * @version (Assignment.8.2.11242017)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class FilterData
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String sourceFileName = "customers.csv";
        int columnNumber = 8;                           // fixed column number - the array length
        File source = new File(sourceFileName);
        Scanner readFile = new Scanner(source);

        String targetProvince = "";
        String outputFileName = "";
        Scanner in = new Scanner(System.in);

        System.out.println("*Available Province code: AB, BC, MB, NB, NL, NS, ON, PE, QC, SK");
        System.out.print("1. Please input a prinvice code: ");
        targetProvince = in.nextLine();
        System.out.print("2. Please specify an output file Name(e.g. ontario.txt): ");
        outputFileName = in.nextLine();

        // 1.------------------input: read file and store in ArrayList--------------------------------------
        ArrayList<String[]> data = new ArrayList<String[]>();   // store the whole information, an arrayList with rows of Array
        String[] arrayOfRow = new String[columnNumber];         // for each row, each row is an array
        
        while(readFile.hasNextLine())
        {
            String currentRow = readFile.nextLine();            // read a row as string
            arrayOfRow = currentRow.split(",");                 // split string to an Array
            data.add(arrayOfRow);                               // add the array of current row to ArrayList data
        }
        readFile.close();


        // 2.-----------------output: filter the data by specified province and output as a file--------
        String newRow = "";
        ArrayList<String> filteredDataList = new ArrayList<String>();       // for store the new ArrayList
        PrintWriter wtiteFile = new PrintWriter(outputFileName);            // prepare for write file
        for (int i=0; i<data.size(); i++)
        {
            arrayOfRow = data.get(i);                                       // loop each row 
            for(int j=0; j<arrayOfRow.length;j++)       
            {
                if(arrayOfRow[j].equals(targetProvince))                    // find the specified Province rows 
                {
                    newRow = arrayOfRow[0] + " " + arrayOfRow[1] + ":   " + arrayOfRow[7];  
                    filteredDataList.add(newRow);                           // add the new row to the new array list
                    wtiteFile.println(newRow);
                }
            }
        }
        wtiteFile.printf("-----Total number of %s is: %d", targetProvince ,filteredDataList.size());
        wtiteFile.close();
        System.out.println("-----Finished! You can check in the output file:  "  + outputFileName);
        System.out.printf("-----Total number of %s is: %d", targetProvince ,filteredDataList.size());
        //-------used to print on the console/screen for check---------
        //System.out.println();
        //for (int n = 0; n<filteredDataList.size();n++)
        //{
        //    System.out.println(filteredDataList.get(n));
        //}
    }
}
