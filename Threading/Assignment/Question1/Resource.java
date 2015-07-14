/*
 * Package Name: assignment2a
 */
package assignment2a;
/*
 * Class Name: Resource
 * includes two synchronized methods 
 */
public class Resource {
	/*
	 * Method Name: pencil
	 * it is a synchronized method which calls 
	 * another synchronized method pen 
	 */
	public synchronized int pencil() throws InterruptedException {
		Thread.sleep(1000);
		return 2;
	}
	/*
	 * Method Name: pen
	 * it is a synchronized method which calls
	 * another synchronized method pencil
	 */
	public synchronized int pen() throws InterruptedException  {
		return 3*pencil();
	}
}
