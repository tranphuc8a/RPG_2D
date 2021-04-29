package gameObject;

import java.util.Random;

import menu.GameFrame;
import system.Theme.ObjectPath;

import system.Animation;
import system.Couple;
import system.GameWorld;
import system.myGraphic;
import system.myImage;

public class GameObject extends myGraphic{
	public GameWorld gameWorld  = null;
	public Map map 				= null;
	
	public Couple position 		= new Couple(0, 0);
	public Couple size 			= new Couple(0, 0);
	public Couple weightPoint 	= new Couple(0, 0);
	
	protected Animation front 	= new Animation(this);
	protected Animation behind 	= new Animation(this);
	protected Animation left 	= new Animation(this);
	protected Animation right 	= new Animation(this);
	
	public ObjectState state 	= new ObjectState();
	protected double timeSleep 	= 0.1;
	protected double lastTime 	= System.nanoTime() / 1e9;
	
	public static final double BASE = GameFrame.stageSize.x / 50; // 1 base
	
	public GameObject() {}
	public GameObject(ObjectPath path) {
		loadImage(path);
	}
	public GameObject(GameWorld gameWorld) {
		this();
		this.gameWorld = gameWorld;
	}
	
	public void initialize() {
		this.map = gameWorld.getMap();
		// init state
		int x = 0, y = 0;
		Random rand = new Random();
		do {
			x = (Math.abs(rand.nextInt()) + map.row) % (map.row);
			y = (Math.abs(rand.nextInt()) + map.col) % (map.col);
		}
		while (!((0 <= x) && (x < map.row) && 
				 (0 <= y) && (y < map.col) && 
				 (map.matrix[x][y] == 0)));
		setWeightPoint(x * BASE, y * BASE);
		state.direct = ObjectState.UP;
		state.speed = 5;
	}
	public void setWeightPoint(double x, double y) {
		this.position.set(x - weightPoint.x, y - weightPoint.y);
	}
	public Couple getWeightPoint() {
		return new Couple(this.position.x + this.weightPoint.x, this.position.y + this.weightPoint.y);
	}
	public void setRealPosition(double x, double y) {
		this.position.set(x, y);
		this.setPosition(this.position.x + map.getX(), this.position.y + map.getY());
	}
	public void loadImage(ObjectPath path) {
		behind.loadImage(path.behind);
		front.loadImage(path.front);
		left.loadImage(path.left);
		right.loadImage(path.right);
		this.setImage(new myImage(path.front[0]));
	}
	public void update() {
		double speed = state.speed;
		if (state.isGoCross) speed /= Math.sqrt(2);
		if (state.isGoUp && !impactMap(ObjectState.UP)) {
			state.direct = ObjectState.UP;
			this.setRealPosition(this.position.x, this.position.y - speed);
		}
		if (state.isGoDown && !impactMap(ObjectState.DOWN)) {
			state.direct = ObjectState.DOWN;
			this.setRealPosition(this.position.x, this.position.y + speed);
		}
		if (state.isGoLeft && !impactMap(ObjectState.LEFT)) {
			state.direct = ObjectState.LEFT;
			this.setRealPosition(this.position.x - speed, this.position.y);
		}
		if (state.isGoRight && !impactMap(ObjectState.RIGHT)) {
			state.direct = ObjectState.RIGHT;
			this.setRealPosition(this.position.x + speed, this.position.y);
		}
	}
	public void update(long currentTime) {
		if (!state.isDie && currentTime/1e9 - lastTime >= timeSleep) {
			update();
			switch (state.direct) {
			case ObjectState.UP:
				behind.update(currentTime);
				break;
			case ObjectState.DOWN:
				front.update(currentTime);
				break;
			case ObjectState.LEFT:
				left.update(currentTime);
				break;
			case ObjectState.RIGHT:
				right.update(currentTime);
				break;
			}
			lastTime = currentTime/1e9;
		}
	}
	public boolean impactMap(int direct) {
		Couple x = this.getWeightPoint();
		System.out.println(x.x/BASE + ", " + x.y/BASE + ", " + map.matrix[(int)(x.x/BASE)][(int)(x.y/BASE)]);
		
		Couple center = this.getWeightPoint();
		double nextY = 0, nextX = 0;
		switch(direct) {
		case ObjectState.UP:
			nextY = center.y - state.speed;
			if (nextY < 0) return true;
			if (map.matrix[(int)(center.x/BASE)][(int)(nextY/BASE)] == 1) {
				return true;
			}
			return false;
		case ObjectState.DOWN:
			nextY = center.y + state.speed;
			if (nextY/BASE > map.row - 1) return true;
			if (map.matrix[(int)(center.x/BASE)][(int)(nextY/BASE)] == 1)
				return true;
			break;
		case ObjectState.LEFT:
			nextX = center.x - state.speed;
			if (nextX < 0) return true;
			if (map.matrix[(int) (nextX/BASE)][(int)(center.y/BASE)] == 1)
				return true;
			break;
		case ObjectState.RIGHT:
			nextX = center.x + state.speed;
			if (nextX/BASE > map.col - 1) return true;
			if (map.matrix[(int) (nextX/BASE)][(int) (center.y/BASE)] == 1)
				return true;
			break;
		}
		return false;
	}
	public boolean impactMap() {
		if (state.isDie) return false;
		switch (state.direct) {
		case ObjectState.UP:
			if (impactMap(ObjectState.UP)) return true;
			if (state.isGoLeft && impactMap(ObjectState.LEFT)) return true;
			if (state.isGoRight && impactMap(ObjectState.RIGHT)) return true;
			return false;
		case ObjectState.DOWN:
			if (impactMap(ObjectState.DOWN)) return true;
			if (state.isGoLeft && impactMap(ObjectState.LEFT)) return true;
			if (state.isGoRight && impactMap(ObjectState.RIGHT)) return true;
			return false;
		case ObjectState.LEFT:
			if (impactMap(ObjectState.LEFT)) return true;
			if (state.isGoUp && impactMap(ObjectState.UP)) return true;
			if (state.isGoDown && impactMap(ObjectState.DOWN)) return true;
			return false;
		case ObjectState.RIGHT:
			if (impactMap(ObjectState.RIGHT)) return true;
			if (state.isGoUp && impactMap(ObjectState.UP)) return true;
			if (state.isGoDown && impactMap(ObjectState.DOWN)) return true;
			return false;
		}
		return false;
	}
	public boolean impact(Monster monster) {
		if (state.isDie) return false;
		
		return false;
	}
	public double getTimeSleep() {
		return this.timeSleep;
	}
	public void setTimeSleep(double sleep) {
		this.timeSleep = sleep;
		front.setTimeSleep(sleep);
		behind.setTimeSleep(sleep);
		left.setTimeSleep(sleep);
		right.setTimeSleep(sleep);
	}
	public void setGameWorld(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
		this.map = gameWorld.getMap();
	}
}
