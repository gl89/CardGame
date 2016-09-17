/*
Gabriel Loterena
9/17/2016
Play Class
*/

import java.util.*;

public class Play{
   
   static int gamesPlayed = 0;
   int players;
   
   Game newGame = new Game();
   Scanner scan = new Scanner(System.in);   
   
   //This method plays the game
   public void playGame() {
       System.out.print("\n\n\nWelcome let's play a simple game!\n");
       newGame.setPlayers();
       newGame.participants();
       System.out.println("Games played today: " + gamesPlayed + "\n");
       if(gamesPlayed==0){//We'll only show the rules the first time
         newGame.rules();
       }
       while(!newGame.winCondition()){
         newGame.round();
       } 
       newGame.gameOver();
       playAgain();
    }
    
    //Ask if players want to play again
    public void playAgain(){
       System.out.println("\nWould you like to play again?: ");
       System.out.println("1: To play again | 2: To end session: ");
       int input = scan.nextInt();
       while( input != 1 && input!= 2){
         System.out.print("Please type 1 to play again or 2 to end session: ");
         input = scan.nextInt();
       }
       if(input==1){
         newGame = new Game();
         gamesPlayed++;
         playGame();
       }else{
         scan.close();
         System.out.println("\n\nThanks for playing!");
       }
    }
    
   public static void main(String[] args){
      Play play = new Play();
      play.playGame();
   }
}