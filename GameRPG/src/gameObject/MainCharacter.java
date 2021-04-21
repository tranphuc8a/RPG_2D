package gameObject;

import system.Couple;
import system.GameConfig;
import system.Theme.ObjectPath;

public class MainCharacter extends GameObject {
	private Couple baseSize = new Couple(1, 1);
	
	@Override public void setBasePosition(int x, int y) {
		super.setBasePosition(x, y);
		this.setPosition(x * GameObject.BASE, (y - 1) * GameObject.BASE);
	}
	
	@Override public void initialize() {
		super.initialize();
		// load graphic:
		this.loadImage(GameConfig.theme.charaterPath);
		this.setPosition(0, 0);
		this.setSize(GameObject.BASE * baseSize.x, GameObject.BASE * baseSize.y);
		this.setTimeSleep(0.05);
	}
}
