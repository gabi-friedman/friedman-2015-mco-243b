package friedman.gravity;

import java.awt.geom.Point2D;

public class Body {

	private Point2D.Double position;

	private Force force;

	public Body(){
		position = new Point2D.Double();
		force = new Force();
		position.x = 0;
		position.y = 0;
	}

	public Body(int x, int y){
		position = new Point2D.Double();
		force = new Force();
		position.x = x;
		position.y = y;
	}

	public Force getForce(){
		return force;
	}

	public void update() {
		position.x += force.getX();
		position.y += force.getY();
	}

	public String printPosition(){
		return "(" + position.x + ", " + position.y + ")";
	}

}