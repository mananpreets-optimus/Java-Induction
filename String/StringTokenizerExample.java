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
		
		String string = "\"A\",\"B\",\"C\",\"D\"";
		string = string.replace("\",\"", "\\\\");
		StringTokenizer string1 = new StringTokenizer(string);
		
		while(string1.hasMoreElements()) {
		System.out.println("Tokens : " +string1.nextToken("\\\\"));
		}
	}
}
                                                                                                                                         