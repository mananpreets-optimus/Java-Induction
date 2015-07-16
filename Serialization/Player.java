/*
 * Package Name: com.serialization.example
 */
package com.serialization.example;
/*
 * Class Name: Player
 * implements java.io.Serializable
 */
public class Player implements java.io.Serializable{
	public String name;
	public int score;
	public transient int number;
	public void playerInfo() {
		System.out.println("Name : "+name+"Score"+score);
	}
	
}
