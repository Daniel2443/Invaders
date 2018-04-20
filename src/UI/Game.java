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

import Android.Server;
import Enemies.Cadete;
import Lists.SimpleList;

@SuppressWarnings("serial")
public class Game extends JPanel {
	public static final int WIDTH = 1350;
	public static final int HEIGHT = 700;

	public Graphics2D g;

	private Player player = new Player(this);
	private SimpleList<Cadete> basic = new SimpleList<Cadete>();
	public Player getPlayer() {
		return this.player;
	}
 	public SimpleList<Cadete> getBasic(){
 		return this.basic;
 	}
	public Game() {

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				player.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				player.keyPressed(e);
			}
		});
		setFocusable(true);
	}

	private void move() throws InterruptedException {
		player.move();
		if (!(getBasic().isEmpty())) {
			for (int i = 0; i < getBasic().size(); i++) {
				getBasic().get(i).move();							}
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		player.paint(g2d);
		if (!(getBasic().isEmpty())) {
			for (int i = 0; i < getBasic().size(); i++) {
				getBasic().get(i).paint(g2d);
			
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
		int x=80;
		int n=0;
		int m=((getWidth()-x) - getWidth()/2);
		while(getBasic().size()<5) {
			getBasic().add(new Cadete(this,x,n,m));
			x+=150;
			n+=150;
			m+=150;
		}
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return HEIGHT;
	}
	public void server() {
		Server server = new Server("Proceso",this);
		server.start();
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Invaders ");
		Game game = new Game();
		frame.add(game);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		game.enemy();
		game.server();
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
	}
}