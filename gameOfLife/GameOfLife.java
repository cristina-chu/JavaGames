import javax.swing.*;
import java.awt.*;

/** 
 * CS 1331 Summer 2012 - HW 7
 * This class creates a new Game of Life GUI
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */

public class GameOfLife{
  
  //instantiates variables
  private static final int ROWS = 20;
  private static final int COLUMNS = 20;
  private JPanel main;
  private Life life;
  private LifePanel lifePanel;
  private ControlPanel control;
  
  /**
   * Main method - It instantiates the frame and adds the LifePanel and ControlPanel 
   */
  public static void main(String[] args) {
    JFrame frame = new JFrame("The Game of Life");
    frame.setPreferredSize(new Dimension(720, 850));
    
    JPanel main = new JPanel();
    
    Life life = new Life(ROWS, COLUMNS);
    LifePanel lifePanel = new LifePanel(life, ROWS, COLUMNS);
    ControlPanel control = new ControlPanel(life, lifePanel);
    
    main.add(control);
    main.add(lifePanel);
    
    frame.add(main);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
 }
}