package dessin;

import java.awt.*;

public interface Dessinable {

	int WIDTH = 1000;
	int HEIGHT = 800;
	Color COULEUR_DEFAUT = Color.BLUE;
	void seDessiner(Graphics g);

}
