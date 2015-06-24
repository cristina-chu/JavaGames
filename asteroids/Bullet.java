import java.awt.*;

/**
 * A bullet object. Used to shoot at things. Specifically Asteroids.
 * 
 * @author Elizabeth
 *
 */
public class Bullet {
 private Point pos;
 private Rectangle field, bounds;
 private double rotation;
 private int vel = 12;
 
 /**
  * Makes a new bullet for the given playing field. Bullet is located at the given position with the given 
  * rotation. 
  * 
  * @param field the field in which the bullet is valid/active
  * @param pos the position of the bullet
  * @param rotation angle of rotation of the bullet
  */
 public Bullet(Rectangle field, Point pos, double rotation){
   this.field = field; 
   this.pos = pos;
   this.rotation = rotation;
   
   this.bounds = new Rectangle(pos, new Dimension(1,1)); 
 
 }
 
 /**
  * Figure out if the bullet hit the asteroid
  * 
  * @param a The asteroid 
  * @return true if the bullet hit the asteroid, false otherwise
  */
 public boolean hit(Asteroid a){
   if (a.collide(bounds) == true)
     return true;
   else
     return false;
 }
 
 /**
  * Draws the bullet
  * 
  * @param g Graphics object on which the bullet is drawn
  */
 public void draw(Graphics g){
  g.setColor(Color.red);
  g.fillOval(pos.x,pos.y,3,3);
  g.setColor(Color.black);
 }
 
 /**
  * Moves the bullet along the right trajectory based on the rotation of the ship when fired
  */
 public void move(){
  pos.translate((int)(Math.cos(rotation)*vel), (int)(Math.sin(rotation)*vel));
  bounds.setLocation(pos);
 }
 
 /**
  * Determines if the bullet is off of the screen (outside of the playing field)
  * @return boolean - true if bullet is offscreen, false if not. 
  */
 public boolean isOffScreen(){
   if (pos.getX() == 0){
     pos.setLocation(500,pos.getY());
     return true;}
   else if (pos.getX() == 500){
     pos.setLocation(0,pos.getY());
     return true;}
   else if (pos.getY() == 0){
     pos.setLocation(pos.getX(),500);
     return true;}
   else if (pos.getY() == 500){
     pos.setLocation(pos.getX(), 0);
     return true;}
   else
     return false;
 }
}
