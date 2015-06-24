/*import statements for JPanel, events, Random class and DecimalFormat*/
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*; 
import java.text.DecimalFormat;

/** 
 * CS 1331 Summer 2012 - HW 5
 * This class creates the panel with the drawn Dartboad, printing darts thrown and score on console 
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */
public class DartboardPanel extends JPanel{
 
  /*Instantiates the variables to be used throughout the class*/
  private int darts,score;
  private double average;
  private Random rand = new Random();
  private DecimalFormat fmt = new DecimalFormat("0.#");
  private boolean fix;
  
  /**
   * Constructor method
   * It creates a DartboardPanel, and receives number of darts to be drawn on dartboard
   * 
   * @param: darts - integer denoting number of darts to be drawn on dartboard
   * */
  public DartboardPanel(int darts){ 
    setPreferredSize(new Dimension(500,500)); //sets panel size to 500x500
    
    this.darts = darts;
    fix = true; //boolean used to prevent multiple scores from printing
  } //ends DartboardPanel Constructor
  
  /**
   * paintComponent method
   * This method draws the dartboard and darts on a Graphics window
   * 
   * @param: g - Graphics window for dartboard and darts to be drawn on 
   * */
  public void paintComponent(Graphics g){    
    /*drawing the bullseye pattern of the dartboard*/
    g.setColor(Color.darkGray);
    g.fillRect(0,0,500,500);
    g.setColor(Color.white);
    g.fillOval(0,0,500,500);
    g.setColor(Color.lightGray);
    g.fillOval(30,30,440,440);   
    g.setColor(Color.white);
    g.fillOval(60,60,380,380);    
    g.setColor(Color.lightGray);
    g.fillOval(90,90,320,320);    
    g.setColor(Color.white);
    g.fillOval(120,120,260,260);    
    g.setColor(Color.lightGray);
    g.fillOval(150,150,200,200);
    g.setColor(Color.white);
    g.fillOval(180,180,140,140);
    g.setColor(Color.lightGray);
    g.fillOval(210,210,80,80);
    g.setColor(Color.red);
    g.fillOval(240,240,20,20);
    
    score = 0; //setting score to 0, before the darts are drawn
    
    /*Drawing given number of darts on dartboard*/
    for (int i=0;i<darts;i++){
      /*generates a random numbers between 0 and 500 for x and y coordinates of dart*/
      int x = rand.nextInt(501);
      int y = rand.nextInt(501);
      
      Dart dart = new Dart(x, y); //a dart object is instantiated with random coordinates
      dart.draw(g); //dart is drawn on dartboard window
      
      double points = Math.sqrt(Math.pow((500.0-x),2.0)+Math.pow((500.0-y),2.0)); //points of dart are calculated using distance formula
      score = score+(int)points; //points are then added to overall score
      } //ends for loop
    
    if (fix==true){ 
      average = (double)score/darts; //average points earned per dart
    
      System.out.println("Threw "+darts+" darts."); //prints number darts thrown 
      System.out.println("Average points per dart: "+fmt.format(average)); //prints average points earned per dart
      
      fix = false; //assigning false to fix variable prevents results from printing more than once thanks to conditional 
    } //ends conditional statement if
  } // ends paintComponent method
} //ends DartboardPanel class