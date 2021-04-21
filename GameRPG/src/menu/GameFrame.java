package menu;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import system.Couple;
import system.EventDistributor;
import system.GameConfig;
import system.GameLoop;
import system.GameWorld;

public class GameFrame extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override public void start(Stage primaryStage) {
		initialize();
		primaryStage = this.stage;
		primaryStage.show();
		gameLoop.setFPS(50);
		gameLoop.start();
	}
	public void run() {
		this.start(stage);
	}
	@Override public void stop() {
		
	}
	
	public ParentMenu parent 			= null;
	private PauseMenu pauseMenu 		= new PauseMenu(this);
	private GameOverMenu gameOverMenu 	= null;

	private Stage stage = null;
	private Scene scene = null;
	private Group root = null;
	
//	private Camera camera = new Camera(this);
	private GameWorld gameWorld = new GameWorld(this);
	private GameLoop gameLoop = new GameLoop(this);
	private EventDistributor eventDistributor = new EventDistributor(this);
	
	public static final Couple stageSize = ParentMenu.stageSize;
	public static final Couple stagePosition = ParentMenu.stagePosition;
	
	public GameFrame() {}
	public GameFrame(ParentMenu parent) {
		this.parent = parent;
	}
	
	public void initialize() {
		stage = new Stage();
		root  = new Group();
		scene = new Scene(root);
		stage.setTitle("RPG_2D: " + GameConfig.hardLevel + ", " + GameConfig.numberPlayer + " người chơi.");
		stage.setScene(scene);
		stage.setX(stagePosition.x);
		stage.setY(stagePosition.y);
		stage.setWidth(stageSize.x);
		stage.setHeight(stageSize.y);
		stage.setMinWidth(stageSize.x);
		stage.setMinHeight(stageSize.y);
		stage.setMaxWidth(stageSize.x);
		stage.setMaxHeight(stageSize.y);
		// load ConfigGame
		// make Graph of list GameObject
		gameWorld.initialize();
		root.getChildren().addAll(gameWorld.getMap(), gameWorld.getCharacter());
		distributeEvent();
	}
	
	public void distributeEvent() {
		this.stage.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
			@Override public void handle(KeyEvent e) {
				eventDistributor.solve(e);
			}
		});
		this.stage.addEventHandler(MouseEvent.ANY, new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				eventDistributor.solve(e);
			}
		});
	}
	public void pauseGame() {
		stage.hide();
		gameLoop.stop();
		pauseMenu.run();
	}
	public void continueGame() {
		stage.show();
		gameLoop.start();
	}
	public void endGame() {
		stage.hide();
		gameLoop.stop();
		gameOverMenu.run();
	}
	public GameWorld getGameWorld() {
		return this.gameWorld;
	}
}
