/*
 * Package Name: com.serialization.example
 */
package com.serialization.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
/*
 * Class Name: PlayerSerialize
 * implementation of Serialization
 */
public class PlayerSerialize {
	public static void main(String args[]) {
		Player player = new Player();
		player.name = "Abc";
		player.score = 2500;
		player.number= 1400;
		
		try{
			FileOutputStream file = new FileOutputStream("Player.ser");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(player);
			out.close();
			file.close();
			System.out.println("Object Serialized");
			
		}catch(IOException exception) {
			System.out.println(exception);
		}
		finally{
			System.out.println("Finally block");
		}
	}
	
}
