package system;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class myAudio 
{
	private Media media;
	private MediaPlayer mediaPlayer;
	private double length;
	private double timeStart;
	private double timePause;
	
	private boolean isPlay;
	private boolean isPause;
	private boolean isRepeat;
	
	public myAudio() {}
	public myAudio(String path, double len) {
		media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		this.length = len;
		timeStart = System.nanoTime() / 1e9;
		isPlay = false;
		timePause = -1;
		isRepeat = false;
	}
	public myAudio(String path, double len, boolean isRepeat) {
		this(path, len);
		this.isRepeat = isRepeat;
	}
	
	public void update() {
		if (this.isPlaying()) return;
		else if (isRepeat) play();
	}
	
	public void play() {
		if (mediaPlayer == null) return;
		this.unMute();
		mediaPlayer.stop();
		timeStart = System.nanoTime() / 1e9;
		mediaPlayer.play();
		
		isPlay = true;
	}
	public void pause() {
		if (mediaPlayer == null) return;
		mediaPlayer.pause();
		isPause = true;
		timePause = System.nanoTime() / 1e9;
		isPlay = false;
	}
	public void resume() {
		if (mediaPlayer == null) return;
		double waiting = System.nanoTime()/1e9 - timePause;
		timeStart += waiting;
		isPause = false;
		mediaPlayer.play();
		isPlay = true;
	}
	public void stop() {
		mediaPlayer.stop();
		isPlay = false;
	}
	public void mute() {
		if (mediaPlayer != null)
			mediaPlayer.setMute(true);
	}
	public void unMute() {
		if (mediaPlayer != null)
			mediaPlayer.setMute(false);
	}
	
	public boolean isPlaying() {
		double now = System.nanoTime() / 1e9;
		if (now - timeStart > length) {
			isPlay = false;
		}
		return isPlay;
	}
	public boolean isPause() {
		return isPause;
	}
	public double getLength() {
		return this.length;
	}
	
	public void setRepeat(boolean isRepeat) {
		this.isRepeat = isRepeat;
	}
	public boolean isRepeat() {
		return this.isRepeat;
	}
} 




