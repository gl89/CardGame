import java.util.*;

/* a

    An object of type Deck represents an ordinary deck of 56 playing cards.
    The deck can be shuffled, and cards can be dealt from the deck.
*/

public class Deck {

    private List<Card> deck = new ArrayList<Card>(); // An arraylist of 56 Cards, representing the deck.
    //private List<Card> graveyard = new ArrayList<Card>();
 
    public int cardsUsed=0;
    
    public Deck() {
       int cardCt = 0; // How many cards have been created so far.
       for ( int suit = 0; suit <= 3; suit++ ) {
          for ( int value = 1; value <= 13; value++ ) {
             deck.add(new Card(value,suit));
             cardCt++;
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
        
        return deck.remove(deck.size()-1);
    }
   
    

   /*
   public static void main(String[] args){
      Deck d = new Deck();
      Scanner scan = new Scanner(System.in);
      int answer;
      do{
         d.shuffle();
         System.out.println(d.drawCard());
         answer = scan.nextInt();
      }while(answer == 1);
   }
   */
}