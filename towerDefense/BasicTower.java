import java.awt.*;

/** 
 * CS 1331 Summer 2012 - HW 8
 *This class creates a Basic Tower
 * 
 * @author: Cristina Chu
 * @version: 1.0
 * */

public class BasicTower extends Tower{
  
  /**
   * constructor. It gives the specific characteristics of the weak basic tower to the constructor of parent class Tower
   * 
   * @param: Point pos - position of the tower
   * */
  public BasicTower(Point pos){
    super(-100,1,5,pos,40, Color.black);
    
    //cost=100; damage=1; health=5; radius=40, color=black
  }
  
  /**
   * This method takes a monster's health when in range of the tower
   * 
   * @param Monster monster
   * */
  public void attack(Monster monster){
    monster.takeHealth(-1);
  } 
}