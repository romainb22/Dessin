package dessin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DessinFormes {

	protected JFrame fenetre;
	protected JButton bouton;

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
		this.bouton = creerBouton("Arc En Ciel", "Colorie les formes de couleurs aléatoires", p);
		p.add(this.bouton);

		this.fenetre.add(p);

		this.fenetre.setVisible(true);

	}

	private JButton creerBouton(String str1, String str2, Panneau p) {
		JButton bouton = new JButton(str1);
		bouton.setFocusable(false);
		bouton.setPreferredSize(new Dimension(180, 60));
		bouton.setToolTipText(str2);
		bouton.addActionListener(e -> {
			p.remove(p.getPanneau());
			p.revalidate();
			p.repaint();
		});
		return bouton;
	}

	public static void creer() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override public void run() {
				DessinFormes fenetre = new DessinFormes();
			}
		});
	}

}
