package system;

import javafx.scene.text.Font;

public class Theme {
	public String buttonPath;
	public String backgroundPath;
	public String nameFramePath;
	public String buttonFramePath;
	public String informationPath;
	public String tutorialPath;
	public Font nameMenuFont;
	public Font nameButtonFont;
	
	public String musicPath;
	public String soundPath;
	
	public static Theme FIRST_THEME() {
		Theme temp = new Theme();
		temp.buttonPath 		= "resource/frame/button2.png";
		temp.backgroundPath 	= "resource/background/beauty2.jpg";
		temp.buttonFramePath 	= "resource/frame/buttonFrame.png";
		temp.nameFramePath 		= "resource/frame/text.png";
		temp.informationPath 	= "resource/symbol/infor.png";
		temp.tutorialPath 		= "resource/symbol/help.png";
		temp.musicPath 			= "resource/deche.mp3";
		temp.soundPath 			= "resource/deche.mp3";
		temp.nameMenuFont 		= new Font("Consolas", 40);
		temp.nameButtonFont 	= new Font("Time new roman", 16);
		return temp;
	}
	public static Theme SECOND_THEME() {
		Theme temp = new Theme();
		temp.buttonPath 		= "resource/frame/button.png";
		temp.backgroundPath 	= "resource/background/beauty1.jpg";
		temp.buttonFramePath 	= "resource/frame/buttonFrame1.jpg";
		temp.nameFramePath 		= "resource/frame/text.png";
		temp.informationPath 	= "resource/symbol/infor.png";
		temp.tutorialPath 		= "resource/symbol/help.png";
		temp.musicPath 			= "resource/deche.mp3";
		temp.soundPath 			= "resource/deche.mp3";
		temp.nameMenuFont 		= new Font("Consolas", 40);
		temp.nameButtonFont 	= new Font("Time new roman", 16);
		return temp;
	}
	public static Theme THIRD_THEME() {
		Theme temp = new Theme();
		temp.buttonPath 		= "resource/frame/button2.png";
		temp.backgroundPath 	= "resource/background/mountainWinter.jpg";
		temp.buttonFramePath 	= "resource/frame/buttonFrame.png";
		temp.nameFramePath 		= "resource/frame/text.png";
		temp.informationPath 	= "resource/symbol/infor.png";
		temp.tutorialPath 		= "resource/symbol/help.png";
		temp.musicPath 			= "resource/deche.mp3";
		temp.soundPath 			= "resource/deche.mp3";
		temp.nameMenuFont 		= new Font("Consolas", 40);
		temp.nameButtonFont 	= new Font("Time new roman", 16);
		return temp;
	}
}
