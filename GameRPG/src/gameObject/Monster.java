package gameObject;

import java.util.Random;

import javafx.scene.Group;
import system.Couple;
import system.GameConfig;
import system.Theme.ObjectPath;
import system.myImage;

public class Monster extends GameObject {
	public static final int EASY = 1;
	public static final int HARD = 2;
	
	protected HeartPoint hp = new HeartPoint(this);
	protected int level = Monster.EASY;
	
	public Monster() {}
	public Monster(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}
	public Monster(double x, double y, GameWorld gameWorld) {
		this(gameWorld);
		this.setRealPosition(x, y);
	}
	public Monster(double x, double y, int hardLevel, GameWorld gameWorld) {
		this(gameWorld);
		this.setRealPosition(x,  y);
		this.setLevel(hardLevel);
	}
	public Monster(ObjectPath path, double x, double y, GameWorld gameWorld) {
		this(gameWorld);
		this.loadGraphic(path);
		this.setRealPosition(x,  y);
	}
	public Monster(ObjectPath path, double x, double y, int hardLevel, GameWorld gameWorld) {
		this(gameWorld);
		this.loadGraphic(path);
		this.setRealPosition(x,  y);
		this.setLevel(hardLevel);
	}
	
	@Override public void loadGraphic() {
		// loadGraphic for monster
		// must be overrided at subClass
	}
	@Override public void loadGraphic(ObjectPath path) {
		super.loadGraphic(path);
		hp.loadGraphic();
	}
	@Override public void initialize() {
		if (level == Monster.EASY) {
			this.state.heartPoint = this.state.maxHP = 250;
			this.state.heartPoint = 50;
		} else {
			this.state.heartPoint = this.state.maxHP = 450;
			this.state.heartPoint = 80;
		}
		this.setTimeDizz(0 );
		this.state.heartPoint = this.state.maxHP = 250;
		this.setSize(4 * BASE, 4 * BASE);
		this.weightPoint.set(this.getFitWidth()/2, this.getFitHeight()/2);
		this.getState().speed = 0.25 * BASE;
		this.setTimeSleep(0.04);
		hp.initialize();
	}
	public void standstill() {
		this.state.isGoDown = false;
		this.state.isGoUp = false;
		this.state.isGoLeft = false;
		this.state.isGoRight = false;
	}
	public void updateEasy(long currentTime) {
		Random rand = new Random();
		int direct = rand.nextInt() % 2;
		if (direct != 0) {
			this.standstill();
			return;
		}
		
		direct = rand.nextInt() % 4 + 1;
		this.standstill();
		this.state.setGo(direct);
	}
	public void updateHard(long currentTime) {
		Random rand = new Random();
		int direct = rand.nextInt() % 2;
		if (direct != 0) {
			this.standstill();
			return;
		}
		MainCharacter character = gameWorld.getCharacter(); 
		Couple chrc = character.getWeightPoint();
		Couple pos  = this.getWeightPoint();
		if (Math.abs(pos.x - chrc.x) >= BASE) {
			this.standstill();
			if (pos.x < chrc.x) this.state.isGoRight = true;
			else this.state.isGoLeft = true;
		} else {
			this.standstill();
			if (pos.y < chrc.y) this.state.isGoDown = true;
			else this.state.isGoUp = true;
		}
	}
	
	
	@Override public void update(long currentTime) {
		if (!(!state.isDie && currentTime/1e9 - lastTime >= timeSleep
						   && currentTime/1e9 - lastTimeDizz >= timeDizz)) return;
		hp.update(currentTime);
		MainCharacter character = gameWorld.getCharacter(); 
		if (this.impactCharacter(character) && currentTime/1e9 - character.lastTimeDizz >= character.timeDizz) {
			character.state.setHP(character.state.heartPoint - this.state.dame);
			character.lastTimeDizz = currentTime/1e9;
			double nextX, nextY;
			Map map = gameWorld.getCurrentMap();
			switch(state.direct) {
			case ObjectState.UP:
				nextX = character.getWeightPoint().x;
				nextY = character.getWeightPoint().y - 5 * character.state.speed;
				if (map.getMatrix()[(int)(nextY/BASE)][(int)(nextX/BASE)] == 0)
					character.setWeightPoint(nextX, nextY);
				break;
			case ObjectState.DOWN:
				nextX = character.getWeightPoint().x;
				nextY = character.getWeightPoint().y + 5 * character.state.speed;
				if (map.getMatrix()[(int)(nextY/BASE)][(int)(nextX/BASE)] == 0)
					character.setWeightPoint(nextX, nextY);
				break;
			case ObjectState.LEFT:
				nextX = character.getWeightPoint().x - 5 * character.state.speed;
				nextY = character.getWeightPoint().y;
				if (map.getMatrix()[(int)(nextY/BASE)][(int)(nextX/BASE)] == 0)
					character.setWeightPoint(nextX, nextY);
				break;
			case ObjectState.RIGHT:
				nextX = character.getWeightPoint().x + 5 * character.state.speed;
				nextY = character.getWeightPoint().y;
				if (map.getMatrix()[(int)(nextY/BASE)][(int)(nextX/BASE)] == 0)
					character.setWeightPoint(nextX, nextY);
				break;
			}
			character.getHPGraphic().update();
			return;
		}
		if (level == Monster.EASY) {
			updateEasy(currentTime);
		} else {
			updateHard(currentTime);
		}
		super.update(currentTime);
	}
	@Override public void insert(Group root) {
		root.getChildren().addAll(this, hp);
	}
	public void remove(Group root) {
		root.getChildren().removeAll(this, hp);
	}
	public boolean impactCharacter(MainCharacter character) {
		return character.impactMonster(this);
	}
	// GETTER AND SETTER
	public void setLevel(int level) {
		if (level <= Monster.EASY) {
			this.level = Monster.EASY;
			this.state.heartPoint = this.state.maxHP = 400;
			this.state.dame = 50;
		} else {
			this.level = Monster.HARD;
			this.state.heartPoint = this.state.maxHP = 800;
			this.state.dame = 50;
		}
	}
	public int getLevel() {
		return this.level;
	}
	public HeartPoint getHPGraphic() {
		return this.hp;
	}
}
