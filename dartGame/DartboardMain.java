import javax.swing.*;

/** 
 * CS 1331 Summer 2012 - HW 5
 * This class creates the JFrame for the Dartboard
 *
 * @author: Cristina Chu
 * @version: 1.0
 * */
public class DartboardMain {
  
  /**
   * Main method
   * This method creates the GUI frame and adds a DartboardPanel to it
   * */
  public static void main(String[] args){
    JFrame frame = new JFrame("Dartboard"); //instantiates a new JFrame
    
    /*Prompts a option panel for the user to enter number of darts to be thrown*/
    String s = (String)JOptionPane.showInputDialog(frame,"How many darts do you want to throw?","Input",JOptionPane.QUESTION_MESSAGE);
    
    int darts = Integer.parseInt(s); //converts the user input (String) to integer
    
    if (darts>0) //if user gives a positive number of darts, it instantiates a new DartboardPanel with number of darts by user and adds it to the JFrame
      frame.add(new DartboardPanel(darts)); 
    else //if user gives a negative number, it instantiates a new DartboardPanel with 1 dart, and adds it to the JFrame.
      frame.add(new DartboardPanel(1)); 
    
    /*Takes cares of generic characteristics of the frame: visibility and exit button*/
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  
  } //ends main method 

} //ends class DartboardMain