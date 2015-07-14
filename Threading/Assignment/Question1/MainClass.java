/*
 * Package Name: assignment2a
 */
package assignment2a;
/*
 * Class Name: MainClass
 * implements Runnable
 * extends Resource Class which includes two synchronized methods
 */
public class MainClass extends Resource implements Runnable{
	int pricePens;
	int pricePencils;
	/*
	 * Method Name: setPricePencils
	 * sets price of pencils
	 */
	public void setPricePencils(int numOfPens) {
		
		pricePencils = numOfPens*5;
	}
	/*
	 * Method Name: setPricePens
	 * sets price of pens
	 */
	public void setPricePens(int numOfPencils) {
		
		pricePens = numOfPencils*2;
	}
	/*
	 * Method Name: getPricePencils
	 * returns- price of pencils
	 */
	public int getPricePencils() {
		
		return pricePencils;
	}
	/*
	 * Method Name: getPricePens
	 * returns- price of pens
	 */
	public int getPricePens() {
		
		return pricePens;
	}
	
	public static void main(String args[]) {
		
		int numOfPens;
		int numOfPencils;
		
		MainClass obj = new MainClass();
		Thread thread1 = new Thread(obj);
		numOfPens = obj.pen();
		numOfPencils = obj.pencil();
		obj.setPricePencils(numOfPencils);
		obj.setPricePens(numOfPens);
		thread1.start();
		
		MainClass obj2 = new MainClass();
		Thread thread2 = new Thread(obj2);
		numOfPens = obj.pen();
		numOfPencils = obj.pencil();
		obj.setPricePens(numOfPens);
		obj.setPricePencils(numOfPencils);
		thread2.start();
	}

	@Override
	public void run() {
		try{
		System.out.println(" Price of Pencils "+this.getPricePencils());
		System.out.println(" Price of Pens "+this.getPricePens());
		}catch (ArithmeticException Exception){
			System.out.println(Exception);
		}
	}
}
