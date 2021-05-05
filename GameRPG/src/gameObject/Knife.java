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
		this.length = 4 * BASE;
		this.setDame(500);
	}
	@Override public void update() {
		this.state.direct = parentObject.getState().direct;
		this.setWeightPoint(parentObject.getWeightPoint().x, 
							parentObject.getWeightPoint().y);
		super.update();
		ArrayList<Monster> list = this.getGameWorld().getCurrentMap().getMonsters();
		for (int i = 0; i < list.size(); i++) {
			if (this.checkDamaged(list.get(i))) {
				System.out.println("OK");
				list.get(i).getState().decreaseHP(this.dame);
				list.get(i).update();
			}
		}
	}
	public boolean checkDamaged(Monster monster) {
		MainCharacter character = (MainCharacter) parentObject;
		Couple vector = new Couple();
		switch (this.state.direct) {
		case ObjectState.LEFT:
			vector.set(monster.getWeightPoint().x - this.getWeightPoint().x,
					   monster.getWeightPoint().y - this.getWeightPoint().y);
			if (!(vector.y >= vector.x && vector.y <= 0)) return false;
			return vector.module() <= this.length;
		case ObjectState.RIGHT:
			vector.set(monster.getWeightPoint().x - this.getWeightPoint().x,
					   monster.getWeightPoint().y - this.getWeightPoint().y);
			if (!(vector.x >= 0 && vector.y <= 0 && vector.x + vector.y >= 0))
				return false;
			return vector.module() <= this.length;
		case ObjectState.UP:
			if (monster.getWeightPoint().x < character.getWeightPoint().x - BASE) return false;
			if (monster.getWeightPoint().x > character.getWeightPoint().x + BASE) return false;
			return this.weightPoint.y - monster.getWeightPoint().y <= this.length;
		case ObjectState.DOWN:
			if (monster.getWeightPoint().x < character.getWeightPoint().x - BASE) return false;
			if (monster.getWeightPoint().x > character.getWeightPoint().x + BASE) return false;
			return monster.getWeightPoint().y - this.weightPoint.y <= this.length;
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
}
