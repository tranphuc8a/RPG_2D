package gameObject;

public class ObjectState {
	public int heartPower 		= 1000;
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
	
	public int maxHP 		= 1000;
	public int minHP		= 0;
	
	public ObjectState() {
		this(1000);
	}
	public ObjectState(int maxHP) {
		this.maxHP = maxHP;
		this.setHP(maxHP);
	}
	
	public void setHP(int newHP) {
		if (newHP >= maxHP) this.heartPower = maxHP;
		else if (newHP <= minHP) this.heartPower = minHP;
		else this.heartPower = newHP;
	}
	public void decreaseHP(int delta) {
		this.setHP(this.heartPower + delta);
	}
	public void increaseHP(int delta) {
		this.setHP(this.heartPower - delta);
	}
}
