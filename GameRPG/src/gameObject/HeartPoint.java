package gameObject;

import system.GameConfig;
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
	public void loadGraphic(myImage[] pathes) {
		this.numFrames = pathes.length;
		images = pathes;
		GameObject parent = this.parentObject;
		int index = numFrames - 1;
		if (parent != null)
			index = (int) (numFrames * parent.state.heartPoint * 1.0 / parent.state.maxHP);
		this.setImage(images[index - 1]);
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
	@Override public void update() {
		double percent = this.parentObject.getState().heartPoint/this.parentObject.getState().maxHP;
		int newFrame = (int) (percent * numFrames) - 1;
		if (newFrame != currentFrame) {
			currentFrame = newFrame;
			if (currentFrame <= 0) currentFrame = 0;
			this.setImage(images[currentFrame]);
		}
		this.setWeightPoint(parentObject.getWeightPoint().x, parentObject.getPosition().y - this.getFitHeight()/2);
	}
	@Override public void update(long currentTime) {
		update();
	}
	
	public void setParentObject(GameObject parent) {
		this.parentObject = parent;
	}
	public GameObject getParentObject() {
		return this.parentObject;
	}
}
