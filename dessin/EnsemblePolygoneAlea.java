package dessin;

public class EnsemblePolygoneAlea extends EnsemblePolygone {

	private Polygone[] ensemble;
	private int taille;
	private final int TAILLEMAX = 100;

	public EnsemblePolygoneAlea(int nbpoly){
		if (nbpoly>TAILLEMAX) {
			return;
		}
		this.taille = 0;
		int i = (int) (Math.random() * (20 - 3));
		this.ensemble = new Polygone[TAILLEMAX];
		while (this.taille != nbpoly){
			switch (i){
				case 3:
					Point[] p = new Point[3];
					for (int k=0; k < i; k++) {
						p[i] = new Point();
					}
					this.ajouterPolygone(new Triangle(p));
					break;
				case 4:
					this.ajouterPolygone(new Rectangle(new Point(), new Point()));
					break;
				default:
					this.ajouterPolygone(new Polygone(i));
					break;
			}
		}
	}

}
