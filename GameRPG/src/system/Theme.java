package system;

import javafx.scene.text.Font;

public class Theme {
	public class ObjectPath{
		public myImage[] front 	= null;
		public myImage[] behind 	= null;
		public myImage[] left 	= null;
		public myImage[] right 	= null;
	}
	
	public myImage buttonPath;
	public myImage backgroundPath;
	public myImage nameFramePath;
	public myImage buttonFramePath;
	public myImage informationPath;
	public myImage tutorialPath;
	public Font nameMenuFont;
	public Font nameButtonFont;
	
	public myImage musicPath;
	public myImage soundPath;
	
	public myImage[] mapImagePath			= {};
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
	public myImage[] hpPath;
	public myImage[] humanHurt;
	public myImage[] monsterHurt;
	public myImage[] monsterBullet;
	
	public static Theme firstTheme = new Theme();
	public static Theme secondTheme = new Theme();
	public static Theme thirdTheme = new Theme();
	
	public static void setData() {
		FIRST_THEME();
		SECOND_THEME();
		THIRD_THEME();
	}
	
	public static Theme FIRST_THEME() {
		firstTheme.buttonPath 		= new myImage("resource/frame/button2.png");
		firstTheme.backgroundPath 	= new myImage("resource/background/beauty2.jpg");
		firstTheme.buttonFramePath 	= new myImage("resource/frame/buttonFrame.png");
		firstTheme.nameFramePath 	= new myImage("resource/frame/text.png");
		firstTheme.informationPath 	= new myImage("resource/symbol/infor.png");
		firstTheme.tutorialPath 		= new myImage("resource/symbol/help.png");
		firstTheme.musicPath 			= new myImage("resource/deche.mp3");
		firstTheme.soundPath 			= new myImage("resource/deche.mp3");
		firstTheme.nameMenuFont 		= new Font("Consolas", 40);
		firstTheme.nameButtonFont 	= new Font("Times New Roman", 20);
		
		// character
		firstTheme.charaterPath.front = new myImage[9];
		firstTheme.charaterPath.behind = new myImage[9];
		firstTheme.charaterPath.left = new myImage[9];
		firstTheme.charaterPath.right = new myImage[9];
		for (int i = 0; i < 9; i++) {
			firstTheme.charaterPath.front[i] = new myImage("resource/character/man/front/fr" + (i + 1) + "-removebg-preview.png");
			firstTheme.charaterPath.behind[i] = new myImage("resource/character/man/behind/bh" + (i + 1) + "-removebg-preview.png");
			firstTheme.charaterPath.left[i] = new myImage("resource/character/man/left/left" + (i + 1) + "-removebg-preview.png");
			firstTheme.charaterPath.right[i] = new myImage("resource/character/man/right/right" + (i + 1) + "-removebg-preview.png");
		}
		// map
		firstTheme.mapImagePath = new myImage[4];
		firstTheme.mapTextPath = new String[4];
		firstTheme.mapImagePath[1] = new myImage("resource/map/myHao.png");
		firstTheme.mapImagePath[2] = new myImage("resource/map/xuanTruong.png");
		firstTheme.mapImagePath[3] = new myImage("resource/map/tuSon.png");
		firstTheme.mapTextPath[1] = "resource/map/myHao.txt";
		firstTheme.mapTextPath[2] = "resource/map/XuanTruong.txt";
		firstTheme.mapTextPath[3] = "resource/map/tuSon.txt";
		// bullet
		firstTheme.bulletPath.front = new myImage[10];
		firstTheme.bulletPath.behind = new myImage[10];
		firstTheme.bulletPath.left = new myImage[10];
		firstTheme.bulletPath.right = new myImage[10];
		for (int i = 0; i < 10; i++) {
			firstTheme.bulletPath.front[i] = new myImage("resource/bullet/bullet/down/" + (i + 1) + ".png");
			firstTheme.bulletPath.behind[i] = new myImage("resource/bullet/bullet/up/" + (i + 1) + ".png");
			firstTheme.bulletPath.left[i] = new myImage("resource/bullet/bullet/left/" + (i + 1) + ".png");
			firstTheme.bulletPath.right[i] = new myImage("resource/bullet/bullet/right/" + (i + 1) + ".png");
		}
		// HP : blue
		firstTheme.hpPath = new myImage[11];
		for (int i = 0; i < 11; i++) {
			firstTheme.hpPath[i] = new myImage("resource/HP/blue/" + (i + 1) + ".png");
		}
		// knife
		firstTheme.knifePath.front = new myImage[6];
		firstTheme.knifePath.behind = new myImage[6];
		firstTheme.knifePath.left = new myImage[6];
		firstTheme.knifePath.right = new myImage[6];
		for (int i = 0; i < 6; i++) {
			firstTheme.knifePath.front[i] = new myImage("resource/knife/word/front/" + (i + 1) + ".png");
			firstTheme.knifePath.behind[i] = new myImage("resource/knife/word/behind/" + (i + 1) + ".png");
			firstTheme.knifePath.left[i] = new myImage("resource/knife/word/left/" + (i + 1) + ".png");
			firstTheme.knifePath.right[i] = new myImage("resource/knife/word/right/" + (i + 1) + ".png");
		}
		// hurt
		firstTheme.hurtPath.front = new myImage[24];
		firstTheme.hurtPath.behind = new myImage[24];
		firstTheme.hurtPath.left = new myImage[24];
		firstTheme.hurtPath.right = new myImage[24];
		for (int i = 0; i < 24; i++) {
			firstTheme.hurtPath.front[i] = new myImage("resource/knife/hurtAnimation/" + (i + 1) + ".png");
			firstTheme.hurtPath.behind[i] = new myImage("resource/knife/hurtAnimation/" + (i + 1) + ".png");
			firstTheme.hurtPath.left[i] = new myImage("resource/knife/hurtAnimation/" + (i + 1) + ".png");
			firstTheme.hurtPath.right[i] = new myImage("resource/knife/hurtAnimation/" + (i + 1) + ".png");
		}
		firstTheme.humanHurt = new myImage[2];
		firstTheme.humanHurt[0] = new myImage("resource/humanHurt/1.png");
		firstTheme.humanHurt[1] = new myImage("resource/humanHurt/2.png");
		firstTheme.monsterHurt = new myImage[2];
		firstTheme.monsterHurt[0] = new myImage("resource/mosterHurt/1.png");
		firstTheme.monsterHurt[1] = new myImage("resource/mosterHurt/2.png");
		firstTheme.monsterBullet = new myImage[1];
		firstTheme.monsterBullet[0] = new myImage("resource/monsterBullet/1.png");
		// monsters:
		// bat:
		firstTheme.batPath.front = new myImage[3];
		firstTheme.batPath.behind = new myImage[3];
		firstTheme.batPath.left = new myImage[3];
		firstTheme.batPath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			firstTheme.batPath.front[i] = new myImage("resource/monster/bat/front/" + (i + 1) + ".png");
			firstTheme.batPath.behind[i] = new myImage("resource/monster/bat/behind/" + (i + 1) + ".png");
			firstTheme.batPath.left[i] = new myImage("resource/monster/bat/left/" + (i + 1) + ".png");
			firstTheme.batPath.right[i] = new myImage("resource/monster/bat/right/" + (i + 1) + ".png");
		}
		// buffalo:
		firstTheme.buffaloPath.front = new myImage[3];
		firstTheme.buffaloPath.behind = new myImage[3];
		firstTheme.buffaloPath.left = new myImage[3];
		firstTheme.buffaloPath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			firstTheme.buffaloPath.front[i] = new myImage("resource/monster/buffalo/front/" + (i + 1) + ".png");
			firstTheme.buffaloPath.behind[i] = new myImage("resource/monster/buffalo/behind/" + (i + 1) + ".png");
			firstTheme.buffaloPath.left[i] = new myImage("resource/monster/buffalo/left/" + (i + 1) + ".png");
			firstTheme.buffaloPath.right[i] = new myImage("resource/monster/buffalo/right/" + (i + 1) + ".png");
		}
		// fox:
		firstTheme.foxPath.front = new myImage[3];
		firstTheme.foxPath.behind = new myImage[3];
		firstTheme.foxPath.left = new myImage[3];
		firstTheme.foxPath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			firstTheme.foxPath.front[i] = new myImage("resource/monster/fox/front/" + (i + 1) + ".png");
			firstTheme.foxPath.behind[i] = new myImage("resource/monster/fox/behind/" + (i + 1) + ".png");
			firstTheme.foxPath.left[i] = new myImage("resource/monster/fox/left/" + (i + 1) + ".png");
			firstTheme.foxPath.right[i] = new myImage("resource/monster/fox/right/" + (i + 1) + ".png");
		}
		// mouse:
		firstTheme.mousePath.front = new myImage[3];
		firstTheme.mousePath.behind = new myImage[3];
		firstTheme.mousePath.left = new myImage[3];
		firstTheme.mousePath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			firstTheme.mousePath.front[i] = new myImage("resource/monster/mouse/front/" + (i + 1) + ".png");
			firstTheme.mousePath.behind[i] = new myImage("resource/monster/mouse/behind/" + (i + 1) + ".png");
			firstTheme.mousePath.left[i] = new myImage("resource/monster/mouse/left/" + (i + 1) + ".png");
			firstTheme.mousePath.right[i] = new myImage("resource/monster/mouse/right/" + (i + 1) + ".png");
		}
		// pig:
		firstTheme.pigPath.front = new myImage[3];
		firstTheme.pigPath.behind = new myImage[3];
		firstTheme.pigPath.left = new myImage[3];
		firstTheme.pigPath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			firstTheme.pigPath.front[i] = new myImage("resource/monster/pig/front/" + (i + 1) + ".png");
			firstTheme.pigPath.behind[i] = new myImage("resource/monster/pig/behind/" + (i + 1) + ".png");
			firstTheme.pigPath.left[i] = new myImage("resource/monster/pig/left/" + (i + 1) + ".png");
			firstTheme.pigPath.right[i] = new myImage("resource/monster/pig/right/" + (i + 1) + ".png");
		}
		// snake red:
		firstTheme.snakePath.front = new myImage[3];
		firstTheme.snakePath.behind = new myImage[3];
		firstTheme.snakePath.left = new myImage[3];
		firstTheme.snakePath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			firstTheme.snakePath.front[i] = new myImage("resource/monster/snake/red/front/" + (i + 1) + ".png");
			firstTheme.snakePath.behind[i] = new myImage("resource/monster/snake/red/behind/" + (i + 1) + ".png");
			firstTheme.snakePath.left[i] = new myImage("resource/monster/snake/red/left/" + (i + 1) + ".png");
			firstTheme.snakePath.right[i] = new myImage("resource/monster/snake/red/right/" + (i + 1) + ".png");
		}
		return firstTheme;
	}
	public static Theme SECOND_THEME() {
		secondTheme.buttonPath 		= new myImage("resource/frame/button2.png");
		secondTheme.backgroundPath 	= new myImage("resource/background/beauty1.jpg");
		secondTheme.buttonFramePath 	= new myImage("resource/frame/buttonFrame1.jpg");
		secondTheme.nameFramePath 		= new myImage("resource/frame/text.png");
		secondTheme.informationPath 	= new myImage("resource/symbol/infor.png");
		secondTheme.tutorialPath 		= new myImage("resource/symbol/help.png");
		secondTheme.musicPath 			= new myImage("resource/deche.mp3");
		secondTheme.soundPath 			= new myImage("resource/deche.mp3");
		secondTheme.nameMenuFont 		= new Font("Consolas", 40);
		secondTheme.nameButtonFont 	= new Font("Times New Roman", 20);
		
		secondTheme.charaterPath.front = new myImage[9];
		secondTheme.charaterPath.behind = new myImage[9];
		secondTheme.charaterPath.left = new myImage[9];
		secondTheme.charaterPath.right = new myImage[9];
		for (int i = 0; i < 9; i++) {
			secondTheme.charaterPath.front[i] = new myImage("resource/character/woman/front/" + (i + 1) + "-removebg-preview.png");
			secondTheme.charaterPath.behind[i] = new myImage("resource/character/woman/behind/" + (i + 1) + "-removebg-preview.png");
			secondTheme.charaterPath.left[i] = new myImage("resource/character/woman/left/" + (i + 1) + "-removebg-preview.png");
			secondTheme.charaterPath.right[i] = new myImage("resource/character/woman/right/" + (i + 1) + "-removebg-preview.png");
		}
		
		secondTheme.mapImagePath = new myImage[4];
		secondTheme.mapTextPath = new String[4];
		secondTheme.mapImagePath[1] = new myImage("resource/map/myHao.png");
		secondTheme.mapImagePath[2] = new myImage("resource/map/xuanTruong.png");
		secondTheme.mapImagePath[3] = new myImage("resource/map/tuSon.png");		
		secondTheme.mapTextPath[1] = "resource/map/myHao.txt";
		secondTheme.mapTextPath[2] = "resource/map/xuanTruong.txt";
		secondTheme.mapTextPath[3] = "resource/map/tuSon.txt";
		
		secondTheme.bulletPath.front = new myImage[10];
		secondTheme.bulletPath.behind = new myImage[10];
		secondTheme.bulletPath.left = new myImage[10];
		secondTheme.bulletPath.right = new myImage[10];
		for (int i = 0; i < 10; i++) {
			secondTheme.bulletPath.front[i] = new myImage("resource/bullet/bullet/down/" + (i + 1) + ".png");
			secondTheme.bulletPath.behind[i] = new myImage("resource/bullet/bullet/up/" + (i + 1) + ".png");
			secondTheme.bulletPath.left[i] = new myImage("resource/bullet/bullet/left/" + (i + 1) + ".png");
			secondTheme.bulletPath.right[i] = new myImage("resource/bullet/bullet/right/" + (i + 1) + ".png");
		}
		// hp: red
		secondTheme.hpPath = new myImage[6];
		for (int i = 0; i < 6; i++) {
			secondTheme.hpPath[i] = new myImage("resource/HP/red/" + (i + 1) + ".png");
		}
		// knife
		secondTheme.knifePath.front = new myImage[6];
		secondTheme.knifePath.behind = new myImage[6];
		secondTheme.knifePath.left = new myImage[6];
		secondTheme.knifePath.right = new myImage[6];
		for (int i = 0; i < 6; i++) {
			secondTheme.knifePath.front[i] = new myImage("resource/knife/word/front/" + (i + 1) + ".png");
			secondTheme.knifePath.behind[i] = new myImage("resource/knife/word/behind/" + (i + 1) + ".png");
			secondTheme.knifePath.left[i] = new myImage("resource/knife/word/left/" + (i + 1) + ".png");
			secondTheme.knifePath.right[i] = new myImage("resource/knife/word/right/" + (i + 1) + ".png");
		}
		// hurtPath
		// hurt
		secondTheme.hurtPath.front = new myImage[24];
		secondTheme.hurtPath.behind = new myImage[24];
		secondTheme.hurtPath.left = new myImage[24];
		secondTheme.hurtPath.right = new myImage[24];
		for (int i = 0; i < 24; i++) {
			secondTheme.hurtPath.front[i] = new myImage("resource/knife/hurtAnimation/" + (i + 1) + ".png");
			secondTheme.hurtPath.behind[i] = new myImage("resource/knife/hurtAnimation/" + (i + 1) + ".png");
			secondTheme.hurtPath.left[i] = new myImage("resource/knife/hurtAnimation/" + (i + 1) + ".png");
			secondTheme.hurtPath.right[i] = new myImage("resource/knife/hurtAnimation/" + (i + 1) + ".png");
		}
		secondTheme.humanHurt = new myImage[2];
		secondTheme.humanHurt[0] = new myImage("resource/humanHurt/1.png");
		secondTheme.humanHurt[1] = new myImage("resource/humanHurt/2.png");
		secondTheme.monsterHurt = new myImage[2];
		secondTheme.monsterHurt[0] = new myImage("resource/mosterHurt/1.png");
		secondTheme.monsterHurt[1] = new myImage("resource/mosterHurt/2.png");
		secondTheme.monsterBullet = new myImage[1];
		secondTheme.monsterBullet[0] = new myImage("resource/monsterBullet/1.png");
		// monsters:
		// bat:
		secondTheme.batPath.front = new myImage[3];
		secondTheme.batPath.behind = new myImage[3];
		secondTheme.batPath.left = new myImage[3];
		secondTheme.batPath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			secondTheme.batPath.front[i] = new myImage("resource/monster/bat/front/" + (i + 1) + ".png");
			secondTheme.batPath.behind[i] = new myImage("resource/monster/bat/behind/" + (i + 1) + ".png");
			secondTheme.batPath.left[i] = new myImage("resource/monster/bat/left/" + (i + 1) + ".png");
			secondTheme.batPath.right[i] = new myImage("resource/monster/bat/right/" + (i + 1) + ".png");
		}
		// buffalo:
		secondTheme.buffaloPath.front = new myImage[3];
		secondTheme.buffaloPath.behind = new myImage[3];
		secondTheme.buffaloPath.left = new myImage[3];
		secondTheme.buffaloPath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			secondTheme.buffaloPath.front[i] = new myImage("resource/monster/buffalo/front/" + (i + 1) + ".png");
			secondTheme.buffaloPath.behind[i] = new myImage("resource/monster/buffalo/behind/" + (i + 1) + ".png");
			secondTheme.buffaloPath.left[i] = new myImage("resource/monster/buffalo/left/" + (i + 1) + ".png");
			secondTheme.buffaloPath.right[i] = new myImage("resource/monster/buffalo/right/" + (i + 1) + ".png");
		}
		// fox:
		secondTheme.foxPath.front = new myImage[3];
		secondTheme.foxPath.behind = new myImage[3];
		secondTheme.foxPath.left = new myImage[3];
		secondTheme.foxPath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			secondTheme.foxPath.front[i] = new myImage("resource/monster/fox/front/" + (i + 1) + ".png");
			secondTheme.foxPath.behind[i] = new myImage("resource/monster/fox/behind/" + (i + 1) + ".png");
			secondTheme.foxPath.left[i] = new myImage("resource/monster/fox/left/" + (i + 1) + ".png");
			secondTheme.foxPath.right[i] = new myImage("resource/monster/fox/right/" + (i + 1) + ".png");
		}
		// mouse:
		secondTheme.mousePath.front = new myImage[3];
		secondTheme.mousePath.behind = new myImage[3];
		secondTheme.mousePath.left = new myImage[3];
		secondTheme.mousePath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			secondTheme.mousePath.front[i] = new myImage("resource/monster/mouse/front/" + (i + 1) + ".png");
			secondTheme.mousePath.behind[i] = new myImage("resource/monster/mouse/behind/" + (i + 1) + ".png");
			secondTheme.mousePath.left[i] = new myImage("resource/monster/mouse/left/" + (i + 1) + ".png");
			secondTheme.mousePath.right[i] = new myImage("resource/monster/mouse/right/" + (i + 1) + ".png");
		}
		// pig:
		secondTheme.pigPath.front = new myImage[3];
		secondTheme.pigPath.behind = new myImage[3];
		secondTheme.pigPath.left = new myImage[3];
		secondTheme.pigPath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			secondTheme.pigPath.front[i] = new myImage("resource/monster/pig/front/" + (i + 1) + ".png");
			secondTheme.pigPath.behind[i] = new myImage("resource/monster/pig/behind/" + (i + 1) + ".png");
			secondTheme.pigPath.left[i] = new myImage("resource/monster/pig/left/" + (i + 1) + ".png");
			secondTheme.pigPath.right[i] = new myImage("resource/monster/pig/right/" + (i + 1) + ".png");
		}
		// snake yellow:
		secondTheme.snakePath.front = new myImage[3];
		secondTheme.snakePath.behind = new myImage[3];
		secondTheme.snakePath.left = new myImage[3];
		secondTheme.snakePath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			secondTheme.snakePath.front[i] = new myImage("resource/monster/snake/yellow/front/" + (i + 1) + ".png");
			secondTheme.snakePath.behind[i] = new myImage("resource/monster/snake/yellow/behind/" + (i + 1) + ".png");
			secondTheme.snakePath.left[i] = new myImage("resource/monster/snake/yellow/left/" + (i + 1) + ".png");
			secondTheme.snakePath.right[i] = new myImage("resource/monster/snake/yellow/right/" + (i + 1) + ".png");
		}
		
		return secondTheme;
	}
	public static Theme THIRD_THEME() {
		thirdTheme.buttonPath 		= new myImage("resource/frame/button2.png");
		thirdTheme.backgroundPath 	= new myImage("resource/background/mountainWinter.jpg");
		thirdTheme.buttonFramePath 	= new myImage("resource/frame/buttonFrame.png");
		thirdTheme.nameFramePath 		= new myImage("resource/frame/text.png");
		thirdTheme.informationPath 	= new myImage("resource/symbol/infor.png");
		thirdTheme.tutorialPath 		= new myImage("resource/symbol/help.png");
		thirdTheme.musicPath 			= new myImage("resource/deche.mp3");
		thirdTheme.soundPath 			= new myImage("resource/deche.mp3");
		thirdTheme.nameMenuFont 		= new Font("Consolas", 40);
		thirdTheme.nameButtonFont 	= new Font("Times New Roman", 20);
		
		thirdTheme.charaterPath.front = new myImage[9];
		thirdTheme.charaterPath.behind = new myImage[9];
		thirdTheme.charaterPath.left = new myImage[9];
		thirdTheme.charaterPath.right = new myImage[9];
		for (int i = 0; i < 9; i++) {
			thirdTheme.charaterPath.front[i] 	= new myImage("resource/character/man/front/fr" 	+ (i + 1) + "-removebg-preview.png");
			thirdTheme.charaterPath.behind[i] = new myImage("resource/character/man/behind/bh" 	+ (i + 1) + "-removebg-preview.png");
			thirdTheme.charaterPath.left[i] 	= new myImage("resource/character/man/left/left" 	+ (i + 1) + "-removebg-preview.png");
			thirdTheme.charaterPath.right[i] 	= new myImage("resource/character/man/right/right" 	+ (i + 1) + "-removebg-preview.png");
		}
		
		thirdTheme.mapImagePath = new myImage[4];
		thirdTheme.mapTextPath = new String[4];
		thirdTheme.mapImagePath[1] = new myImage("resource/map/myHao.png");
		thirdTheme.mapImagePath[2] = new myImage("resource/map/xuanTruong.png");
		thirdTheme.mapImagePath[3] = new myImage("resource/map/tuSon.png");
		thirdTheme.mapTextPath[1] = "resource/map/myHao.txt";
		thirdTheme.mapTextPath[2] = "resource/map/xuanTruong.txt";
		thirdTheme.mapTextPath[3] = "resource/map/tuSon.txt";
		
		
		thirdTheme.bulletPath.front = new myImage[10];
		thirdTheme.bulletPath.behind = new myImage[10];
		thirdTheme.bulletPath.left = new myImage[10];
		thirdTheme.bulletPath.right = new myImage[10];
		for (int i = 0; i < 10; i++) {
			thirdTheme.bulletPath.front[i] = new myImage("resource/bullet/bullet/down/" + (i + 1) + ".png");
			thirdTheme.bulletPath.behind[i] = new myImage("resource/bullet/bullet/up/" + (i + 1) + ".png");
			thirdTheme.bulletPath.left[i] = new myImage("resource/bullet/bullet/left/" + (i + 1) + ".png");
			thirdTheme.bulletPath.right[i] = new myImage("resource/bullet/bullet/right/" + (i + 1) + ".png");
		}
		// hp: blue
		thirdTheme.hpPath = new myImage[6];
		for (int i = 0; i < 6; i++) {
			thirdTheme.hpPath[i] = new myImage("resource/HP/red/" + (i + 1) + ".png");
		}
		// knife
		thirdTheme.knifePath.front = new myImage[6];
		thirdTheme.knifePath.behind = new myImage[6];
		thirdTheme.knifePath.left = new myImage[6];
		thirdTheme.knifePath.right = new myImage[6];
		for (int i = 0; i < 6; i++) {
			thirdTheme.knifePath.front[i] = new myImage("resource/knife/word/front/" + (i + 1) + ".png");
			thirdTheme.knifePath.behind[i] = new myImage("resource/knife/word/behind/" + (i + 1) + ".png");
			thirdTheme.knifePath.left[i] = new myImage("resource/knife/word/left/" + (i + 1) + ".png");
			thirdTheme.knifePath.right[i] = new myImage("resource/knife/word/right/" + (i + 1) + ".png");
		}
		// hurtPath
		// hurt
		thirdTheme.hurtPath.front = new myImage[24];
		thirdTheme.hurtPath.behind = new myImage[24];
		thirdTheme.hurtPath.left = new myImage[24];
		thirdTheme.hurtPath.right = new myImage[24];
		for (int i = 0; i < 24; i++) {
			thirdTheme.hurtPath.front[i] = new myImage("resource/knife/hurtAnimation/" + (i + 1) + ".png");
			thirdTheme.hurtPath.behind[i] = new myImage("resource/knife/hurtAnimation/" + (i + 1) + ".png");
			thirdTheme.hurtPath.left[i] = new myImage("resource/knife/hurtAnimation/" + (i + 1) + ".png");
			thirdTheme.hurtPath.right[i] = new myImage("resource/knife/hurtAnimation/" + (i + 1) + ".png");
		}
		thirdTheme.humanHurt = new myImage[2];
		thirdTheme.humanHurt[0] = new myImage("resource/humanHurt/1.png");
		thirdTheme.humanHurt[1] = new myImage("resource/humanHurt/2.png");
		thirdTheme.monsterHurt = new myImage[2];
		thirdTheme.monsterHurt[0] = new myImage("resource/mosterHurt/1.png");
		thirdTheme.monsterHurt[1] = new myImage("resource/mosterHurt/2.png");
		thirdTheme.monsterBullet = new myImage[1];
		thirdTheme.monsterBullet[0] = new myImage("resource/monsterBullet/1.png");
		// monsters:
		// bat:
		thirdTheme.batPath.front = new myImage[3];
		thirdTheme.batPath.behind = new myImage[3];
		thirdTheme.batPath.left = new myImage[3];
		thirdTheme.batPath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			thirdTheme.batPath.front[i] = new myImage("resource/monster/bat/front/" + (i + 1) + ".png");
			thirdTheme.batPath.behind[i] = new myImage("resource/monster/bat/behind/" + (i + 1) + ".png");
			thirdTheme.batPath.left[i] = new myImage("resource/monster/bat/left/" + (i + 1) + ".png");
			thirdTheme.batPath.right[i] = new myImage("resource/monster/bat/right/" + (i + 1) + ".png");
		}
		// buffalo:
		thirdTheme.buffaloPath.front = new myImage[3];
		thirdTheme.buffaloPath.behind = new myImage[3];
		thirdTheme.buffaloPath.left = new myImage[3];
		thirdTheme.buffaloPath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			thirdTheme.buffaloPath.front[i] = new myImage("resource/monster/buffalo/front/" + (i + 1) + ".png");
			thirdTheme.buffaloPath.behind[i] = new myImage("resource/monster/buffalo/behind/" + (i + 1) + ".png");
			thirdTheme.buffaloPath.left[i] = new myImage("resource/monster/buffalo/left/" + (i + 1) + ".png");
			thirdTheme.buffaloPath.right[i] = new myImage("resource/monster/buffalo/right/" + (i + 1) + ".png");
		}
		// fox:
		thirdTheme.foxPath.front = new myImage[3];
		thirdTheme.foxPath.behind = new myImage[3];
		thirdTheme.foxPath.left = new myImage[3];
		thirdTheme.foxPath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			thirdTheme.foxPath.front[i] = new myImage("resource/monster/fox/front/" + (i + 1) + ".png");
			thirdTheme.foxPath.behind[i] = new myImage("resource/monster/fox/behind/" + (i + 1) + ".png");
			thirdTheme.foxPath.left[i] = new myImage("resource/monster/fox/left/" + (i + 1) + ".png");
			thirdTheme.foxPath.right[i] = new myImage("resource/monster/fox/right/" + (i + 1) + ".png");
		}
		// mouse:
		thirdTheme.mousePath.front = new myImage[3];
		thirdTheme.mousePath.behind = new myImage[3];
		thirdTheme.mousePath.left = new myImage[3];
		thirdTheme.mousePath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			thirdTheme.mousePath.front[i] = new myImage("resource/monster/mouse/front/" + (i + 1) + ".png");
			thirdTheme.mousePath.behind[i] = new myImage("resource/monster/mouse/behind/" + (i + 1) + ".png");
			thirdTheme.mousePath.left[i] = new myImage("resource/monster/mouse/left/" + (i + 1) + ".png");
			thirdTheme.mousePath.right[i] = new myImage("resource/monster/mouse/right/" + (i + 1) + ".png");
		}
		// pig:
		thirdTheme.pigPath.front = new myImage[3];
		thirdTheme.pigPath.behind = new myImage[3];
		thirdTheme.pigPath.left = new myImage[3];
		thirdTheme.pigPath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			thirdTheme.pigPath.front[i] = new myImage("resource/monster/pig/front/" + (i + 1) + ".png");
			thirdTheme.pigPath.behind[i] = new myImage("resource/monster/pig/behind/" + (i + 1) + ".png");
			thirdTheme.pigPath.left[i] = new myImage("resource/monster/pig/left/" + (i + 1) + ".png");
			thirdTheme.pigPath.right[i] = new myImage("resource/monster/pig/right/" + (i + 1) + ".png");
		}
		// snake blue:
		thirdTheme.snakePath.front = new myImage[3];
		thirdTheme.snakePath.behind = new myImage[3];
		thirdTheme.snakePath.left = new myImage[3];
		thirdTheme.snakePath.right = new myImage[3];
		for (int i = 0; i < 3; i++) {
			thirdTheme.snakePath.front[i] = new myImage("resource/monster/snake/blue/front/" + (i + 1) + ".png");
			thirdTheme.snakePath.behind[i] = new myImage("resource/monster/snake/blue/behind/" + (i + 1) + ".png");
			thirdTheme.snakePath.left[i] = new myImage("resource/monster/snake/blue/left/" + (i + 1) + ".png");
			thirdTheme.snakePath.right[i] = new myImage("resource/monster/snake/blue/right/" + (i + 1) + ".png");
		}

		return thirdTheme;
	}
}
