/**
 * Package com.patterns.adapter involves classes and interfaces for implementation
 * of Adapter design pattern.
 */
package com.patterns.adapter;

/**
 * Class AdapterPatternDemo : demo class for adapter pattern 
 *
 */
public class AdapterPatternDemo {
	
	/**
	 * main method
	 * @param args
	 */
	   public static void main(String[] args) {
		   
	      AudioPlayer audioPlayer = new AudioPlayer();
	      audioPlayer.play("mp3", "Hello.mp3");
	      audioPlayer.play("mp4", "alone.mp4");
	      audioPlayer.play("vlc", "away.vlc");
	      audioPlayer.play("avi", "mind.avi");
	   }
	}
