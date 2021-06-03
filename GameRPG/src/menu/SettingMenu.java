package menu;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import system.Couple;
import system.GameConfig;
import system.Theme;
import system.myGraphic;

public class SettingMenu extends ParentMenu{
	public static void main(String[] args) {
		launch(args);
	}
	
	private Text nameMenu = new Text();
	
	public static final int numButtons = 4;
	public static final Couple buttonSize = new Couple(200, 50);
	
	public SettingMenu() {}
	public SettingMenu(ParentMenu menu) {
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
		name = new Text[numButtons + 1];
		double start = buttonFrame.getY() + 55;
		double distance = 8;
		double layout = buttonFrame.getX() + (buttonFrame.getFitWidth() - buttonSize.x)/2;
		for (int i = 1; i <= numButtons; i++)
		{
			buttons[i] = new myGraphic("resource/frame/button2.png");
			name[i] = new Text();
			buttons[i].setSize(buttonSize.x, buttonSize.y);
			double y;
			if (i > 1) y = buttons[i - 1].getY() + buttons[i - 1].getFitHeight() + distance;
			else y = start;
			buttons[i].setPosition(layout, y);
			root.getChildren().addAll(buttons[i], name[i]);
		}
		// NAME:
		if (GameConfig.music) name[1].setText("Nhạc nền: Bật");
		else name[1].setText("Nhạc nền: Tắt");
		if (GameConfig.sound) name[2].setText("Âm thanh: Bật");
		else name[2].setText("Âm thanh: Tắt");
		if (GameConfig.noTheme == GameConfig.FIRST_THEME) name[3].setText("Theme: theme 1");
		else if (GameConfig.noTheme == GameConfig.SECOND_THEME) name[3].setText("Theme: theme 2");
		else name[3].setText("Theme: theme 3");
		name[4].setText("Okay");
		for (int i = 1; i <= numButtons; i++)
		{
			name[i].setX(buttons[i].getX() + (buttons[i].getFitWidth() - name[i].getText().length() * 8)/2);
			name[i].setY(buttons[i].getY() + 30);
			name[i].setFont(GameConfig.theme.nameButtonFont);
		}
	}
	public void setEvent()
	{
		EventHandler<MouseEvent> e1 = new EventHandler<MouseEvent>(){
			@Override public void handle(MouseEvent e) {
				if (GameConfig.music) {
					name[1].setText("Nhạc nền: Tắt");
					GameConfig.menubgAudio.stop();
					GameConfig.playbgAudio.stop();
				} else {
					name[1].setText("Nhạc nền: Bật");
					GameConfig.menubgAudio.play();
					GameConfig.playbgAudio.stop();
				}
				GameConfig.music = !GameConfig.music;
			}
		};
		EventHandler<MouseEvent> e2 = new EventHandler<MouseEvent>(){
			@Override public void handle(MouseEvent e) {
				if (GameConfig.sound) {
					name[2].setText("Âm thanh: Tắt");
				} else {
					name[2].setText("Âm thanh: Bật");
				}
				GameConfig.sound = !GameConfig.sound;
			}
		};
		EventHandler<MouseEvent> e3 = new EventHandler<MouseEvent>(){
			@Override public void handle(MouseEvent e) {
				if (GameConfig.noTheme == GameConfig.FIRST_THEME) {
					name[3].setText("Theme: theme 2");
					GameConfig.noTheme = GameConfig.SECOND_THEME;
					GameConfig.theme = Theme.SECOND_THEME();
				} else if (GameConfig.noTheme == GameConfig.SECOND_THEME) {
					name[3].setText("Theme: theme 3");
					GameConfig.noTheme = GameConfig.THIRD_THEME;
					GameConfig.theme = Theme.THIRD_THEME();
				} else {
					name[3].setText("Theme: theme 1");
					GameConfig.noTheme = GameConfig.FIRST_THEME;
					GameConfig.theme = Theme.FIRST_THEME();
				}
				loadGraphic(GameConfig.theme);
				if (parent instanceof PauseMenu) {
					((PauseMenu) parent).getGameFrame().getGameWorld().loadGraphic();
				}
			}
		};
		EventHandler<MouseEvent> e4 = new EventHandler<MouseEvent>(){
			@Override public void handle(MouseEvent e) {
				stop();
			}
		};
		buttons[1].addEventHandler(MouseEvent.MOUSE_CLICKED, e1);
		buttons[2].addEventHandler(MouseEvent.MOUSE_CLICKED, e2);
		buttons[3].addEventHandler(MouseEvent.MOUSE_CLICKED, e3);
		buttons[4].addEventHandler(MouseEvent.MOUSE_CLICKED, e4);
		name[1].addEventHandler(MouseEvent.MOUSE_CLICKED, e1);
		name[2].addEventHandler(MouseEvent.MOUSE_CLICKED, e2);
		name[3].addEventHandler(MouseEvent.MOUSE_CLICKED, e3);
		name[4].addEventHandler(MouseEvent.MOUSE_CLICKED, e4);
	}
	public void initText()
	{
		nameMenu = new Text("Cài đặt");
		Font font = new Font("Consolas", 40);
		nameMenu.setFont(font);
		nameMenu.setX(nameFrame.getX() + 200);
		nameMenu.setY(nameFrame.getY() + 60);
		root.getChildren().add(nameMenu);
	}
	
}
