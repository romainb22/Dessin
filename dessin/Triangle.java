package dessin;

public class Triangle extends Polygone {

	public Triangle(Point[] points) {
		super(3, points);
	}

	public double surface() {
		System.out.println("Calcul de la surface d'un triangle");
		double a, b, c;
		a = this.points[0].distance(this.points[1]);
		b = this.points[0].distance(this.points[2]);
		c = this.points[1].distance(this.points[2]);
		return Math.sqrt(demi_perimetre(a, b, c)*(demi_perimetre(a, b, c) - a)*(demi_perimetre(a, b, c) - b)*
				(demi_perimetre(a, b, c) - c));
	}

	public double demi_perimetre(double a, double b, double c) {
		return (a + b + c)/2;
	}

}
