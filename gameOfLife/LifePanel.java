import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/** 
 * CS 1331 Summer 2012 - HW 7
 * This class creates a LifePanel - it consists of a grid panel with buttons representing cells
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */

public class LifePanel extends JPanel{
  
  //instantiates variables
  private JButton[][] buttons;
  private Life life;
  
  /**
   *Constructor LifePanel
   * It creates a panel that will hold all the buttons corresponding to cells
   * 
   * @param: Life life = an object life
   * @param: int rows = numbers of rows that the grid-panel should have
   * @param: int columns = numbers of columns that the grid-panel should have
   */  
  public LifePanel(Life life, int rows, int columns){
    this.life = life;
  
    setLayout(new GridLayout(rows, columns)); //sets the GridLayout for the panel
    
    buttons = new JButton[rows][columns]; //creates a new array of buttons with the specified rows and columns
    
    //creates a JButton for each space in the grid of the panel. 
    for (int i = 0; i<life.getRows(); i++){
      for (int j = 0; j<life.getColumns(); j++){
        buttons[i][j] = new JButton();
        buttons[i][j].setPreferredSize(new Dimension(30, 30)); //dimension of button = 30x30
        buttons[i][j].setBackground(Color.BLACK); //initial color of button (inactive) = black
        //cheat code for setting color in macs
        try{
          UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } 
        catch (Exception x){
          x.printStackTrace();
        }
        buttons[i][j].addActionListener(new ButtonListener(i,j)); //adds actionListener to each JButton
        add(buttons[i][j]); //finally adds each JButton to each space in grid
      } //ends j-for loop
    } //ends i-for loop
    
    buttons[0][0].setBackground(Color.BLACK);
    try{
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    } 
    catch (Exception x){
      x.printStackTrace();
    }
    
  } //ends constructor


  /**
   *This method resets all buttons to black (inactive/dead cell) 
   * 
   */
  public void resetButtons(){
    for (int i=0; i<buttons.length; i++){
      for (int j=0; j<buttons.length; j++){
        buttons[i][j].setBackground(Color.BLACK);
        try{
          UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } 
        catch (Exception x){
          x.printStackTrace();
        }
      }
    }
  }

  /**
   *This method set a particular button to actice or inactive 
   * 
   * @param: int x - button in row x
   * @param: int y - button in column y
   * @param: boolean z - true to set button to active, false to set button to inactive
   */
  public void setButton(int x, int y, boolean z){
    if (z == true){ //if button active, button changes color to white
      buttons[x][y].setBackground(Color.white); 
      try{
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      } 
      catch (Exception d){ 
        d.printStackTrace();
      }
    }
    else{ //if botton is inactive, button changes color to black
      buttons[x][y].setBackground(Color.black);
      try{
        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      } 
      catch (Exception f){ 
        f.printStackTrace();
      }
    }
  }

  
  /**
   *This private class deals with the action of the buttons
   */
  private class ButtonListener implements ActionListener{
    private int row, column;
    
   /**
   *Constructor method for the creation the action of the buttons
   * 
   * @param: int row - row number where button is
   * @param: int column - column number where button is
   */
    public ButtonListener(int row, int column){
      this.row = row;
      this.column = column;
    }
  
    /**
     *This method deals with the actions the button takes dependin if active or inactive 
     * 
     * @param: ActionEvent e 
     */
    public void actionPerformed(ActionEvent e){
      Cell c = life.getCell1(row,column);
      if (c.getIsAlive()==true){
        c.changeState(false);
        buttons[row][column].setBackground(Color.black);
        try{
          UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } 
        catch (Exception x) {
          x.printStackTrace();
        }
      }
      else if (c.getIsAlive()==false){
        c.changeState(true);
        buttons[row][column].setBackground(Color.white);
        try{
          UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } 
        catch (Exception x) {
          x.printStackTrace();
        }
      }
    }
  }
  
}
  
  
