import java.util.*;

public class Game{
   
   int roundNum = 1;
   public int players;
   public boolean win=false;
   
   public Player[] PP;
   public Player[] position;
   
   Scanner scanner = new Scanner(System.in);
   Deck d = new Deck();
   
   public void rules(){
   System.out.println("Welcome! This is a simple card game for party size of a 2-4 players");
   System.out.println("The game is simple! There will be one deck that each player will draw from.");
   System.out.println("Each deck consists of 56 cards.It includes your standard suits and face values");
   System.out.println("along with FOUR special penalty cards.");
   System.out.println("There will one round consisting of each player drawing one card. Before each round the deck is shuffled");
   System.out.println("If a deck runs out a new deck will be issued.");
   System.out.println("Scoring is simple: The player that draws the highest card value is given TWO points, all others are given ZERO");
   System.out.println("If you're unfortunate enough to draw a PENALTY card MINUS one point is taken from your score.");
   System.out.println("To win the game a player must have a score of 21 or greater AND must win by TWO.");
   System.out.println("Rounds continue until a winner is crowed!");
   System.out.print("Press any key to continue: ");
   scanner.nextLine();
   System.out.println();
   }
   
   public void setPlayers(int numPlayers){
      players = numPlayers;
   }
   
   //somekind of sort
   public void PositionSort(Player[] pos){
        int i;
        Player key;                // the item to be inserted  
        for (int j = 1; j < pos.length; j++){  
              key = pos[j];
              for( i = j - 1; (i >= 0) && (pos[i].getScore() < key.getScore()); i--){  
                    pos[i+1] = pos[i];
             }
             pos[i+1] = key;    // Put the key in its proper location
        }
   }
   
   public void partic(){
      PP = new Player[players]; //actual players
      position = new Player[players]; //positions of said players
      for(int pl = 0; pl < players; pl++){ //create players
         PP[pl] = new Player("Player"+(pl+1));
         position[pl] = PP[pl]; //initial order just them
      }
   }
   
   /*
   public void show(){
      System.out.print("Current score| ");
      for(int pl = 0; pl < players; pl++){
         System.out.print(PP[pl]+" | ");
      }
      System.out.println();
   }
   */
   
   public void show_pos(){
      System.out.print("Current positions| ");
      for(int pl = 0; pl < players; pl++){
         System.out.print(position[pl]+" | ");
      }
      System.out.println();
   }
   
    public void round(){
      System.out.println("----------------------------------------------------------------------------------------------------");
      System.out.println("ROUND "+roundNum+" ");
      //show();
      show_pos();
      d.showCardsLeft();
      
      System.out.println();
      int high=Integer.MIN_VALUE;
      int winner=0;
      //shuffle
      d.shuffle();
      //everyone draws
      for(int i=0;i < players; i++){//look at this.
         if(d.isEmpty()){
            d = d.newDeck();
            d.shuffle(); //need to shuffle this
            System.out.print(PP[i].getName()+" press any key to draw a card.");
            scanner.nextLine();
            PP[i].setCard(d.drawCard());
            System.out.println(PP[i].getName()+" drew "+PP[i].getCard());//add just penalty
            if(PP[i].getCard().getSuitAsString()=="PENALTY"){
               PP[i].penalty();
            }
         }else{
         
            System.out.print(PP[i].getName()+" press any key to draw a card.");
            scanner.nextLine();
            PP[i].setCard(d.drawCard());
            System.out.println(PP[i].getName()+" drew "+PP[i].getCard());//add just penalty
            if(PP[i].getCard().getSuitAsString()=="PENALTY"){
               PP[i].penalty();
            }
         }
         
         System.out.println();
      } 
      //go back to class means value
      for(int i=0;i < players; i++){
         if(PP[i].getCard().scoreValue()>high){
            winner = i;
            high = PP[i].getCard().scoreValue();
         }
      } 
      System.out.println(PP[winner].getName() + " wins ROUND "+roundNum+"!");   
      PP[winner].win();
      roundNum++;
      PositionSort(position);
      System.out.println();
   }
   
   //Must have a score equal to 21 or greater AND 1st must win be 2 more than 2nd place
   //Change this to only update at end of round
   public boolean WINC(){
     if(position[0].getScore() >= 21 && (position[0].getScore()-position[1].getScore()) >1){
       win = true;
     }
     return win;
   }

    public static void main(String[] args){
    
    Game d = new Game();
    d.setPlayers(3);
    d.partic();
    d.rules();
    while(!d.WINC()){
       d.round(); 
    }
    System.out.println("----------------------------------------------------------------------------------------------------");
    d.show_pos();
    System.out.println(d.position[0].getName()+" has won the game!");
   }
}