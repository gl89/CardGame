/*
Gabriel Loterena
9/17/2016
Player class: The construction of one player
*/

public class Player{
   
   //class fields
   public int score;
   public final String name;
   public Card cardDrawn;
   
   //Player constructor
   public Player(String playerName){
      name = playerName; 
      score = 0; 
      cardDrawn=null;
   }
   
   //Sets the card the player draws
   public void setCard(Card c){
      cardDrawn = c;
   }
  
  //Access methods
   public Card getCard(){
      return cardDrawn;
   }
   
   public int getScore(){
      return score;
   }
   
   public String getName(){
      return name;
   }
   
   //Removes 1 point if player draws a penalty
   public void penalty(){
      if(score>0){
         score--; 
      }
   }
   
   //Awards 2 points if player wins
   public void addScore(){
      score+=2;
   }
   
   public String toString() {   
      return getName() + " " + getScore() + " points";
   }
}