import java.text.DecimalFormat;
/**
 * 
 * The class ShoppingCart.java 
 * represents a virtual shopping cart into which up to ten items can be added
 * @author Dhruv Saksena
 * @version 08-Mar-2012
 */


public class ShoppingCart 
{
	//Instances
	private int noi=0;
	private Purchasable [] list;
	
	//Constructor 
	
	/**
	 * 
	 *Constructor for class ShoppingCart.java
	 *Initialises number of items to 0 and the array of Purchasable objects
	 * @param max
	 */
	public ShoppingCart(int max)
	{
		noi=0;
		list=new Purchasable[max];
	}//Constructor
	
	//Instance methods
	
	/**
	 *addItem to array of purchasable items
	 *@param Item
	 *@return success or failure
	 */
	public int addItem(Purchasable Item)
	{
		if(noi<list.length)
		{
			list[noi]=Item;
			noi++;
			return 0;//success
		}
		else
		{
			return 1;//faliure
		}
	}//addtiem
	
	/**
	 *emptyCart empties the array
	 *blanks out the pruchasable array
	 */
	public void emptyCart()
	{
		int n=list.length;
		list=new Purchasable[n];
		noi=0;
		
	}//emptyCart
	
	/**
	 *subTotal:generates the total of the prices without tax
	 *@return subtotal price
	 */
	public double subtotal()
	{
		double price=0;
		
		for(int i=0;i<noi;i++)
		{
			price=price+list[i].getPrice();
		}
		
		return price;
		
	}//subTotal
	
	/**
	 *total: calculates total amount of bill
	 *@return the total amount
	 */
	public double total()
	{
		double price=0;
		
		for(int i=0;i<noi;i++)
		{
			price=price+list[i].getAfterTaxPrice();
		}
		
		return price;
	}//total
	
	/**
	 * 
	 *isFull:Check if the cart is full or not
	 *@return true if full else false
	 */
	
	public boolean isFull()
	{
		boolean b;
		if(noi==list.length)
		{
			b=true;
		}
		else
		{
			b=false;
		}
		
		return b;
	}//isFull
	
	/**
	 * 
	 *isEmpty;checks if cart if empty
	 *@return true or false
	 */
	public boolean isEmpty()
	{
		boolean b;
		
		if(noi==0)
		{
			b=true;
		}
		else
		{
			b=false;
			
		}
		
		return b;
	}//isEmpty
	
	/**
	 *getNumofItems: getter for num of items
	 *@return number of items in cart
	 */
	public int getNumOfItems()
	{
		return noi;
	}//noi getter
	
	
	/**
	 *getMaxItems: getter for max number of items
	 *@return the max capacity of the cart
	 */
	public int getMaxItems()
	{
		return list.length;
	}//getMaxItems
	
	/**
	 * generates the entire list the form of a string
	 * @returns that string
	 */
	public String toString()
	{
		String s="<html><pre>";
		
		int i=0;
		DecimalFormat f=new DecimalFormat("0.##");
		
		while(i<noi)
		{
			s=s+list[i].getName()+" costs $"+f.format(list[i].getPrice())+" \n";
			i++;
		}
		
		s=s+"</pre></html>";
		return s;
	}//toString

}//Class
