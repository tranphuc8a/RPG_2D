package gameObject;

import system.GameConfig;
import system.Theme.ObjectPath;

public class Bat extends Monster{
	public Bat() {}
	public Bat(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}
	public Bat(double x, double y, GameWorld gameWorld) {
		this(gameWorld);
		this.setWeightPoint(x, y);
	}
	public Bat(double x, double y, int hardLevel, GameWorld gameWorld) {
		this(gameWorld);
		this.setWeightPoint(x,  y);
		this.setLevel(hardLevel);
	}
	public Bat(ObjectPath path, double x, double y, GameWorld gameWorld) {
		this(gameWorld);
		this.loadGraphic(path);
		this.setWeightPoint(x,  y);
	}
	public Bat(ObjectPath path, double x, double y, int hardLevel, GameWorld gameWorld) {
		this(gameWorld);
		this.loadGraphic(path);
		this.setWeightPoint(x,  y);
		this.setLevel(hardLevel);
	}
	
	@Override public void loadGraphic() {
		super.loadGraphic(GameConfig.theme.batPath);
		this.hp.loadGraphic();
	}
	
	@Override public void initialize() {
		super.initialize();
		this.setTimeSleep(0.08);
		this.state.speed = 0.35*BASE;
	}
	
}
