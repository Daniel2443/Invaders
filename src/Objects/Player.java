/**
 * 
 */
package Objects;

/**
 * @author Daniel Acuña Mora
 *
 */
import java.awt.*;
import java.awt.event.KeyListener;

import UI.FrameGui;
public class Player {
	private int x = 150;
	private int y = 350;
	
	private FrameGui gui;
	
	public Player(FrameGui game) {
		this.gui = game;
	}
	public void paint(Graphics2D g) {
		g.fillRect(x, y, 50, 50);
		g.setColor(Color.RED);
	}

}
