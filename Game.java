

public class Game{

   public int players;
   Deck d = new Deck();
   public Player[] PP;
   public boolean win=false;
   
   public void setPlayers(int numPlayers){
      players = numPlayers;
   }
   
   
   public void partic(){
      PP = new Player[players];
      for(int pl = 0; pl < players; pl++){
         PP[pl] = new Player("Player "+(pl+1));
      }
   
   }
   
   public void show(){
      for(int pl = 0; pl < players; pl++){
         System.out.print(PP[pl]+" ");
         
      }
      System.out.println();
   }
   
    public void round(){
      int high=-100;
      int winner = 0;
      //everyone draws
      for(int i=0;i < players; i++){
         PP[i].setCard(d.drawCard());
         if(PP[i].getCard().getSuitAsString()=="JOKER"){
            PP[i].penalty();
         }
      } 
      //go back to class means value
      for(int i=0;i < players; i++){
         if(PP[i].getCard().scoreValue()>high){
            winner = i;
            high = PP[i].getCard().scoreValue();
         }
      }    
      PP[winner].win();
     }
   
   public boolean WINC(){
      for(int i=0;i < players; i++){
         if(PP[i].getScore()>= 21){
            win = true;
         }
      }   
      return win;
   }

    
 
    public static void main(String[] args){
    Game g = new Game();
    g.setPlayers(2);
    g.partic();
    
    while(!g.WINC()){
       g.round();
       g.show();
      }
    }
}