package gameObject;

import system.GameConfig;
import system.Theme.ObjectPath;

public class Pig extends Monster {
	public Pig() {}
	public Pig(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}
	public Pig(double x, double y, GameWorld gameWorld) {
		this(gameWorld);
		this.setRealPosition(x, y);
	}
	public Pig(double x, double y, int hardLevel, GameWorld gameWorld) {
		this(gameWorld);
		this.setRealPosition(x,  y);
		this.setLevel(hardLevel);
	}
	public Pig(ObjectPath path, double x, double y, GameWorld gameWorld) {
		this(gameWorld);
		this.loadGraphic(path);
		this.setRealPosition(x,  y);
	}
	public Pig(ObjectPath path, double x, double y, int hardLevel, GameWorld gameWorld) {
		this(gameWorld);
		this.loadGraphic(path);
		this.setRealPosition(x,  y);
		this.setLevel(hardLevel);
	}
	
	@Override public void loadGraphic() {
		super.loadGraphic(GameConfig.theme.pigPath);
		this.hp.loadGraphic();
	}
	
	@Override public void initialize() {
		super.initialize();
		this.setTimeSleep(0.08);
		this.state.speed = 0.35*BASE;
		this.setSize(4 * BASE, 4 * BASE);
		this.weightPoint.set(0.5 * this.getFitWidth(), 0.9 * this.getFitHeight());
	}
}
