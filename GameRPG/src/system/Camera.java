package system;

import gameObject.GameObject;
import gameObject.MainCharacter;
import gameObject.Map;
import gameObject.Monster;
import menu.GameFrame;

public class Camera {
	private GameFrame gameFrame 	= null;
	private Couple centerPosition 	= new Couple(0, 0);
	private Couple cameraSize 		= new Couple(0, 0);
	private Couple[] safeArea 		= new Couple[3];
	
	public Camera() {}
	public Camera(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}
	
	public void initialize() {
		for (int i = 1; i <= 2; i++) safeArea[i] = new Couple(0, 0);
		update();
	}
	
	public void update() {
		Map map = gameFrame.getGameWorld().getCurrentMap();
		MainCharacter character = gameFrame.getGameWorld().getCharacter();
		
		this.setCameraSize(gameFrame.stageSize.x, gameFrame.stageSize.y);
		Couple center = character.getWeightPoint();
		if (center.x < safeArea[1].x) {
			map.setX(0);
		}
		else if (center.x > safeArea[2].x) {
			map.setX(this.cameraSize.x - map.getFitWidth());
		}
		else{
			map.setX(this.centerPosition.x - center.x);
		}
		
		if (center.y < safeArea[1].y) {
			map.setY(0);
		}
		else if (center.y > safeArea[2].y) {
			map.setY(this.cameraSize.y - map.getFitHeight());
		}
		else{
			map.setY(this.centerPosition.y - center.y);
		}
		
		character.setPosition(character.getPosition().x + map.getX(), character.getPosition().y + map.getY());
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
		Map map = gameFrame.getGameWorld().getCurrentMap();
		this.cameraSize.set(x, y);
		this.safeArea[1].set(this.cameraSize.x/2, this.cameraSize.y/2);
		this.safeArea[2].set(map.getFitWidth() - cameraSize.x/2, map.getFitHeight() - cameraSize.y/2);
		setCenterPosition(cameraSize.x/2, cameraSize.y/2);
	}
}
