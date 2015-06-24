/**
 * 
 * The class Purchasable describes an object that can be purchased at the grocery store 
 * @author Dhruv Saksena
 * @version 03-Mar-2012
 */
public interface Purchasable 
{

	//Instances
	
	final public double SALESTAX=0.04;
	
	
	
	//Methods
	
		/**
		 * getter for item name
		 *@return the name of item
		 */
		public String getName();
		//Name getter
		
		/**
		 * getter for item price
		 *@return the price of item
		 */
		public double getPrice();
		//Price Getter
		
		/**
		 * getter for item price after salestex
		 *@return the price of itemafter salestex
		 */
		public double getAfterTaxPrice();
		//Price Getter after tax
	
	
}//Class
