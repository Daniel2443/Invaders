/**
 * 
 */
package Objects;

import java.awt.*;
import javax.swing.JPanel;

import UI.FrameGui;

/**
 * @author Daniel Acuña Mora
 *
 */
public class Bullet extends JPanel {
	FrameGui f = new FrameGui();
	public boolean fire = false;
	public int x,y;
	public void pintar() {
		if(fire==true) {
			paint(getGraphics());
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.BLACK);
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 50, 50);
		
	}
	
	
}

