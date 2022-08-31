/**
 * File: Deck.java
 * Author: Linh Phan
 * Date: 02/08/2022
 * Course: CS231 A
 * Project 1
 * 
 * Deck class hold a set of cards and be able to shuffle and deal the cards. 
 * 
 * How to run: enter "javac Deck.java"
 *          then enter "java Deck"
 */

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    // initialize the ArrayList.
    private ArrayList<Card> deck;
    
    /*
    public Deck() builds a deck of 52 cards, 4 each of cards with values 
    2-9 and 11, and 16 cards with the value 10. 
    Note, you probably want the constructor to call the build() method, below.
    */
    public Deck(){
        // dynamic momery lost every time shuffle() is called
        this.deck = new ArrayList<Card>();
        build();
    }

    /* builds a deck of 52 cards, 4 each of cards with values 2-9 and 11, 
    and 16 cards with the value 10.
    */
    public void build() {
        // create 16 cards with the value 10
        for (int i = 0; i < 16; i++) {
            Card D = new Card(10);
            this.deck.add(D);
        }
        // create 4 each of cards with values 2-9 
        for (int i = 2; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                Card D = new Card(i);
                this.deck.add(D);
            }   
        }

        // create 4 each of cards with value 11
        for (int i = 0; i < 4; i++) {
            Card D = new Card(11);
            this.deck.add(D);
        }
    }

    // returns the number of cards in the deck.
    public int size() {
        return this.deck.size();
    }

    // returns the top card (position zero) and removes it from the deck.
    public Card deal() {
        return this.deck.remove(0);
    }

    // get card at position but does not delete the card
    public Card getCard(int i){
        return this.deck.get(i);
    }

    // shuffles the deck. 
    public void shuffle() {
        // this dynamic momery lost every time shuffle() is called, except for the first time
        ArrayList<Card> new_deck = new ArrayList<Card>();
        int deck_size = this.deck.size();
        // create an instance of the Random() method
        Random rand = new Random();

        for (int i = 0; i < deck_size; i++)
        {
            // generate random int within the number of item lefts
            int val = rand.nextInt(this.deck.size());
            // print out the item removed
            // System.out.println("The item removed: " + this.deck.get(val));
            // put the item removed in a new list
            new_deck.add(this.deck.get(val));
            // remove the item 
            this.deck.remove(val);
        }
        this.deck = new_deck;
    }

    /* returns a String that has the contents of the deck "written" in 
    a nice format (so that you can see the ordering of the card values).
    */
    public String toString() {
        String deckStr = "";
        // loop through every card inside deck
        for (int i = 0; i < this.deck.size(); i++){
            Card card = this.deck.get(i);
            deckStr += card.toString() + " ";
        }
        return deckStr;
    }

    public static void main (String[] args) {
        // this dynamic momery lost when the shuffle() is called
        Deck cardDeck = new Deck();
        System.out.println("The size of the Deck: " + cardDeck.size());
        // get the top card out of deck
        // System.out.println("The top card of the deck: " + cardDeck.deal());
        // pick the card at position 1
        // System.out.println("The card at position 1: " + cardDeck.pick(1));
        System.out.println("The value of the card: " + cardDeck.toString());
        // shuffle the deck and print out the value
        cardDeck.shuffle();
        System.out.println("The value of the card: " + cardDeck.toString());
        System.out.println("The size of the Deck: " + cardDeck.size());
        // shuffle the deck and print out the value
        cardDeck.shuffle();
        System.out.println("The value of the card: " + cardDeck.toString());
        System.out.println("The size of the Deck: " + cardDeck.size());
    }
}
