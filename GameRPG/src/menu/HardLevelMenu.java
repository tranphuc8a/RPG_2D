package menu;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import system.Couple;
import system.GameConfig;
import system.myGraphic;

public class HardLevelMenu extends ParentMenu {
	public static void main(String[] args) {
		launch(args);
	}
	
	private Text menuName 			= null;
	
	public final int numButtons		= 3;
	public final Couple buttonSize 	= new Couple(200, 60);
	
	public HardLevelMenu() {}
	public HardLevelMenu(ParentMenu menu) {
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
		double distance = 15;
		double start = buttonFrame.getY() + 60;
		double layout = buttonFrame.getX() + (buttonFrame.getFitWidth() - buttonSize.x)/2;
		for (int i = 1; i <= numButtons; i++)
		{
			buttons[i] = new myGraphic("resource/frame/button2.png");
			buttons[i].setSize(buttonSize.x, buttonSize.y);
			buttons[i].setX(layout);
			if (i == 1)
				buttons[1].setY(start);
			else buttons[i].setY(buttons[i - 1].getY() + buttons[i - 1].getFitHeight() + distance);
			root.getChildren().add(buttons[i]);
		}
		// TEXT:
		name = new Text[numButtons + 1];
		for (int i = 1; i <= numButtons; i++) name[i] = new Text();
		name[1].setText("Dễ");
		name[2].setText("Trung bình");
		name[3].setText("Khó");
		for (int i = 1; i <= numButtons; i++)
		{	
			name[i].setX(buttons[i].getX() + (buttons[i].getFitWidth() - name[i].getText().length() * 8)/2);
			name[i].setY(buttons[i].getY() + 37);
			name[i].setFont(GameConfig.theme.nameButtonFont);
			root.getChildren().add(name[i]);
		}
	}
	public void setEvent()
	{
		EventHandler<MouseEvent> e1 = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				GameConfig.hardLevel = GameConfig.EASY;
				Text name = ((MainMenu) parent).getName()[2];
				myGraphic button = ((MainMenu) parent).getButtons()[2];
				name.setText("Độ khó: Dễ");
				name.setX(button.getX() + (button.getFitWidth() - name.getText().length() * 8)/2);
				stop();
			}
		};
		EventHandler<MouseEvent> e2 = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				GameConfig.hardLevel = GameConfig.NORMAL;
				Text name = ((MainMenu) parent).getName()[2];
				myGraphic button = ((MainMenu) parent).getButtons()[2];
				name.setText("Độ khó: Trung bình");
				name.setX(button.getX() + (button.getFitWidth() - name.getText().length() * 8)/2);
				stop();
			}
		};
		EventHandler<MouseEvent> e3 = new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				GameConfig.hardLevel = GameConfig.HARD;
				Text name = ((MainMenu) parent).getName()[2];
				myGraphic button = ((MainMenu) parent).getButtons()[2];
				name.setText("Độ khó: Khó");
				name.setX(button.getX() + (button.getFitWidth() - name.getText().length() * 8)/2);
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
		menuName = new Text("Độ khó");
		menuName.setFont(font);
		menuName.setX(nameFrame.getX() + 200);
		menuName.setY(nameFrame.getY() + 60);
		root.getChildren().add(menuName);
	}

}
