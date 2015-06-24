import java.text.DecimalFormat;
import java.text.NumberFormat;
/**
 * The class GroceryItem implements the interface Purchasable 
 * it depicts a grocery item with a name and price 
 * @author Dhruv Saksena
 * @version 03-Mar-2012
 */
public class GroceryItem implements Purchasable 
{
	//Instances
	
	private double price;
	private String name;
	private final double FOODTAX=0.05;
	
	//Constructor
	/**
	 *Constructor for class GroceryItem
	 *Initialises price and name to passed parameters 
	 * @param price
	 * @param name
	 */
	public GroceryItem(String name,double price)
	{
		this.name=name;
		this.price=price;
	}//Constructor
	
	//Methods
	
		/**
		 * getter for item name
		 *@return the name of item
		 */
		public String getName()//is this an implementation of an interface or not?
		{
			return name;
		}//Name getter
		
		/**
		 * getter for item price
		 *@return the price of item
		 */
		public double getPrice()
		{
			return price;
		}//Price Getter
		
		/**
		 * getter for item price after sales tax
		 *@return the price of item after sales tax
		 */
		public double getAfterTaxPrice()
		{
			double n= (price+price*FOODTAX);
			return n;
		}//Price Getter after tax

		/**
		 * to String method
		 * @return Name and price in a formatted string
		 */
		public String toString()
		{
			NumberFormat f1=NumberFormat.getCurrencyInstance();
			DecimalFormat f2=new DecimalFormat("0.##");
					
			return(name+": "+f1.format(f2.format(price)));
		}//toString
		
}//Class
