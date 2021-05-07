package gameObject;

import java.util.ArrayList;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import system.Animation;
import system.Couple;
import system.GameConfig;
import system.Theme.ObjectPath;
import system.myGraphic;


public class MainCharacter extends GameObject {
	public static final double BASE = GameObject.BASE;
	protected HeartPoint hp		= new HeartPoint(this);
	private Knife knife 		= new Knife(this);
	private Bullet bullet		= new Bullet(this);
	private GameObject hurtAnimation = new GameObject();
	

	MainCharacter() {}
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
	public void initHurtAnimation(GameObject hurt) {
		hurt.initialize();
		hurt.getState().direct = ObjectState.DOWN;
		hurt.getState().isDie = true;
		hurt.loadGraphic(GameConfig.theme.hurtPath);
		hurt.setSize(5 * BASE, 5 * BASE);
		hurt.setGameWorld(this.gameWorld);
		hurt.weightPoint.set(0.5 * hurt.getFitWidth(), 
							 0.5 * hurt.getFitHeight());
		hurt.setTimeSleep(0.001);
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
		bullet.initialize();
		knife.initialize();
		knife.loadGraphic();
		knife.getState().isDie = true;
		this.initHurtAnimation(hurtAnimation);
	}
	@Override public void insert(Group root) {
		super.insert(root);
		hp.insert(root);
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
		knife.getState().isDie = false;
		Group root = this.gameWorld.getGameFrame().getRoot();
		if (!(root.getChildren().contains(knife))) {
			root.getChildren().add(knife);
		}
		
		hurtAnimation.getState().isDie = false;
		hurtAnimation.setWeightPoint(knife.getWeightPoint().x, knife.getWeightPoint().y);
		switch (this.getState().direct) {
		case ObjectState.UP:
			hurtAnimation.setWeightPoint(this.getWeightPoint().x, 
					 this.getWeightPoint().y - knife.getLength());
			break;
		case ObjectState.DOWN:
			hurtAnimation.setWeightPoint(this.getWeightPoint().x, 
					 this.getWeightPoint().y + 0.5 * knife.getLength());
			break;
		case ObjectState.LEFT:
			hurtAnimation.setWeightPoint(this.getWeightPoint().x - 0.75 * knife.getLength(), 
					 this.getWeightPoint().y - BASE/2);
			break;
		case ObjectState.RIGHT:
			hurtAnimation.setWeightPoint(this .getWeightPoint().x + 0.75 * knife.getLength(), 
					 this.getWeightPoint().y - BASE/2);
			break;
		}
		if (!root.getChildren().contains(hurtAnimation))
			hurtAnimation.insert(root);
	}
	public void useGun() {
		if (!bullet.getState().isDie) return;
		
		bullet.getState().isDie = false;
		Group root = this.getGameWorld().getGameFrame().getRoot();
		bullet.getState().direct = this.state.direct;
		bullet.setWeightPoint(this.getWeightPoint().x, this.getWeightPoint().y);
		switch (this.getState().direct) {
		case ObjectState.UP:
			bullet.setWeightPoint(this.getWeightPoint().x, 
					 this.getWeightPoint().y - 2 * BASE);
			break;
		case ObjectState.DOWN:
			bullet.setWeightPoint(this.getWeightPoint().x, 
					 this.getWeightPoint().y + BASE);
			break;
		case ObjectState.LEFT:
			bullet.setWeightPoint(this.getWeightPoint().x - BASE, 
					 this.getWeightPoint().y);
			break;
		case ObjectState.RIGHT:
			bullet.setWeightPoint(this .getWeightPoint().x + BASE, 
					 this.getWeightPoint().y);
			break;
		}
		if (!root.getChildren().contains(bullet))
			bullet.insert(root);
	}
	@Override
	public void update(long currentTime) {
		if (!(!state.isDie && currentTime/1e9 - lastTime >= timeSleep
					 	   && currentTime/1e9 - lastTimeDizz >= timeDizz)) return;	
		super.update(currentTime); 
		hp.update(currentTime);
		
		if (!(knife.getState().isDie)) knife.update(currentTime); 
	
		if (!hurtAnimation.getState().isDie) {
			if (hurtAnimation.front.getCurrentFrame() >= hurtAnimation.front.getNumFrame() - 1) {
				hurtAnimation.getState().isDie = true;
				this.getGameWorld().getGameFrame().getRoot().getChildren().remove(hurtAnimation);
			}
			hurtAnimation.update();
		} else {
			this.getGameWorld().getGameFrame().getRoot().getChildren().remove(hurtAnimation); 
		}
		
		if (!bullet.getState().isDie) {
			bullet.update();
		} else {
			this.getGameWorld().getGameFrame().getRoot().getChildren().remove(bullet);
		}
			
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
