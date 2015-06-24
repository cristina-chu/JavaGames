/** 
 * CS 1331 Summer 2012 - HW 7
 * This class creates a cell that can be either alive or dead
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */

public class Cell {
  
  //initiates boolean isAlive
  private boolean isAlive;
  
  /**
   *Constructor method
   * Creates a cell that can be alive or dead
   * 
   * @param: boolean isAlive = true if cell is alive, false if cell is dead
   */
  public Cell(boolean isAlive){
    this.isAlive = isAlive;
  } //ends constructor
  
  
  /**
   *This method changes the state (alive or dead) of the cell 
   * 
   * @param: boolean change = true to change cell to alive, and false to change cell to dead
   */
  public void changeState(boolean change){
    isAlive = change;
  } //ends changeState method
  
  
  /**
   * This method returns the value of isAlive
   * 
   * @return: boolean isAlive = true if cell is alive, false if cell is dead
   */
  public boolean getIsAlive(){
    return isAlive;
  } //ends getIsAlive method

}//ends class
  