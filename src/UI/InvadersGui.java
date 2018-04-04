/**
 * 
 */
package UI;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Daniel Acuña Mora
 *
 */

public class InvadersGui extends JPanel {
	private static final int WIDTH = 1000, HEIGHT = 700;
	int x = 150, y = 400;

	public InvadersGui() {
		JFrame f = new JFrame("Invaders");
		f.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		f.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		f.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.add(new FrameGui());
	}

}
