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
	
	public String[] mapImagePath			= {};
	public String[] mapTextPath				= {};
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
		
		temp.mapImagePath = new String[4];
		temp.mapTextPath = new String[4];
		temp.mapImagePath[1] = "resource/map/myHao.png";
		temp.mapImagePath[2] = "resource/map/xuanTruong.jpg";
		temp.mapImagePath[3] = "resource/map/tuSon.png";
		
		temp.mapTextPath[1] = "resource/map01/myHao.txt";
		temp.mapTextPath[3] = "resource/map01/mapXuanTruong.txt";
		temp.mapTextPath[2] = "resource/map01/tuSon.txt";
		
		
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
			temp.charaterPath.front[i] = "resource/character/woman/front/" + (i + 1) + "-removebg-preview.png";
			temp.charaterPath.behind[i] = "resource/character/woman/behind/" + (i + 1) + "-removebg-preview.png";
			temp.charaterPath.left[i] = "resource/character/woman/left/" + (i + 1) + "-removebg-preview.png";
			temp.charaterPath.right[i] = "resource/character/woman/right/" + (i + 1) + "-removebg-preview.png";
		}
		
		temp.mapImagePath = new String[4];
		temp.mapTextPath = new String[4];
		temp.mapImagePath[1] = "resource/map/myHao.png";
		temp.mapImagePath[2] = "resource/map/xuanTruong.png";
		temp.mapImagePath[3] = "resource/map/tuSon.png";
		temp.mapTextPath[1] = "resource/map01/myHao.txt";
		temp.mapTextPath[2] = "resource/map01/xuanTruong.txt";
		temp.mapTextPath[3] = "resource/map01/tuSon.txt";
		
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
		
		temp.mapImagePath = new String[4];
		temp.mapTextPath = new String[4];
		temp.mapImagePath[1] = "resource/map/myHao.png";
		temp.mapImagePath[2] = "resource/map/xuanTruong.png";
		temp.mapImagePath[3] = "resource/map/tuSon.png";
		temp.mapTextPath[1] = "resource/map01/myHao.txt";
		temp.mapTextPath[2] = "resource/map01/xuanTruong.txt";
		temp.mapTextPath[3] = "resource/map01/tuSon.txt";
		
		return temp;
	}
}
