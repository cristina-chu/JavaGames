import java.awt.*;

/** 
 * CS 1331 Summer 2012 - HW 5
 * This class creates darts with given x and y coordinates
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */
public class Dart{
  
  /*instantiates variables for x coordinate and y coordinate*/
  private int xPos, yPos;
  
  /**
   * Constructor method
   * It sets the values of the dart's x and y coordinates with the values given by user. 
   * 
   * @param: xPos - integer denoting x coordinate
   * @param: yPos - integer denoting y coordinate
   * */
  public Dart (int xPos, int yPos){
    this.xPos = xPos; //setting coordinates of dart with values given by user
    this.yPos = yPos;
  }// ends Constructor method
  
  /**
   * draw method
   * It draws the dart at its x-y coordinate in a given Graphics window
   * 
   * @param: g - a Graphics window
   * */
  public void draw(Graphics g){
    //obtaining top left corner coordinates by subtracting 5 from given coordinates (center coordinates)
    int xCenter = xPos-5;
    int yCenter = yPos-5;
    
    g.setColor(Color.cyan); //set cyan as color of darts on dartboard 
    
    g.fillOval(xCenter,yCenter,10,10); //draw small cyan circle to denote dart
  } //ends draw method 
} // ends Dart class
    
  
  
  
  