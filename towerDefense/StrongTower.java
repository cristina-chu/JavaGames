import java.awt.*;

/** 
 * CS 1331 Summer 2012 - HW 8
 * this class creates a Strong Tower
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */

public class StrongTower extends Tower{
  
    /**
   * constructor. It gives the specific characteristics of the strongest tower to the constructor of parent class Tower
   * 
   * @param: Point pos - position of the tower
   * */
  public StrongTower(Point pos){
    super(-500,5,15,pos,80, Color.red);
    
    //cost=500; damage=5; health=15; radius=80
  }
  
   /**
   * This method takes a monster's health when in range of the tower
   * 
   * @param Monster monster
   * */
  public void attack(Monster monster){
    monster.takeHealth(-3);
  }
  
}