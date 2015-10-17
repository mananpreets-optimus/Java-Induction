/**
 * Package com.patterns.adapter involves classes and interfaces for implementation
 * of Adapter design pattern.
 */
package com.patterns.adapter;

/**
 * Interface AdvancedMediaPlayer which involves playVlc and playMp4
 */
public interface AdvancedMediaPlayer {
	
	public void playVlc(String fileName);
	public void playMp4(String fileName);

}
