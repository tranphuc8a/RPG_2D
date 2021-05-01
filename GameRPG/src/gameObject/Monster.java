package gameObject;

import system.myImage;

public class Monster extends GameObject {
	public Monster() {}
	public Monster(double x, double y) {
		this.setRealPosition(x, y);
	}
	public Monster(String imagePath, double x, double y) {
		this.setImage(new myImage(imagePath));
		this.setPosition(x,  y);
	}
	public void loadGraphic() {
		// do nothing
		// must be overrided at subClass
	}
}
