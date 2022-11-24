package dessin;

import java.awt.*;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/* Aggrégation faible */

public class Polygone extends FormeSurface implements Forme, Dessinable {
	public Point[] points;
	private static final AtomicInteger ID_FACTORY = new AtomicInteger();
	private final int ID;

	public Polygone(int nbCotes) {
		ID = ID_FACTORY.getAndIncrement();
		this.points = new Point[nbCotes];
		do {
			for(int i = 0; i < nbCotes; i++) {
				this.points[i] = new Point();
			}
		} while (this.perimetre()<600);
	}

	public Polygone(int nbCotes, Point[] points) {
		ID = ID_FACTORY.getAndIncrement();
		if (nbCotes != points.length) {
			throw new InvalidParameterException("The points numbers is not equal to the sides number");
		}
		this.points = points;
	}

	@Override public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(o == null || getClass() != o.getClass()) {
			return false;
		}
		Polygone polygone = (Polygone) o;
		return points.hashCode() == polygone.points.hashCode();
	}

	@Override public int hashCode() {
		return Arrays.hashCode(points);
	}

	public int nbrCotes() {
		return this.points.length;
	}

	public Point getPoint(int n) {
		if(n >= this.points.length || n < 0) {
			throw new InvalidParameterException("The given index is not valid");
		}
		return this.points[n];
	}

	public void changePoint(int n, Point p) {
		if(n >= nbrCotes() || n < 0 || p == null) {
			throw new InvalidParameterException("Either the point or the index is not correct");
		}
		this.points[n] = p;
	}

	public void changePoint(int n, int x, int y) {
		if (n >= nbrCotes() || n < 0) {
			throw new InvalidParameterException("The given index is not correct");
		}
		points[n].setX(x);
		points[n].setY(y);
	}

	public double perimetre() {
		Point first = points[0];
		double perimetre = 0;
		for (int i=1; i<nbrCotes();i++) {
			perimetre+= points[i].distance(points[i-1]);
		}
		perimetre += first.distance(points[nbrCotes()-1]);
		return perimetre;
	}

	public double surface() {
		double surface = 0.0;
		Point[] p = new Point[3];
		p[0] = points[0];
		if (!this.estConvexe()) {
			return -1.0;
		}
		for (int i = 1; i < this.points.length; i++) {
			p[1]=points[i];
			p[2]=points[i+1];
			Triangle t = new Triangle(p);
			surface += t.surface();
		}
		return surface;
	}

	@Override public String toString() {
		String s = this.getClass().getSimpleName() + "(n°"+ID+")" ;
		for ( int i = 0; i < this.points.length; i ++) {
			s += this.points[i].toString();
		}
		s += " de surface : " + this.surface();
		return s;
	}

	public boolean estConvexe() {
		boolean sam, samOriginal;
		if (this.points[0].signeAngle(this.points[1], this.points[this.points.length-1]) < 0) {
			sam = true;
		} else {
			sam = false;
		}
		samOriginal = sam;
		for(int i=1; i<this.points.length; i++ ){
			if (this.points[i].signeAngle(this.points[(i+1)%this.points.length], this.points[(i-1)%this.points.length]) <= 0 ) {
				sam = true;
			} else {
				sam = false;
			}
			if(sam != samOriginal) {
				break;
			}
		}
		return sam && samOriginal;
	}

	/* On suppose le polygone convexe lors de l'appel de cette méthode */
	public boolean estDedans(Point p) {
		double sommeAngle = 0.0;
		int reste;
		for (int i=0; i<this.points.length; i++) {
			sommeAngle += p.angle(this.points[(i)%this.points.length], this.points[(i+1)%this.points.length]);
			System.out.println(sommeAngle);
		}
		reste = ((int) sommeAngle)%360;
		return reste == 0;
	}

	@Override public boolean plusGrand(Cercle c) {
		return this.surface()>c.surface();
	}

	public boolean plusGrand(Polygone p) {
		return this.surface()>p.surface();
	}

	public void zoom(int zoomX) {}

	public Polygon convertToPolygon() {
		int xPoly[] = new int[this.points.length], yPoly[] = new int[this.points.length], i=0;
		for (Point p: this.points) {
			xPoly[i] = (int) p.getX() + this.WIDTH/2;
			yPoly[i] = (int) p.getY() + this.HEIGHT/2;
			i++;
		}
		return new Polygon(xPoly, yPoly, this.points.length);
	}

	@Override public void seDessiner(Graphics g) {
		g.drawPolygon(this.convertToPolygon());
		g.setColor(Color.BLACK);
		g.drawString(this.toString(), (int) points[0].getX() + this.WIDTH/2, (int) points[0].getY() + this.HEIGHT/2);
	}

	@Override public int compareTo(Forme f) {
		if (this.surface()>f.surface()) {
			return 1;
		}
		if (this.surface()<f.surface()) {
			return -1;
		}
		return 0;
	}
}
