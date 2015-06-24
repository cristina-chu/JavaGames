import javax.swing.*;
import java.awt.*;

/** 
 * CS 1331 Summer 2012 - HW 8
 * This class creates the frame with the GamePanel, ControlPanel, and entire game. 
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */
public class TowerDefenseGame{
  
  //instantiates variables
  private JPanel main;
  private ControlPanel control;
  private GamePanel game;
  private Path path;
  
  /**
   * Main method - It instantiates the frame and adds the GamePanel and ControlPanel 
   */
  public static void main(String[] args) {
    //creates frame and sets some specifics for it
    JFrame frame = new JFrame("Tower Defense");
    frame.setPreferredSize(new Dimension(1020, 810));
    frame.setBackground(new Color(191,0,10));
    
    //creates a main panel that will hold the ControlPanel and GamePanel
    JPanel main = new JPanel(new FlowLayout());
    
    //instantiates path, ControlPanel and GamePanel
    Path path = new Path("path.txt");
    ControlPanel control = new ControlPanel(path);
    GamePanel game = new GamePanel(control,frame,path);
    
    //adds all panels to main panel
    main.add(control);
    main.add(game);
    
    //adds main to frame and sets other characteristics to the frame.
    frame.add(main);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
 }
}