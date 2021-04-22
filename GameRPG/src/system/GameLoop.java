package system;

import javafx.animation.AnimationTimer;
import menu.GameFrame;

public class GameLoop extends AnimationTimer {
	public static void main(String[] args) {
		new GameLoop().start();
	}
	private GameWorld gameWorld = null;
	@Override public void handle(long currentTime) {
		if (currentTime - lastTime >= SLEEP * 1e9) {
//			System.out.println("Loop called!");
			gameWorld.update(currentTime);
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
	
	private GameFrame gameFrame = null;
	
	public GameLoop() {}
	public GameLoop(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		this.gameWorld = gameFrame.getGameWorld();
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

