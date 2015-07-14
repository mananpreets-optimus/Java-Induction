/*
 * Package Name: basics
 */
package basics;
/*
 * Class Name: Multi
 * extends Thread class
 */
public class Multi extends Thread{
	
	public void run() {
		
		System.out.println("Thread is running.");
	}
	
	public static void main(String args[]) {
		
		Multi thread = new Multi();
		thread.start();
	}
}
