package system;

import java.io.File;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.stage.Stage;

public class myAudio extends Application  
{  
    @Override  
    public void start (Stage primaryStage) throws Exception {  
        String path = "resource/deche.mp3";  
          
        Media media = new Media(new File(path).toURI().toString());  
    	
  
        primaryStage.setTitle("Playing Audio");
        primaryStage.show();  
    }  
    public static void main(String[] args) {  
        launch(args);  
    }  
      
} 