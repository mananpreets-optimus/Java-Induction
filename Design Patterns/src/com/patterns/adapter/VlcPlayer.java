/**
 * Package com.patterns.adapter involves classes and interfaces for implementation
 * of Adapter design pattern.
 */
package com.patterns.adapter;

/**
 * Class VlcPlayer implements AdvancedMediaPlayer
 */
public class VlcPlayer implements AdvancedMediaPlayer{

	/**
	 * Method for playing vlc
	 * @param fileName name of file
	 */
	@Override
	public void playVlc(String fileName) {
		System.out.println("Playing Vlc file. Name: "+ fileName);	
	}

	/**
	 * Does not have to do anything for this class.
	 */
	@Override
	public void playMp4(String fileName) {
		
	}

	
}
