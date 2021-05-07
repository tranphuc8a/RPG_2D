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
	
	public ObjectPath hurtPath			= new ObjectPath();
	public String[] hpPath;
	
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
		
		// character
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
		// map
		firstTheme.mapImagePath = new String[4];
		firstTheme.mapTextPath = new String[4];
		firstTheme.mapImagePath[1] = "resource/map/myHao.png";
		firstTheme.mapImagePath[2] = "resource/map/xuanTruong.png";
		firstTheme.mapImagePath[3] = "resource/map/tuSon.png";
		firstTheme.mapTextPath[1] = "resource/map/myHao.txt";
		firstTheme.mapTextPath[2] = "resource/map/XuanTruong.txt";
		firstTheme.mapTextPath[3] = "resource/map/tuSon.txt";
		// bullet
		firstTheme.bulletPath.front = new String[10];
		firstTheme.bulletPath.behind = new String[10];
		firstTheme.bulletPath.left = new String[10];
		firstTheme.bulletPath.right = new String[10];
		for (int i = 0; i < 10; i++) {
			firstTheme.bulletPath.front[i] = "resource/bullet/bullet/down/" + (i + 1) + ".png";
			firstTheme.bulletPath.behind[i] = "resource/bullet/bullet/up/" + (i + 1) + ".png";
			firstTheme.bulletPath.left[i] = "resource/bullet/bullet/left/" + (i + 1) + ".png";
			firstTheme.bulletPath.right[i] = "resource/bullet/bullet/right/" + (i + 1) + ".png";
		}
		// HP : blue
		firstTheme.hpPath = new String[11];
		for (int i = 0; i < 11; i++) {
			firstTheme.hpPath[i] = "resource/HP/blue/" + (i + 1) + ".png";
		}
		// knife
		firstTheme.knifePath.front = new String[6];
		firstTheme.knifePath.behind = new String[6];
		firstTheme.knifePath.left = new String[6];
		firstTheme.knifePath.right = new String[6];
		for (int i = 0; i < 6; i++) {
			firstTheme.knifePath.front[i] = "resource/knife/word/front/" + (i + 1) + ".png";
			firstTheme.knifePath.behind[i] = "resource/knife/word/behind/" + (i + 1) + ".png";
			firstTheme.knifePath.left[i] = "resource/knife/word/left/" + (i + 1) + ".png";
			firstTheme.knifePath.right[i] = "resource/knife/word/right/" + (i + 1) + ".png";
		}
		// hurt
		firstTheme.hurtPath.front = new String[24];
		firstTheme.hurtPath.behind = new String[24];
		firstTheme.hurtPath.left = new String[24];
		firstTheme.hurtPath.right = new String[24];
		for (int i = 0; i < 24; i++) {
			firstTheme.hurtPath.front[i] = "resource/knife/hurtAnimation/" + (i + 1) + ".png";
			firstTheme.hurtPath.behind[i] = "resource/knife/hurtAnimation/" + (i + 1) + ".png";
			firstTheme.hurtPath.left[i] = "resource/knife/hurtAnimation/" + (i + 1) + ".png";
			firstTheme.hurtPath.right[i] = "resource/knife/hurtAnimation/" + (i + 1) + ".png";
		}
		// monsters:
		// bat:
		firstTheme.batPath.front = new String[3];
		firstTheme.batPath.behind = new String[3];
		firstTheme.batPath.left = new String[3];
		firstTheme.batPath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			firstTheme.batPath.front[i] = "resource/monster/bat/front/" + (i + 1) + ".png";
			firstTheme.batPath.behind[i] = "resource/monster/bat/behind/" + (i + 1) + ".png";
			firstTheme.batPath.left[i] = "resource/monster/bat/left/" + (i + 1) + ".png";
			firstTheme.batPath.right[i] = "resource/monster/bat/right/" + (i + 1) + ".png";
		}
		// buffalo:
		firstTheme.buffaloPath.front = new String[3];
		firstTheme.buffaloPath.behind = new String[3];
		firstTheme.buffaloPath.left = new String[3];
		firstTheme.buffaloPath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			firstTheme.buffaloPath.front[i] = "resource/monster/buffalo/front/" + (i + 1) + ".png";
			firstTheme.buffaloPath.behind[i] = "resource/monster/buffalo/behind/" + (i + 1) + ".png";
			firstTheme.buffaloPath.left[i] = "resource/monster/buffalo/left/" + (i + 1) + ".png";
			firstTheme.buffaloPath.right[i] = "resource/monster/buffalo/right/" + (i + 1) + ".png";
		}
		// fox:
		firstTheme.foxPath.front = new String[3];
		firstTheme.foxPath.behind = new String[3];
		firstTheme.foxPath.left = new String[3];
		firstTheme.foxPath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			firstTheme.foxPath.front[i] = "resource/monster/fox/front/" + (i + 1) + ".png";
			firstTheme.foxPath.behind[i] = "resource/monster/fox/behind/" + (i + 1) + ".png";
			firstTheme.foxPath.left[i] = "resource/monster/fox/left/" + (i + 1) + ".png";
			firstTheme.foxPath.right[i] = "resource/monster/fox/right/" + (i + 1) + ".png";
		}
		// mouse:
		firstTheme.mousePath.front = new String[3];
		firstTheme.mousePath.behind = new String[3];
		firstTheme.mousePath.left = new String[3];
		firstTheme.mousePath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			firstTheme.mousePath.front[i] = "resource/monster/mouse/front/" + (i + 1) + ".png";
			firstTheme.mousePath.behind[i] = "resource/monster/mouse/behind/" + (i + 1) + ".png";
			firstTheme.mousePath.left[i] = "resource/monster/mouse/left/" + (i + 1) + ".png";
			firstTheme.mousePath.right[i] = "resource/monster/mouse/right/" + (i + 1) + ".png";
		}
		// pig:
		firstTheme.pigPath.front = new String[3];
		firstTheme.pigPath.behind = new String[3];
		firstTheme.pigPath.left = new String[3];
		firstTheme.pigPath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			firstTheme.pigPath.front[i] = "resource/monster/pig/front/" + (i + 1) + ".png";
			firstTheme.pigPath.behind[i] = "resource/monster/pig/behind/" + (i + 1) + ".png";
			firstTheme.pigPath.left[i] = "resource/monster/pig/left/" + (i + 1) + ".png";
			firstTheme.pigPath.right[i] = "resource/monster/pig/right/" + (i + 1) + ".png";
		}
		// snake red:
		firstTheme.snakePath.front = new String[3];
		firstTheme.snakePath.behind = new String[3];
		firstTheme.snakePath.left = new String[3];
		firstTheme.snakePath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			firstTheme.snakePath.front[i] = "resource/monster/snake/red/front/" + (i + 1) + ".png";
			firstTheme.snakePath.behind[i] = "resource/monster/snake/red/behind/" + (i + 1) + ".png";
			firstTheme.snakePath.left[i] = "resource/monster/snake/red/left/" + (i + 1) + ".png";
			firstTheme.snakePath.right[i] = "resource/monster/snake/red/right/" + (i + 1) + ".png";
		}
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
		
		secondTheme.bulletPath.front = new String[10];
		secondTheme.bulletPath.behind = new String[10];
		secondTheme.bulletPath.left = new String[10];
		secondTheme.bulletPath.right = new String[10];
		for (int i = 0; i < 10; i++) {
			secondTheme.bulletPath.front[i] = "resource/bullet/bullet/down/" + (i + 1) + ".png";
			secondTheme.bulletPath.behind[i] = "resource/bullet/bullet/up/" + (i + 1) + ".png";
			secondTheme.bulletPath.left[i] = "resource/bullet/bullet/left/" + (i + 1) + ".png";
			secondTheme.bulletPath.right[i] = "resource/bullet/bullet/right/" + (i + 1) + ".png";
		}
		// hp: red
		secondTheme.hpPath = new String[6];
		for (int i = 0; i < 6; i++) {
			secondTheme.hpPath[i] = "resource/HP/red/" + (i + 1) + ".png";
		}
		// knife
		secondTheme.knifePath.front = new String[6];
		secondTheme.knifePath.behind = new String[6];
		secondTheme.knifePath.left = new String[6];
		secondTheme.knifePath.right = new String[6];
		for (int i = 0; i < 6; i++) {
			secondTheme.knifePath.front[i] = "resource/knife/word/front/" + (i + 1) + ".png";
			secondTheme.knifePath.behind[i] = "resource/knife/word/behind/" + (i + 1) + ".png";
			secondTheme.knifePath.left[i] = "resource/knife/word/left/" + (i + 1) + ".png";
			secondTheme.knifePath.right[i] = "resource/knife/word/right/" + (i + 1) + ".png";
		}
		// hurtPath
		// hurt
		secondTheme.hurtPath.front = new String[24];
		secondTheme.hurtPath.behind = new String[24];
		secondTheme.hurtPath.left = new String[24];
		secondTheme.hurtPath.right = new String[24];
		for (int i = 0; i < 24; i++) {
			secondTheme.hurtPath.front[i] = "resource/knife/hurtAnimation/" + (i + 1) + ".png";
			secondTheme.hurtPath.behind[i] = "resource/knife/hurtAnimation/" + (i + 1) + ".png";
			secondTheme.hurtPath.left[i] = "resource/knife/hurtAnimation/" + (i + 1) + ".png";
			secondTheme.hurtPath.right[i] = "resource/knife/hurtAnimation/" + (i + 1) + ".png";
		}		
		// monsters:
		// bat:
		secondTheme.batPath.front = new String[3];
		secondTheme.batPath.behind = new String[3];
		secondTheme.batPath.left = new String[3];
		secondTheme.batPath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			secondTheme.batPath.front[i] = "resource/monster/bat/front/" + (i + 1) + ".png";
			secondTheme.batPath.behind[i] = "resource/monster/bat/behind/" + (i + 1) + ".png";
			secondTheme.batPath.left[i] = "resource/monster/bat/left/" + (i + 1) + ".png";
			secondTheme.batPath.right[i] = "resource/monster/bat/right/" + (i + 1) + ".png";
		}
		// buffalo:
		secondTheme.buffaloPath.front = new String[3];
		secondTheme.buffaloPath.behind = new String[3];
		secondTheme.buffaloPath.left = new String[3];
		secondTheme.buffaloPath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			secondTheme.buffaloPath.front[i] = "resource/monster/buffalo/front/" + (i + 1) + ".png";
			secondTheme.buffaloPath.behind[i] = "resource/monster/buffalo/behind/" + (i + 1) + ".png";
			secondTheme.buffaloPath.left[i] = "resource/monster/buffalo/left/" + (i + 1) + ".png";
			secondTheme.buffaloPath.right[i] = "resource/monster/buffalo/right/" + (i + 1) + ".png";
		}
		// fox:
		secondTheme.foxPath.front = new String[3];
		secondTheme.foxPath.behind = new String[3];
		secondTheme.foxPath.left = new String[3];
		secondTheme.foxPath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			secondTheme.foxPath.front[i] = "resource/monster/fox/front/" + (i + 1) + ".png";
			secondTheme.foxPath.behind[i] = "resource/monster/fox/behind/" + (i + 1) + ".png";
			secondTheme.foxPath.left[i] = "resource/monster/fox/left/" + (i + 1) + ".png";
			secondTheme.foxPath.right[i] = "resource/monster/fox/right/" + (i + 1) + ".png";
		}
		// mouse:
		secondTheme.mousePath.front = new String[3];
		secondTheme.mousePath.behind = new String[3];
		secondTheme.mousePath.left = new String[3];
		secondTheme.mousePath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			secondTheme.mousePath.front[i] = "resource/monster/mouse/front/" + (i + 1) + ".png";
			secondTheme.mousePath.behind[i] = "resource/monster/mouse/behind/" + (i + 1) + ".png";
			secondTheme.mousePath.left[i] = "resource/monster/mouse/left/" + (i + 1) + ".png";
			secondTheme.mousePath.right[i] = "resource/monster/mouse/right/" + (i + 1) + ".png";
		}
		// pig:
		secondTheme.pigPath.front = new String[3];
		secondTheme.pigPath.behind = new String[3];
		secondTheme.pigPath.left = new String[3];
		secondTheme.pigPath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			secondTheme.pigPath.front[i] = "resource/monster/pig/front/" + (i + 1) + ".png";
			secondTheme.pigPath.behind[i] = "resource/monster/pig/behind/" + (i + 1) + ".png";
			secondTheme.pigPath.left[i] = "resource/monster/pig/left/" + (i + 1) + ".png";
			secondTheme.pigPath.right[i] = "resource/monster/pig/right/" + (i + 1) + ".png";
		}
		// snake yellow:
		secondTheme.snakePath.front = new String[3];
		secondTheme.snakePath.behind = new String[3];
		secondTheme.snakePath.left = new String[3];
		secondTheme.snakePath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			secondTheme.snakePath.front[i] = "resource/monster/snake/yellow/front/" + (i + 1) + ".png";
			secondTheme.snakePath.behind[i] = "resource/monster/snake/yellow/behind/" + (i + 1) + ".png";
			secondTheme.snakePath.left[i] = "resource/monster/snake/yellow/left/" + (i + 1) + ".png";
			secondTheme.snakePath.right[i] = "resource/monster/snake/yellow/right/" + (i + 1) + ".png";
		}
		
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
		
		
		thirdTheme.bulletPath.front = new String[10];
		thirdTheme.bulletPath.behind = new String[10];
		thirdTheme.bulletPath.left = new String[10];
		thirdTheme.bulletPath.right = new String[10];
		for (int i = 0; i < 10; i++) {
			thirdTheme.bulletPath.front[i] = "resource/bullet/bullet/down/" + (i + 1) + ".png";
			thirdTheme.bulletPath.behind[i] = "resource/bullet/bullet/up/" + (i + 1) + ".png";
			thirdTheme.bulletPath.left[i] = "resource/bullet/bullet/left/" + (i + 1) + ".png";
			thirdTheme.bulletPath.right[i] = "resource/bullet/bullet/right/" + (i + 1) + ".png";
		}
		// hp: blue
		thirdTheme.hpPath = new String[6];
		for (int i = 0; i < 6; i++) {
			thirdTheme.hpPath[i] = "resource/HP/red/" + (i + 1) + ".png";
		}
		// knife
		thirdTheme.knifePath.front = new String[6];
		thirdTheme.knifePath.behind = new String[6];
		thirdTheme.knifePath.left = new String[6];
		thirdTheme.knifePath.right = new String[6];
		for (int i = 0; i < 6; i++) {
			thirdTheme.knifePath.front[i] = "resource/knife/word/front/" + (i + 1) + ".png";
			thirdTheme.knifePath.behind[i] = "resource/knife/word/behind/" + (i + 1) + ".png";
			thirdTheme.knifePath.left[i] = "resource/knife/word/left/" + (i + 1) + ".png";
			thirdTheme.knifePath.right[i] = "resource/knife/word/right/" + (i + 1) + ".png";
		}
		// hurtPath
		// hurt
		thirdTheme.hurtPath.front = new String[24];
		thirdTheme.hurtPath.behind = new String[24];
		thirdTheme.hurtPath.left = new String[24];
		thirdTheme.hurtPath.right = new String[24];
		for (int i = 0; i < 24; i++) {
			thirdTheme.hurtPath.front[i] = "resource/knife/hurtAnimation/" + (i + 1) + ".png";
			thirdTheme.hurtPath.behind[i] = "resource/knife/hurtAnimation/" + (i + 1) + ".png";
			thirdTheme.hurtPath.left[i] = "resource/knife/hurtAnimation/" + (i + 1) + ".png";
			thirdTheme.hurtPath.right[i] = "resource/knife/hurtAnimation/" + (i + 1) + ".png";
		}
		// monsters:
		// bat:
		thirdTheme.batPath.front = new String[3];
		thirdTheme.batPath.behind = new String[3];
		thirdTheme.batPath.left = new String[3];
		thirdTheme.batPath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			thirdTheme.batPath.front[i] = "resource/monster/bat/front/" + (i + 1) + ".png";
			thirdTheme.batPath.behind[i] = "resource/monster/bat/behind/" + (i + 1) + ".png";
			thirdTheme.batPath.left[i] = "resource/monster/bat/left/" + (i + 1) + ".png";
			thirdTheme.batPath.right[i] = "resource/monster/bat/right/" + (i + 1) + ".png";
		}
		// buffalo:
		thirdTheme.buffaloPath.front = new String[3];
		thirdTheme.buffaloPath.behind = new String[3];
		thirdTheme.buffaloPath.left = new String[3];
		thirdTheme.buffaloPath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			thirdTheme.buffaloPath.front[i] = "resource/monster/buffalo/front/" + (i + 1) + ".png";
			thirdTheme.buffaloPath.behind[i] = "resource/monster/buffalo/behind/" + (i + 1) + ".png";
			thirdTheme.buffaloPath.left[i] = "resource/monster/buffalo/left/" + (i + 1) + ".png";
			thirdTheme.buffaloPath.right[i] = "resource/monster/buffalo/right/" + (i + 1) + ".png";
		}
		// fox:
		thirdTheme.foxPath.front = new String[3];
		thirdTheme.foxPath.behind = new String[3];
		thirdTheme.foxPath.left = new String[3];
		thirdTheme.foxPath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			thirdTheme.foxPath.front[i] = "resource/monster/fox/front/" + (i + 1) + ".png";
			thirdTheme.foxPath.behind[i] = "resource/monster/fox/behind/" + (i + 1) + ".png";
			thirdTheme.foxPath.left[i] = "resource/monster/fox/left/" + (i + 1) + ".png";
			thirdTheme.foxPath.right[i] = "resource/monster/fox/right/" + (i + 1) + ".png";
		}
		// mouse:
		thirdTheme.mousePath.front = new String[3];
		thirdTheme.mousePath.behind = new String[3];
		thirdTheme.mousePath.left = new String[3];
		thirdTheme.mousePath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			thirdTheme.mousePath.front[i] = "resource/monster/mouse/front/" + (i + 1) + ".png";
			thirdTheme.mousePath.behind[i] = "resource/monster/mouse/behind/" + (i + 1) + ".png";
			thirdTheme.mousePath.left[i] = "resource/monster/mouse/left/" + (i + 1) + ".png";
			thirdTheme.mousePath.right[i] = "resource/monster/mouse/right/" + (i + 1) + ".png";
		}
		// pig:
		thirdTheme.pigPath.front = new String[3];
		thirdTheme.pigPath.behind = new String[3];
		thirdTheme.pigPath.left = new String[3];
		thirdTheme.pigPath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			thirdTheme.pigPath.front[i] = "resource/monster/pig/front/" + (i + 1) + ".png";
			thirdTheme.pigPath.behind[i] = "resource/monster/pig/behind/" + (i + 1) + ".png";
			thirdTheme.pigPath.left[i] = "resource/monster/pig/left/" + (i + 1) + ".png";
			thirdTheme.pigPath.right[i] = "resource/monster/pig/right/" + (i + 1) + ".png";
		}
		// snake blue:
		thirdTheme.snakePath.front = new String[3];
		thirdTheme.snakePath.behind = new String[3];
		thirdTheme.snakePath.left = new String[3];
		thirdTheme.snakePath.right = new String[3];
		for (int i = 0; i < 3; i++) {
			thirdTheme.snakePath.front[i] = "resource/monster/snake/blue/front/" + (i + 1) + ".png";
			thirdTheme.snakePath.behind[i] = "resource/monster/snake/blue/behind/" + (i + 1) + ".png";
			thirdTheme.snakePath.left[i] = "resource/monster/snake/blue/left/" + (i + 1) + ".png";
			thirdTheme.snakePath.right[i] = "resource/monster/snake/blue/right/" + (i + 1) + ".png";
		}

		return thirdTheme;
	}
}
