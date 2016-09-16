public class Player{
   
   public String name;
   public int score;//inital starting score;
   public Card card_drew;
   
   
   public Player(String fname){
      name = fname; 
      score = 0; 
      card_drew=null;
   }
  
   public Card getCard(){
      return card_drew;
   }
   public int getScore(){
      return score;
   }
   
   public String getName(){
      return name;
   }
   
   public void penalty(){
      if(score>0){
         score--;
      }
   }
   
   public void win(){
      score+=2;
   }
   
   public void setCard(Card c){
      card_drew = c;
   }
   
   public String toString() {   
     return getName() + " " + getScore();
   }

}