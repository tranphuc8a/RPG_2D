package gameObject;

import java.util.ArrayList;

import system.Animation;
import system.Theme.ObjectPath;

public class Skill extends GameObject {
	protected GameObject parentObject = null;
	protected double dame 			= 0;
	
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
		this.damage();
	}
	@Override public void update(long currentTime) {
		if (currentTime/1e9 - lastTime >= timeSleep) {
			update();
			
			lastTime = currentTime/1e9;
		}
	}
	public void damage() {
		ArrayList<GameObject> target = this.getTarget();
		for (int i = 0; i < target.size(); i++) {
			target.get(i).getState().decreaseHP(this.dame);
		}
	}
	public ArrayList<GameObject> getTarget(){
		ArrayList<GameObject> list = new ArrayList<GameObject>();
		if (parentObject instanceof MainCharacter) {
			ArrayList<Monster> monsters = parentObject.getGameWorld().getCurrentMap().getMonsters();
			for (int i = 0; i < monsters.size(); i++) {
				if (this.impact(monsters.get(i))) {
					list.add(monsters.get(i));
				}
			}
		} else if (parentObject instanceof Monster) {
			MainCharacter character = parentObject.getGameWorld().getCharacter();
			if (this.impact(character)) {
				list.add(character);
			}
		}
		return list;
	}
	public boolean impact(GameObject gameObject) {
		if (gameObject == null || gameObject.getState().isDie) return false;
		double distance = this.getWeightPoint().distance(gameObject.getWeightPoint());
		if (distance <= Math.sqrt(2) * GameObject.BASE) {
			return true;
		}
		return false;
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
}
