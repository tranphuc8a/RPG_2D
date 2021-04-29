package gameObject;

import system.Couple;
import system.GameConfig;
import system.Theme.ObjectPath;

public class MainCharacter extends GameObject {
//	@Override public void setBasePosition(double x, double y) {
//		super.setBasePosition(x, y);
//	}
	
	@Override public void initialize() {
		super.initialize();
		
		this.size.set(4 * GameObject.BASE, 4 * GameObject.BASE);
		this.weightPoint.set(size.x/2, size.y * 3/4);
		this.setTimeSleep(0.001);
		this.state.speed = 5;
		// load graphic:
		this.loadImage(GameConfig.theme.charaterPath);
		this.setPosition(this.position.x, this.position.y);
		this.setSize(size.x, size.y);
	}
}
