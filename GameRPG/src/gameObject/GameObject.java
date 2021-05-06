package gameObject;

import java.util.Random;

import javafx.scene.Group;
import menu.GameFrame;
import system.Theme.ObjectPath;

import system.Animation;
import system.Couple;
import system.myGraphic;
import system.myImage;

public class GameObject extends myGraphic{
	public static final double BASE = GameFrame.stageSize.x / 60; // 1 base
	
	protected GameWorld gameWorld  	= null;
	
	protected Couple realPosition 	= new Couple(0, 0);
	protected Couple position 		= new Couple(0, 0);
	protected Couple weightPoint 	= new Couple(0, 0);
	private	  Couple getWeightPoint = new Couple(0, 0);
	
	protected Animation front 	= new Animation(this);
	protected Animation behind 	= new Animation(this);
	protected Animation left 	= new Animation(this);
	protected Animation right 	= new Animation(this);
	
	protected ObjectState state 	= new ObjectState();
	protected double timeSleep 	= 0.1;
	protected double lastTime 	= System.nanoTime() / 1e9;
	
	protected double timeDizz 			= 3;
	protected double lastTimeDizz 		= System.nanoTime() / 1e9;
	
	public GameObject() {}
	public GameObject(ObjectPath path) {
		loadGraphic(path);
	}
	public GameObject(GameWorld gameWorld) {
		this();
		this.gameWorld = gameWorld;
	}
	
	public void loadGraphic(ObjectPath path) {
		behind.loadImage(path.behind);
		front.loadImage(path.front);
		left.loadImage(path.left);
		right.loadImage(path.right);
		this.setImage(new myImage(path.front[0]));
	}
	public void loadGraphic() {
		// do nothing
	}
	public void initialize() {
		// Map map = gameWorld.getCurrentMap();
		// init state
		state.direct = ObjectState.UP;
		state.speed = 0.5 * BASE;
		state.isDie = false;
		
//		int x = 0, y = 0;
//		Random rand = new Random();
//		do {
//			x = (Math.abs(rand.nextInt()) + map.getCol()) % (map.getCol());
//			y = (Math.abs(rand.nextInt()) + map.getRow()) % (map.getRow());
//		}
//		while (!((0 <= x) && (x < map.getCol()) && 
//				 (0 <= y) && (y < map.getRow()) && 
//				 (map.getMatrix()[y][x] == 0)));
//		setWeightPoint(x * BASE, y * BASE);
	}
	public void insert(Group root) {
		root.getChildren().add(this);
	}
	public void update() {
		this.setWeightPoint(this.getWeightPoint().x, this.getWeightPoint().y);
		double speed = state.speed;
		if (state.isGoCross()) speed /= Math.sqrt(2);
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
		switch (state.direct) {
		case ObjectState.UP:
			behind.update();
			break;
		case ObjectState.DOWN:
			front.update();
			break;
		case ObjectState.LEFT:
			left.update();
			break;
		case ObjectState.RIGHT:
			right.update();
			break;
		}
	}
	public void update(long currentTime) {
		if (!state.isDie && currentTime/1e9 - lastTime 		>= timeSleep && 
							currentTime/1e9 - lastTimeDizz 	>= timeDizz) {
			update();
			lastTime = currentTime/1e9;
		}
	}
	public boolean impactMap(int direct) {
		Map map = gameWorld.getCurrentMap();
		Couple center = this.getWeightPoint();
		double nextY = 0, nextX = 0;
		switch(direct) {
		case ObjectState.UP:
			nextY = center.y - state.speed;
			if (nextY < 0) return true;
			if (map.getMatrix()[(int)(nextY/BASE)][(int)(center.x/BASE)] == 1) {
				return true;
			}
			return false;
		case ObjectState.DOWN:
			nextY = center.y + state.speed;
			if (nextY/BASE > map.getRow() - 1) return true;
			if (map.getMatrix()[(int)(nextY/BASE)][(int)(center.x/BASE)] == 1)
				return true;
			break;
		case ObjectState.LEFT:
			nextX = center.x - state.speed;
			if (nextX < 0) return true;
			if (map.getMatrix()[(int)(center.y/BASE)][(int)(nextX/BASE)] == 1)
				return true;
			break;
		case ObjectState.RIGHT:
			nextX = center.x + state.speed;
			if (nextX/BASE > map.getCol() - 1) return true;
			if (map.getMatrix()[(int) (center.y/BASE)][(int) (nextX/BASE)] == 1)
				return true;
			break;
		}
		return false;
	}
	
	// Getter and Setter
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
	}
	public void setWeightPoint(double x, double y) {
		this.position.set(x - weightPoint.x, y - weightPoint.y);
		this.setPosition(position.x + gameWorld.getCurrentMap().getX(), 
					     position.y + gameWorld.getCurrentMap().getY());
	}
	public Couple getWeightPoint() {
		this.getWeightPoint.set(this.position.x + this.weightPoint.x, 
								this.position.y + this.weightPoint.y);
		return this.getWeightPoint;
	}
	public void setRealPosition(double x, double y) {
		this.position.set(x, y);
		this.setPosition(this.position.x + gameWorld.getCurrentMap().getX(), 
						 this.position.y + gameWorld.getCurrentMap().getY());
	}
	public Couple getRealPosition() {
		this.realPosition.set(this.getX(), this.getY());
		return this.realPosition;
	}
	public Couple getPosition() {
		return position;
	}
	public void setPosition(Couple position) {
		this.position = position;
	}
	public ObjectState getState() {
		return state;
	}
	public void setState(ObjectState state) {
		this.state = state;
	}
	public GameWorld getGameWorld() {
		return gameWorld;
	}
	public void setWeightPoint(Couple weightPoint) {
		this.weightPoint = weightPoint;
	}
	public void setTimeDizz(double timeDizz) {
		this.timeDizz = timeDizz;
	}
}
