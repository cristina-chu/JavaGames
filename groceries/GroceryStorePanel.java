import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 * 
 * The Class GroceryStorePanel creates the GUI panel 
 * @extends Class JPanel
 * @author Dhruv Saksena
 * @version 03-Mar-2012
 */
public class GroceryStorePanel extends JPanel
{
	//Instance Variables
	private ShoppingCart cart;
	private JTextField name,price;
	private final JLabel iname,iprice;
	private JButton add,remAll;
	private JLabel number,itemList,bill;
	private JButton PBJ,salad,stew;
	private final JLabel deliCorner;
	
	
	//Constructor 
	/**
	 * 
	 *Constructor for class GroceryStorePanel
	 *Initialises the panel and adds all GUI components
	 */
	public GroceryStorePanel()
	{
		final int n= 10;
		
		cart=new ShoppingCart(n);
		
		name=new JTextField("Cookies");
		price=new JTextField("2.50");
		
		iname=new JLabel("Item Name");
		iprice=new JLabel("Item Price");
		
		add=new JButton("Add Item");
		remAll=new JButton("Remove all items");
		
		bill=new JLabel("Subtotal: $"+cart.subtotal()+", Total: $"+cart.total());
		itemList=new JLabel(cart.toString());
		number=new JLabel(cart.getNumOfItems()+"/"+n);
		
		PBJ=new JButton("PB+J");
		salad=new JButton("Potato Salad");
		stew=new JButton("Beef Stew");
		
		deliCorner=new JLabel("The Deli Corner      ");
		
		add.addActionListener(new AddItemListener());
		remAll.addActionListener(new ClearCartListener());
		PBJ.addActionListener(new DeliCounterListener("PBJ"));
		salad.addActionListener(new DeliCounterListener("Potato Salad"));
		stew.addActionListener(new DeliCounterListener("Beef Stew"));
		
		add(number);
		add(itemList);
		add(iname);
		add(name);
		add(iprice);
		add(price);
		add(add);
		add(deliCorner);
		add(PBJ);
		
		add(salad);
		add(stew);
		add(bill);
		add(remAll);
		
		setPreferredSize(new Dimension(175,470));
		
		
		
	}//Constructor
	
	//ActionListeners
	
	
	/**
	 * 
	 * The class AddItemListner
	 * is an actionListener for the add an item button
	 * it adds an item to the Shopping Cart
	 * @author Dhruv Saksena
	 * @version 03-Mar-2012
	 */
	private class AddItemListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			DecimalFormat f=new DecimalFormat("0.##");
			cart.addItem(new GroceryItem(name.getText(),Double.parseDouble(price.getText())));
			itemList.setText(cart.toString());
			number.setText(cart.getNumOfItems()+"/"+cart.getMaxItems());
			
			bill.setText("Subtotal: $"+f.format(cart.subtotal())+", Total: $"+f.format(cart.total()));
			
			if(cart.isFull())
			{
				add.setEnabled(false);
				PBJ.setEnabled(false);
				salad.setEnabled(false);
				stew.setEnabled(false);
			}
		}//actionPerformed

	}//Action Listener Class
	
	/**
	 * The class ClearCartListener
	 * is an action listner for the RemoveAllItems Button
	 * it removes all the items in the ShoppingCart 
	 * @author Dhruv Saksena
	 * @version 03-Mar-2012
	 */
	private class ClearCartListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			cart.emptyCart();
			itemList.setText(cart.toString());
			number.setText(cart.getNumOfItems()+"/"+cart.getMaxItems());
			DecimalFormat f=new DecimalFormat("0.##");
			bill.setText("Subtotal: $"+f.format(cart.subtotal())+", Total: $"+f.format(cart.total()));
			
			if(cart.isEmpty())
			{
				add.setEnabled(true);
				PBJ.setEnabled(true);
				salad.setEnabled(true);
				stew.setEnabled(true);
			}
		}//actionPerformed

	}//Action Listener Class
	
	/**
	 * 
	 * The class DeliCounterListener is an action listner
	 * for the Deli Corner buttons
	 * it adds deli corner item when the corresponding button is pressed
	 * @author Dhruv Saksena
	 * @version 03-Mar-2012
	 */
	private class DeliCounterListener implements ActionListener
	{
		String deliFood;
		public DeliCounterListener(String deliFood)
		{
			this.deliFood=deliFood;
		}//Constructor 
		
		public void actionPerformed(ActionEvent event)
		{
			if(deliFood=="PBJ")
			{
				cart.addItem(DeliFood.createPBJ());
				
			}
			
			if(deliFood=="Potato Salad")
			{
				cart.addItem(DeliFood.createPotatoSalad());
			}
			if(deliFood=="Beef Stew")
			{
				cart.addItem(DeliFood.createBeefStew());
			}
			
			itemList.setText(cart.toString());
			number.setText(cart.getNumOfItems()+"/"+cart.getMaxItems());
			DecimalFormat f=new DecimalFormat("0.##");
			bill.setText("Subtotal: $"+f.format(cart.subtotal())+", Total: $"+f.format(cart.total()));
			
			if(cart.isFull())
			{
				add.setEnabled(false);
				PBJ.setEnabled(false);
				salad.setEnabled(false);
				stew.setEnabled(false);
			}
		}//actionPerformed

	}//Action Listener Class
	
}//Class
