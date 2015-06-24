import java.awt.*;

/** 
 * CS 1331 Summer 2012 - HW 8
 * This class is the parent-abstract class Monster. It contains all the generic characteristics of a monster
 * and all the actions that a monster should have. 
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */
public abstract class Monster{
  
  //instantiating all the variables
  public final int moneyPts, scorePts, speed;
  public int health;
  public Point position;
  public Color color;
  
  /**
   * Constructor. It creates the monster with the specified characteristics
   * 
   * @param: int moneyPts - money awarded to player if monster is killed
   * @param: int health - health of monster
   * @param: int speed - speed of monster
   * @param: Point position - initial position of monster
   * @param: Color color - color of the monster when drawn 
   * @param: int scorePts - points awarded to player if monster is killed
   * */
  public Monster(int moneyPts, int health, int speed, Point position, Color color, int scorePts){
    this.moneyPts = moneyPts;
    this.health = health;
    this.speed = speed;
    this.position = position;
    this.color = color;
    this.scorePts = scorePts;
  }
  
  /**
   * this method returns the health of the monster
   * 
   * @return: int health - health of the monster
   * */
  public int getHealth(){
    return health;
  }

  /**
   * this method returns the money awarded to player if monster is killed
   * 
   * @return: int moneyPts - points awarded to player
   * */
  public int getMoneyPts(){
    return moneyPts;
  }
  
  /**
   * this method returns the speed of the monster
   * 
   * @return: int speed - speed of monster
   * */
  public int getSpeed(){
    return speed;
  }
  
  /**
   * this method returns the current position of the monster
   * 
   * @return: Point position - position of monster
   * */
  public Point getPosition(){
    return position;
  }
  
  /**
   * this method returns the points awarded to the player if the monster is killed
   * 
   * @return: int scorePts - score points awarded to player
   * */
  public int getScorePts(){
    return scorePts;
  }
  
  /**
   * this method sets the position of the monster to a new one
   * 
   * @param: Point newPos - the new position for the monster
   * */
  public void setPosition(Point newPos){
    position = newPos;
  }
  
  /**
   * this method takes health away from the monster
   * 
   * @param: int damage - amount of health that will be taken from the monster
   * */
  public void takeHealth(int damage){
    health = health+damage;
  }
  
  /**
   * this method draws the monster in the panel
   * 
   * @param: Graphics g - Graphics object where the monster will be drawn
   * */
  public void draw(Graphics g){
    g.setColor(color);
    g.fillOval((int)position.getX()-3,(int)position.getY()-3, 6,6);
  }

}