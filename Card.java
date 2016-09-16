public class Card {
   
   
   public final static int SPADES = 0;   
   public final static int HEARTS = 1;
   public final static int DIAMONDS = 2;
   public final static int CLUBS = 3;
   
   public final  int ACE = 1;      
   public final  int JACK = 11;    
   public final  int QUEEN = 12;   
   public final  int KING = 13;
   public final  int JOKER = -1;
   
   private final int suit; 
   private final int value;
   
   public Card(){
      value = -1;
      suit = JOKER;
   }
   
   
   public Card(int theValue, int theSuit) {
      value = theValue;
      suit = theSuit;
   }

   public int getSuit() {
      return suit;
   }
   
   public int getValue() {
      
      
      return value;
   }
   
   public int scoreValue(){
     switch ( suit ) {
           case JOKER:   return  0;
           case SPADES:   return 4*value;
           case HEARTS:   return 3*value;
           case DIAMONDS: return 2*value;
           case CLUBS:    return value;
           default:       return 0;
        }
   }
   
   public String getSuitAsString() {
        switch ( suit ) {
           case JOKER:   return "JOKER";
           case SPADES:   return "Spades";
           case HEARTS:   return "Hearts";
           case DIAMONDS: return "Diamonds";
           case CLUBS:    return "Clubs";
           default:       return "?";
        }
    }
    
    public String getValueAsString() {
        switch ( value ) {
           case -1: return "-1";
           case 1:   return "Ace";
           case 2:   return "2";
           case 3:   return "3";
           case 4:   return "4";
           case 5:   return "5";
           case 6:   return "6";
           case 7:   return "7";
           case 8:   return "8";
           case 9:   return "9";
           case 10:  return "10";
           case 11:  return "Jack";
           case 12:  return "Queen";
           case 13:  return "King";
           default:  return "?";
        }
    }
    
    public String toString() {
           // Return a String representation of this card, such as
           // "10 of Hearts" or "Queen of Spades".
        return getValueAsString() + " " + getSuitAsString();
    }

   
  
  } // end class Card