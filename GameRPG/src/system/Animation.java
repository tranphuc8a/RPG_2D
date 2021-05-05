package system;

import gameObject.Buffalo;
import gameObject.Fox;
import gameObject.GameObject;
import gameObject.MainCharacter;
import gameObject.Mouse;
import gameObject.Pig;
import gameObject.Snake;

//import javafx.stage.Stage;
//import menu.ParentMenu;

public class Animation {
	private GameObject parent = null;
	
	private myImage[] images = null;
	private int numFrame = 0;
	private int currentFrame = 0;
	private double timeSleep = 1;
	private double lastTime = 0;
	
	public Animation() {
		lastTime = System.nanoTime() / 1e9;
	}
	public Animation(String[] imagePath) {
		this();
		loadImage(imagePath);
	}
	public Animation(GameObject gameObject) {
		parent = gameObject;
		this.timeSleep = gameObject.getTimeSleep();
	}
	
	public void update() {
		currentFrame = (currentFrame + 1) % numFrame;
		if (parent.getState().isStandStill() && 
				(parent instanceof MainCharacter ||
				 parent instanceof Buffalo ||
				 parent instanceof Snake ||
				 parent instanceof Fox ||
				 parent instanceof Mouse ||
				 parent instanceof Pig))
			currentFrame = 0;
		parent.setImage(images[currentFrame]);
	}
	public void update(long currentTime) {
		if ((currentTime / 1e9 - this.lastTime) >= timeSleep) {
			update();
			lastTime = currentTime / 1e9;
		}
	}
	public void loadImage(String[] imagePath) {
		numFrame = imagePath.length;
		images = new myImage[numFrame];
		for (int i = 0; i < numFrame; i++) {
			images[i] = new myImage(imagePath[i]);
		}
	}
	
	// getter and setter:
	public void setTimeSleep(double time) {
		this.timeSleep = time;
	}
	public double getTimeSleep() {
		return this.timeSleep;
	}
	public void setSpeed(double speed) {
		this.timeSleep = 1.0 / speed;
	}
	public double getSpeed() {
		return 1.0 / timeSleep;
	}
}
