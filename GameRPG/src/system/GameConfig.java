package system;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

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
	
	public static myAudio menubgAudio = new myAudio("resource/audio/menubg.wav", 166, true); // 166
	public static myAudio playbgAudio = new myAudio("resource/audio/playbg.wav", 253, true);
	public static myAudio bulletAudio = new myAudio("resource/audio/bullet.wav", 0.2, false);
	public static myAudio knifeAudio = new myAudio("resource/audio/knife.wav", 0.2, false);
	public static myAudio breakrecordsAudio = new myAudio("resource/audio/breakrecords.wav", 3, false);
	
	public static void readData() {
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
				
		
		try (FileWriter fw = new FileWriter(new File("Data/GameConfig.txt"), StandardCharsets.UTF_8);
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
				writer.append(highScore[i].name);
				writer.newLine();
				writer.append(String.valueOf(highScore[i].score));
				writer.newLine();
			}
			
        } catch (Exception e) {
            e.printStackTrace();
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
