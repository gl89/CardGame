/*
Gabriel Loterena
9/17/2016
Game Class 
*/

import java.util.Scanner;

public class Game{
   
   //Class fields 
   public int players;
   public static int roundNum=1;
   public boolean gameOver=false;
   
   //Array of the players and their positions during the game
   public Player[] playerArr;
   public Player[] position;
   
   Scanner scan = new Scanner(System.in);
   Deck d = new Deck();
   
   //States the rules
   public void rules(){
      System.out.print("Welcome! This is a simple card game for party size of a 2-4 players.");
      System.out.print("\nThe game is simple! There will be one deck that each player will draw from.");
      System.out.print("\nEach deck consists of 56 cards.It includes your standard suits and face values"); 
      System.out.print("\nalong with FOUR special penalty cards.There will be rounds consisting of each");
      System.out.print("\nplayer drawing one card. Before each round the deck is shuffled. If a deck runs out"); 
      System.out.print("\na new deck will be issued.Scoring is as follows: The player that draws the highest card");
      System.out.print("\nvalue is given TWO points and all others are given ZERO points If you're unfortunate enough to");
      System.out.print("\ndraw a PENALTY card MINUS one point is taken from your score. To win the game a player must");
      System.out.print("\nhave a score of 21 or greater AND must win by TWO. Rounds continue until a winner is crowed!");
      System.out.print("\nPress any key to continue: ");
      scan.nextLine();
      scan.nextLine();
   }
   
   //Prompts a player to set the number of players
   public void setPlayers(){
      System.out.print("Please choose the number of players(2-4): ");
      int numPlayers = scan.nextInt();
      while( numPlayers < 2 || numPlayers > 4){
         System.out.print("The number must be between 2 & 4 inclusive: ");
         numPlayers = scan.nextInt();
      }
      players = numPlayers;
   }
   
   //Insertion sort to sort positions after scoring
   public void posSort(Player[] pos){
        int i;
        Player key;// the item to be inserted  
        for (int j = 1; j < pos.length; j++){  
              key = pos[j];
              for( i = j - 1; (i >= 0) && (pos[i].getScore() < key.getScore()); i--){  
                    pos[i+1] = pos[i];
             }
             pos[i+1] = key;// Put the key in its proper location
        }
   }
   
   //Creates the players and sets their initial posotions
   public void participants(){
      playerArr = new Player[players]; 
      position = new Player[players]; 
      for(int pl = 0; pl < players; pl++){ 
         playerArr[pl] = new Player("Player"+(pl+1));//Player names Player#
         position[pl] = playerArr[pl]; 
      }
   }
   
   //Shows players positions
   public void showPos(){
      System.out.print("Current positions| ");
      for(int pl = 0; pl < players; pl++){
         System.out.print(position[pl]+" | ");
      }
      System.out.println();
   }
    //One complete round
   public void round(){
      System.out.println("\n----------------------------------------------------------------------------------------------------");
      System.out.println("\n\nROUND "+roundNum+" ");
      showPos(); //Scoreboard
      d.showCardsLeft();
      
      int high=Integer.MIN_VALUE;//Value of highest card value
      int winner=0;//index of the winner
     
      //shuffle deck before round beings
      d.shuffle();
      
      //Each player draws a card 
      for(int i=0;i < players; i++){//look at this.
         
         if(d.isEmpty()){//issure a new deck if the deck is empty and shuffle it.
            d = d.newDeck();
            d.shuffle();
            System.out.print(playerArr[i].getName()+" press any key to draw a card.");
            scan.nextLine();
            playerArr[i].setCard(d.drawCard());
            //conditions based on suite of the card drawn
            if(playerArr[i].getCard().getSuitAsString()=="PENALTY"){
               playerArr[i].penalty();
               System.out.println(playerArr[i].getName()+" drew a PENALTY! *SAD TRUMBONE*");
            }else{
               System.out.println(playerArr[i].getName()+" drew "+playerArr[i].getCard());
            }
            
         }else{ //same as above with a non-empty deck
            System.out.print(playerArr[i].getName()+" press [ENTER] to draw a card.");
            scan.nextLine();
            playerArr[i].setCard(d.drawCard());
            if(playerArr[i].getCard().getSuitAsString()=="PENALTY"){
               playerArr[i].penalty();
               System.out.println(playerArr[i].getName()+" drew a PENALTY! *SAD TRUMBONE*");
            }else{
               System.out.println(playerArr[i].getName()+" drew "+playerArr[i].getCard());
            }
         }
         
         System.out.println();
      } 
      //Figures out who won the round
      for(int i=0;i < players; i++){
         if(playerArr[i].getCard().scoreValue()>high){
            winner = i;
            high = playerArr[i].getCard().scoreValue();
         }
      } 
      //Declare winner, update score,increment round and reposition them
      System.out.println(playerArr[winner].getName() + " wins ROUND "+roundNum+"!\n\n");   
      playerArr[winner].addScore();
      roundNum++;
      posSort(position);
   }
   
   /*This is checked after positions are determined
   Must have a score equal to 21 or greater AND 1st must win be 2 more than 2nd place
   Change this to only update at end of round */
   public boolean winCondition(){
     if(position[0].getScore() >= 21 && (position[0].getScore()-position[1].getScore()) > 1){
       gameOver = true;
     }
     return gameOver;
   }
   
   //Shows end of game scoring and the winner of the game
   public void gameOver(){
       System.out.println("----------------------------------------------------------------------------------------------------");
       showPos();
       System.out.println(position[0].getName()+" has won the game!");
   }
}