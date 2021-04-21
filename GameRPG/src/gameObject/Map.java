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
				matrix[i][j] = fscan.nextInt();
			}
		}
		fscan.close();
	}
	
	public void initialize() {
		// readMask
		// loadGraphic
		this.setImage(new myImage(GameConfig.theme.mapPath[0]));
		row = col = 75;
		matrix = new int[row][col];
		for (int i = 0; i < row; i++)
		{
			for (int j = 0; j < col; j++)
			{
				matrix[i][j] = 0;
			}
		}
	}
}
