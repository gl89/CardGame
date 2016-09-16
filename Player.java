public class Player{
   
   public String name;
   public int score;//inital starting score;
   
   public Player(String fname){
      name = fname; 
      score = 0; 
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
      score++;
   }
   
   public String toString() {   
     return getName() + " " + getScore();
   }

}