/*
 * Package Name: concepts
 */
package concepts;
/*
 * Class Name: Stationary
 * includes fields: manufacturer,id
 * 
 */
public class Stationary {
	
	private String manufacturer; //name of manufacturer of stationary
	private int id;//id of stationary product
	
	/*
	 * Constructor to initialize manufacturer name and id of the product
	 */
	Stationary(String manufacturer, int id) {	
		System.out.println("Constructing Stationary");
		this.manufacturer = manufacturer;
		this.id = id;
	}
	
	/*
	 * Function Name: typePolymorphism
	 * Used in derived class: Pen for showing Function Overridding. 
	 */
	protected void typePolymorphism() {
		System.out.println("Inside Stationary");
	}
}


	


