
/**
 * Write a description of class ChangeSolution here.
 * 
 * @author (Teng Liu - 306750) 
 * @version (Assignment.4.SongLyricGenerator.10162017)
 */
import java.util.Scanner;

public class SongLyric
{
    public static void main(String[] args)
    {
        SongLyric song = new SongLyric();

        int start;
        int end;
        Scanner input = new Scanner(System.in);
        System.out.println("============\"There's a Hole\" Lyric Builder============");

        do 
        {
            System.out.print("Which verse would you like to start with (1 to 7)? ");
            start = input.nextInt();
        } while (start<1 || start>7);

        do
        {
            System.out.printf("Which verse would you like to end with (%d to 7)? ",start);
            end = input.nextInt();
        } while (end < start);
        
        System.out.println();
        System.out.printf("============There's a Hole (%d - %d)============\n",start,end);

        for (int i = start; i<=end; i++)
        {
            song.genNew(i);
        }
        
    }

    public void genNew(int verse_no)
    {
        String line = "There's";
        
        switch(verse_no)
        {
            case 7:
                line = line + " a flea on";
            case 6:
                line = line + " a wing on";
            case 5:
                line = line + " a flea on";
            case 4:
                line = line + " a frog on";
            case 3:
                line = line + " a bump on";
            case 2:
                line = line + " a log in";
            case 1:
                line = line + " a hole";   
        }
        line = line + " in the bottom of the sea.";
        System.out.println(line);
        System.out.println(line);
        System.out.println("There's hole. There's hole.");
        System.out.println("There's hole in the bottom of the sea.");
        System.out.println();
    }

// ------here is an example of the output-------
// ============"There's a Hole" Lyric Builder============
// Which verse would you like to start with (1 to 7)? 0
// Which verse would you like to start with (1 to 7)? 2
// Which verse would you like to end with (2 to 7)? 1
// Which verse would you like to end with (2 to 7)? 6
// 
// ============There's a Hole (2 - 6)============
// There's a log in a hole in the bottom of the sea.
// There's a log in a hole in the bottom of the sea.
// There's hole. There's hole.
// There's hole in the bottom of the sea.
// 
// There's a bump on a log in a hole in the bottom of the sea.
// There's a bump on a log in a hole in the bottom of the sea.
// There's hole. There's hole.
// There's hole in the bottom of the sea.
// 
// There's a frog on a bump on a log in a hole in the bottom of the sea.
// There's a frog on a bump on a log in a hole in the bottom of the sea.
// There's hole. There's hole.
// There's hole in the bottom of the sea.
// 
// There's a flea on a frog on a bump on a log in a hole in the bottom of the sea.
// There's a flea on a frog on a bump on a log in a hole in the bottom of the sea.
// There's hole. There's hole.
// There's hole in the bottom of the sea.
// 
// There's a wing on a flea on a frog on a bump on a log in a hole in the bottom of the sea.
// There's a wing on a flea on a frog on a bump on a log in a hole in the bottom of the sea.
// There's hole. There's hole.
// There's hole in the bottom of the sea.
// 

}
