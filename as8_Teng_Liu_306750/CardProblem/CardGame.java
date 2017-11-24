
/**
 * Write a description of class ChangeSolution here.
 * 
 * @author (Teng Liu - 306750) 
 * @version (Assignment.8.1.11242017)
 */

import java.util.*;

public class CardGame
{
    public static void main(String[] args)
    {
        ArrayList<String> deck = new ArrayList<String>();       // store the deck
        ArrayList<String>[] playerHands = new ArrayList[0];     // an array of arraylist, for each player's hand
        String option = "";
        
        while(true)
        {
            System.out.println("a) Create a new deck");
            System.out.println("b) Shuffle the deck");
            System.out.println("c) Deal player hands");
            System.out.println("d) Display player hands");
            System.out.println("e) Display the deck");
            System.out.println("f) QUIT ");

            System.out.print("Please choose the option: ");
            Scanner input = new Scanner(System.in);
            String opt = input.nextLine();

            if (opt.equals("a"))                // createDeckOfCard
            {
                System.out.println("----------A New Deck------------------");
                createDeckOfCard(deck);
                System.out.println("--------------------------------------\n");
            }
            else if (opt.equals("b"))           // shuffleTheDeck  
            {
                System.out.println("----------Shuffled deck---------------");
                shuffleTheDeck(deck);
                System.out.println("--------------------------------------\n");
            }
            else if (opt.equals("c"))           // dealPlayerHands
            {
                System.out.println("----------Dealing cards...------------");
                playerHands = dealPlayerHands(deck);;
                System.out.println("--Done!-----(option d is to display)--");
                System.out.println("--------------------------------------\n");
            }
            else if (opt.equals("d"))           // displayHands
            {
                System.out.println("----------Cards per hand--------------");
                displayHands(playerHands);
                System.out.println("--------------------------------------\n");
            }
            else if (opt.equals("e"))           // displayDeck
            {
                System.out.println("----------Remaining Cards-------------");
                displayDeck(deck);
                System.out.println("--------------------------------------\n");
            }
            else
                break;
        }
    }

    public static void createDeckOfCard(ArrayList<String> deck)
    {
        ArrayList<String> suit = new ArrayList<String>();       
        ArrayList<String> rank = new ArrayList<String>();

        suit.add("Clubs");              // four suits
        suit.add("Diamonds");
        suit.add("Spades");
        suit.add("Hearts");

        rank.add("Ace");                
        rank.add("2");
        rank.add("3");
        rank.add("4");
        rank.add("5");
        rank.add("6");
        rank.add("7");
        rank.add("8");
        rank.add("9");
        rank.add("10");
        rank.add("Jack");
        rank.add("Queen");
        rank.add("King");

        // generate a deck, the same deck decleared in main method
        for(int i=0; i<suit.size(); i++)
        {
            for(int j=0; j<rank.size(); j++)
            {
                deck.add(rank.get(j) + " of " + suit.get(i));
            }
        }
        System.out.println(deck);
        System.out.println("Total cards in deck: " + deck.size());
    }

    public static void shuffleTheDeck(ArrayList<String> deck)
    {   
        // temp = A, A = B, B = temp
        for (int i = 0; i < deck.size(); i++) 
        { 
            int pos = (int)(Math.random() * deck.size()); 
            String tempCard = deck.get(pos); 
            deck.set(pos, deck.get(i)); 
            deck.set(i, tempCard);     
        } 
        System.out.println(deck);
        System.out.println("Total cards in deck: " + deck.size());
    }

    public static ArrayList<String>[] dealPlayerHands(ArrayList<String> deck)
    {                
        int numPlayers = 0;
        int cardsPerHand = 0;
        ArrayList<String>[] playerHands;                   // store the hands for each player and return 

        Scanner input = new Scanner(System.in);
        
        while(true)                                        // 1.ask for player and card number
        {
            System.out.print("How many players? ");
            numPlayers = input.nextInt();
            System.out.print("How many cards per hand? ");
            cardsPerHand = input.nextInt();
            if(numPlayers * cardsPerHand > deck.size())
            {
                System.out.println("ERROR: Not enough cards ... try again.");
            }
            else
            {
                break;
            }            
        }
       
        playerHands= new ArrayList[numPlayers];             // 2. hand out cards and record in corresponding ArrayList(of the Array)
        for(int round = 0; round < cardsPerHand; round++)
        {
            for (int player = 0; player < numPlayers; player ++)
            {
                if(playerHands[player] == null)             // initial the arrayList at first time for each player
                {
                    playerHands[player] = new ArrayList<String>();
                }
                playerHands[player].add(deck.remove(0));    // hand the first card from deck, and remove it. Always hand out the fist card 
            }
        }
        return playerHands;
    }

    public static void displayHands(ArrayList<String>[] playerHands)
    {
        for(int i = 0; i < playerHands.length; i++)
        {
            System.out.println("playerHands " + i + ": " +playerHands[i].toString());
        }
    }

    public static void displayDeck(ArrayList<String> deck)  // the remaining card in the deck
    {
        System.out.println(deck.toString());
        System.out.println("Total cards in deck: " + deck.size());
    }

}
