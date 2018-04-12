/**
 * 
 */
package UI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;

/**
 * @author Daniel Acuña Mora
 *
 */

public class InvadersGui {
	private static final int WIDTH = 1000, HEIGHT = 700;
	private JFrame f;
	private FrameGui fg;
	
	public InvadersGui() {
		
		f = new JFrame("Invaders");
		f.setSize(WIDTH,HEIGHT);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		fg = new FrameGui();
		f.setBackground(new Color(212,154,140));
		f.setLocationRelativeTo(null);
		f.add(fg);
		while(true) {
			fg.move();
			fg.repaint();
		}
	}
	public FrameGui getCanvas() {
		return fg;
	}
	

}
