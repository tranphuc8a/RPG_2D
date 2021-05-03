package gameObject;

public class ObjectState {
	public double heartPoint 	= 1000;
	public double speed			= 0.3 * GameObject.BASE; // pixels per move
			
	public boolean isGoUp 		= false;
	public boolean isGoDown 	= false;
	public boolean isGoLeft		= false;
	public boolean isGoRight	= false;
	public boolean isGoCross	= false;
	
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
	public void decreaseHP(int delta) {
		this.setHP(this.heartPoint + delta);
	}
	public void increaseHP(int delta) {
		this.setHP(this.heartPoint - delta);
	}
}
