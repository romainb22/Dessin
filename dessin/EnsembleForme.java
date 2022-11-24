package dessin;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EnsembleForme {

	private final int TAILLE_MAX = 20;
	private int taille;
	protected Forme ensemble[];

	public EnsembleForme() {
		this.taille = 0;
		this.ensemble = new Polygone[TAILLE_MAX];
	}

	public void ajouterForme(Forme f) {
		if (this.taille >= TAILLE_MAX - 1 || f == null) {
			return;
		}
		this.ensemble[this.taille] = f;
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
			System.out.println("Forme (n°" + (i+1) + ") " + this.ensemble[i].toString());
		}
	}

	public double sommeSurface() {
		double somme = 0.0;
		for (int i=0; i< this.taille; i++){
			if (this.ensemble[i].getClass().getSimpleName() == "Polygone") {
				Polygone p = (Polygone) this.ensemble[i];
				if (p.estConvexe()) {
					somme += this.ensemble[i].surface();
				}
			} else {
				somme += this.ensemble[i].surface();
			}
		}
		return somme;
	}

	public void zoomZoomable(int x) {
		for (int i = 0; i < this.taille; i++) {
			this.ensemble[i].zoom(x);
		}
	}

	public void changeCouleurs(Graphics g) {
		g.setColor(Color.getHSBColor(ThreadLocalRandom.current().nextFloat(), ThreadLocalRandom.current().nextFloat(),
			ThreadLocalRandom.current().nextFloat()));
	}
}
