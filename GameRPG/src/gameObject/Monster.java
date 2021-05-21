package gameObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javafx.scene.Group;
import system.Couple;
import system.GameConfig;
import system.Theme.ObjectPath;
import system.myImage;

public class Monster extends GameObject {
	public static final int EASY = 1;
	public static final int HARD = 2;
	
	protected HeartPoint hp = new HeartPoint(this);
	protected int level = Monster.EASY;
	protected double lastTimeBite = 0;
	protected double timeWait = 1;
	
	public Monster() {}
	public Monster(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}
	public Monster(double x, double y, GameWorld gameWorld) {
		this(gameWorld);
		this.setRealPosition(x, y);
	}
	public Monster(double x, double y, int hardLevel, GameWorld gameWorld) {
		this(gameWorld);
		this.setRealPosition(x,  y);
		this.setLevel(hardLevel);
	}
	public Monster(ObjectPath path, double x, double y, GameWorld gameWorld) {
		this(gameWorld);
		this.loadGraphic(path);
		this.setRealPosition(x,  y);
	}
	public Monster(ObjectPath path, double x, double y, int hardLevel, GameWorld gameWorld) {
		this(gameWorld);
		this.loadGraphic(path);
		this.setRealPosition(x,  y);
		this.setLevel(hardLevel);
	}
	
	@Override public void loadGraphic() {
		// loadGraphic for monster
		// must be overrided at subClass
	}
	@Override public void loadGraphic(ObjectPath path) {
		super.loadGraphic(path);
		hp.loadGraphic();
	}
	@Override public void initialize() {
		if (level == Monster.EASY) {
			this.state.heartPoint = this.state.maxHP = 250;
			this.state.heartPoint = 50;
		} else {
			this.state.heartPoint = this.state.maxHP = 450;
			this.state.heartPoint = 80;
		}
		this.setTimeDizz(0 );
		this.state.heartPoint = this.state.maxHP = 250;
		this.setSize(4 * BASE, 4 * BASE);
		this.weightPoint.set(this.getFitWidth()/2, this.getFitHeight()/2);
		this.getState().speed = 0.25 * BASE;
		this.setTimeSleep(0.04);
		hp.initialize();
	}
	public void standstill() {
		this.state.isGoDown = false;
		this.state.isGoUp = false;
		this.state.isGoLeft = false;
		this.state.isGoRight = false;
	}
	public void updateEasy(long currentTime) {
		Random rand = new Random();
		int direct = rand.nextInt() % 2;
		if (direct != 0) {
			this.standstill();
			return;
		}
		
		direct = rand.nextInt() % 4 + 1;
		this.standstill();
		this.state.setGo(direct);
	}
	public void updateHard(long currentTime) {
		Random rand = new Random();
		int direct = rand.nextInt() % 2;
		if (direct != 0) {
			this.standstill();
			return;
		}
		MainCharacter character = gameWorld.getCharacter(); 
		Couple chrc = character.getWeightPoint();
		Couple pos  = this.getWeightPoint();
		double distance = 15 * BASE;
		if (chrc.distance(pos) >= distance) {
			direct = rand.nextInt() % 4 + 1;
			this.standstill();
			this.state.setGo(direct);
		} else {
			ArrayList<Couple> path = getPath();
			if (path.size() >= 2) {
				Couple direct2 = getPath().get(1);
	//			this.setWeightPoint(direct2.x* BASE, direct2.y * BASE);
				
				if (direct2.y - pos.y/BASE >= 0.5) {
					this.state.setGo(ObjectState.DOWN);
				} else if (direct2.y - pos.y/BASE <= -0.5) {
					this.state.setGo(ObjectState.UP);
				} else if (direct2.x - pos.x/BASE >= 0.5) {
					this.state.setGo(ObjectState.RIGHT);
				} else {
					this.state.setGo(ObjectState.LEFT);
				}
			}	
		}
	}
	
	public ArrayList<Couple> getPath(){
		ArrayList<Couple> result = new ArrayList<Couple>();
		
		MainCharacter character = this.getGameWorld().getCharacter();
		Map map = this.getGameWorld().getCurrentMap();
		
		Couple source = new Couple(this.getWeightPoint().x/BASE, this.getWeightPoint().y/BASE);
		Couple desti = new Couple(character.getWeightPoint().x/BASE, character.getWeightPoint().y/BASE);
		
		LinkedList<Couple> queue = new LinkedList<Couple>();
		Couple[][] trace = new Couple[map.getRow()][map.getCol()];
		boolean[][] visited = new boolean[map.getRow()][map.getCol()];
		
		visited[(int)source.x][(int)source.y] = true;
		trace[(int)source.x][(int)source.y] = new Couple(-1, -1);
		
		queue.addLast(source);
		
		Couple[] direct = {	new Couple(0, -1), 
							new Couple(0, 1), 
							new Couple(-1, 0), 
							new Couple(1, 0)	};
		Couple res = null;
		
		while (!queue.isEmpty()) {
			Couple front = queue.getFirst();
			queue.removeFirst();
			
			for (int i = 0; i < 4; i++) {
				Couple newCouple = new Couple(front.x + direct[i].x, front.y + direct[i].y);
				if (Math.abs(newCouple.x - desti.x) <= 0.5 && Math.abs(newCouple.y - desti.y) <= 0.5) {
					res = newCouple;
					trace[(int)res.x][(int) res.y] = front;
				} else if (!visited[(int) newCouple.x][(int) newCouple.y] 
							&& (map.getMatrix()[(int) newCouple.y][(int) newCouple.x] == 0)) {
					queue.addLast(newCouple);
					visited[(int) newCouple.x][(int) newCouple.y] = true;
					trace[(int) newCouple.x][(int) newCouple.y] = front;
				}
			}
		}
		
		if (res != null) {
			while (res.x >= 0) {
				result.add(0, res);
				res = trace[(int) res.x][(int) res.y];
			}
		}
		
		return result;
	}
	
	
	@Override public void update(long currentTime) {
		if (!(!state.isDie && currentTime/1e9 - lastTime >= timeSleep
						   && currentTime/1e9 - lastTimeDizz >= timeDizz)) return;
		hp.update(currentTime);
		MainCharacter character = gameWorld.getCharacter(); 
		
//		if (this.impactCharacter(character) && currentTime/1e9 - lastTimeBite >= timeWait) {
//			character.state.setHP(character.state.heartPoint - this.state.dame);
//			lastTimeBite = currentTime/1e9;
//			character.getHPGraphic().update();
//		}
		
		if (level == Monster.EASY) {
			updateEasy(currentTime);
		} else {
			updateHard(currentTime);
		}
		super.update(currentTime);
	}
	@Override public void insert(Group root) {
		root.getChildren().addAll(this, hp);
	}
	public void remove(Group root) {
		root.getChildren().removeAll(this, hp);
	}
	public boolean impactCharacter(MainCharacter character) {
		return character.impactMonster(this);
	}
	// GETTER AND SETTER
	public void setLevel(int level) {
		if (level <= Monster.EASY) {
			this.level = Monster.EASY;
			this.state.heartPoint = this.state.maxHP = 400;
			this.state.dame = 50;
		} else {
			this.level = Monster.HARD;
			this.state.heartPoint = this.state.maxHP = 800;
			this.state.dame = 50;
		}
	}
	public int getLevel() {
		return this.level;
	}
	public HeartPoint getHPGraphic() {
		return this.hp;
	}
}
