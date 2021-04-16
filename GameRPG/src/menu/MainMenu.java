package menu;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
//import javafx.scene.text.FontPosture;
//import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import system.Couple;
import system.GameConfig;
import system.myGraphic;

public class MainMenu extends ParentMenu{
	public static void main(String[] args) {
		launch(args);
	}
	
	public GameConfig gameConfig 	= new GameConfig();
	private myGraphic buttons[]		= new myGraphic[6];
	private Text name[] 			= new Text[6];
	private Text menuName 			= null;
	
	public final Couple buttonSize 			= new Couple(150, 40);
	private StartMenu startMenu 			= new StartMenu(this);
//	private HardLevelMenu hardLevelMenu 	= new HardLevelMenu(this);
//	private HighScoreMenu highScoreMenu 	= new HighScoreMenu(this);
//	private SettingMenu settingMenu 		= new SettingMenu(this);
	
	public MainMenu() {
		super();
	}
	public MainMenu(GameConfig gmcfg) {
		super();
		this.gameConfig = gmcfg;
	}
	
	@Override
	public void initialize()
	{
		super.initialize();
		initButton();
		setEvent();
		initText();
	}
	
	public void initButton()
	{
		double layout = buttonFrame.getX() + (buttonFrame.getFitWidth() - buttonSize.x)/2;
		double distance = 5;
		for (int i = 1; i <= 5; i++)
		{
			buttons[i] = new myGraphic("resource/frame/button2.png");
			buttons[i].setSize(buttonSize.x, buttonSize.y);
			buttons[i].setX(layout);
			if (i > 1)
				buttons[i].setY(buttons[i - 1].getY() + distance + buttons[i - 1].getFitHeight());
			else
				buttons[1].setY(buttonFrame.getY() + 55);
			root.getChildren().add(buttons[i]);
		}
		// TEXT:
		
		for (int i = 1; i <= 5; i++)
		{
			name[i] = new Text();
			name[i].setX(buttons[i].getX() + 45);
			name[i].setY(buttons[i].getY() + 25);
			root.getChildren().add(name[i]);
			
			Font font = new Font("Time New Roman", 16);
			name[i].setFont(font);
		}
		name[1].setText("Bắt đầu");
		name[2].setText("Độ khó");
		name[3].setText("Điểm cao");
		name[4].setText("Cài đặt");
		name[5].setText("Thoát");
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
//				stage.hide();
//				hardLevelMenu.run();
			}
		};
		EventHandler<MouseEvent> e3 = new EventHandler<MouseEvent>(){
			@Override public void handle(MouseEvent e) {
//				stage.hide();
//				highScoreMenu.run();
			}
		};
		EventHandler<MouseEvent> e4 = new EventHandler<MouseEvent>(){
			@Override public void handle(MouseEvent e) {
//				stage.hide();
//				settingMenu.run();
			}
		};
		EventHandler<MouseEvent> e5 = new EventHandler<MouseEvent>(){
			@Override public void handle(MouseEvent e) {
//				stage.hide();
				stop();
			}
		};
		
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
	}
	
	public void initText()
	{
		menuName = new Text("Game RPG 2D");
		Font font = new Font("Consolas", 40);
		menuName.setFont(font);
		menuName.setX(nameFrame.getX() + 150);
		menuName.setY(nameFrame.getY() + 60);
		root.getChildren().add(menuName);
	}
}
