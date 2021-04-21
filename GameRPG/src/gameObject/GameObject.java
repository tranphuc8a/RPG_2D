package gameObject;

import java.util.Random;
import system.Theme.ObjectPath;

import system.Animation;
import system.Couple;
import system.GameWorld;
import system.myGraphic;
import system.myImage;

public class GameObject extends myGraphic{
	public GameWorld gameWorld = null;
	public Map map 				= null;
	public Couple basePosition  = new Couple(0, 0);
	public Couple centerPosition = new Couple(0, 0);
	
	protected Animation front 	= new Animation(this);
	protected Animation behind 	= new Animation(this);
	protected Animation left 	= new Animation(this);
	protected Animation right 	= new Animation(this);
	
	public ObjectState state 	= new ObjectState();
	protected double timeSleep 	= 0.1;
	protected double lastTime 	= System.nanoTime() / 1e9;
	
	public static final int BASE 	= 60; // 1 base = 50 pixel
	
	public GameObject() {}
	public GameObject(ObjectPath path) {
		loadImage(path);
	}
	public GameObject(GameWorld gameWorld) {
		this();
		this.gameWorld = gameWorld;
		this.map = gameWorld.getMap();
	}
	
	public void initialize() {
		// init state
//		Random rand = new Random(22042001);
//		int x, y;
//		do {
//			x = rand.nextInt() % map.row;
//			y = rand.nextInt() % map.col;
//		}
//		while (map.matrix[x][y] != 0);
//		setBasePosition(x, y);
		state.direct = ObjectState.UP;
		state.speed = 5;
	}
	public void setBasePosition(int x, int y) {
		this.basePosition = new Couple(x, y);
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
			this.setY(this.getY() - speed);
		}
		if (state.isGoDown && !impactMap(ObjectState.DOWN)) {
			state.direct = ObjectState.DOWN;
			this.setY(this.getY() + speed);
		}
		if (state.isGoLeft && !impactMap(ObjectState.LEFT)) {
			state.direct = ObjectState.LEFT;
			this.setX(this.getX() - speed);
		}
		if (state.isGoRight && !impactMap(ObjectState.RIGHT)) {
			state.direct = ObjectState.RIGHT;
			this.setX(this.getX() + speed);
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
		centerPosition = new Couple(this.getX() + BASE/2, this.getY() + 3 * BASE / 2.0);
		double nextY = 0, nextX = 0;
		switch(direct) {
		case ObjectState.UP:
			nextY = centerPosition.y - state.speed;
			if (nextY < 0) return true;
			if (map.matrix[(int)this.getX()/BASE][(int)nextY/BASE] == 1)
				return true;
			break;
		case ObjectState.DOWN:
			nextY = centerPosition.y + state.speed;
			if (nextY/BASE >= map.row) return true;
			if (map.matrix[(int)this.getX()/BASE][(int)nextY/BASE] == 1)
				return true;
			break;
		case ObjectState.LEFT:
			nextX = centerPosition.x - state.speed;
			if (nextX/BASE < 0) return true;
			if (map.matrix[(int)nextX/BASE][(int)this.getX()/BASE] == 1)
				return true;
			break;
		case ObjectState.RIGHT:
			nextX = centerPosition.x + state.speed;
			if (nextX/BASE >= map.col) return true;
			if (map.matrix[(int)nextX/BASE][(int)this.getX()/BASE] == 1)
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
