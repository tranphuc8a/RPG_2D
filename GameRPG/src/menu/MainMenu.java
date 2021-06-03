package menu;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import system.Couple;
import system.GameConfig;
import system.Theme;
import system.myAudio;
import system.myGraphic;

public class MainMenu extends ParentMenu{
	public static void main(String[] args) {
		launch(args);
	}
	
	private Text menuName 			= null;
	
	public final int numButtons				= 5;
	public final Couple buttonSize 			= new Couple(180, 40);
	public StartMenu startMenu 				= new StartMenu(this);
	public HardLevelMenu hardLevelMenu 		= new HardLevelMenu(this);
	public HighScoreMenu highScoreMenu 		= new HighScoreMenu(this);
	public SettingMenu settingMenu 			= new SettingMenu(this);
	
	public MainMenu() {
		super();
	}
	
	@Override
	public void initialize()
	{
		System.out.println("Start Game");
		GameConfig.readData();
		Theme.setData();
		super.initialize();
		initButton();
		setEvent();
		initText();
		if (GameConfig.music)
			GameConfig.menubgAudio.play();
	}
	
	public void initButton()
	{
		buttons = new myGraphic[numButtons + 1];
		double layout = buttonFrame.getX() + (buttonFrame.getFitWidth() - buttonSize.x)/2;
		double distance = 5;
		for (int i = 1; i <= numButtons; i++)
		{
			buttons[i] = new myGraphic(GameConfig.theme.buttonPath);
			buttons[i].setSize(buttonSize.x, buttonSize.y);
			buttons[i].setX(layout);
			if (i > 1)
				buttons[i].setY(buttons[i - 1].getY() + distance + buttons[i - 1].getFitHeight());
			else
				buttons[1].setY(buttonFrame.getY() + 55);
			root.getChildren().add(buttons[i]);
		}
		// TEXT:
		name = new Text[numButtons + 1];
		for (int i = 1; i <= numButtons; i++) name[i] = new Text();
		int hardLevel = GameConfig.hardLevel;
		String hard = 	(hardLevel == GameConfig.EASY 	? "Dễ" : 
						(hardLevel == GameConfig.NORMAL ? "Trung bình" : "Khó"));
		name[1].setText("Bắt đầu");
		name[2].setText("Độ khó: " + hard);
		name[3].setText("Điểm cao");
		name[4].setText("Cài đặt");
		name[5].setText("Thoát");
		for (int i = 1; i <= numButtons; i++)
		{
			name[i].setX(buttons[i].getX() + (buttons[i].getFitWidth() - name[i].getText().length() * 8)/2);
			name[i].setY(buttons[i].getY() + 25);
			root.getChildren().add(name[i]);
			
			name[i].setFont(GameConfig.theme.nameButtonFont);
		}
	}
	public void setEvent()
	{
		EventHandler<MouseEvent> e1 = new EventHandler<MouseEvent>(){
			@Override public void handle(MouseEvent e) {
				stage.hide();
				startMenu.run();
			}
		};
		EventHandler<MouseEvent> e2 = new EventHandler<MouseEvent>(){
			@Override public void handle(MouseEvent e) {
				stage.hide();
				hardLevelMenu.run();
			}
		};
		EventHandler<MouseEvent> e3 = new EventHandler<MouseEvent>(){
			@Override public void handle(MouseEvent e) {
				stage.hide();
				highScoreMenu.run();
			}
		};
		EventHandler<MouseEvent> e4 = new EventHandler<MouseEvent>(){
			@Override public void handle(MouseEvent e) {
				stage.hide();
				settingMenu.run();
			}
		};
		EventHandler<MouseEvent> e5 = new EventHandler<MouseEvent>(){
			@Override public void handle(MouseEvent e) {
//				stage.hide();
				GameConfig.writeData();
				stop();
			}
		};
//		EventHandler<MouseEvent> e6 = new EventHandler<MouseEvent>(){
//			@Override public void handle(MouseEvent e) {
//				myGraphic gr = (myGraphic) e.getTarget();
//				gr.setX(gr.getX() + 20);
//			}
//		};
//		EventHandler<MouseEvent> e7 = new EventHandler<MouseEvent>(){
//			@Override public void handle(MouseEvent e) {
//				myGraphic gr = (myGraphic) e.getTarget();
//				gr.setX(gr.getX() - 20);
//			}
//		};
		
		buttons[1].addEventHandler(MouseEvent.MOUSE_CLICKED, e1);
		buttons[2].addEventHandler(MouseEvent.MOUSE_CLICKED, e2);
		buttons[3].addEventHandler(MouseEvent.MOUSE_CLICKED, e3);
		buttons[4].addEventHandler(MouseEvent.MOUSE_CLICKED, e4);
		buttons[5].addEventHandler(MouseEvent.MOUSE_CLICKED, e5);
		name[1].addEventHandler(MouseEvent.MOUSE_CLICKED, e1);
		name[2].addEventHandler(MouseEvent.MOUSE_CLICKED, e2);
		name[3].addEventHandler(MouseEvent.MOUSE_CLICKED, e3);
		name[4].addEventHandler(MouseEvent.MOUSE_CLICKED, e4);
		name[5].addEventHandler(MouseEvent.MOUSE_CLICKED, e5);
//		for (int i = 1; i <= 5; i++) {
//			buttons[i].addEventHandler(MouseEvent.MOUSE_ENTERED, e6);
//			buttons[i].addEventHandler(MouseEvent.MOUSE_EXITED, e7);
//		}
	}
	@Override public void run() {
		this.loadGraphic(GameConfig.theme);
		this.stage.show();
//		new myAudio("playbg.mp3", 120, false).play();
	}
	public void initText()
	{
		menuName = new Text("Game RPG 2D");
		menuName.setFont(GameConfig.theme.nameMenuFont);
		menuName.setX(nameFrame.getX() + 150);
		menuName.setY(nameFrame.getY() + 60);
		root.getChildren().add(menuName);
	}
}
