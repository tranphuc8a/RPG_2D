package menu;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import system.Couple;
import system.GameConfig;
import system.myGraphic;

public class GameOverMenu extends ParentMenu {
	public static void main(String[] args) {
		launch(args);
	}
	private GameFrame gameFrame 		= null;
	private MainMenu mainMenu 			= null;
	private HighScoreMenu highScoreMenu = null;
	
	private Text menuName				= null;
	private int numButtons 				= 2;
	public static final Couple buttonSize = new Couple(150, 60);
	
	private Text information = new Text();
	
	public GameOverMenu() {}
	public GameOverMenu(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}
	
	@Override public void initialize() { 
		super.initialize();
		mainMenu = (MainMenu) gameFrame.parent.parent;
		highScoreMenu = new HighScoreMenu(this);
		initButtons();
		initText();
		setEvent();
		if (GameConfig.music) 
			GameConfig.menubgAudio.play();
	}
	
	public void initButtons() {
		buttons = new myGraphic[numButtons + 1];
		name = new Text[numButtons + 1];
		double center = buttonFrame.getX() + buttonFrame.getFitWidth()/2 + 10;
		double layout = buttonFrame.getY() + 200;
		for (int i = 1; i <= numButtons; i++) {
			buttons[i] = new myGraphic(GameConfig.theme.buttonPath);
			buttons[i].setSize(buttonSize.x, buttonSize.y);
			buttons[i].setY(layout);
			
			name[i] = new Text();
			name[i].setFont(GameConfig.theme.nameButtonFont);
			root.getChildren().addAll(buttons[i], name[i]);
		}
		buttons[1].setX(buttonFrame.getX() + (buttonFrame.getFitWidth()/2 - buttonSize.x)/2 + 20);
		buttons[2].setX(center + (buttonFrame.getFitWidth()/2 - buttonSize.x)/2 - 20);
		name[1].setText("Menu chính");
		name[2].setText("Điểm cao");
		for (int i = 1; i <= numButtons; i++) {
			name[i].setX(buttons[i].getX() + (buttonSize.x - name[i].getText().length() * 8)/2 - 5);
			name[i].setY(buttons[i].getY() + 35);
		}
	}
	public void initText() {
		menuName = new Text("Game Over");
		menuName.setFont(GameConfig.theme.nameMenuFont);
		menuName.setX(nameFrame.getX() + 180);
		menuName.setY(nameFrame.getY() + 60);
		root.getChildren().add(menuName);
		
		information.setX(this.buttonFrame.getX() + 90);
		information.setY(this.buttonFrame.getY() + 100);
		information.setFont(Font.font("Time New Roman", FontWeight.EXTRA_BOLD, 30));
		information.setFill(Color.DEEPPINK);
		information.setTextAlignment(TextAlignment.CENTER);
		root.getChildren().add(information);
	}
	public void setEvent() {
		EventHandler<MouseEvent> e1 = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				stop();
				GameConfig.writeData();
				mainMenu.run();
			}
		};
		EventHandler<MouseEvent> e2 = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				stage.hide();
				highScoreMenu.run();
			}
		};
		buttons[1].addEventHandler(MouseEvent.MOUSE_CLICKED, e1);
		buttons[2].addEventHandler(MouseEvent.MOUSE_CLICKED, e2);
		name[1].addEventHandler(MouseEvent.MOUSE_CLICKED, e1);
		name[2].addEventHandler(MouseEvent.MOUSE_CLICKED, e2);
	}
	
	public Text getInformation() {
		return this.information;
	}
}
