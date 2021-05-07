package gameObject;

import java.util.ArrayList;

import system.GameConfig;

public class Bullet extends Skill{
	private double range = 10 * BASE;
	
	public Bullet() {}
	public Bullet(GameObject parentObject) {
		this.parentObject = parentObject;
	}
	
	@Override public void loadGraphic() {
		super.loadGraphic(GameConfig.theme.bulletPath);
	}
	@Override public void initialize() {
		super.initialize();
		this.setSize(4 * BASE, 4 * BASE);
		this.weightPoint.set(this.getFitWidth()/2, this.getFitHeight()/2);
		this.state.isDie = true;
		this.loadGraphic();
		this.state.speed = BASE;
		this.dame = 5;
	}
	public void refresh() {
		this.front.setCurrentFrame(0);
		this.behind.setCurrentFrame(0);
		this.left.setCurrentFrame(0);
		this.right.setCurrentFrame(0);
	}
	@Override public void update() {
		
		switch (this.state.direct) {
		case ObjectState.UP:
			this.setWeightPoint(this.getWeightPoint().x, 
					this.getWeightPoint().y - this.state.speed);
			if (behind.getCurrentFrame() >= behind.getNumFrame() - 1) {
				this.state.isDie = true;
			}
			break;
		case ObjectState.DOWN:
			this.setWeightPoint(this.getWeightPoint().x, 
					this.getWeightPoint().y + this.state.speed);
			if (front.getCurrentFrame() >= front.getNumFrame() - 1) {
				this.state.isDie = true;
			}
			break;
		case ObjectState.LEFT:
			this.setWeightPoint(this.getWeightPoint().x - this.state.speed, 
					this.getWeightPoint().y);
			if (left.getCurrentFrame() >= left.getNumFrame() - 1) {
				this.state.isDie = true;
			}
			break;
		case ObjectState.RIGHT:
			this.setWeightPoint(this.getWeightPoint().x + this.state.speed, 
					this.getWeightPoint().y);
			if (right.getCurrentFrame() >= right.getNumFrame() - 1) {
				this.state.isDie = true;
			}
			break;
		}
		
		if (this.state.isDie) {
			this.refresh();
			return;
		}
		
		super.update();
		
		ArrayList<Monster> list = parentObject.getGameWorld().getCurrentMap().getMonsters();
		for (int i = 0; i < list.size(); i++) {
			if (this.impact(list.get(i))) {
				list.get(i).getState().decreaseHP(this.dame);
				list.get(i).update();
				list.get(i).lastTimeDizz = System.nanoTime()/1e9;
				this.state.isDie = true;
				this.refresh();
			}
		}
		
	}
	@Override public void update(long currentTime) {
		if (currentTime/1e9 - lastTime >= timeSleep) {
			update();
			
			lastTime = currentTime/1e9;
		}
	}
	
	
	
	public boolean impact(Monster monster) {
		if (monster == null || monster.getState().isDie) return false;
		return this.getWeightPoint().distance(monster.getWeightPoint()) 
					<= Math.sqrt(2) * BASE;
	}
	
	// GETTER AND SETTER
	public double getRange() {
		return range;
	}
	public void setRange(double range) {
		this.range = range;
	}
}
