
/**
 * Write a description of class ChangeSolution here.
 * 
 * @author (Teng Liu - 306750) 
 * @version (Assignment.6.2.11102017)
 */
import java.util.*;

public class ShowCalendar
{
    public static void main(String[] args)
    {
        int year;
        int month;

        //--1. get input of year and month
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the calendar Month (1-12):" );
        month = input.nextInt();
        System.out.print("Enter the calendar Year (YYYY):" );
        year = input.nextInt();
        System.out.println();

        int totalLength = ("Su Mo Tu We Th Fr Sa").length();
        int monthDayNumber;
        int firstWeekDay;

        //--2. printHeaderLine 2 lines, one is Month+Year, another is the title of WeekDay.
        printHeaderLine(year, month, totalLength);
        
        //--3. get the first WeekDay number, and calculate the number of begining-space for the first week.
        firstWeekDay = getFirstWeekDay(year, month);
        int blankForFirstWeek = totalLength - ((7 - firstWeekDay)*3 - 1);     // get the displaying space, then total - display = empty space. 
        printSpace(blankForFirstWeek);

        //--4. get total month-day-number
        monthDayNumber = getMonthDayNumber(year,month);

        //--5. get how many weeks, and print body date number
        int weekCount = getWeekNumber(firstWeekDay, monthDayNumber);
        printBodyDateNumber(firstWeekDay,weekCount, monthDayNumber);
    }

    public static int getWeekNumber(int firstWeekDay, int monthDayNumber)
    {
        int weekCount = (int)Math.ceil((double)(monthDayNumber - (7 - firstWeekDay))/7.);   
        weekCount = weekCount + 1;              // 1 is for the first week 
        return weekCount;
    }

    public static void printBodyDateNumber(int firstWeekDay, int weekCount, int monthDayNumber)
    {
        int endDay = 7 - firstWeekDay;          // the end date of each week  
        for (int i = 0; i < weekCount ; i ++)   // loop for each week
        {
            if (i == 0)                        
            {
                for (int j = 1; j < endDay+1; j++)
                {
                    System.out.print(j + "  ");
                }
                endDay ++;
            }
            else
            {
                for (int k = endDay; k < endDay + 7 && k < monthDayNumber + 1; k++)    
                {
                    if(k < 10)
                    {
                        System.out.print(k + "  ");
                    }
                    else
                    {
                        System.out.print(k + " ");
                    }
                }
                endDay+=7;
                if(endDay>monthDayNumber)       
                {
                    endDay = monthDayNumber;
                }
            }
            System.out.println();
        }
    }

    public static int getFirstWeekDay(int year, int month)
    {
        int startWeekDay = java.time.LocalDate.of(year,month,1).getDayOfWeek().getValue();
        return startWeekDay;
    }

    public static int getMonthDayNumber(int year, int month)
    {
        int monthDayNumber = 0;

        if(month == 2)
        {
            monthDayNumber = isLeapYear(year)? 29:28;
        }
        else if (month == 1 || month == 3 || month == 5 ||
                 month == 7 || month == 8 || month == 10 || month == 12)
        {
            monthDayNumber = 31;
        }
        else if (month == 4 || month == 6 || month == 9 || month == 11)
        {
            monthDayNumber = 30;
        }
        return monthDayNumber;
    }

    public static boolean isLeapYear(int year)          // isLeapYear? %4 but not %100, and %400
    {
        if( (year%4 == 0 && year%100!=0) || year%400 == 0 )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void printHeaderLine(int year, int month, int totalLength)
    {
        String monthName = "";
        switch (month)
        {
            case 1: monthName = "January";  break;
            case 2: monthName = "February"; break;
            case 3: monthName = "March";    break;
            case 4: monthName = "April";    break;
            case 5: monthName = "May";      break;
            case 6: monthName = "June";     break;
            case 7: monthName = "July";     break;
            case 8: monthName = "August";   break;
            case 9: monthName = "September";    break;
            case 10: monthName = "October";     break;
            case 11: monthName = "November";    break;
            case 12: monthName = "Decembers";   break;
        }

        String weekTitle = "Su Mo Tu We Th Fr Sa";
        String titleYM = monthName + " " + year;
        printSpace((totalLength - titleYM.length())/2);
        System.out.println(titleYM + "\n" + weekTitle);
    }

    public static void printSpace(int numOfSpace)
    {
        for (int i = 0; i < numOfSpace; i++)
        System.out.print(" ");
    }

}
