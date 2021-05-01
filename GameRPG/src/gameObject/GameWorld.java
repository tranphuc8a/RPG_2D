package gameObject;

import javafx.scene.Group;
import menu.GameFrame;
import system.GameConfig;

public class GameWorld {
	private GameFrame gameFrame = null;
	private int score = 0;
	
	private MainCharacter character 	= new MainCharacter(this);
	private Map myHao 					= new Map(this);
	private Map xuanTruong 				= new Map(this);
	private Map tuSon 					= new Map(this);
	
	private Map currentMap				= null;
	
	public GameWorld() {}
	public GameWorld(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}
	public void loadGraphic() {
		currentMap.loadGraphic(currentMap.getImagePath());
		character.loadGraphic(GameConfig.theme.charaterPath);
	}
	public void initialize() {
		myHao.setImagePath(GameConfig.theme.mapImagePath[1]);
		xuanTruong.setImagePath(GameConfig.theme.mapImagePath[2]);
		tuSon.setImagePath(GameConfig.theme.mapImagePath[3]);
		
		myHao.setTextPath(GameConfig.theme.mapTextPath[1]);
		xuanTruong.setTextPath(GameConfig.theme.mapTextPath[2]);
		tuSon.setTextPath(GameConfig.theme.mapTextPath[3]);
		
		myHao.initialize();
		xuanTruong.initialize();
		tuSon.initialize();
		currentMap = tuSon;
		
		// add monsters for each map
		// write later
		// using method: addMonster(Monster) of each map
		
		character.initialize();
	}
	public void update(long currentTime) {
		character.update(currentTime);
	}
	
	// GET_SET GameObject
	public MainCharacter getCharacter() {
		return character;
	}
	public void setCharacter(MainCharacter character) {
		this.character = character;
	}
	public Map getCurrentMap() {
		return currentMap;
	}
	public void setCurrentMap(Map currentMap) {
		Group root = gameFrame.getRoot();
		root.getChildren().removeAll(root.getChildren());
		this.currentMap = currentMap;
		root.getChildren().addAll(currentMap, character);
		root.getChildren().addAll(currentMap.getMonsters());
		System.out.println(currentMap.getImagePath() + " " + currentMap.getTextPath());
		
		this.loadGraphic();
	}
	public GameFrame getGameFrame() {
		return this.gameFrame;
	}
	public int getScore() {
		return this.score;
	}
	public void setScore(int score) {
		if (score < 0) score = 0;
		this.score = score;
	}
	public Map getMyHao() {
		return myHao;
	}
	public Map getXuanTruong() {
		return xuanTruong;
	}
	public Map getTuSon() {
		return tuSon;
	}
}
