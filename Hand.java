/**
 * File: Hand.java
 * Author: Linh Phan
 * Date: 02/08/2022
 * Course: CS231 A
 * Project 1
 * 
 * Hand class hold a set of cards for players and dealer in the blackjack game
 * 
 * How to run: enter "javac Hand.java"
 *          then enter "java Hand"
 */

import java.util.ArrayList;

public class Hand {
    ArrayList<Card> set;
    
    // initialize the ArrayList.
    public Hand(){

        // This dynamic momery get lost every time reset() is called 
        this.set = new ArrayList<Card>();
    }

    // reset the hand to empty.
    public void reset() {
        // This dynamic momery get lost every time reset() is called, except the first time
        this.set = new ArrayList<Card>();
    }

    // add the card object to the hand.
    public void add( Card card ) {
        this.set.add(card);
    }

    // returns the number of cards in the hand.
    public int size() {
        return this.set.size();
    }

    // returns the card with index i. Cast as appropriate.
    public Card getCard( int i ) {
        return set.get(i);
    }

    // returns the sum of the values of the cards in the hand.
    public int getTotalValue() {
        int sum = 0;
        for (int i = 0; i < set.size(); i++){
            Card card = set.get(i);
            sum += card.getValue();
        }
        return sum;
    }

    /*
    returns a String that has the contents of the hand presented in a nice format. 
    Use the Card toString method (implicitly or explicitly) to accomplish this.
    */
    public String toString() {
        String hand = "";
        for (int i = 0; i < set.size(); i++) {
            Card card = set.get(i);
            System.out.println(card);
            hand.concat(card.toString() + " ");
        }
        return hand;
    }

    public static void main (String[] args) {
        Card card1 = new Card(1);
        Card card2 = new Card(3);
        Hand set = new Hand();
        set.add(card1);
        set.add(card2);
        System.out.println(set.toString());
        System.out.println((set.getTotalValue()));
    }
}
