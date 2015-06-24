import javax.swing.JFrame;

/**
 * The class GroceryStore creates and instantiates the JFrame and furnishes 
 * and is the driver class for the program
 * @author Dhruv Saksena
 * @version 03-Mar-2012
 */
public class GroceryStore 
{
	/**
	 * 
	 *main function of the driver class, executes the JFrame
	 *@param args
	 */
	public static void main(String [] args)
	{
		JFrame f= new JFrame("Grocery Store!");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new GroceryStorePanel());
		f.pack();
		f.setVisible(true);
		
	}//Main
	
}//Class
