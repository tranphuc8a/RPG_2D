package gameObject;

import java.io.File;
import java.util.Scanner;

import system.GameConfig;
import system.myGraphic;
import system.myImage;

public class Map extends myGraphic {
	public int[][] matrix = null;
	public int row, col;
	
	public Map() {}
	public Map(String path) {
		super(path);
	}
	public void readMask(String path) throws Exception {
		File file = new File(path);
		Scanner fscan = new Scanner(file);	
		row = fscan.nextInt();
		col = fscan.nextInt();
		matrix = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[j][i] = fscan.nextInt();
//				matrix[i][j] = 0;
			}
		}
		fscan.close();
		System.out.println(row + ", " + col);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(matrix[j][i]);
			}
			System.out.println();
		}
	}
	
	public void initialize() {
		// readMask
		// loadGraphic
		this.setImage(new myImage(GameConfig.theme.mapImagePath[2]));
		try{this.readMask(GameConfig.theme.mapTextPath[2]);}
		catch (Exception e) {
			System.out.println("Cannot read file!");
		};
		this.setSize(row * GameObject.BASE, col * GameObject.BASE);
		this.setPosition(0, 0);
	}
}
