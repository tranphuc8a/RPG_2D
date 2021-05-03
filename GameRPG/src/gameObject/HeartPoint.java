package gameObject;

import system.Animation;
import system.GameConfig;
import system.myGraphic;
import system.myImage;

public class HeartPoint extends GameObject {
	private GameObject parentObject = null;
	private myImage[] images;
	private int numFrames = 0;
	private int currentFrame = 0;
	
	public HeartPoint() {}
	public HeartPoint(GameObject par) {
		this.parentObject = par;
	}	
	public void loadGraphic(String[] pathes) {
		this.numFrames = pathes.length;
		images = new myImage[numFrames];
		for (int i = 0; i < numFrames; i++) {
			images[i] = new myImage(pathes[i]);
		}
		currentFrame = numFrames - 1;
		this.setImage(images[currentFrame]);
	}
	public void loadGraphic() {
		this.loadGraphic(GameConfig.theme.hpPath);
	}
	@Override public void initialize() {
//		this.loadGraphic(GameConfig.theme.hpPath);
//		this.loadGraphic();
		this.gameWorld = parentObject.getGameWorld();
		this.setSize(parentObject.getFitWidth(), parentObject.getFitWidth()/7);
		this.weightPoint.set(this.getFitWidth()/2, this.getFitHeight()/2);
		this.setWeightPoint(parentObject.getWeightPoint().x, parentObject.getPosition().y - this.getFitHeight()/2);
	}
	@Override public void update(long currentTime) {
		double percent = this.parentObject.getState().heartPoint/this.parentObject.getState().maxHP;
		int newFrame = (int) (percent * numFrames) - 1;
		if (newFrame != currentFrame) {
			currentFrame = newFrame;
			if (currentFrame <= 0) currentFrame = 0;
			this.setImage(images[currentFrame]);
		}
		this.setWeightPoint(parentObject.getWeightPoint().x, parentObject.getPosition().y - this.getFitHeight()/2);
	}
	
	public void setParentObject(GameObject parent) {
		this.parentObject = parent;
	}
	public GameObject getParentObject() {
		return this.parentObject;
	}
}
