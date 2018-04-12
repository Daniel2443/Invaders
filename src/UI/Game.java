/**
 * 
 */
package UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Objects.Basic;

@SuppressWarnings("serial")
public class Game extends JPanel {
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 700;

	public Graphics2D g;

	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	ArrayList<Basic> basic = new ArrayList<Basic>();

	public Game() {

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
	}

	private void move() throws InterruptedException {
		ball.move();
		racquet.move();
		if (!(basic.isEmpty())) {
			for (int i = 0; i < basic.size(); i++) {
				basic.get(i).move();
				
			}
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
		if (!(basic.isEmpty())) {
			for (int i = 0; i < basic.size(); i++) {
				basic.get(i).paint(g2d);
			
			}
		}

	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return WIDTH;
	}

	public void enemy() {
		if (basic.size() < 10)
			basic.add(new Basic(this));
		System.out.println("Basic: " + basic.size());

	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return HEIGHT;
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tennis");
		Game game = new Game();
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		while (true) {
			game.enemy();
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
}