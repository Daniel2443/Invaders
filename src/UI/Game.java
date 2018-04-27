/**
 * 
 */
package UI;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Android.Server;
import Enemies.*;
import Hileras.*;
import Lists.*;

@SuppressWarnings("serial")
public class Game extends JPanel {
	public static final int WIDTH = 1900;
	public static final int HEIGHT = 1000;
	public Graphics2D g;
	private int score = 0;
	public static int level = 1;

	public Functions fn = new Functions();
	private Player player = new Player(this);
	private SimpleList<Recruit> basic = new SimpleList<>();
	private static DoubleList<Recruit> Double = new DoubleList<Recruit>();
	public int generated = 0;

	/**
	 * @return the double
	 */
	public static DoubleList<Recruit> getDouble() {
		return Double;
	}

	public int getScore() {
		return score;
	}

	/**
	 * @param socore,
	 *            the score to set
	 */
	public void setScore(int puntos) {
		this.score += puntos;
	}

	public int getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(int level) {
		this.level += level;
	}

	public Player getPlayer() {
		return this.player;
	}

	public SimpleList<Recruit> getBasic() {
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
		setVisible(true);

	}

	public DoubleList<Integer> index = new DoubleList<Integer>();
	public int counter = 1;

	public void swap() {
		counter++;
		if (counter % 2 == 0) {
			Random random = new Random();
			int select = random.nextInt(index.size() + 1);
			int rnd = index.getNodo(select - 1).getObj();
			getDouble().change(0, rnd);
		}
	}

	public void move() {
		swap();
		player.move();
		if (!(getBasic().isEmpty()) || !(getDouble().isEmpty())) {
			for (int i = 0; i < getBasic().size(); i++) {
				getBasic().get(i).move();
			}
			for (int j = 0; j < getDouble().size(); j++) {
				getDouble().get(j).move();

			}
		} else {
			enemy();
			level++;
		}
	}

	Image imgi = new Image();
	BufferedImage img = imgi.image("bg");

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(img, 0, 0, WIDTH, HEIGHT, this);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Minecraft", Font.BOLD, 30));
		g2d.drawString("Level: " + String.valueOf(getLevel()), 250, 50);
		g2d.drawString("Score: " + String.valueOf(getScore()), 500, 50);
		g2d.drawString("Currente Type: " + getHilera(), 750, 50);
		g2d.drawString("Next Type: " + getNextHilera(), 1250, 50);

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

	public void reArrange() {
		int i = 0;
		int n = 0;
		int m = limits();
		if (getBasic().size() != 0) {
			int xa = getBasic().get(0).x;
			while (i < getBasic().size()) {
				getBasic().get(i).x = xa;
				getBasic().get(i).n = n;
				getBasic().get(i).m = m;
				xa += 170;
				n += 170;
				m += 170;
				i++;
			}

		}
		if (getDouble().size() != 0) {
			int xb = getDouble().get(0).x;
			while (i < getDouble().size()) {
				getDouble().get(i).x = xb;
				getDouble().get(i).n = n;
				getDouble().get(i).m = m;
				xb += 170;
				n += 170;
				m += 170;
				i++;
			}
		}
	}

	public int limits() {
		if (getBasic().size() == 4 | getDouble().size() == 4) {
			return 1170;
		} else if (getBasic().size() == 3 | getDouble().size() == 3) {
			return 1320;
		} else if (getBasic().size() == 2 | getDouble().size() == 2) {
			return 1470;
		} else {
			return 1620;
		}
	}

	/**
	 * @return the width
	 */
	// public String hilera() {
	// if (!getBasic().isEmpty()) {
	// return getBasic().getType();
	// }
	// if (!getDouble().isEmpty()) {
	// return getDouble().getType();
	// }
	// return "No hay nada";
	// }

	public int getWidth() {
		return WIDTH;
	}

	public void restart() {
		if (!getBasic().isEmpty()) {
			getBasic().clear();

		} else if (!getDouble().isEmpty()) {
			getDouble().clear();
		}
		this.level = 0;
		this.score = 0;
		enemy();
		Sound.GAME.loop();

	}

	int n = 3;
	int current;
	int next;

	public String getHilera() {
		switch (current) {
		case 1:
			return "A";
		case 2:
			return "Basic";
		case 3:
			return "B";
		case 4:
			;
			break;
		case 5:
			;
			break;
		}
		return "No hay Hileras";
	}

	public String getNextHilera() {
		switch (next) {
		case 1:
			return "A";
		case 2:
			return "Basic";
		case 3:
			return "B";
		case 4:
			;
			break;
		case 5:
			;
			break;
		}
		return "No hay Hileras";
	}

	public void enemy() {
		current = 3;
		next = (int) (Math.random() * n) + 1;
		switch (current) {
		case 1:
			A a = new A(this);
			a.render();
			generated = 1;
			;
			break;
		case 2:
			Basic ba = new Basic(this);
			ba.paint();
			generated = 1;

			;
			break;
		case 3:
			B b = new B(this);
			b.render();
			generated = 2;
			;
			break;
		case 4:
			;
			break;
		case 5:
			;
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
		Server server = new Server("Proceso", this);
		server.start();

	}

	// public static void main(String[] args) throws InterruptedException {
	// JFrame frame = new JFrame("Invaders ");
	// Game game = new Game();
	// frame.add(game);
	// frame.setSize(WIDTH, HEIGHT);
	// frame.setVisible(true);
	// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// frame.setLocationRelativeTo(null);
	// game.enemy();
	// game.server();
	// while (true) {
	// game.move();
	// game.repaint();
	// Thread.sleep(10);
	// }
	// }
	public void run() {
		JFrame frame = new JFrame("Invaders ");
		frame.add(this);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		enemy();
		server();
		Sound.GAME.loop();
		this.level = 1;

	}
}