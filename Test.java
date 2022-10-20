import dessin.EnsemblePolygoneAlea;
import dessin.Point;
import dessin.Polygone;
import dessin.Quadrilatere;
import dessin.Rectangle;
import dessin.Triangle;

/* rendu sous jar source */

public class Test {

	public static void main(String args[]){
		Point p1 = new Point();
		Point p2 = new Point();
		Point p3 = new Point();
		Point p4 = new Point();
		Point p5 = new Point();
		Point p6 = new Point();
		Point p7 = new Point();
		Point p8 = new Point();
		Point p9 = new Point();

		System.out.println("p1: " + p1.afficherCoord());
		System.out.println("p2: " + p2.afficherCoord());
		System.out.println("p3: " + p3.afficherCoord());
		System.out.println("p4: " + p4.afficherCoord());
		System.out.println("p5: " + p5.afficherCoord());
		System.out.println("p6: " + p6.afficherCoord());
		System.out.println("p7: " + p7.afficherCoord());
		System.out.println("p8: " + p8.afficherCoord());
		System.out.println("p9: " + p9.afficherCoord());
		System.out.println("Distance p1-p2 " + p1.distance(p2));
		System.out.println("Distance p3-p4 " + p3.distance(p4));
		System.out.println("Distance p5-p6 " + p5.distance(p6));
		System.out.println("Distance p7-p8 " + p7.distance(p8));
		System.out.println("Distance p9-origine " + p9.distance());
		System.out.println(p1.signeAngle(p2, p3));

		Polygone pol = new Polygone(4);
		pol.estDedans(p1);
		Point[] points = new Point[3];
		for (int i=0; i<3; i++) {
			points[i] = new Point();
		}
		Polygone t = new Triangle(points);
		System.out.println(t.surface());

		/*
			Ici, le triangle t est surclassé en polygone
		 */

		Point[] pointsQ = new Point[4];
		for (int i=0; i<4; i++) {
			pointsQ[i] = new Point();
		}
		Quadrilatere q = new Quadrilatere(pointsQ);
		Rectangle r = new Rectangle(p1, p2);
		System.out.println(r.plusGrand(t));
		/* On appelle bien les surface() de triangle et de rectangle */

		EnsemblePolygoneAlea ens = new EnsemblePolygoneAlea(54);
		ens.affiche();

		/*
		* dessinSRC.jar -> jar source
		* dessinEXEC.jar -> jar executable
		* diagramme de classes
		* */
	}
}
