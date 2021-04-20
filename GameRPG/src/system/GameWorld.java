package system;

import gameObject.MainCharacter;
import gameObject.Map;
import gameObject.Monster;
import menu.GameFrame;

public class GameWorld {
	public GameFrame gameFrame = null;
	public int gamePoint = 0;
	
	private MainCharacter character = null;
	private Monster monsters[] = null;
	private Map map = null;
	
	public GameWorld() {}
	public GameWorld(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}
	
	public void initialize() {
		
	}
	public void render() {
		
	}
	public void update() {
		
	}
	
	// GET_SET GameObject
	public MainCharacter getCharacter() {
		return character;
	}
	public void setCharacter(MainCharacter character) {
		this.character = character;
	}
	public Monster[] getMonsters() {
		return monsters;
	}
	public void setMonsters(Monster[] monsters) {
		this.monsters = monsters;
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	
	
}
