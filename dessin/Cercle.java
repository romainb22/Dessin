package dessin;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Cercle extends FormeSurface implements Forme, Zoomable, Dessinable {

	private Point centre;
	private double rayon;
	private static final AtomicInteger ID_FACTORY = new AtomicInteger();
	private final int ID;

	public Cercle() {
		ID = ID_FACTORY.getAndIncrement();
		this.centre = new Point();
		this.rayon = ThreadLocalRandom.current().nextDouble(150);
	}

	public Cercle(Point p, double r) {
		ID = ID_FACTORY.getAndIncrement();
		this.centre = p;
		this.rayon = r;
	}

	public double perimetre() {
		return 2 * this.rayon * Math.PI;
	}

	public double surface() {
		return Math.PI * this.rayon * this.rayon;
	}

	public boolean estDedans(Point p) {
		return (this.centre.distance(p) <= this.rayon);
	}

	public boolean plusGrand(Cercle c) {
		return (this.surface() >= c.surface());
	}

	@Override public boolean plusGrand(Polygone p) {
		return (this.surface() >= p.surface());
	}

	public void translater(double dx, double dy) {
		this.centre.setX(this.centre.getX()+dx);
		this.centre.setY(this.centre.getY()+dy);
	}

	@Override public String toString() {
		String s = this.getClass().getSimpleName() + "(n°"+ID+")" ;;
		s += this.centre.toString();
		s += " de surface : " + this.surface();
		return s;
	}

	public void zoom(int zoomx) {
		this.rayon = this.rayon * zoomx;
	}

	@Override public void seDessiner(Graphics g) {
		g.drawOval((int) (this.centre.getX() - this.rayon/2 + this.WIDTH/2),
			(int) (this.centre.getY() - this.rayon/2 + this.HEIGHT/2), (int) this.rayon, (int) this.rayon);
		g.setColor(Color.BLACK);
		g.drawString(this.toString(),(int) (this.centre.getX() - this.rayon/2 + this.WIDTH/2),
			(int) (this.centre.getX() - this.rayon/2 + this.HEIGHT/2));
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
