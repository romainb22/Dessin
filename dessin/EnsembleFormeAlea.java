package dessin;

import java.util.Random;

public class EnsembleFormeAlea extends EnsembleForme {
	private int taille;
	private final int TAILLEMAX = 100;

	public EnsembleFormeAlea(int nbpoly){
		super();
		if (nbpoly>TAILLEMAX) {
			return;
		}
		while (this.taille != nbpoly){
			int i = new Random().nextInt(21) + 2;
			switch (i) {
				case 2:
					this.ajouterForme(new Cercle());
					break;
				case 3:
					Point[] p = new Point[3];
					for (int k=0; k < i; k++) {
						p[k] = new Point();
					}
					this.ajouterForme(new Triangle(p));
					break;
				case 4:
					this.ajouterForme(new Rectangle(new Point(), new Point()));
					break;
				default:
					this.ajouterForme(new Polygone(i));
					break;
			}
			this.taille++;
		}
	}
}
