package gameObject;

import system.Couple;
import system.GameConfig;
import system.Theme.ObjectPath;

public class MainCharacter extends GameObject {
	private Couple baseSize = new Couple(1, 2);
	
//	@Override public void setBasePosition(double x, double y) {
//		super.setBasePosition(x, y);
//	}
	
	@Override public void initialize() {
		super.initialize();
		// load graphic:
		this.loadImage(GameConfig.theme.charaterPath);
		this.setPosition(this.positionMap.x, this.positionMap.y);
		this.setSize(GameObject.BASE * baseSize.x, GameObject.BASE * baseSize.y);
		this.setTimeSleep(0.05);
	}
}
