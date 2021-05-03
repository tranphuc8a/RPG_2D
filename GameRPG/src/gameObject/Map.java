package gameObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.Group;
import system.GameConfig;
import system.myGraphic;
import system.myImage;

public class Map extends myGraphic {
	private String imagePath;
	private String textPath;
	
	private int[][] matrix = null;
	private int row, col;
	
	private GameWorld gameWorld = null;
	private ArrayList<Monster> monsters = new ArrayList<Monster>();
	
	public Map() {}
	public Map(String imagePath, String textPath) {
		super(imagePath);
		setImagePath(imagePath);
		setTextPath(textPath);
		readMask(textPath);
	}
	public Map(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}
	
	public void readMask(String path){
		this.setTextPath(path);
		this.readMask();
	}
	public void readMask() {
		File file = new File(textPath);
		try {
			Scanner fscan = new Scanner(file);
			row = col = 2;
			row = fscan.nextInt();
			col = fscan.nextInt();
			matrix = new int[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					matrix[i][j] = fscan.nextInt();
				}
			}
			fscan.close();
		}
		catch(Exception e) {
			System.out.println("readMask of Map error: " + e.getMessage());
		}
	}
	public void loadGraphic(String path) {
		this.setImagePath(path);
		this.loadGraphic();
	}
	public void loadGraphic() {
		this.setImage(new myImage(this.imagePath));
//		readMask(this.textPath);
		for (int i = 0; i < monsters.size(); i++) {
			monsters.get(i).loadGraphic();
		}
	}
	public void initialize() {
		this.readMask();
		this.setSize(col * GameObject.BASE, row * GameObject.BASE);
		this.setPosition(0, 0);
	}
	public void insert(Group root) {
		if (!root.getChildren().contains(root))
			root.getChildren().add(this);
		for (Monster mon : monsters) {
			if (!root.getChildren().contains(mon)) {
				mon.insert(root);
			}
		}
	}
	public void update(long currentTime) {
		for (int i = 0; i < monsters.size(); i++) {
			while (i < monsters.size() && monsters.get(i).state.isDie) {
				if (monsters.get(i).getLevel() == Monster.EASY) {
					gameWorld.addScore(1);
				} else gameWorld.addScore(2);
				monsters.remove(i);
			}
			if (i < monsters.size()) {
				monsters.get(i).update(currentTime);
			}
		}
	}
	
	
	// Getter and setter
	public void setGameWorld(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
//		this.loadGraphic(imagePath);
	}
	public String getTextPath() {
		return textPath;
	}
	public void setTextPath(String textPath) {
		this.textPath = textPath;
//		this.readMask(textPath);
	}
	public void set(String imagePath, String textPath) {
		this.setImagePath(imagePath);
		this.setTextPath(textPath);
	}
	public int[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public ArrayList<Monster> getMonsters() {
		return monsters;
	}
	public int countMonster() {
		return this.monsters.size();
	}
	public void setMonsters(ArrayList<Monster> monsters) {
		this.monsters = monsters;
	}
	public GameWorld getGameWorld() {
		return gameWorld;
	}
	public void addMonster(Monster monster) {
		monster.initialize();
		monsters.add(monster);
	}
}
