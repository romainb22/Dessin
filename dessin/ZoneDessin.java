package dessin;

import java.awt.*;
import javax.swing.*;

public class ZoneDessin extends JPanel {

	public ZoneDessin() {

	}
	public static void main(String[] arg) {
		JFrame cadre = new JFrame("Dessin de segment");
		ZoneDessin zone = new ZoneDessin();
		zone.setPreferredSize(new Dimension(900, 600));
		cadre.setContentPane(zone);
		cadre.setLocation(400, 300);
		cadre.pack();
		cadre.setVisible(true);
		cadre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
