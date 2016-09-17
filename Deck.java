/*
Gabriel Loterena
9/17/2016
Deck Class: The construction of a deck of cards and methods on how to use the deck
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Deck{
   
    //Clsss fields
    public int cardsLeft=56;
    public final List<Card> deck = new ArrayList<Card>(); // An arraylist of 56 Cards, representing the deck.
    
    //Creates the first 52 cards and adds the 4 penalty cards.
    public Deck() {
       for ( int suit = 0; suit <= 3; suit++ ) {
          for ( int value = 1; value <= 13; value++ ) {
             deck.add(new Card(value,suit));
          }
       }
       deck.add(new Card());
       deck.add(new Card());
       deck.add(new Card());
       deck.add(new Card());
    }
    
    //Shuffle used before every round & new deck. 
    public void shuffle() {
      Collections.shuffle(deck);
    }
    
    //A person draws from the 'top' of the deck
    public Card drawCard() {
        cardsLeft--;
        return deck.remove(deck.size()-1);
    }
    
    //Creates a new Deck for play 
    public Deck newDeck(){
      System.out.println("NEW DECK ISSUED\n");
      return new Deck();  
    }
    
    //Simply shows the amount of cards left. 
    public void showCardsLeft(){
       System.out.println("Deck has " + cardsLeft + " cards remaining.\n");
    }
    
    //returns true if there are no more cards left
    //could have used Arraylist.size() method too
    public boolean isEmpty(){
      if(cardsLeft==0){return true;}
      return false;
    }   
}