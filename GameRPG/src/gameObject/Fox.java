package gameObject;

import system.GameConfig;
import system.Theme.ObjectPath;

public class Fox extends Monster {
	public Fox() {}
	public Fox(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}
	public Fox(double x, double y, GameWorld gameWorld) {
		this(gameWorld);
		this.setWeightPoint(x, y);
	}
	public Fox(double x, double y, int hardLevel, GameWorld gameWorld) {
		this(gameWorld);
		this.setWeightPoint(x,  y);
		this.setLevel(hardLevel);
	}
	public Fox(ObjectPath path, double x, double y, GameWorld gameWorld) {
		this(gameWorld);
		this.loadGraphic(path);
		this.setWeightPoint(x,  y);
	}
	public Fox(ObjectPath path, double x, double y, int hardLevel, GameWorld gameWorld) {
		this(gameWorld);
		this.loadGraphic(path);
		this.setWeightPoint(x,  y);
		this.setLevel(hardLevel);
	}
	
	@Override public void loadGraphic() {
		super.loadGraphic(GameConfig.theme.foxPath);
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
