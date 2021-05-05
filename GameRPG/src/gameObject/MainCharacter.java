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
	private Knife knife 		= new Knife(this);
	
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
		this.setTimeSleep(0.04);
		this.setTimeDizz(0.2);
		this.state.heartPoint = this.state.maxHP = 1000;
		this.state.speed = 0.5 * BASE;
		this.state.direct = ObjectState.DOWN;
		this.setSize(4 * GameObject.BASE, 4 * GameObject.BASE);
		this.weightPoint.set(this.getFitWidth()/2, this.getFitHeight() * 3/4);
		this.setWeightPoint(53.5 * BASE, 8 * BASE);
		hp.initialize();
		knife.initialize();
		knife.getState().isDie = true;
	}
	@Override public void insert(Group root) {
		super.insert(root);
		hp.insert(root);
		knife.insert(root);
	}
	public void checkChangeMap() {
		// check change map
		Map map = gameWorld.getCurrentMap();
		int x = (int) (this.getWeightPoint().x / BASE);
		int y = (int) (this.getWeightPoint().y / BASE);
		int direct = map.getMatrix()[y][x];
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
			System.out.println("Xuan Truong");
			this.gameWorld.setCurrentMap(gameWorld.getXuanTruong());
			this.setWeightPoint(38 * BASE, 2 * BASE);			
		} 
	}
	public void useKnife() {
		if (!knife.getState().isDie) return;
		knife.getState().isDie = false;
//		this.gameWorld.getGameFrame().getRoot().getChildren().add(knife);
		knife.loadGraphic();
	}
	public void useGun() {
		
	}
	@Override
	public void update(long currentTime) {
		if (!(!state.isDie && currentTime/1e9 - lastTime >= timeSleep
					 	   && currentTime/1e9 - lastTimeDizz >= timeDizz)) return;	
		hp.update(currentTime);
		
		if (!knife.getState().isDie) knife.update(currentTime);
		
		super.update(currentTime);
		this.checkChangeMap();
	}
	public boolean impactMonster(Monster monster) {
		double distance = this.getWeightPoint().distance(monster.getWeightPoint());
		return distance <= Math.sqrt(2) * BASE;
	}
	public HeartPoint getHPGraphic() {
		return this.hp;
	}
}
