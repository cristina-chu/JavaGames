import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** 
 * CS 1331 Summer 2012 - HW 7
 * This class creates a ControlPanel --> Main controls that start and reset the game
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */

public class ControlPanel extends JPanel{
  
  //instantiates variables
  private Life life;
  private LifePanel lifePanel;
  private JButton clear, step;
  private JLabel generation; 
  private JPanel panel;
  
   /**
   *This method gets a cell from array 1
   * 
   * @param: Life life - object life that contains the array of cells to handle
   * @param: LifePanel lifePanel - panel that contains the buttons portraying the cells
   */
  public ControlPanel(Life life, LifePanel lifePanel){
    this.life = life;
    this.lifePanel = lifePanel;
    
    setLayout(new BorderLayout()); 
    
    step = new JButton("Step");
    step.addActionListener(new StepListener());
    
    clear = new JButton("Clear");
    clear.addActionListener(new ClearListener());
    
    generation = new JLabel("Generation: 0");
    
    panel = new JPanel();
    panel.add(step);
    panel.add(clear);
    panel.add(generation);
    
    add(panel, BorderLayout.NORTH);
    add(lifePanel, BorderLayout.CENTER);
  }
 
    /**
   *This class states the actions of the JButton clear  
   */
  private class ClearListener implements ActionListener{
      /**
   *This clears all the buttons on the LifePanel - makes them inactive
   * 
   * @param: ActionEvent e
   */
    public void actionPerformed(ActionEvent e){
      life.reset();
      life.clearG();
      generation.setText("Generation: 0");
      lifePanel.resetButtons(); 
    }
  } //ends clearlistener
  
    /**
   *This class states the actions of the JButton step
   */
  private class StepListener implements ActionListener{
      /**
   *This method sets the buttons in the LifePanel accordingly to the cells state (dead/alive)
   * 
   * @param: ActionEvent e
   */
    public void actionPerformed(ActionEvent e){
      for (int i=0; i<life.getRows(); i++){
        for (int j=0; j<life.getColumns(); j++){ 
          life.update(i,j);
        }
      }
      for (int i=0; i<life.getRows(); i++){
        for (int j=0; j<life.getColumns(); j++){
          Cell c = life.getCell2(i,j);
          lifePanel.setButton(i,j,c.getIsAlive());
        }
      }
      life.stepDone(); 
      life.increaseG();
      generation.setText("Generation: "+life.getGeneration());
    }
  }//ends steplistener
  
} //ends class
  