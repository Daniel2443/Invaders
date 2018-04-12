/**
 * 
 */
package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Objects.Bullet;
import Objects.Player;

/**
 *
 */
public class FrameGui extends JPanel implements KeyListener{
	Player p1 = new Player(this);
	
	int px=150,py=400;
	public Graphics g;

	/**
	 * @return the px
	 */
	public int getPx() {
		return px;
	}
	/**
	 * @return the py
	 */
	public int getPy() {
		return py;
	}
	public FrameGui() {
		addKeyListener(this);
		setFocusable(true);
	}
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g1 = (Graphics2D) g;
		p1.paint(g1);
		
	}
	public void move() {
		
		
	}

	public void keyPressed(KeyEvent kp) {
		
		int keyCode = kp.getKeyCode();
		switch (keyCode) {  
		case KeyEvent.VK_A:
			
			break;
		case KeyEvent.VK_D:
			px+=5;
			break;
		case KeyEvent.VK_LEFT:
			px-=5;
			break;
		case KeyEvent.VK_RIGHT:
			px+=5;
			break;
		case KeyEvent.VK_SPACE:
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
