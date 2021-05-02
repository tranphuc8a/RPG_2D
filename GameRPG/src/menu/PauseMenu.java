package menu;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import system.Couple;
import system.GameConfig;
import system.myGraphic;

public class PauseMenu extends ParentMenu {
	public static void main(String[] args) {
		launch(args);
	}
	private GameFrame gameFrame 			= null;
	private MainMenu mainMenu 				= null;
	private HighScoreMenu highScoreMenu 	= null;
	private SettingMenu settingMenu 		= null;
	
	private Text menuName					= null;
	private int numButtons 					= 4;
	public static final Couple buttonSize 	= new Couple(200, 50);
	
	public PauseMenu() {}
	public PauseMenu(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}
	
	@Override public void initialize() {
		super.initialize();
		mainMenu = (MainMenu) gameFrame.parent.parent;
		highScoreMenu = new HighScoreMenu(this);
		settingMenu = new SettingMenu(this);
		initButtons();
		initText();
		setEvent();
	}
	
	public void initButtons() {
		buttons = new myGraphic[numButtons + 1];
		name = new Text[numButtons + 1];
		double layout = buttonFrame.getX() + (buttonFrame.getFitWidth() - buttonSize.x)/2;
		double distance = 5, start = buttonFrame.getY() + 60;
		for (int i = 1; i <= numButtons; i++) {
			buttons[i] = new myGraphic(GameConfig.theme.buttonPath);
			buttons[i].setSize(buttonSize.x, buttonSize.y);
			if (i == 1) buttons[1].setY(start);
			else buttons[i].setY(buttons[i - 1].getY() + buttonSize.y + distance);
			buttons[i].setX(layout);
			
			name[i] = new Text();
			name[i].setFont(GameConfig.theme.nameButtonFont);
			root.getChildren().addAll(buttons[i], name[i]);
		}
		name[1].setText("Tiếp tục");
		name[2].setText("Điểm cao");
		name[3].setText("Cài đặt");
		name[4].setText("Menu chính");
		for (int i = 1; i <= numButtons; i++) {
			name[i].setX(buttons[i].getX() + (buttons[i].getFitWidth() - name[i].getText().length() * 8)/2);
			name[i].setY(buttons[i].getY() + 30);
		}
	}
	public void setEvent() {
		EventHandler<MouseEvent> e1 = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				stop();
				gameFrame.continueGame();
			}
		};
		EventHandler<MouseEvent> e2 = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				stage.hide();
				highScoreMenu.run();
			}
		};
		EventHandler<MouseEvent> e3 = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				stage.hide();
				settingMenu.run();
			}
		};
		EventHandler<MouseEvent> e4 = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				stop();
				gameFrame.stop();
				GameConfig.writeData();
				mainMenu.run();
			}
		};
		buttons[1].addEventFilter(MouseEvent.MOUSE_CLICKED, e1);
		buttons[2].addEventFilter(MouseEvent.MOUSE_CLICKED, e2);
		buttons[3].addEventFilter(MouseEvent.MOUSE_CLICKED, e3);
		buttons[4].addEventFilter(MouseEvent.MOUSE_CLICKED, e4);
		name[1].addEventFilter(MouseEvent.MOUSE_CLICKED, e1);
		name[2].addEventFilter(MouseEvent.MOUSE_CLICKED, e2);
		name[3].addEventFilter(MouseEvent.MOUSE_CLICKED, e3);
		name[4].addEventFilter(MouseEvent.MOUSE_CLICKED, e4);
	}
	public void initText() {
		menuName = new Text("Tạm dừng");
		menuName.setFont(GameConfig.theme.nameMenuFont);
		menuName.setX(nameFrame.getX() + 200);
		menuName.setY(nameFrame.getY() + 60);
		root.getChildren().add(menuName);
	}
	public GameFrame getGameFrame() {
		return this.gameFrame;
	}
}
