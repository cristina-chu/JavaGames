import java.awt.*;

/** 
 * CS 1331 Summer 2012 - HW 8
 * This class creates a Basilisk, which is the second strongest monster
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */
public class Basilisk extends Monster{
  
  /**
   * constructor. It gives the specific characteristics of a basiliks to the parent class Monster
   * 
   * @param: Point start - starting position of the monster
   * */
  public Basilisk(Point start){
    super(40,20,2, start, new Color(0,191,16), 200);
    
    //moneyPts=40; health=20; speed=2; scorePts = 200
  }
}

