import java.awt.*;

/** 
 * CS 1331 Summer 2012 - HW 8
 * this class creates a FastTower
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */

public class FastTower extends Tower{
  
  /**
   * constructor. It gives the specific characteristics of the 2nd strongest fast tower to the parent constructor of class Tower
   * 
   * @param: Point pos - position of the tower
   * */
  public FastTower(Point pos){
    super(-350,2,10,pos,60, Color.green);
    
    //cost=-350; damage=-2; health=10; radius=60
  }
  
  /**
   * This method takes a monster's health when in range of the tower
   * 
   * @param Monster monster
   * */
  public void attack(Monster monster){
    monster.takeHealth(-2);
  }
  
}