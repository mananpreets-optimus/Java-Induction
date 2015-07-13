/*
 * Package Name: concepts
 */
package concepts;
/*
 *  Class Name: Pen 
 *  extends Class: Stationary
 *  includes fields: price,quantity
 *  includes functions: setPrice, getPrice, setQuantity, getQuantity, totalAmount
 * 
 */
public class Pen extends Stationary {
	

	private int price; 
	private int quantity;
	
	/*
	 * Constructor to initialize name of manufacturer and id of product. 
	 */
	Pen(String manufacturer, int id) {
		super(manufacturer, id);
	}
	/*Function Name: typePolymorphism
	 * Used for showing function overridding.
	 * 
	 */
	protected void typePolymorphism() {
		System.out.println("Inside Stationary");
	}
	/*
	 * Function Name: setPrice
	 * sets the price for pen
	 */
	protected void setPrice(int price) {
				this.price = price;	
	}
	/*
	 * Function Name: setQuantity
	 * sets the quantity of pens
	 */
	protected void setQuantity(int quantity) {
		this.quantity = quantity;	
	}
	
	/*
	 * Function Name: getPrice
	 * returns -price for Pen 
	 */
	protected int getPrice() {
		return (price);
	}
	
	/*
	 * Function Name: getQuantity
	 * returns -quantity of Pen
	 */
	protected int getQuantity() {
		return (quantity);
	}
	/*
	 * Function Name: totalAmount
	 * returns -total amount for Pen 
	 */
	protected int totalAmount() {
	return (getPrice()*getQuantity());
	}
	/*
	 * Function Name: totalAmount
	 * returns -total amount for Pen with new Price (function Overloading) 
	 */
	protected int totalAmount(int newPrice) {
	return (newPrice*getQuantity());	
	}
	public static void main(String args[]){
		
		Pen p = new Pen("Stick Pens", 1);
		int priceOfPen=-1;
		int quantityOfPen=5;
		/*
		 * Exception Handling to find catch exception if Quantity of Pen is less than 0
		 * or if Price of each pen is less than 0.
		 */
		try{
			if(priceOfPen>0)
			{
				if(quantityOfPen>0) {
					p.setPrice(priceOfPen);
					p.setQuantity(quantityOfPen);
				}
				else {
					throw new ArithmeticException("Quantity Of Pen less 0 not possible");
				}
			}
			else {
				throw new ArithmeticException("Price less than 0 not possible");
			}
		}catch(ArithmeticException ae) {
			System.out.println(ae.getMessage());
		}
		finally{
			System.out.println("Finally is executed");
		}
		System.out.println("Price of Each Pen = "+ p.getPrice());
		System.out.println("Quantity of Pens = "+ p.getQuantity());
		System.out.println("Total Amount = "+ p.totalAmount());
	}
	
}
