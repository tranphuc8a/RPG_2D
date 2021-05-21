package menu;

import javax.swing.GroupLayout.Alignment;

import gameObject.GameWorld;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import system.Camera;
import system.Couple;
import system.EventDistributor;
import system.GameConfig;
import system.GameConfig.Player;
import system.GameLoop;

public class GameFrame extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	@Override public void start(Stage primaryStage) {
		// start GAME
		initialize();
		loadGraphic();
		
		primaryStage = this.stage;
		primaryStage.show();
		
		gameLoop.start();
	}
	public void run() {
		this.start(stage);
	}
	@Override public void stop() {
		
	}
	
	public ParentMenu parent 			= null;
	private PauseMenu pauseMenu 		= new PauseMenu(this);
	private GameOverMenu gameOverMenu 	= new GameOverMenu(this);

	private Stage stage = null;
	private Scene scene = null;
	private Group root = null;
	
	private GameWorld gameWorld 		= new GameWorld(this);
	private Camera camera 				= new Camera(this);
	private GameLoop gameLoop 			= new GameLoop(this);
	private EventDistributor eventDistributor = new EventDistributor(this);
	
	
	public static final Couple stageSize = new Couple(800, 550);
	public static final Couple stagePosition = ParentMenu.stagePosition;
	public static final Couple stagePad = ParentMenu.padFrame;
	
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
		stage.setWidth(stageSize.x + stagePad.x);
		stage.setHeight(stageSize.y + stagePad.y);
		stage.setMinWidth(stageSize.x + stagePad.x);
		stage.setMinHeight(stageSize.y + stagePad.y);
		stage.setMaxWidth(stageSize.x + stagePad.x);
		stage.setMaxHeight(stageSize.y + stagePad.y);
		// load ConfigGame
		// make Graph of list GameObject
		
		gameWorld.initialize();
		gameLoop.setFPS(50);
		camera.initialize();
		distributeEvent();
	}
	public void loadGraphic() {
		gameWorld.loadGraphic();
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
//		gameWorld.loadGraphic();
		stage.show();
		gameLoop.start();
	}
	public void checkHighScore(int score) {
		if (score > GameConfig.highScore[5].score) {
			(new MessageBox() {

				@Override
				public void initialization() {
					super.initialization();
					inputName = new TextField();
					Content.setText("You f*cking break world records");
					Content.setLayoutX(20);
					Content.setLayoutY(50);
					root.getChildren().add(inputName);
					this.setTitle("Congratulation!!!");
					inputName.setLayoutX(10);
					inputName.setLayoutY(100);
					inputName.setPrefSize(200, 20);
					inputName.setText("Enter your name");
					inputName.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
						@Override public void handle(MouseEvent e) {
							inputName.setText("");
						}
					});
					okay.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {;
						@Override public void handle(MouseEvent e) {
							GameConfig.updateHighScore(inputName.getText(), score);
							gameOverMenu.run();
						}
					});
				}
			}).run();		
		} else gameOverMenu.run();
	}
	public void endGame(boolean isWin, int score) {
		stage.hide();
		gameLoop.stop();
		String infor = "";
		if (isWin) {
			infor += "YOU WIN!\n";
		} else infor += "YOU LOSE!\n";
		infor += "YOUR SCORE: " + score;
		gameOverMenu.getInformation().setText(infor);
		checkHighScore(score);
	}
	public GameWorld getGameWorld() {
		return this.gameWorld;
	}
	public Camera getCamera() {
		return this.camera;
	}
	public Group getRoot() {
		return this.root;
	}
}
