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
		currentMap.loadGraphic();
		character.loadGraphic();
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
		currentMap = myHao;
		
		double BASE = GameObject.BASE;
		
		myHao.addMonster(new Bat(55 * BASE, 40 * BASE, Monster.HARD, this));
		myHao.addMonster(new Buffalo(55 * BASE, 30 * BASE, Monster.EASY, this));
		myHao.addMonster(new Fox(55 * BASE, 35 * BASE, Monster.EASY, this));
		myHao.addMonster(new Mouse(55 * BASE, 25 * BASE, Monster.EASY, this));
		myHao.addMonster(new Pig(55 * BASE, 45 * BASE, Monster.HARD, this));
		myHao.addMonster(new Snake(55 * BASE, 50 * BASE, Monster.HARD, this));
		
		// add monsters for each map
		// write later
		// using method: addMonster(Monster) of each map
		
		character.initialize();
		
		currentMap.insert(gameFrame.getRoot());
		character.insert(gameFrame.getRoot());
	}
	public void update(long currentTime) {
		// Check win or lose game
		int sumMonsters = myHao.countMonster() + 
						  xuanTruong.countMonster() + 
						  tuSon.countMonster();
		if (sumMonsters == 0) {
			System.out.println("You win");
			gameFrame.endGame(true, score);
		}
		if (character.state.isDie) {
			System.out.println("You lose");
			gameFrame.endGame(false, score);
		}
		// Update
		currentMap.update(currentTime);
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
		currentMap.loadGraphic();
		currentMap.insert(root);
		character.insert(root);
		System.out.println(currentMap.getImagePath() + " " + currentMap.getTextPath());
	}
	public GameFrame getGameFrame() {
		return this.gameFrame;
	}
	public int getScore() {
		return this.score;
	}
	public void addScore(int delta) {
		this.score += delta;
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
