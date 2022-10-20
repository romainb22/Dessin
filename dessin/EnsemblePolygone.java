package dessin;

public class EnsemblePolygone {

	private final int TAILLE_MAX = 100;
	private int taille;
	private Polygone ensemble[];

	public EnsemblePolygone() {
		this.taille = 0;
		this.ensemble = new Polygone[TAILLE_MAX];
	}

	public void ajouterPolygone(Polygone pol) {
		if (this.taille >= TAILLE_MAX - 1 || pol == null) {
			return;
		}
		this.ensemble[this.taille-1] = pol;
		this.taille++;
	}

	public double sommePerimetres() {
		double result = 0.0;
		for (int i=0; i < this.taille; i++) {
			result += this.ensemble[i].perimetre();
		}
		return result;
	}

	public void affiche() {
		for (int i=0; i < this.taille; i++) {
			System.out.println(this.ensemble[i].toString());
		}
	}

	public double sommeSurface() {
		double somme = 0.0;
		for (int i=0; i< this.taille; i++){
			if (this.ensemble[i].estConvexe()) {
				somme += this.ensemble[i].surface();
			}
		}
		return somme;
	}
}
