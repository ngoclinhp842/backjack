/**
 * File: NewBlackjack.java
 * Author: Linh Phan
 * Date: 02/08/2022
 * Course: CS231 A
 * Project 1
 * 
 * This is the extension of the project
 * NewBlackjack class uses input from the terminal to control the player's actions. 
 * Thus, lets you play Blackjack on the terminal.
 * 
 * How to run: enter "javac NewBlackjack.java" in the terminal 
 *              then enter "java NewBlackjack" in the terminal
 * 
 */

import java.util.Scanner;

public class NewBlackjack {
    static boolean playerTurnInteractive(){
        // Let the user play one game of Blackjack.
        // Return true if the user wins, false if the user loses.

        int cutoff = 26;

        // A deck of cards.  A new deck for each game.
        Deck deck = new Deck();  
        deck.shuffle();           
        // The dealer's hand.     
        Hand dealerHand = new Hand();   
        // The user's hand.
        Hand userHand = new Hand();    

        // If the number of cards in the deck is less than the reshuffle cutoff, 
        // then the method should create a fresh (complete), shuffled deck. 
        if (deck.size() < cutoff){
            deck = new Deck();
            deck.shuffle();
        }
        
        // deal out two cards to players
        userHand.add(deck.deal());
        userHand.add(deck.deal());
        System.out.println("You has a " + userHand.getCard(0) + " and a " + userHand.getCard(1) + " .");
        dealerHand.add(deck.deal());
        dealerHand.add(deck.deal());
        
        /* Check if one of the players has Blackjack (two cards totaling to 21).
            The player with Blackjack wins the game.  Dealer wins ties.
        */
        if (userHand.getTotalValue() == 21){
            System.out.println("You has a blackjack. You win!");
            return true;
        }

        if (dealerHand.getTotalValue() == 21){
            System.out.println("The dealer has a blackjack. The dealer wins!");
            return false;
        }

        /*  If neither player has Blackjack, play the game.  First the user 
            gets a chance to draw cards (i.e., to "Hit").  The while loop ends 
            when the user chooses to "Stand".  If the user goes over 21,
            the user loses immediately.
        */

        Scanner myObj = new Scanner(System.in);
        while (true){
            /* Display user's card value, and let user decide to Hit or Stand. */
            System.out.println("Your current card value are: " + userHand.getTotalValue());
            System.out.println("The dealer is showing " + dealerHand.getCard(0) + "\n");

            // get input from the user
            System.out.println("Hit (H) or Stand (S)? ");

            // String input
            String action = myObj.next();

            // keep taking input until the user enter the correct one
            // do {
            //     System.out.println("Please respond H or S:  ");
            // } 
            // while (action.toUpperCase() != "H" && action.toUpperCase() != "S");

            /* If the user Hits, the user gets a card.  If the user Stands,
            the loop ends (and it's the dealer's turn to draw cards).
            */

            if (action.equals("S") || action.equals("s") ){
                //  Loop ends; user is done taking cards.
                break;
            }
            else {
                // userAction is 'H'.  Give the user a card.  
                // If the user goes over 21, the user loses.
                Card new_card = deck.deal();
                userHand.add(new_card);
                System.out.println("User hits. Your new card is " + new_card);
                System.out.println("Your total is now " + userHand.getTotalValue());

                if (userHand.getTotalValue() > 21){
                    System.out.println("You busted by going over 21. You lose.");

                    // reveal the other card of the dealer
                    System.out.println("Dealer's other card was the " + dealerHand.getCard(1));
                    return false;  
                }
            }
            
        }

        myObj.close();
        
        /*
        The while ends, which means that the user stood with 21 or less.
        It's the dealer turn to draw. Dealer draws cards until the dealer's
        total is > 16.  If dealer goes over 21, the dealer loses.
        */
        System.out.println("The user stands.");
        System.out.println("The dealer's card value is: " + dealerHand.getTotalValue());
        
        // if the dealer value > 21, the dealer bust.
        if (dealerHand.getTotalValue() > 21){
            System.out.println("Dealer busted by going over 21. You win.");
            return true;
        }
        System.out.println("The dealer total card value is " + dealerHand.getTotalValue() + "\n");

        /* Now, both players have 21 or less.  We
        can determine the winner by comparing the values of their hands. */
        if (userHand.getTotalValue() == dealerHand.getTotalValue()){
            System.out.println("The dealer wins on a tie. You loses.");
            return false;
        }

        if (userHand.getTotalValue() > dealerHand.getTotalValue()){
            System.out.println("You win with " + userHand.getTotalValue() + " to the dealer's points "
                                + dealerHand.getTotalValue());
            return true;
        }
          
        System.out.println("Dealer win with " + dealerHand.getTotalValue() + " to your points "
                            + userHand.getTotalValue());
        return false;
    }

    public static void main(String[] args) {
        playerTurnInteractive();
    }
}
