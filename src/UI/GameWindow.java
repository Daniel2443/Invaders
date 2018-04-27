/**
 * 
 */
package UI;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/**
 * @author Daniel Acuña Mora
 *
 */
public class GameWindow extends JFrame{
	public Game game;
	private JPanel start,pause;
	
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1900, 1000);
		setTitle("Invaders");
		getContentPane().setLayout(null);
		setSize(1900, 1000);
		setVisible(true);
	
		game = new Game();
		game.setVisible(true);
		getContentPane().add(game);

	
		
//		start = new JPanel();
//		start.setBounds(0, 0, 1900, 1000);
//		start.setVisible(false);
//		JButton btn = new JButton("Hola");
//		start.add(btn);
//		getContentPane().add(start);
//		while(true) {
//			game.move();
//			game.repaint();
//		}
	}

}
