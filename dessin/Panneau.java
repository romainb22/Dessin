package dessin;

import java.awt.*;
import javax.swing.*;

public class Panneau extends JPanel {

	private JPanel panneau;
	private EnsembleFormeAlea ensembleF;

	public Panneau() {
		this.panneau = new JPanel();
		this.panneau.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		this.panneau.paintComponents(null);
		this.ensembleF = new EnsembleFormeAlea(20);
	}

	public void toutDessiner(Graphics g) {
		for(Forme f : this.ensembleF.ensemble) {
			if(f != null) {
				this.ensembleF.changeCouleurs(g);
				f.seDessiner(g);
			}
		}
	}

	@Override protected void paintComponent(Graphics g) {
		g.setColor(Dessinable.COULEUR_DEFAUT);
		toutDessiner(g);
		/* Cercle c = new Cercle(new Point(0.0,0.0), 200);
		c.seDessiner(g);
		Cercle c2 = new Cercle(new Point(400.0,300.0), 100);
		c2.seDessiner(g);

		Polygone pol = new Polygone(4);
		pol.seDessiner(g);

		Point[] points = new Point[3];
		for (int i=0; i<3; i++) {
			points[i] = new Point();
		}
		Polygone t = new Triangle(points);
		t.seDessiner(g);



		Point p1 = new Point(0.0, 0.0);
		Point p2 = new Point(-80.0, 80.0);
		Rectangle r = new Rectangle(p1, p2);
		r.seDessiner(g); */
	}
}
