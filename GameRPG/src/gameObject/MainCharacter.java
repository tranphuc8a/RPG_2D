package gameObject;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import system.Couple;
import system.GameConfig;
import system.Theme.ObjectPath;


public class MainCharacter extends GameObject {
	public static final double BASE = GameObject.BASE;
	protected HeartPoint hp		= new HeartPoint(this);
	
	public MainCharacter() {}
	public MainCharacter(GameWorld gameWorld) {
//		super(gameWorld);
		this.gameWorld = gameWorld;
	}
	@Override public void loadGraphic(ObjectPath path) {
		super.loadGraphic(path);
		this.hp.loadGraphic(GameConfig.theme.hpPath);
	}
	@Override public void loadGraphic() {
		super.loadGraphic(GameConfig.theme.charaterPath);
		this.hp.loadGraphic();
	}
	@Override public void initialize() {
		super.initialize();
		this.setTimeSleep(0.03);
		this.state.speed = 0.6 * BASE;
		this.state.direct = ObjectState.DOWN;
		this.setSize(4 * GameObject.BASE, 4 * GameObject.BASE);
		this.weightPoint.set(this.getFitWidth()/2, this.getFitHeight() * 3/4);
		this.setWeightPoint(53.5 * BASE, 8 * BASE);
		hp.initialize();
	}
	@Override public void insert(Group root) {
		super.insert(root);
		hp.insert(root);
	}
	@Override
	public void update(long currentTime) {
		Map map = gameWorld.getCurrentMap();
		if (currentTime - lastTime >= timeSleep) {
			hp.update(currentTime);
		}
		super.update(currentTime);
		int x = (int) (this.getWeightPoint().x / BASE);
		int y = (int) (this.getWeightPoint().y / BASE);
		int direct = map.getMatrix()[y][x];
//		System.out.println(direct);
		if (direct == 0) return;
		else if (direct == 7) {
			// map tuSon
			this.gameWorld.setCurrentMap(gameWorld.getTuSon());
			this.setWeightPoint(35 * BASE, 147 * BASE);
		} else if (direct == 8) {
			// map myHao
			if (this.gameWorld.getCurrentMap() == this.gameWorld.getTuSon()) {
				this.setWeightPoint(53.5 * BASE, 3 * BASE);
			} else {
				this.setWeightPoint(53.5 * BASE, 95 * BASE);
			}
			this.gameWorld.setCurrentMap(gameWorld.getMyHao());
		} else if (direct == 9) {
			// map xuanTruong
			System.out.println("XUan Truong");
			this.gameWorld.setCurrentMap(gameWorld.getXuanTruong());
			this.setWeightPoint(38 * BASE, 2 * BASE);			
		} else {
			return;
		}
	}
}
