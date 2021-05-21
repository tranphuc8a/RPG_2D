package gameObject;

import java.util.ArrayList;

import system.Couple;
import system.GameConfig;

public class Knife extends Skill {
	private double length = 0;
	
	
	public Knife() {}
	public Knife(GameObject parentObject) {
		super(parentObject);
		this.state.direct = parentObject.getState().direct;
	}
	
	@Override public void loadGraphic() {
//		this.state.direct = parentObject.getState().direct;
		super.loadGraphic(GameConfig.theme.knifePath);
	}
	@Override public void initialize() {
		this.gameWorld = parentObject.getGameWorld();
		this.setTimeSleep(0.05);
		super.initialize();
		this.setSize(11 * BASE, 7.5 * BASE);
		this.weightPoint.set(0.48 * this.getFitWidth(), 0.85 * this.getFitHeight());
		this.length = 6 * BASE;
		this.setDame(10);
		this.state.isDie = true;
	}
	@Override public void update() {
		this.state.direct = parentObject.getState().direct;
		this.setWeightPoint(parentObject.getWeightPoint().x, 
							parentObject.getWeightPoint().y);
		super.update();
		
		boolean isCheck = false;
		switch (state.direct) {
		case ObjectState.UP:
			if (behind.getCurrentFrame() >= behind.getNumFrame() - 1) {
				this.state.isDie = true;
				isCheck = true;
			}
			break;
		case ObjectState.DOWN:
			if (front.getCurrentFrame() >= front.getNumFrame() - 1) {
				this.state.isDie = true;
				isCheck = true;
			}
			break;
		case ObjectState.LEFT:
			if (left.getCurrentFrame() >= left.getNumFrame() - 1) {
				this.state.isDie = true;
				isCheck = true;
			}
			break;
		case ObjectState.RIGHT:
			if (right.getCurrentFrame() >= right.getNumFrame() - 1) {
				this.state.isDie = true;
				isCheck = true;
			}
			break;
		}
		if (isCheck) {
			ArrayList<Monster> list = this.getGameWorld().getCurrentMap().getMonsters();
			for (int i = 0; i < list.size(); i++) {
				if (this.checkDamaged(list.get(i))) {
					list.get(i).getState().decreaseHP(this.dame);
//					list.get(i).update();
					list.get(i).lastTimeDizz = System.nanoTime()/1e9;
				}
			}
		}
		 
		if (this.state.isDie) {
			parentObject.getGameWorld().getGameFrame().getRoot().getChildren().remove(this);
		}
	}
	public boolean checkDamaged(Monster monster) {
		MainCharacter character = (MainCharacter) parentObject;
		this.state.direct = parentObject.getState().direct;
		Couple under = new Couple(parentObject.getX() + parentObject.getFitWidth() * 0.5,
								  parentObject.getY() + parentObject.getFitHeight() * 0.9);
		Couple vector = new Couple();
		switch (this.state.direct) {
		case ObjectState.LEFT:
			if (monster.getY() + 0.5 * monster.getFitHeight() < parentObject.getY()) return false;
			if (monster.getY() > parentObject.getY() + 0.5 * parentObject.getFitHeight()) 
					return false;
			if (monster.getWeightPoint().x > parentObject.getWeightPoint().x)
					return false;
			return Math.abs(monster.getWeightPoint().x - parentObject.getWeightPoint().x) 
					< this.length;
		case ObjectState.RIGHT:
			if (monster.getY() + 0.5 * monster.getFitHeight() < parentObject.getY()) return false;
			if (monster.getY() > parentObject.getY() + 0.5 * parentObject.getFitHeight()) 
					return false;
			if (monster.getWeightPoint().x < parentObject.getWeightPoint().x)
					return false;
			return Math.abs(monster.getWeightPoint().x - parentObject.getWeightPoint().x) 
					< this.length;
		case ObjectState.UP:
			if (monster.getWeightPoint().x < (character.getWeightPoint().x - BASE)) return false;
			if (monster.getWeightPoint().x > (character.getWeightPoint().x + BASE)) return false;
			if (this.getWeightPoint().y - monster.getWeightPoint().y < 0) return false;
			return Math.abs(monster.getWeightPoint().y - this.getWeightPoint().y) <= (this.length);
		case ObjectState.DOWN:
			if (monster.getWeightPoint().x < (character.getWeightPoint().x - BASE)) return false;
			if (monster.getWeightPoint().x > (character.getWeightPoint().x + BASE))  return false;
			if (this.getWeightPoint().y - monster.getWeightPoint().y > 0) return false;
			return Math.abs(this.getWeightPoint().y - monster.getWeightPoint().y) <= (this.length);
		}
		return false;
	}
	@Override public void update(long currentTime) {
		if (currentTime/1e9 - lastTime >= timeSleep) {
			update();
			lastTime = currentTime/1e9;
		}
	}
	
	// GETTER and SETTER
	public double getLength() {
		return this.length;
	}
}
