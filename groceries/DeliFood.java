import java.text.*;
/**
 * 
 * The class DeliFood implements interface purchasable 
 * refers to an object that can be bought at the Deli Corner
 * @author Dhruv Saksena
 * @version 03-Mar-2012
 */
public class DeliFood implements Purchasable 
{
	//Instance Variables
	private double price;
	private String name;
	
	//Constructor
	/** 
	 *Constructor for class DeliFood.java
	 *Initializes name and price to passed parameters
	 * @param name
	 * @param price
	 */
	private DeliFood(String name,double price)
	{
		this.name=name;
		this.price=price;
		//how do you now allow other classes to create new items as in assignment?
	}//Constructor
	
	//Instance Methods
	
	/**
	 * getName:nameGetter
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}//getName
	
	/**
	 * getPrice:pricegetter
	 * @return 
	 * @return the price
	 */
	public double getPrice()//is this an interface implement?
	{
		return price;
	}//getPrice
	
	
	
	/**
	 *getAterTaxPrice:price tax adder and getter
	 *@return the price after adding tax
	 */
	public double getAfterTaxPrice()
	{
		double n=price+price*SALESTAX;
		
		return (n);
		
	}//getPriceAfterTax
	
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
	
	//Static Methods
	/** 
	 *createPotatoSalad
	 *@return the object of DeliFood created to represent a potato salad
	 */
	public static DeliFood createPotatoSalad()
	{
		return (new DeliFood("Potato Salad",2.50));
	}//Potato Salad
	
	/** 
	 *createPBJ
	 *@return the object of DeliFood created to rep a peanut butter jelly sandwich
	 */
	public static DeliFood createPBJ()
	{
		return (new DeliFood("PB+J",1.50));
	}//PBJ
	
	/** 
	 *createBeefStew
	 *@return the object of DeliFood created to represent a Beef Stew
	 */
	public static DeliFood createBeefStew()
	{
		return (new DeliFood("Beef Stew",4.50));
	}//Beef Stew
	
}//Class
