package system;

import javafx.scene.text.Font;

public class Theme {
	public class ObjectPath{
		public String[] front 	= null;
		public String[] behind 	= null;
		public String[] left 	= null;
		public String[] right 	= null;
	}
	
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
	
	public String[] mapPath				= {};
	public ObjectPath charaterPath		= new ObjectPath();
	public ObjectPath batPath			= new ObjectPath();
	public ObjectPath buffaloPath		= new ObjectPath();
	public ObjectPath foxPath			= new ObjectPath();
	public ObjectPath mousePath			= new ObjectPath();
	public ObjectPath snakePath			= new ObjectPath();
	public ObjectPath pigPath			= new ObjectPath();
	public ObjectPath bulletPath		= new ObjectPath();
	public ObjectPath knifePath			= new ObjectPath();
	public ObjectPath hpPath			= new ObjectPath();
	
	
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
		temp.nameButtonFont 	= new Font("Times New Roman", 20);
		
		temp.charaterPath.front = new String[9];
		temp.charaterPath.behind = new String[9];
		temp.charaterPath.left = new String[9];
		temp.charaterPath.right = new String[9];
		for (int i = 0; i < 9; i++) {
			temp.charaterPath.front[i] = "resource/character/man/front/fr" + (i + 1) + "-removebg-preview.png";
			temp.charaterPath.behind[i] = "resource/character/man/behind/bh" + (i + 1) + "-removebg-preview.png";
			temp.charaterPath.left[i] = "resource/character/man/left/left" + (i + 1) + "-removebg-preview.png";
			temp.charaterPath.right[i] = "resource/character/man/right/right" + (i + 1) + "-removebg-preview.png";
		}
		
		temp.mapPath = new String[4];
		temp.mapPath[1] = "resource/map/map1.jpg";
		temp.mapPath[2] = "resource/map/map2.png";
		temp.mapPath[3] = "resource/map/map3.png";
		
		return temp;
	}
	public static Theme SECOND_THEME() {
		Theme temp = new Theme();
		temp.buttonPath 		= "resource/frame/button2.png";
		temp.backgroundPath 	= "resource/background/beauty1.jpg";
		temp.buttonFramePath 	= "resource/frame/buttonFrame1.jpg";
		temp.nameFramePath 		= "resource/frame/text.png";
		temp.informationPath 	= "resource/symbol/infor.png";
		temp.tutorialPath 		= "resource/symbol/help.png";
		temp.musicPath 			= "resource/deche.mp3";
		temp.soundPath 			= "resource/deche.mp3";
		temp.nameMenuFont 		= new Font("Consolas", 40);
		temp.nameButtonFont 	= new Font("Times New Roman", 20);
		
		temp.charaterPath.front = new String[9];
		temp.charaterPath.behind = new String[9];
		temp.charaterPath.left = new String[9];
		temp.charaterPath.right = new String[9];
		for (int i = 0; i < 9; i++) {
			temp.charaterPath.front[i] = "resource/character/man/front/fr" + (i + 1) + "-removebg-preview.png";
			temp.charaterPath.behind[i] = "resource/character/man/behind/bh" + (i + 1) + "-removebg-preview.png";
			temp.charaterPath.left[i] = "resource/character/man/left/left" + (i + 1) + "-removebg-preview.png";
			temp.charaterPath.right[i] = "resource/character/man/right/right" + (i + 1) + "-removebg-preview.png";
		}
		
		temp.mapPath = new String[4];
		temp.mapPath[1] = "resource/map/map1.jpg";
		temp.mapPath[2] = "resource/map/map2.png";
		temp.mapPath[3] = "resource/map/map3.png";
		
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
		temp.nameButtonFont 	= new Font("Times New Roman", 20);
		
		temp.charaterPath.front = new String[9];
		temp.charaterPath.behind = new String[9];
		temp.charaterPath.left = new String[9];
		temp.charaterPath.right = new String[9];
		for (int i = 0; i < 9; i++) {
			temp.charaterPath.front[i] 	= "resource/character/man/front/fr" 	+ (i + 1) + "-removebg-preview.png";
			temp.charaterPath.behind[i] = "resource/character/man/behind/bh" 	+ (i + 1) + "-removebg-preview.png";
			temp.charaterPath.left[i] 	= "resource/character/man/left/left" 	+ (i + 1) + "-removebg-preview.png";
			temp.charaterPath.right[i] 	= "resource/character/man/right/right" 	+ (i + 1) + "-removebg-preview.png";
		}
		
		temp.mapPath = new String[4];
		temp.mapPath[1] = "resource/map/map1.jpg";
		temp.mapPath[2] = "resource/map/map2.png";
		temp.mapPath[3] = "resource/map/map3.png";
		
		return temp;
	}
}
