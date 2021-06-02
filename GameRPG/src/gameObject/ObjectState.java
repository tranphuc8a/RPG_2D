package gameObject;

public class ObjectState {
	public double heartPoint 	= 1000;
	public double speed			= 0.3 * GameObject.BASE; // pixels per move
			
	public boolean isGoUp 		= false;
	public boolean isGoDown 	= false;
	public boolean isGoLeft		= false;
	public boolean isGoRight	= false;
	
	public boolean isUseKnife	= false;
	public boolean isUseGun		= false;
	
	public boolean isDie		= false;
	
	public int direct			= UP;
	
	public static final int UP			= 1;
	public static final int DOWN		= 2;
	public static final int LEFT		= 3;
	public static final int RIGHT		= 4;
	
	public double maxHP 		= 1000;
	public double minHP			= 0;
	
	public double dame			= 50;
	
	public ObjectState() {
		this(1000);
	}
	public ObjectState(int maxHP) {
		this.maxHP = maxHP;
		this.setHP(maxHP);
	}
	
	public void setHP(double newHP) {
		if (newHP >= maxHP) this.heartPoint = maxHP;
		else if (newHP <= minHP) {
			this.heartPoint = minHP;
			this.isDie = true;
		}
		else this.heartPoint = newHP;
	}
	public void decreaseHP(double delta) {
		this.setHP(this.heartPoint - delta);
	}
	public void increaseHP(double delta) {
		this.setHP(this.heartPoint + delta);
	}
	public void setStandStill() {
		this.isGoDown = false;
		this.isGoUp = false;
		this.isGoLeft = false;
		this.isGoRight = false;
	}
	public boolean isStandStill() {
		return !this.isGoDown && !this.isGoLeft &&
			   !this.isGoUp && !this.isGoRight;
	}
	public boolean isGoCross() {
		if (!this.isGoDown && !this.isGoUp) return false;
		if (!this.isGoLeft && !this.isGoRight) return false;
		return true;
	}
	public void setGo(int direct) {
		this.direct = direct;
		switch (direct) {
		case UP:
			this.isGoUp = true;
			this.isGoDown = false;
			break;
		case DOWN:
			this.isGoUp = false;
			this.isGoDown = true;
			break;
		case LEFT:
			this.isGoLeft = true;
			this.isGoRight = false;
			break;
		case RIGHT:
			this.isGoLeft = false;
			this.isGoRight = true;
			break;
		default:
			break;
		}
	}
}
