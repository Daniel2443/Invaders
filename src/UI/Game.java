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
import Enemies.*;
import Hileras.*;
import Lists.*;

@SuppressWarnings("serial")
public class Game extends JPanel {
	public static final int WIDTH = 1900;
	public static final int HEIGHT = 700;

	public Graphics2D g;

	private Player player = new Player(this);
	private SimpleList<Recruit> basic = new SimpleList<>();
	private DoubleList<Recruit> Double = new DoubleList<Recruit>();
	public int generated =0;
	
	/**
	 * @return the double
	 */
	public DoubleList<Recruit> getDouble() {
		return Double;
	}
	public Player getPlayer() {
		return this.player;
	} 
 	public SimpleList<Recruit> getBasic(){
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
		if (!(getDouble().isEmpty())) {
			for (int i = 0; i < getDouble().size(); i++) {
				getDouble().get(i).move();
			
			}
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
		if (!(getDouble().isEmpty())) {
			for (int i = 0; i < getDouble().size(); i++) {
				getDouble().get(i).paint(g2d);
			
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
		int n = 3;
		int numero = (int) (Math.random() * n) + 1;
        switch (numero) {
        case 1: A a = new A(this);
				a.render();
				generated=1;;
                 break;
        case 2: Basic ba = new Basic(this);
				ba.paint();
				generated=1;;
                 break;
        case 3: B b = new B(this);
				b.render();
				generated=2; ;
                 break;
        case 4:  ;
                 break;
        case 5:  ;
                 break;
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