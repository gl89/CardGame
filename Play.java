import java.util.*;

public class Play{
   
   static int gamesPlayed = 0;
   Game ng = new Game();
   Scanner scan = new Scanner(System.in);   
   int players;
   //This should do evetything;
   public void playGame() {
       System.out.println("\n\nWelcome let's play a simple game!");
       ng.setPlayers();
       ng.partic();
       if(gamesPlayed==0){
         ng.rules();
       }
       while(!ng.WINC()){
         ng.round();
       } 
       ng.gameOver();
       playAgain();
    }
    
    public void playAgain(){
       System.out.println();
       System.out.println("Would you like to play again?: ");
       System.out.print("1: To play again | 2: To end session: ");
       int input = scan.nextInt();
       while( input != 1 && input!= 2){
         System.out.print("Please type 1 to play again or 2 to end session: ");
         input = scan.nextInt();
       }
       if(input==1){
         ng = new Game();
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