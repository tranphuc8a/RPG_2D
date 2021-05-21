package menu;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import system.myImage;

public class MessageBox extends Application{
	protected ParentMenu parent = null;
	protected String title = "Message Box";
	protected String content = "Unknown";
	protected Button okay = null;
	protected Label Content = null;
	protected Stage stage = null;
	protected Scene scene = null;
	protected Group root = null;
	protected TextField inputName = null;
	
	public static double HEIGHT = 250;
	public static double WIDTH = 250;
	public static double PAD_HEIGHT = 37;
	public static double PAD_WIDTH = 16;
	public static String TUTORIAL = "HƯỚNG DẪN CHƠI GAME\n"
			+ "Bấm các phím mũi tên để di chuyển nhân vật\n"
			+ "Bấm SPACE để dùng sát thương dao\n"
			+ "Bấm ENTER để sát thương súng\n";
	public static String INFORMATION = "THÔNG TIN\n"
			+ "Trần Văn Phúc 20194139\n"
			+ "Trịnh Becgie 20194185\n"
			+ "Trần Truồng Long 20194102\n"
			+ "Đỗ Hữu Bằng\n";
			
	public MessageBox() {initialization();}
	public MessageBox(ParentMenu parent) {
		this.parent = parent;
		initialization();
	}

	public void initialization()
	{
		root = new Group();
		scene = new Scene(root);
		stage = new Stage();
		stage.setHeight(HEIGHT);
		stage.setWidth(WIDTH);
		if (parent != null)
		{
			stage.setX(parent.getStage().getX() + (parent.getStage().getWidth() - stage.getWidth())/2);
			stage.setY(parent.getStage().getY() + (parent.getStage().getHeight() - stage.getHeight())/2);
		}
		stage.setScene(scene);
		stage.setTitle(title);
		stage.getIcons().add(new myImage("resource/symbol/help.png"));
		
		this.content = INFORMATION;
		Content = new Label(this.content);
		okay = new Button("OK");
		okay.setPrefSize(100, 30);
		okay.setLayoutX((stage.getWidth() - PAD_WIDTH - okay.getPrefWidth())/2);
		okay.setLayoutY(stage.getHeight() - 2 * PAD_HEIGHT - okay.getPrefHeight());
		okay.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
		{
			@Override
			public void handle(MouseEvent e)
			{
				stage.hide();
				stop();
			}
		});
		
		root.getChildren().addAll(Content, okay);
		
	}
	public void run()
	{
		this.start(this.stage);
	}
	@Override
	public void start(Stage primaryStage)
	{
		primaryStage = stage;
		primaryStage.show();
	}
	@Override
	public void stop()
	{
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	public void setContent(String content)
	{
		this.content = content;
		this.Content.setText(content);
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
}
