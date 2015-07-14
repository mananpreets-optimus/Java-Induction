/*
 * Package Name: Test
 */
package test;

import java.util.StringTokenizer;
/*
 * Class Name: StringTokenizerExample
 */
public class StringTokenizerExample { 
	
	public static void main(String args[]) {
		
		StringTokenizer string = new StringTokenizer("\"A\",\"B\",\"C\",\"D\"");
		while(string.hasMoreElements()) {
		System.out.println("Tokens : " +string.nextToken("\",\""));
		}
	}
}
