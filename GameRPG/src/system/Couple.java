package system;

public class Couple {
	public double x, y;
	public Couple() {x = y = 0;}
	public Couple(double x, double y)
	{
		this.set(x, y);
	}
	public void set(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public double distance(Couple cp2) {
		return Math.sqrt(Math.pow(x - cp2.x, 2) + Math.pow(y - cp2.y, 2));
	}
	public double module() {
		return Math.sqrt(x * x + y * y);
	}
}
