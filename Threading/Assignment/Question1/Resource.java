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
	public synchronized int pencil() {
		return 2*pen();
	}
	/*
	 * Method Name: pen
	 * it is a synchronized method which calls
	 * another synchronized method pencil
	 */
	public synchronized int pen() {
		return 3*pencil();
	}
}
