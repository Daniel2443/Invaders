/**
 * 
 */
package UI;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
	private int score=0;
	public static int level=1;
	
	public Functions fn = new Functions();
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
	public int getScore() {
		return score;
	}
	/**
	 * @param socore, the score to set
	 */
	public void setScore(int puntos) {
		this.score+=puntos;
	}

	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level +=level;
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

	public void move(){
		player.move();
		if (!(getBasic().isEmpty())||!(getDouble().isEmpty())) {
			for (int i = 0; i < getBasic().size(); i++) {
				getBasic().get(i).move();		}					
			for (int j = 0; j < getDouble().size(); j++) {
				getDouble().get(j).move();
			
			}
		}else {
			enemy();
			level++;
		}
	}
	BufferedImage img;

	@Override
	public void paint(Graphics g) {
		JPanel p = new JPanel();

		try {
			img = ImageIO.read(new File("C:\\Users\\Danie\\Pictures\\ANDROID//bg.png"));

		}catch(IOException ex) {
		}
		
		super.paint(g);
		
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, 0, 0,WIDTH,HEIGHT, this);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		player.paint(g2d);
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("Minecraft", Font.BOLD, 30));
		g2d.drawString("Nivel: "+String.valueOf(getLevel()), 250, 50);

		g2d.drawString("Puntos: "+String.valueOf(getScore()), 500, 50);
		
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
	
//	public static void main(String[] args) throws InterruptedException {
//		JFrame frame = new JFrame("Invaders ");
//		Game game = new Game();
//		frame.add(game);
//		frame.setSize(WIDTH, HEIGHT);
//		frame.setVisible(true);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setLocationRelativeTo(null);
//		game.enemy();
//		game.server();
//		while (true) {
//			game.move();
//			game.repaint();
//			Thread.sleep(10);
//		}
//	}
	public void run(){
		JFrame frame = new JFrame("Invaders ");
		frame.add(this);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		enemy();
		server();
		this.level =1;

	}
}