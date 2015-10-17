/**
 * Package com.patterns.adapter involves classes and interfaces for implementation
 * of Adapter design pattern.
 */
package com.patterns.adapter;

/**
 * Class Mp4Player implements AdvancedMediaPlayer
 */
public class Mp4Player implements AdvancedMediaPlayer{
	
	/**
	 * Does not have to do anything for this class.
	 */
	@Override
	public void playVlc(String fileName) {
		
	}

	/** 
	 * Method for playing Mp4 file
	 */
	@Override
	public void playMp4(String fileName) {
		System.out.println("Playing mp4 file. Name: "+ fileName);	
	}

}
