import java.util.*;

/* a

    An object of type Deck represents an ordinary deck of 56 playing cards.
    The deck can be shuffled, and cards can be dealt from the deck.
*/

public class Deck {

    private List<Card> deck = new ArrayList<Card>(); // An arraylist of 56 Cards, representing the deck.
    //private List<Card> graveyard = new ArrayList<Card>();
 
    public int cardsLeft=56;
    
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
    
    public void shuffle() {
      Collections.shuffle(deck);
    }
    
    public Card drawCard() {
        cardsLeft--;
        return deck.remove(deck.size()-1);
    }
    
    public Deck newDeck(){
      System.out.println("NEW DECK ISSUED\n");
      return new Deck();  
    }
    
    public void showCardsLeft(){
       System.out.println("Deck has "+cardsLeft+" cards remaining.");
    }
    public boolean isEmpty(){
      if(cardsLeft==0){return true;}
      return false;
    }   
}