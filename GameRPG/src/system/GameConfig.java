package system;

//import java.io.File;
//
//import javafx.application.Application;
//import javafx.scene.Group;
//import javafx.scene.media.AudioClip;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.stage.Stage;

public class GameConfig {
	public static final int EASY = 0;
	public static final int NORMAL = 1;
	public static final int HARD = 2;
	
	public static final int FIRST_THEME = 3;
	public static final int SECOND_THEME = 4;
	public static final int THIRD_THEME = 5;
	
	public static int numberPlayer = 1;
	public static int hardLevel = EASY;
	public static int[] highScore = new int[6];
	public static boolean sound = true;
	public static boolean music = true;
	public static int theme = FIRST_THEME;
	
	public GameConfig() {
		for (int i = 1; i <= 5; i++)
			highScore[i] = 0;
	}
}
