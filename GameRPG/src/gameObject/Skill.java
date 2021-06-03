package gameObject;

import system.Theme.ObjectPath;

public class Skill extends GameObject {
	protected GameObject parentObject = null;
	protected double dame 			= 0;
	protected double timeUse 		= 0.05;
	protected double lastTimeUse	= System.nanoTime() / 1e9;
	
	public Skill() {}
	public Skill(GameObject parent) {
		this.parentObject = parent;
	}
	
	
	@Override public void loadGraphic() {
		// must be overrided in subclass
	}
	@Override public void loadGraphic(ObjectPath path) {
		super.loadGraphic(path);
	}
	@Override public void initialize() {
		this.gameWorld = parentObject.getGameWorld();
		super.initialize();
	}
	@Override public void update() {
		super.update();
	}
	@Override public void update(long currentTime) {
		if (currentTime/1e9 - lastTime >= timeSleep) {
			update();
			
			lastTime = currentTime/1e9;
		}
	}
	
	// GETTER and SETTER
	public GameObject getParentObject() {
		return parentObject;
	}
	public void setParentObject(GameObject parent) {
		this.parentObject = parent;
	}
	public double getDame() {
		return dame;
	}
	public void setDame(double dame) {
		this.dame = dame;
	}
	public double getTimeUse() {
		return timeUse;
	}
	public void setTimeUse(double timeUse) {
		this.timeUse = timeUse;
	}
	public double getLastTimeUse() {
		return lastTimeUse;
	}
	public void setLastTimeUse(double lastTimeUse) {
		this.lastTimeUse = lastTimeUse;
	}
	
}
