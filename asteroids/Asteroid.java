import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * Represents an Asteroid for the game of Asteroids
 * 
 * @author Elizabeth
 *
 */
public class Asteroid {
 private int vX, vY;
 private int size;
 private static Random rand = new Random();
 private static final int MIN_SIZE = 12;
 private Point pos;
 private Rectangle field,bounds;
 private ImageIcon img;
 
 /**
  * Creates a new Asteroid for the given playing field - uses constructor chaining to 
  * set the instance data of the Asteroid
  * 
  * @param field the field in which the asteroid can move
  */
 public Asteroid(Rectangle field){   
   this(field,new Point(rand.nextInt((int)field.getWidth()),rand.nextInt((int)field.getHeight())),24);
 }
 
 /**
  * Creates a new Asteroid for the given field, with the specified size and position.
  * Also sets up the bounding box for the asteroid (bounding boxes are used in collision detection)
  *  
  * @param field the filed in which the asteroid can move
  * @param pos the initial position of the asteroid
  * @param size the size of the asteroid
  */
 public Asteroid(Rectangle field, Point pos, int size){
   this.field = field; 
   this.pos = pos;
   this.size = size;
   
   this.bounds = new Rectangle(pos,new Dimension(size+3,size+3)); 
   
   //Assigns a random integer in [-2,2] to the velocities in X and Y
   vX = rand.nextInt(5)-2;
   vY = rand.nextInt(5)-2;
   
   img = new ImageIcon("asteroid" + size +".png");
 }
 
 /**
  * Moves the asteroid.
  */
 public void move(){
   //checks that the velocities vX and vY are not both 0
   if (vX==0 && vY==0){
     vX = rand.nextInt(5)-2;
     vY = rand.nextInt(5)-2;}

   //translates the asteroid by adding the velocities to each coordinate
   pos.translate(vX,vY);
   bounds.setLocation(pos);
   
   //makes the asteroid "wrap around" the playing field
   switch (field.outcode(pos)) {
   case (Rectangle.OUT_BOTTOM):
    pos.translate(0, -field.height);
    break;
   case (Rectangle.OUT_TOP):
    pos.translate(0, field.height);
    break;
   case (Rectangle.OUT_RIGHT):
    pos.translate(-field.width, 0);
    break;
   case (Rectangle.OUT_LEFT):
    pos.translate(field.width, 0);
    break;
  }
 }
 
 /**
  * Draws the asteroid - uses an image icon that is based on the size of the asteroid
  * 
  * @param g The graphics object that the asteroid is drawn on
  */
 public void draw(Graphics g){
  img.paintIcon(null, g, pos.x, pos.y);
 }
 
 /**
  * Checks to see if the Asteroid collides with another object's bounding box
  * 
  * *NOTE: Passing in the bounding box instead of the actual object is a little bit strange,
  * but it works Later on when we learn inheritance we will learn a better way to do things 
  * like this.
  * 
  * @param shape The bounding box of the object we are checking collision with
  * @return true if a collision occurred
  */
 public boolean collide(Rectangle shape){
   if (shape.intersects(bounds) == true) 
     return true;
   else
     return false;
 }
 
 /**
  * When a large asteroid is hit, it splits into two smaller asteroids.
  * 
  * To use the provided images as image icons, sizes for asteroids should be 24, 18, or 12
  * 
  * @return an ArrayList with the two asteroids produced by the split - if the current asteroid
  * is the smallest possible size, the ArrayList should be empty
  * 
  */
 public ArrayList<Asteroid> split(){
   ArrayList<Asteroid> splitA = new ArrayList<Asteroid>();
   if (size == 12)
     return splitA;
   else if (size == 18){
     splitA.add(new Asteroid(this.field, new Point((int)pos.getX()+3,(int)pos.getY()+3), 12));
     splitA.add(new Asteroid(this.field, new Point((int)pos.getX()-3,(int)pos.getY()-3), 12));
     return splitA;}
   else if (size==24){
     splitA.add(new Asteroid(this.field, new Point((int)pos.getX()-3,(int)pos.getY()-3), 18));
     splitA.add(new Asteroid(this.field, new Point((int)pos.getX()+3,(int)pos.getY()+3), 18));
     return splitA;}
   else
     return splitA;
}
}
