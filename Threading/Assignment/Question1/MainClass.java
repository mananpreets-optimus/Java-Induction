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
	
	public static void main(String args[]) throws InterruptedException {
		
		int numOfPens;
		int numOfPencils;
		
		MainClass obj = new MainClass();
		Thread thread1 = new Thread(obj,"thread1");
		thread1.start();
		
		MainClass obj2 = new MainClass();
		Thread thread2 = new Thread(obj2,"thread2");
		thread2.start();
	}

	@Override
	public void run() {
		
			if(Thread.currentThread().getName().equals("thread1"))
				{
					
						try {
							System.out.println(" Price of Pens "+this.pen());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}
			else{
					
						try {
							System.out.println(" Price of Pencil "+this.pencil());
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}	
		
		
		}

}