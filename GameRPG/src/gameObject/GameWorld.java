package gameObject;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import menu.GameFrame;
import system.GameConfig;

public class GameWorld {
	private GameFrame gameFrame = null;
	private int score = 0;
	private Label Score = new Label();
	
	private MainCharacter character 	= new MainCharacter(this);
	private Map myHao 					= new Map(this);
	private Map xuanTruong 				= new Map(this);
	private Map tuSon 					= new Map(this);
	
	private Group root1, root2, root3, currentRoot = null;
	private Map currentMap 				= myHao;
	
	public GameWorld() {}
	public GameWorld(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}
	public void loadGraphic() {
		myHao.loadGraphic();
		xuanTruong.loadGraphic();
		tuSon.loadGraphic();
		character.loadGraphic();
	}
	
	public void initialize() {
		// init for 3 map and 1 character
		myHao.setImagePath(GameConfig.theme.mapImagePath[1]);
		xuanTruong.setImagePath(GameConfig.theme.mapImagePath[2]);
		tuSon.setImagePath(GameConfig.theme.mapImagePath[3]);
		myHao.setTextPath(GameConfig.theme.mapTextPath[1]);
		xuanTruong.setTextPath(GameConfig.theme.mapTextPath[2]);
		tuSon.setTextPath(GameConfig.theme.mapTextPath[3]);
		myHao.initialize();
		xuanTruong.initialize();
		tuSon.initialize();
		
		root1 = new Group(); root2 = new Group(); root3 = new Group();
		this.currentRoot = root1;
		gameFrame.setRoot(root1);
		
		setMyHaoMonster();
		setXuanTruongMonster();
		setTuSonMonster();
		
		int div = 0;
		if (GameConfig.hardLevel == GameConfig.NORMAL) {
			div = 2;
		} else if (GameConfig.hardLevel == GameConfig.HARD) {
			div = 1;
		}
		if (div > 0) {
			for (int i = 0; i < myHao.getMonsters().size() / div; i++) {
				myHao.getMonsters().get(i).setLevel(Monster.HARD);
			}
			for (int i = 0; i < xuanTruong.getMonsters().size() / div; i++) {
				xuanTruong.getMonsters().get(i).setLevel(Monster.HARD);
			}
			for (int i = 0; i < tuSon.getMonsters().size() / div; i++) {
				tuSon.getMonsters().get(i).setLevel(Monster.HARD);
			}
		}
		
		character.initialize();
		
		// insert map and character to stage
		myHao.insert(root1);
		xuanTruong.insert(root2);
		tuSon.insert(root3);
		character.insert(root1);
		root1.getChildren().add(Score);
		
		// init for text score
		Font font = Font.font("Time New Roman", FontWeight.EXTRA_BOLD, 30);
		
		Score.setTextFill(Color.LIGHTCYAN);
		Score.setFont(font);
		Score.setLayoutX(20);
		Score.setLayoutY(20);
		Score.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
		
		Score.setText("SCORE: 0");
	}
	public void update(long currentTime) {
		// Update
		currentMap.update(currentTime);
		character.update(currentTime);
	}
	
