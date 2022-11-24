package dessin;

import java.awt.*;
import javax.swing.*;

public class DessinFormes {

	private JFrame fenetre;

	public DessinFormes() {
		initialiser();
	}

	public void initialiser() {
		fenetre = new JFrame();
		this.fenetre.setTitle("Dessin de formes géométriques");
		this.fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.fenetre.setSize(Dessinable.WIDTH, Dessinable.HEIGHT);
		this.fenetre.setLocation(100,100);
		this.fenetre.getContentPane().setBackground(Color.gray);
		this.fenetre.setResizable(false);

		Panneau p = new Panneau();

		this.fenetre.add(p);

		this.fenetre.setVisible(true);

	}

	public static void creer() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override public void run() {
				DessinFormes fenetre = new DessinFormes();
			}
		});
	}

}
