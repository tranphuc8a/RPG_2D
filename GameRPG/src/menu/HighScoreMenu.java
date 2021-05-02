package menu;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import system.Couple;
import system.GameConfig;
import system.myGraphic;

public class HighScoreMenu extends ParentMenu {
	public static void main(String[] args) {
		launch(args);
	}
	
	private Text menuName 			= null;
	private Text content			= null;
	
	public final int numButtons		= 1;
	public final Couple buttonSize 	= new Couple(200, 60);
	
	public HighScoreMenu() {}
	public HighScoreMenu(ParentMenu menu) {
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
		buttons = new myGraphic[numButtons + 1];
		double start = buttonFrame.getY() + buttonFrame.getFitHeight() - buttonSize.y - 60;
		double layout = buttonFrame.getX() + (buttonFrame.getFitWidth() - buttonSize.x)/2;
		buttons[1] = new myGraphic("resource/frame/button2.png");
		buttons[1].setSize(buttonSize.x, buttonSize.y);
		buttons[1].setPosition(layout, start);
		root.getChildren().add(buttons[1]);
		// TEXT:
		name = new Text[numButtons + 1];
		for (int i = 1; i <= numButtons; i++) name[i] = new Text();
		name[1].setText("Okay");
		name[1].setX(buttons[1].getX() + (buttons[1].getFitWidth() - name[1].getText().length() * 8)/2);
		name[1].setY(buttons[1].getY() + 37);
		name[1].setFont(GameConfig.theme.nameButtonFont);
		root.getChildren().add(name[1]);
	}
	public void setEvent()
	{
		EventHandler<MouseEvent> e = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				stop();
			}
		};
		buttons[1].addEventHandler(MouseEvent.MOUSE_CLICKED, e);
		name[1].addEventHandler(MouseEvent.MOUSE_CLICKED, e);
	}
	public void initText()
	{
		// NAME MENU
		Font font = new Font("Consolas", 40);
		menuName = new Text("Điểm cao");
		menuName.setFont(font);
		menuName.setX(nameFrame.getX() + 200);
		menuName.setY(nameFrame.getY() + 60);
		root.getChildren().add(menuName);
		// HIGHSCORE
		
		content = new Text(GameConfig.getHighScore());
		content.setFont(new Font("Courier", 20));
		
		double layout = buttonFrame.getX() + (buttonFrame.getFitWidth() - 30)/2;
		double start  = buttonFrame.getY() + 90;
		content.setX(layout);
		content.setY(start);
		root.getChildren().add(content);
	}
}
