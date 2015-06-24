import java.awt.*;

/** 
 * CS 1331 Summer 2012 - HW 8
 * This class creates a troll, which is the weakest monster
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */
public class Troll extends Monster{

  /**
   * Constructor. It gives the specific characteristics of a troll to the parent class Monster
   * 
   * @param: Point start - starting position of the monster
   * */
  public Troll(Point start){
    super(20,15,1,start, new Color(64,49,122),100);
    
    //moneyPts=20; health=15; speed=1; scorePts=100
  }
}