import java.awt.*;

/** 
 * CS 1331 Summer 2012 - HW 8
 * This class creates a Dragon, which is the strongest monster
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */
public class Dragon extends Monster{
  
  /**
   * Constructor. It gives the specific characteristics of a dragon to the parent class Monster
   * 
   * @param: Point start - starting position of the monster
   * */
  public Dragon(Point start){
    super(80,30,3, start, new Color(227,0,159), 300);
    
    //moneyPts=80; health=30; speed=3; scorePts=300
  }
}