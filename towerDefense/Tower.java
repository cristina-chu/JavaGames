import java.awt.*;

/** 
 * CS 1331 Summer 2012 - HW 8
 * This class is the parent-abstract class Tower. It contains all the generic characteristics of a tower
 * and all the actions that a tower should have. 
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */

public abstract class Tower{
  
  //intantiates all the variables
  private final int cost, damage, radius;
  private int health;
  private final Point position;
  private Color color;
  
  /**
   * constructor. It creates a tower with the given parameters
   * 
   * @param: int cost - cost of constructing the tower
   * @param: int damage - damage that tower inflicts on a monster
   * @param: int health - health of the tower
   * @param: Point position - position of the tower
   * @param: int radius - radius of attack of the tower
   * @param: Color color - color of the tower
   * */
  public Tower(int cost, int damage, int health, Point position, int radius, Color color){
    this.cost = cost;
    this.damage = damage;
    this.health = health;
    this.position = position;
    this.radius = radius;
  }
  
  /**
   * this method returns the health of the tower
   * 
   * @return: int health - health of tower
   * */
  public int getHealth(){
    return health;
  }
  
  /**
   * this method returns the cost of constructing the tower
   * 
   * @return: int cost - cost of building tower
   * */
  public int getCost(){
    return cost;
  }
  
  /**
   * this method returns the radius of damage of the tower
   * 
   * @return: int radius - radius of attack of tower
   * */
  public int getRadius(){
    return radius;
  }
  
  /**
   * this method draws the tower in the given Graphics object
   * 
   * @param: Graphics g - where the tower will be drawn
   * */
  public void draw(Graphics g){
    g.setColor(new Color(192,192,192,80));
    g.fillOval((int)position.getX()-radius, (int)position.getY()-radius, (radius*2), (radius*2));
    
    g.setColor(color);
    g.fillRect((int)position.getX()-6,(int)position.getY()-6,12,12);
  }
  
  /**
   * this method returns a whether a monster is in the range of damage of the tower
   * 
   * @param: Point monster 
   * @return: boolean true if monster in range, false if monster not in range.
   * */
  public boolean inRange(Point monster){
    if (Point.distance(position.getX(), position.getY(),monster.getX(), monster.getY()) <= radius)
      return true;
    else 
      return false;
  }
  
  /**
   * this method takes 2 health fromt the tower
   * */
  public void takeHealth(){
    health = health - 2;
  }
  
  /**
   * abstract method attack. Defined in child classes. 
   * 
   * @param: Monster monster
   * */
  public abstract void attack(Monster monster);
  
}