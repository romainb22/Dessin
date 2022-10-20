package dessin;

import java.security.InvalidParameterException;
import java.util.Arrays;

/* Aggrégation faible */

public class Polygone {

	public Point[] points;

	public Polygone(int nbCotes) {
		this.points = new Point[nbCotes];
		do {
			for(int i = 0; i < nbCotes; i++) {
				this.points[i] = new Point();
			}
		} while (perimetre()<600);
	}

	public Polygone(int nbCotes, Point[] points) {
		if (nbCotes != points.length) {
			throw new InvalidParameterException("The points numbers is not equal to the sides number");
		}
		this.points = points;
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
		String s = this.getClass().getSimpleName();
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
		}
		reste = ((int) sommeAngle)%360;
		return reste == 0;
	}

	public boolean plusGrand(Polygone p) {
		return this.surface()>p.surface();
	}
}
