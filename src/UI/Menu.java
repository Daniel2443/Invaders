/**
 * 
 */
package UI;

import java.awt.Button;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/**
 * @author Daniel Acuña Mora
 *
 */
public class Menu extends JPanel{
	Game game;
	Menu menu = this;

	public Menu(Game game) {
		this.game = game;
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				menu.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				menu.keyPressed(e);
			}
		});
		setFocusable(true);
	}
	/**
	 * @param e
	 */
	protected void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	int WIDTH = 1900;
	int HEIGHT = 1000;
	public void run() {
		JFrame frame = new JFrame("Invaders ");
		frame.add(this);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
 	}
	public void keyTyped(KeyEvent e) {

	}
	public void keyPressed(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			game();
		}
	}
	public void game(){
		game.run();
		this.setFocusable(false);
	}
}
