package gameObject;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import system.Couple;
import system.GameConfig;
import system.Theme.ObjectPath;


public class MainCharacter extends GameObject {
	public static final double BASE = GameObject.BASE;
	
	public MainCharacter() {}
	public MainCharacter(GameWorld gameWorld) {
//		super(gameWorld);
		this.gameWorld = gameWorld;
	}
	public void loadGraphic(String path) {
		this.loadGraphic(path);
		this.setWeightPoint(getWeightPoint().x, getWeightPoint().y);
	}
	@Override public void initialize() {
		super.initialize();
		this.setPosition(this.position.x, this.position.y);
		this.setSize(4 * GameObject.BASE, 4 * GameObject.BASE);
		
		this.weightPoint.set(this.getFitWidth()/2, this.getFitHeight() * 3/4);
		this.setTimeSleep(0.02);
		this.state.speed = 5;
	}
	@Override
	public void update(long currentTime) {
		super.update(currentTime);
		int x = (int) (this.getWeightPoint().x / BASE);
		int y = (int) (this.getWeightPoint().y / BASE);
		int direct = map.getMatrix()[y][x];
//		System.out.println(direct);
		if (direct == 0) return;
		else if (direct == 7) {
			// map tuSon
			this.gameWorld.setCurrentMap(gameWorld.getTuSon());
			this.map = gameWorld.getCurrentMap();
			this.setWeightPoint(43 * BASE, 147 * BASE);
		} else if (direct == 8) {
			// map myHao
			if (this.gameWorld.getCurrentMap() == this.gameWorld.getTuSon()) {
				this.setWeightPoint(53 * BASE, 2 * BASE);
			} else {
				this.setWeightPoint(53 * BASE, 95 * BASE);
			}
			this.gameWorld.setCurrentMap(gameWorld.getMyHao());
			this.map = gameWorld.getCurrentMap();
		} else if (direct == 9) {
			// map xuanTruong
			System.out.println("XUan Truong");
			this.gameWorld.setCurrentMap(gameWorld.getXuanTruong());
			this.map = gameWorld.getCurrentMap();
			this.setWeightPoint(37 * BASE, 2 * BASE);			
		} else {
			return;
		}
	}
}