	public void checkEndGame() {
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
		this.currentMap = currentMap;
		currentRoot.getChildren().removeAll(character, character.getHPGraphic());
		if (currentMap == myHao) {
			gameFrame.setRoot(root1);
		} else if (currentMap == xuanTruong) {
			gameFrame.setRoot(root2);
		} else if (currentMap == tuSon) {
			gameFrame.setRoot(root3);
		} else {
			System.out.println("Error in changing map");
		}
		currentRoot = gameFrame.getRoot();
		character.insert(currentRoot);
		currentRoot.getChildren().add(Score);
		
		System.out.println(currentMap.getImagePath() + " " + currentMap.getTextPath());
	}
	public GameFrame getGameFrame() {
		return this.gameFrame;
	}
	public int getScore() {
		return this.score;
	}
	public void addScore(int delta) {
		this.setScore(score + delta);
	}
	public void setScore(int score) {
		if (score < 0) score = 0;
		this.score = score;
		Score.setText("SCORE: " + this.score);
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
	public void setMyHaoMonster() {
		double BASE = GameObject.BASE;
		double[][] listBuffaloPoint = {
			{14, 28}, {26, 26}, {85, 69}, {84, 88}, {76, 88}, {54, 76},
			{15, 60}, {21, 88}, {26, 78}, {48, 86}, {59, 53}, {9, 86},
			{76, 13}, {79, 42}, {80, 21}, {74, 59}, {43, 24},	
		};
		double[][] listPigPoint = {
			{18, 85}, {56, 83}, {49, 77}, {44, 30}, {54, 71}, {51, 58},
			{68, 26}, {66, 62}, {77, 68}, {85, 68}, {85, 53}, {85, 57},
			{85, 61}, {21, 35}, {9, 75}, {13, 65}
		};
		for (int i = 0; i < listBuffaloPoint.length; i++) {
			myHao.addMonster(new Buffalo(listBuffaloPoint[i][0] * BASE, 
										 listBuffaloPoint[i][1] * BASE, this));
		}
		for (int i = 0; i < listPigPoint.length; i++) {
			myHao.addMonster(new Pig(listPigPoint[i][0] * BASE, 
									 listPigPoint[i][1] * BASE, this));
		}
	}
	public void setXuanTruongMonster() {
		double BASE = GameObject.BASE;
		double[][] listBatPoint = {
			{4, 16}, {8, 14}, {23, 20}, {64, 20}, {83, 20},
			{82, 2.5}, {89, 1.5}, {88, 8}, {92.5, 8}, {3, 65},
			{14, 41}, {20, 39}, {24, 43}, {36, 69}, {16, 94}, 
			{38, 85}, {38, 88}, {40, 95}, {89, 68}, {73, 78}, {78, 89}
		};
		double[][] listFoxPoint = {
			{17, 23}, {30, 22}, {57, 19}, {78, 20}, {84, 14.5},
			{1, 50}, {4, 58}, {13, 64}, {59, 39}, {60, 59}, {54, 58},
			{46, 62}, {51, 65.5}, {37, 88}, {37, 90}, {79, 38},
			{75, 44}, {80, 43}, {89, 71}
		};
		for (int i = 0; i < listBatPoint.length; i++) {
			xuanTruong.addMonster(new Bat(listBatPoint[i][0] * BASE, 
										  listBatPoint[i][1] * BASE, this));
		}
		for (int i = 0; i < listFoxPoint.length; i++) {
			xuanTruong.addMonster(new Fox(listFoxPoint[i][0] * BASE, 
									      listFoxPoint[i][1] * BASE, this));
		}
	}
	public void setTuSonMonster() {
		double BASE = GameObject.BASE;
		double[][] listSnakePoint = {
			{58, 137}, {59, 140}, {72, 139}, {65, 129}, 
			{72, 120}, {57, 121}, {34, 116}, {3.5, 85}, {0.6, 62.2},
			{24.2, 66.8}, {31.3, 66.8}, {71.6, 94}, {48.7, 62.4},
			{74.3, 43}, {24.3, 45.9}, {27, 50.2}, {31.5, 51.7},
			{10.4, 20.5}, {10.4, 26.5}, {11.4, 33}, {14, 35.2},
			{18.2, 32.1}, {16.2, 25.6}, {20.7, 24.6}, {20.7, 30.6},
			{22.9, 20.04}	
		};
		double[][] listMousePoint = {
			{50, 125}, {28, 96}, {17, 95}, {19, 101}, 
			{8.4, 84.7}, {5.7, 78}, {6.7, 71.7}, {67.3, 96.2},
			{52.5, 97.4}, {39.3, 78.7}, {50.5, 80.2}, {71.3, 52.7},
			{68.4, 60.5}, {72.1, 67.7}, {65.1, 65.7}, {58.7, 33.9},
			{52.8, 36.3}, {43.8, 36.3}, {24.7, 35.1}	
		};
		for (int i = 0; i < listSnakePoint.length; i++) {
			tuSon.addMonster(new Snake(listSnakePoint[i][0] * BASE, 
									   listSnakePoint[i][1] * BASE, this));
		}
		for (int i = 0; i < listMousePoint.length; i++) {
			tuSon.addMonster(new Mouse(listMousePoint[i][0] * BASE, 
									   listMousePoint[i][1] * BASE, this));
		}
	}
	public Group getRoot1() {
		return root1;
	}
	public void setRoot1(Group root1) {
		this.root1 = root1;
	}
	public Group getRoot2() {
		return root2;
	}
	public void setRoot2(Group root2) {
		this.root2 = root2;
	}
	public Group getRoot3() {
		return root3;
	}
	public void setRoot3(Group root3) {
		this.root3 = root3;
	}
	
}
