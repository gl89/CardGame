

public class Game{

   public int players;
   public Player[] PP;
   public boolean won = false; 
   
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
         System.out.println(PP[pl]+" ");
      }

   }
   

    
    
    public static void main(String[] args){
    Game g = new Game();
    g.setPlayers(2);
    g.partic();
    g.show();
    }
}