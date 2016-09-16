import java.util.*;

public class Play{
   
   static int gamesPlayed = 0;
   Game ng = new Game();
   Scanner scan = new Scanner(System.in);   
   int players;
   //This should do evetything;
   public void playGame() {
       System.out.println("Welcome let's play a simple game!");
       System.out.print("How many players?: ");
       players = scan.nextInt();
       ng.setPlayers(players);
       ng.setPlayers(players);
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
       System.out.print("Would you like to play again?(1/2): ");
       int input = scan.nextInt();
       if(input==1){
         ng = new Game();
         gamesPlayed++;
         playGame();
       }else{
         scan.close();
         System.out.println("Thanks for playing!");
       }
    }
    
 
   public static void main(String[] args){
      Play play = new Play();
      play.playGame();
   }
}