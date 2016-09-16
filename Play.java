import java.util.*;

public class Play{

   Game ng = new Game();
   Scanner scan = new Scanner(System.in);   
   int players;
   //This should do evetything;
   public void Play() {
       System.out.println("Welcome let's play a simple game!");
       System.out.print("How many players?: ");
       players = scan.nextInt();
       ng.setPlayers(players);
       ng.partic();
       ng.show();
   }
   public static void main(String[] args){
    Play g = new Play();
    g.Play();
    }
}