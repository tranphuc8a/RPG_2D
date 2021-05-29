package system;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

//import java.io.File;
//
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.media.AudioClip;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.stage.Stage;


public class GameConfig {
	public class Player{
		public String name;
		public int score;
		public Player() {}
		public Player(String _name, int _score) {
			name = _name;
			score = _score;
		}
	}
	
	public static final int EASY = 1;
	public static final int NORMAL = 2;
	public static final int HARD = 3;
	
	public static final int FIRST_THEME = 1;
	public static final int SECOND_THEME = 2;
	public static final int THIRD_THEME = 3;
	
	public static int numberPlayer = 1;
	public static int hardLevel = EASY;
	public static Player[] highScore = new Player[6];
	public static boolean sound = true;
	public static boolean music = true;
	public static int noTheme = FIRST_THEME;
	public static Theme theme = Theme.FIRST_THEME();
	
	public static void readData() {
		Theme.setData();
		try
		{
			File file = new File("Data/GameConfig.txt");
			Scanner fscan = new Scanner(file);
			
			hardLevel = Integer.valueOf(fscan.nextLine());
			int isSound = Integer.valueOf(fscan.nextLine());
			int isMusic = Integer.valueOf(fscan.nextLine());
			noTheme = Integer.valueOf(fscan.nextLine());
			if (isSound == 1) sound = true; else sound = false;
			if (isMusic == 1) music = true; else music = false;
			if (noTheme == 1) theme = Theme.firstTheme;
			else if (noTheme == 2) theme = Theme.secondTheme;
			else theme = Theme.thirdTheme;
			
			for (int i = 1; i <= 5; i++) {
				highScore[i] = new GameConfig().new Player();
				highScore[i].name = fscan.nextLine().toString();
				highScore[i].score = Integer.valueOf(fscan.nextLine());
			}
			fscan.close();
		}
		catch (Exception e) {
			
			System.out.println("Cannot read GameConfig Data: " + e.getMessage());
		}
		
	}
	public static void writeData() {
		int isSound = sound ? 1 : 0;
		int isMusic = music ? 1 : 0;
		noTheme = (theme == Theme.firstTheme ? 1 : theme == Theme.secondTheme ? 2 : 3);
		
		try
		{
			File file = new File("Data/GameConfig.txt");
			
			try (FileWriter fw = new FileWriter(file, StandardCharsets.UTF_8);
	             BufferedWriter writer = new BufferedWriter(fw)) {
				
				writer.append(String.valueOf(hardLevel));
				writer.newLine();
				writer.append(String.valueOf(isSound));
				writer.newLine();
				writer.append(String.valueOf(isMusic));
				writer.newLine();
				writer.append(String.valueOf(noTheme));
				writer.newLine();
				for (int i = 1; i <= 5; i++) {
//	 				out.appendUTF(highScore[i].name);
					writer.append(highScore[i].name);
					writer.newLine();
					writer.append(String.valueOf(highScore[i].score));
					writer.newLine();
				}
				
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		catch(Exception e) {
			System.out.println("Cannot append Out GameConfig Data");
		}
	}
	public static String getHighScore() {
		StringBuffer res = new StringBuffer("");
		for (int i = 1; i <= 5; i++) {
			res.append(highScore[i].name + ": " + highScore[i].score + "\n");
		}
		return res.toString();
	}
	public static void updateHighScore(String name, int score) {
		int index = 1;
		while (index < 5 && score <= highScore[index].score) index++;
		if (index > 5) return;
		for (int i = 5; i > index; i--) {
			highScore[i].name = highScore[i - 1].name;
			highScore[i].score = highScore[i - 1].score;
		}
		highScore[index].name = name;
		highScore[index].score = score;
	}
}
