package gameObject;

import system.GameConfig;
import system.Theme.ObjectPath;

public class Snake extends Monster {
	public Snake() {}
	public Snake(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}
	public Snake(double x, double y, GameWorld gameWorld) {
		this(gameWorld);
		this.setRealPosition(x, y);
	}
	public Snake(double x, double y, int hardLevel, GameWorld gameWorld) {
		this(gameWorld);
		this.setRealPosition(x,  y);
		this.setLevel(hardLevel);
	}
	public Snake(ObjectPath path, double x, double y, GameWorld gameWorld) {
		this(gameWorld);
		this.loadGraphic(path);
		this.setRealPosition(x,  y);
	}
	public Snake(ObjectPath path, double x, double y, int hardLevel, GameWorld gameWorld) {
		this(gameWorld);
		this.loadGraphic(path);
		this.setRealPosition(x,  y);
		this.setLevel(hardLevel);
	}
	
	@Override public void loadGraphic() {
		super.loadGraphic(GameConfig.theme.snakePath);
		this.hp.loadGraphic();
	}
	
	@Override public void initialize() {
		super.initialize();
		this.setTimeSleep(0.1);
		this.state.speed = 0.35*BASE;
		this.setSize(4 * BASE, 4 * BASE);
		this.weightPoint.set(0.5 * this.getFitWidth(), 0.9 * this.getFitHeight());
	}
}
