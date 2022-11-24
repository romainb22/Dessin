package dessin;

import java.awt.*;

public interface Forme {
	double perimetre();
	double surface();
	boolean estDedans(Point p);
	boolean plusGrand(Cercle c);
	boolean plusGrand(Polygone p);
	void zoom(int zoomX);
	void seDessiner(Graphics g);
}
