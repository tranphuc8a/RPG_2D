package system;

import gameObject.GameObject;
import gameObject.MainCharacter;
import gameObject.Map;
import gameObject.Monster;
import menu.GameFrame;

public class Camera {
	private GameFrame gameFrame = null;
	private Couple centerPosition = new Couple(0, 0);
	private Couple cameraSize = new Couple(0, 0);
	private Map map = null;
	private MainCharacter character = null;
	private Monster[] monsters = null;
	private Couple[] safeArea = new Couple[3];
	
	public Camera() {}
	public Camera(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}
	
	public void initialize() {
		this.map = gameFrame.getGameWorld().getMap();
		this.character = gameFrame.getGameWorld().getCharacter();
		this.monsters = gameFrame.getGameWorld().getMonsters();
		this.setCameraSize(gameFrame.stageSize.x, gameFrame.stageSize.y);
		update();
	}
	
	public void update() {
		if (character.positionMap.x < safeArea[1].x) {
			map.setX(0);
		}
		else if (character.positionMap.x > safeArea[2].x) {
			map.setX(this.cameraSize.x - map.getFitWidth());
		}
		else{
			map.setX(this.centerPosition.x - character.positionMap.x);
		}
		
		if (character.positionMap.y < safeArea[1].y) {
			map.setY(0);
		}
		else if (character.positionMap.y > safeArea[2].y) {
			map.setY(this.cameraSize.y - map.getFitHeight());
		}
		else{
			map.setY(this.centerPosition.y - character.positionMap.y);
		}
		
//		character.setPosition(character.positionMap.x + map.getX(), character.positionMap.y + map.getY());
	}
	
	// GET/SET:
	public GameFrame getGameFrame() {
		return gameFrame;
	}
	public void setGameFrame(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}
	public Couple getCenterPosition() {
		return centerPosition;
	}
	public void setCenterPosition(double x, double y) {
		this.centerPosition = new Couple(x, y);
	}
	public Couple getCameraSize() {
		return cameraSize;
	}
	public void setCameraSize(double x, double y) {
		this.cameraSize = new Couple(x, y);
		this.safeArea[1] = new Couple(this.cameraSize.x/2, this.cameraSize.y/2);
		this.safeArea[2] = new Couple(this.map.col * GameObject.BASE - this.cameraSize.x/2,
									  this.map.row * GameObject.BASE - this.cameraSize.y/2);
		setCenterPosition(cameraSize.x/2, cameraSize.y/2);
	}
}
