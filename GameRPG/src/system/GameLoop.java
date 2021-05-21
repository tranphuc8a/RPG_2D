package system;

import gameObject.GameWorld;
import javafx.animation.AnimationTimer;
import menu.GameFrame;

public class GameLoop extends AnimationTimer {
	public static void main(String[] args) {
		new GameLoop().start();
	}
	private GameFrame gameFrame = null;
	
	@Override public void handle(long currentTime) {
		if (currentTime - lastTime >= SLEEP * 1e9) {
			gameFrame.getGameWorld().checkEndGame();
			
			gameFrame.getGameWorld().update(currentTime);
			gameFrame.getCamera().update();
			
			lastTime = currentTime;
		}
	}
	
	protected long lastTime = System.nanoTime();
	
	public static long TO_MILI = 1_000;
	public static long TO_MICRO = 1_000_000;
	public static long TO_NANO = 1_000_000_000;
	public static double FPS = 1;
	public static double SLEEP = 1.0 / FPS;
	
	public GameLoop() {}
	public GameLoop(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}
	public void setSleep(double second) {
		SLEEP = second;
		FPS = 1.0 / second;
	}
	public void setFPS(double fps) {
		FPS = fps;
		SLEEP = 1.0 / fps;
	}
}

