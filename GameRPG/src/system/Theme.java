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
	
	public static Theme firstTheme = new Theme();
	public static Theme secondTheme = new Theme();
	public static Theme thirdTheme = new Theme();
	
	public static void setData() {
		FIRST_THEME();
		SECOND_THEME();
		THIRD_THEME();
	}
	
	public static Theme FIRST_THEME() {
		firstTheme.buttonPath 		= "resource/frame/button2.png";
		firstTheme.backgroundPath 	= "resource/background/beauty2.jpg";
		firstTheme.buttonFramePath 	= "resource/frame/buttonFrame.png";
		firstTheme.nameFramePath 		= "resource/frame/text.png";
		firstTheme.informationPath 	= "resource/symbol/infor.png";
		firstTheme.tutorialPath 		= "resource/symbol/help.png";
		firstTheme.musicPath 			= "resource/deche.mp3";
		firstTheme.soundPath 			= "resource/deche.mp3";
		firstTheme.nameMenuFont 		= new Font("Consolas", 40);
		firstTheme.nameButtonFont 	= new Font("Times New Roman", 20);
		
		firstTheme.charaterPath.front = new String[9];
		firstTheme.charaterPath.behind = new String[9];
		firstTheme.charaterPath.left = new String[9];
		firstTheme.charaterPath.right = new String[9];
		for (int i = 0; i < 9; i++) {
			firstTheme.charaterPath.front[i] = "resource/character/man/front/fr" + (i + 1) + "-removebg-preview.png";
			firstTheme.charaterPath.behind[i] = "resource/character/man/behind/bh" + (i + 1) + "-removebg-preview.png";
			firstTheme.charaterPath.left[i] = "resource/character/man/left/left" + (i + 1) + "-removebg-preview.png";
			firstTheme.charaterPath.right[i] = "resource/character/man/right/right" + (i + 1) + "-removebg-preview.png";
		}
		
		firstTheme.mapImagePath = new String[4];
		firstTheme.mapTextPath = new String[4];
		firstTheme.mapImagePath[1] = "resource/map/myHao.png";
		firstTheme.mapImagePath[2] = "resource/map/xuanTruong.png";
		firstTheme.mapImagePath[3] = "resource/map/tuSon.png";
		
		firstTheme.mapTextPath[1] = "resource/map/myHao.txt";
		firstTheme.mapTextPath[2] = "resource/map/XuanTruong.txt";
		firstTheme.mapTextPath[3] = "resource/map/tuSon.txt";
		
		
		return firstTheme;
	}
	public static Theme SECOND_THEME() {
		secondTheme.buttonPath 		= "resource/frame/button2.png";
		secondTheme.backgroundPath 	= "resource/background/beauty1.jpg";
		secondTheme.buttonFramePath 	= "resource/frame/buttonFrame1.jpg";
		secondTheme.nameFramePath 		= "resource/frame/text.png";
		secondTheme.informationPath 	= "resource/symbol/infor.png";
		secondTheme.tutorialPath 		= "resource/symbol/help.png";
		secondTheme.musicPath 			= "resource/deche.mp3";
		secondTheme.soundPath 			= "resource/deche.mp3";
		secondTheme.nameMenuFont 		= new Font("Consolas", 40);
		secondTheme.nameButtonFont 	= new Font("Times New Roman", 20);
		
		secondTheme.charaterPath.front = new String[9];
		secondTheme.charaterPath.behind = new String[9];
		secondTheme.charaterPath.left = new String[9];
		secondTheme.charaterPath.right = new String[9];
		for (int i = 0; i < 9; i++) {
			secondTheme.charaterPath.front[i] = "resource/character/woman/front/" + (i + 1) + "-removebg-preview.png";
			secondTheme.charaterPath.behind[i] = "resource/character/woman/behind/" + (i + 1) + "-removebg-preview.png";
			secondTheme.charaterPath.left[i] = "resource/character/woman/left/" + (i + 1) + "-removebg-preview.png";
			secondTheme.charaterPath.right[i] = "resource/character/woman/right/" + (i + 1) + "-removebg-preview.png";
		}
		
		secondTheme.mapImagePath = new String[4];
		secondTheme.mapTextPath = new String[4];
		secondTheme.mapImagePath[1] = "resource/map/myHao.png";
		secondTheme.mapImagePath[2] = "resource/map/xuanTruong.png";
		secondTheme.mapImagePath[3] = "resource/map/tuSon.png";
		
		secondTheme.mapTextPath[1] = "resource/map/myHao.txt";
		secondTheme.mapTextPath[2] = "resource/map/xuanTruong.txt";
		secondTheme.mapTextPath[3] = "resource/map/tuSon.txt";
		
		return secondTheme;
	}
	public static Theme THIRD_THEME() {
		thirdTheme.buttonPath 		= "resource/frame/button2.png";
		thirdTheme.backgroundPath 	= "resource/background/mountainWinter.jpg";
		thirdTheme.buttonFramePath 	= "resource/frame/buttonFrame.png";
		thirdTheme.nameFramePath 		= "resource/frame/text.png";
		thirdTheme.informationPath 	= "resource/symbol/infor.png";
		thirdTheme.tutorialPath 		= "resource/symbol/help.png";
		thirdTheme.musicPath 			= "resource/deche.mp3";
		thirdTheme.soundPath 			= "resource/deche.mp3";
		thirdTheme.nameMenuFont 		= new Font("Consolas", 40);
		thirdTheme.nameButtonFont 	= new Font("Times New Roman", 20);
		
		thirdTheme.charaterPath.front = new String[9];
		thirdTheme.charaterPath.behind = new String[9];
		thirdTheme.charaterPath.left = new String[9];
		thirdTheme.charaterPath.right = new String[9];
		for (int i = 0; i < 9; i++) {
			thirdTheme.charaterPath.front[i] 	= "resource/character/man/front/fr" 	+ (i + 1) + "-removebg-preview.png";
			thirdTheme.charaterPath.behind[i] = "resource/character/man/behind/bh" 	+ (i + 1) + "-removebg-preview.png";
			thirdTheme.charaterPath.left[i] 	= "resource/character/man/left/left" 	+ (i + 1) + "-removebg-preview.png";
			thirdTheme.charaterPath.right[i] 	= "resource/character/man/right/right" 	+ (i + 1) + "-removebg-preview.png";
		}
		
		thirdTheme.mapImagePath = new String[4];
		thirdTheme.mapTextPath = new String[4];
		thirdTheme.mapImagePath[1] = "resource/map/myHao.png";
		thirdTheme.mapImagePath[2] = "resource/map/xuanTruong.png";
		thirdTheme.mapImagePath[3] = "resource/map/tuSon.png";
		
		thirdTheme.mapTextPath[1] = "resource/map/myHao.txt";
		thirdTheme.mapTextPath[2] = "resource/map/xuanTruong.txt";
		thirdTheme.mapTextPath[3] = "resource/map/tuSon.txt";
		
		return thirdTheme;
	}
}
