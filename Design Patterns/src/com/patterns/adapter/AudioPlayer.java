/**
 * Package com.patterns.adapter involves classes and interfaces for implementation
 * of Adapter design pattern.
 */
package com.patterns.adapter;

/**
 * Class AudioPlayer implements MediaPlayer
 */
public class AudioPlayer implements MediaPlayer {

	MediaAdapter mediaAdapter;
	/**
	 * Method play for playing file of a particular audio type.
	 */
	@Override
	public void play(String audioType, String fileName) {
		if(audioType.equalsIgnoreCase("mp3")) {
			System.out.println("Playing mp3 file name : "+ fileName);
		}
		else if ((audioType.equalsIgnoreCase("vlc")) ||(audioType.equalsIgnoreCase("mp4"))) {
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}
		else {
			System.out.println("Invalid media type : " + audioType + " not supported.");
		}
	}
}
