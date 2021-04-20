package system;

import javafx.stage.Stage;
import menu.ParentMenu;

class Animator extends myGraphic {
	private myImage[] images = null;
	private int numFrame = 0;
	private int currentFrame = 0;
	private double timeSleep = 1;
	private double lastTime = 0;
	
	public Animator() {
		lastTime = System.nanoTime() / 1e9;
	}
	public Animator(String[] imagePath) {
		this();
		loadImage(imagePath);
	}
	
	public void update() {
		currentFrame = (currentFrame + 1) % numFrame;
		this.setImage(images[currentFrame]);
		this.setY(this.getY() + 5);
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

// run try the Animation
class loop extends GameLoop{
	public Animator anm1 = new Animator();
	public Animator anm2 = new Animator();
	@Override public void handle(long currentTime) {
		if (currentTime - lastTime >= SLEEP) {
			anm1.update(currentTime);
			anm2.update(currentTime);
			lastTime = currentTime;
		}
	}
}
public class Animation extends ParentMenu{
	loop Loop = new loop();
	@Override public void start(Stage primaryStage) {
		Loop.setSleep(0.001);
		
		Loop.anm1 = new Animator();
		Loop.anm1.loadImage(images());
		Loop.anm1.setSpeed(8);
		Loop.anm1.setSize(200, 200);
		Loop.anm1.setPosition(300, 0);
		
		Loop.anm2 = new Animator();
		Loop.anm2.loadImage(images());
		Loop.anm2.setSpeed(2);
		Loop.anm2.setSize(200, 200);
		Loop.anm2.setPosition(100, 0);
		
		super.start(primaryStage);
		root.getChildren().addAll(Loop.anm1, Loop.anm2);
		Loop.start();
	}
	public String[] images() {
		String[] imgs = new String[9];
		for (int i = 0; i < 9; i++) {
			String path = "resource/character/man/front/fr" + (i + 1) + "-removebg-preview.png";
			imgs[i] = path;
		}
		return imgs;
	}
	public static void main(String[] args) {
		launch(args);
	}
}

