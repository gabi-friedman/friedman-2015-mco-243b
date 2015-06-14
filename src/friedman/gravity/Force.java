package friedman.gravity;

public class Force {

	private double x;
	private double y;

	public Force() {
		x = 0;
		y = 0;
	}

	public Force(double x, double y){
		this.x = x;
		this.y = y;
	}

	public void add(Force f) {
		x += f.x;
		y += f.y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

}

