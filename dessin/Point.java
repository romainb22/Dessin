package dessin;

import java.util.concurrent.ThreadLocalRandom;

public class Point {

	private double x;
	private double y;
	private final int SAM = -1;
	private final int ALIGNES = 0;
	private final int SIAM = 1;

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public String afficherCoord() {
		return "x: " + getX() + ", y: " + getY();
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point() {
		this(ThreadLocalRandom.current().nextDouble(300), ThreadLocalRandom.current().nextDouble(300));
	}

	public double distance(Point p) {
		if( p == null) {
			return -1.0;
		}
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));

	}

	public double distance() {
		return this.distance(new Point(0.0,0.0));
	}

	@Override public String toString() {
		return "< " + this.getX() + "> <" + this.getY() + " >";
	}

	public double produitScalaire(Point b, Point c) {
		return 0.5 * (Math.pow(this.distance(b), 2) + Math.pow(this.distance(c), 2) - Math.pow(b.distance(c), 2));
	}

	public double angle(Point b, Point c) {
		return Math.acos(produitScalaire(b ,c) / (this.distance(b) * this.distance(c)));
	}

	public double determinant(Point b, Point c) {
		return (b.getX() - this.getX()) * (c.getY() - this.getY()) - (c.getX() - this.getX()) * (b.getY() - this.getY());
	}

	public int signeAngle(Point b, Point c) {
		double angle = this.determinant(b, c);
		System.out.println(angle);
		if ( angle < 0) {
			return SAM;
		}
		if ( angle == 0) {
			return ALIGNES;
		}
		return SIAM;
	}
}
