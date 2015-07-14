/*
 * Package Name: basics
 */
package basics;
/*
 * Class Name: Multi2
 * implements Runnable interface
 */
public class Multi2 implements Runnable {
	
	public void run() {
		
		System.out.println("|This thread is running");
	}
	public static void main() {
		
		Multi2 multi = new Multi2();
		Thread t1 = new Thread(multi);
		t1.start();
	}
	

}
