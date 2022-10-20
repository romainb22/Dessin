package dessin;

public class Rectangle extends Quadrilatere {

	private Rectangle(Point[] points) {
		super(points);
	}

	public Rectangle(Point p1, Point p2) {
		this(new Point[4]);
		points[0] = p1;
		points[1] = new Point(p1.getY(), p2.getX());
		points[2] = p2;
		points[3] = new Point(p2.getY(), p1.getX());
	}

	public double hauteur() {
		return this.points[0].distance(this.points[3]);
	}

	public double largeur() {
		return this.points[0].distance(this.points[1]);
	}

	public double surface() {
		System.out.println("Calcul de la surface d'un Rectangle");
		return this.hauteur() * this.largeur();
	}
}
