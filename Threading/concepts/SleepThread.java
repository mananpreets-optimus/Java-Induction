/*
 * Package Name: basics
 */
package basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Class Name: SleepThread
 * extends Thread class includes Thread.sleep class
 */
public class SleepThread extends Thread {
	
	public void run() {
		
	for(int i = 0; i < 2; i++)
	{
		try{
			Thread.sleep(1000);
		}catch(InterruptedException ie) {
			System.out.println(ie);
		}
		System.out.println(i);
	}
	}
	public static void main(String args[]) {
		
		SleepThread t1 = new SleepThread();
		t1.start();
		SleepThread t2 = new SleepThread();
		t2.start();
		t1.run();
		t2.run();
		
	}

}
