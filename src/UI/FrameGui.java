/**
 * 
 */
package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 */
public class FrameGui extends JPanel implements KeyListener{
	int x=150,y=400;

	public FrameGui() {
		addKeyListener(this);
		setFocusable(true);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.BLACK);
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 50, 50);
		
	}
	public void keyPressed(KeyEvent kp) {
		
		int keyCode = kp.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_A:
			x-=5;
			break;
		case KeyEvent.VK_D:
			x+=5;
			break;
		case KeyEvent.VK_LEFT:
			x-=5;
			break;
		case KeyEvent.VK_RIGHT:
			x+=5;
			break;

		default:
			break;
		}
		repaint();
	}
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
