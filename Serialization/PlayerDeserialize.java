/*
 * Package Name:com.serialization.example
 */
package com.serialization.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
/*
 * Class Name: PlayerDeserialize
 * deserialization implementation
 */
public class PlayerDeserialize {
	public static void main(String args[]) throws ClassNotFoundException {
		Player player = null;
		try{
			FileInputStream  filein = new FileInputStream("Player.ser");
			ObjectInputStream file = new ObjectInputStream(filein);
			player =(Player) file.readObject();
			file.close();
			filein.close();
		}catch(IOException exception){
			System.out.println(exception);

		}
		System.out.println(player.name+" "+player.number+" "+player.score);
	}

}
