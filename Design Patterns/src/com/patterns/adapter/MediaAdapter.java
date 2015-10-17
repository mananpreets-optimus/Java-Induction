/**
 * Package com.patterns.adapter involves classes and interfaces for implementation
 * of Adapter design pattern.
 */
package com.patterns.adapter;

/**
 * Class MediaAdapter implements MediaPlayer
 */
public class MediaAdapter implements MediaPlayer{

	AdvancedMediaPlayer advancedMediaPlayer;
	/**
	 * Constructor for class MediaAdapter
	 * @param audioType audio type of file
	 */
	public MediaAdapter(String audioType) {
		if(audioType.equalsIgnoreCase("vlc")) {
			advancedMediaPlayer = new VlcPlayer();
		}
		else if(audioType.equalsIgnoreCase("mp4")) {
			advancedMediaPlayer = new Mp4Player();
		}
	}
	
	/**
	 * play method for playing audio file
	 * @param audioType type of audio of file
	 * @param fileName name of file
	 */
	@Override
	public void play(String audioType, String fileName) {
		if(audioType.equalsIgnoreCase("vlc")) {
			advancedMediaPlayer.playVlc(fileName);
		}
		else if(audioType.equalsIgnoreCase("mp4")) {
			advancedMediaPlayer.playMp4(fileName);
		}
	}

}
