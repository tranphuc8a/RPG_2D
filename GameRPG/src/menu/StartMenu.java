package menu;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import system.Couple;
//import system.GameConfig;
import system.myGraphic;

public class StartMenu extends ParentMenu{
	public static void main(String[] args) {
		launch(args);
	}
	
	private myGraphic buttons[]		= new myGraphic[4];
	Text name[] 					= new Text[4];
	private Text menuName 			= null;
//	private GameFrame gameFrame 	= new GameFrame(this);
	
	public final Couple buttonSize = new Couple(200, 60);
	
	public StartMenu() {}
	public StartMenu(ParentMenu menu) {
		super(menu);
	}
	
	@Override public void initialize()
	{
		super.initialize();
		initButton();
		setEvent();
		initText();
	}
	public void initButton()
	{
		double distance = 15;
		double start = buttonFrame.getY() + 60;
		double layout = buttonFrame.getX() + (buttonFrame.getFitWidth() - buttonSize.x)/2;
		for (int i = 1; i <= 3; i++)
		{
			buttons[i] = new myGraphic("resource/frame/button2.png");
			buttons[i].setSize(buttonSize.x, buttonSize.y);
			buttons[i].setX(layout);
			if (i == 1)
				buttons[1].setY(start);
			else buttons[i].setY(buttons[i - 1].getY() + buttons[i - 1].getFitHeight() + distance);
			root.getChildren().add(buttons[i]);
		}
		Font font = new Font("Time new Roman", 18);
		for (int i = 1; i <= 3; i++)
		{
			name[i] = new Text();
			name[i].setX(buttons[i].getX() + 35);
			name[i].setY(buttons[i].getY() + 35);
			name[i].setFont(font);
			root.getChildren().add(name[i]);
		}
		name[1].setText("Một người chơi");
		name[2].setText("Hai người chơi");
		name[3].setText("Trở lại");
	}
	public void setEvent()
	{
		EventHandler<MouseEvent> e1 = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				stage.hide();
//				GameConfig gmcfg = ((MainMenu) parent).gameConfig;
//				gmcfg set 1 player;
//				gameFrame(gmcfg) run
			}
		};
		EventHandler<MouseEvent> e2 = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				stage.hide();
//				GameConfig gmcfg = ((MainMenu) parent).gameConfig;
//				gmcfg set 2 player;
//				gameFrame(gmcfg) run
			}
		};
		EventHandler<MouseEvent> e3 = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				stop();
			}
		};
		buttons[1].addEventHandler(MouseEvent.MOUSE_CLICKED, e1);
		buttons[2].addEventHandler(MouseEvent.MOUSE_CLICKED, e2);
		buttons[3].addEventHandler(MouseEvent.MOUSE_CLICKED, e3);
		name[2].addEventHandler(MouseEvent.MOUSE_CLICKED, e2);
		name[1].addEventHandler(MouseEvent.MOUSE_CLICKED, e1);
		name[3].addEventHandler(MouseEvent.MOUSE_CLICKED, e3);
	}
	public void initText()
	{
		Font font = new Font("Consolas", 40);
		menuName = new Text("Bắt đầu");
		menuName.setFont(font);
		menuName.setX(nameFrame.getX() + 200);
		menuName.setY(nameFrame.getY() + 60);
		root.getChildren().add(menuName);
	}
}
