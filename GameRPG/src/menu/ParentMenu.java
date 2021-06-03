package menu;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import system.Couple;
import system.GameConfig;
import system.Theme;
import system.myAudio;
import system.myGraphic;
import system.myImage;

public class ParentMenu extends Application {
	@Override
	public void start(Stage primaryStage)
	{
		if (GameConfig.music){
			GameConfig.menubgAudio.update();
		}
		this.initialize();
		primaryStage = this.stage;
		primaryStage.show();
	}
	@Override
	public void stop()
	{
		GameConfig.writeData();
		stage.hide();
		if (parent != null)
		{
			parent.loadGraphic(GameConfig.theme);
			parent.stage.show();
		}
	}
	public void run()
	{
		this.start(stage);
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	protected ParentMenu parent = null;
	
	protected Group root = null;
	protected Scene scene = null;
	protected Stage stage = null;
	
	protected myGraphic background 	= null;
	protected myGraphic nameFrame 	= null;
	protected myGraphic buttonFrame = null;
	protected myGraphic buttons[]	= null;
	protected Text name[] 			= null;
	
	protected myGraphic infor = null;
	protected myGraphic tutor = null;
	protected MessageBox inforMess = null;
	protected MessageBox tutorMess = null;
	
	public static final Couple stagePosition 		= new Couple(300, 100);
	public static final Couple padFrame				= new Couple(16, 37);
	public static final Couple stageSize 			= new Couple(700, 500);
	public static final Couple nameFramePosition 	= new Couple(30, 30);
	public static final Couple nameFrameSize 		= new Couple(630, 100);
	public static final Couple buttonSize 			= new Couple(150, 50);
	public static final Couple buttonFramePosition 	= new Couple(110, 140);
	public static final Couple buttonFrameSize 		= new Couple(400, 330);

	// constructor:
	public ParentMenu() {
		// this.initialize();
	}
	public ParentMenu(ParentMenu parent)
	{
		this();
		this.parent = parent;
	}
	public ParentMenu(double x, double y)
	{
		this();
		this.setSize(x, y);
	}
	public void initialize()
	{
		stage = new Stage();
		this.setSize(stageSize.x + padFrame.x, stageSize.y + padFrame.y);
		stage.setX(stagePosition.x);
		stage.setY(stagePosition.y);
		stage.setTitle("RPG_2D Nhóm 18 Lập trình hướng đối tượng");
		// init component:
		initBackground();
		initNameFrame();
		initButtonFrame();
		initInfor();
		initTutor();
		// connect
		root = new Group(background, nameFrame, buttonFrame, infor, tutor);
		scene = new Scene(root);
		stage.setScene(scene);
	}
	public void initBackground()
	{
		background = new myGraphic();
		setBackground(GameConfig.theme.backgroundPath);
	}
	public void initNameFrame()
	{
		nameFrame = new myGraphic(GameConfig.theme.nameFramePath);
		nameFrame.setPosition(nameFramePosition.x, nameFramePosition.y);
		nameFrame.setSize(nameFrameSize.x, nameFrameSize.y);
	}
	public void initButtonFrame()
	{
		buttonFrame = new myGraphic(GameConfig.theme.buttonFramePath);
		buttonFrame.setPosition(buttonFramePosition.x, buttonFramePosition.y);
		buttonFrame.setSize(buttonFrameSize.x, buttonFrameSize.y);
	}
	public void initInfor()
	{
		inforMess = new MessageBox(this);
		inforMess.setContent(MessageBox.INFORMATION);
		inforMess.setTitle("Thông tin");
		// set myGraphic
		infor = new myGraphic(GameConfig.theme.informationPath);
		infor.setSize(50, 50);
		infor.setPosition(600, 320);
		// add Event
		infor.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent e)
			{
				inforMess.run();
			}
		});
	}
	public void initTutor()
	{
		tutorMess = new MessageBox(this);
		tutorMess.setContent(MessageBox.TUTORIAL);
		tutorMess.setTitle("Hướng dẫn");
		// set myGraphic
		tutor = new myGraphic(GameConfig.theme.tutorialPath);
		tutor.setSize(50, 50);
		tutor.setPosition(600, 400);
		tutor.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent e)
			{
				tutorMess.run();
			}
		});
	}
	
	// get-set
	public void setBackground(myImage path)
	{
		background.setImage(path);
		background.setSize(stageSize.x, stageSize.y);
	}
	public ParentMenu getParent() {
		return parent;
	}
	public void setParent(ParentMenu parent) {
		this.parent = parent;
	}
	public Group getRoot() {
		return root;
	}
	public Scene getScene() {
		return scene;
	}
	public Stage getStage() {
		return stage;
	}
	public myGraphic getBackground() {
		return background;
	}
	public void setBackground(myGraphic background) {
		this.background = background;
	}
	public void setSize(double x, double y) {
		stage.setWidth(x);
		stage.setHeight(y);
		stage.setMinWidth(x);
		stage.setMaxWidth(x);
		stage.setMinHeight(y);
		stage.setMaxHeight(y);
	}
	public void setPosition(double x, double y) {
		stage.setX(x);
		stage.setY(y);		
	}
	public Text[] getName() {
		return name;
	}
	public myGraphic[] getButtons() {
		return buttons;
	}
	public void loadGraphic(Theme newTheme) {
		background.setImage(newTheme.backgroundPath);
		nameFrame.setImage(newTheme.nameFramePath);
		buttonFrame.setImage(newTheme.buttonFramePath);
		for (int i = 1; i < buttons.length; i++) {
			buttons[i].setImage(newTheme.buttonPath);
			name[i].setFont(newTheme.nameButtonFont);
		}
		infor.setImage(newTheme.informationPath);
		tutor.setImage(newTheme.tutorialPath);
	}
}
