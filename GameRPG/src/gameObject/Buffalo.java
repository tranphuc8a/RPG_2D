package gameObject;

import system.GameConfig;
import system.Theme.ObjectPath;

public class Buffalo extends Monster{
	public Buffalo() {}
	public Buffalo(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}
	public Buffalo(double x, double y, GameWorld gameWorld) {
		this(gameWorld);
		this.setRealPosition(x, y);
	}
	public Buffalo(double x, double y, int hardLevel, GameWorld gameWorld) {
		this(gameWorld);
		this.setRealPosition(x,  y);
		this.setLevel(hardLevel);
	}
	public Buffalo(ObjectPath path, double x, double y, GameWorld gameWorld) {
		this(gameWorld);
		this.loadGraphic(path);
		this.setRealPosition(x,  y);
	}
	public Buffalo(ObjectPath path, double x, double y, int hardLevel, GameWorld gameWorld) {
		this(gameWorld);
		this.loadGraphic(path);
		this.setRealPosition(x,  y);
		this.setLevel(hardLevel);
	}
	
	@Override public void loadGraphic() {
		super.loadGraphic(GameConfig.theme.buffaloPath);
		this.hp.loadGraphic();
	}
	
	@Override public void initialize() {
		super.initialize();
		this.setTimeSleep(0.08);
		this.setSize(5 * BASE, 5 * BASE);
		this.weightPoint.set(0.5 * this.getFitWidth(), 0.9 * this.getFitHeight());
		this.state.speed = 0.5*BASE;
	}
}