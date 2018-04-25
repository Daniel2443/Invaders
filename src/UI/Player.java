/**
 * 
 */
package UI;

import java.awt.*;
import java.awt.event.*;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;

import javax.imageio.ImageIO;

import Lists.SimpleList;

public class Player extends Frame {

	private Game game;
	BufferedImage img;

	int x;
	int xa = 0;
	private Graphics2D g;

	ArrayList<Bala> bala;

	public Player(Game game) {
		try {
			img = ImageIO.read(new File("C:\\Users\\Danie\\Pictures\\ANDROID//1.png"));
		} catch (IOException ex) {
		}
		this.game = game;
		this.x = game.getWidth() / 2;
		bala = new ArrayList<Bala>();
	}
/**
 * Este metodo es llamado cuando se presiona alguna de las teclas predefinidas
 * mas abajo, checkea la posicion del jugador y usa una variable -xa- que obitene 
 * un valor, el cual será sumado o restado al x. 
 */
	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - 170)
			x = x + xa;
		if (!(bala.isEmpty())) {
			for (int i = 0; i < bala.size(); i++) {
				bala.get(i).move();
			}

		}

	}
/**
 * En este metodo se usa una imagen importada para pintarla en pantalla, con 
 * las cooredenadas en "X" y en "Y".
 * @param g
 */
	public void paint(Graphics2D g) {
		g.drawImage(img,x, 800, 150, 150, game);
		// g.fillRect(x, 800, 60, 60);
		if (!(bala.isEmpty())) {
			for (int i = 0; i < bala.size(); i++) {
				bala.get(i).paint(g);

			}
		}
		
		if (bala.size() >= 10) {
			bala.remove(1);
		}

	}

	public boolean shoot = true;

	public void shoot() {
		if (shoot && bala.size()<10) {
			bala.add(new Bala(game, x));
			shoot = false;
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xa = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			shoot = true;
		}
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -5;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 5;
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			shoot();
	}

	public void moveRight() {
		xa = 5;
	}

	public void moveLeft() {
		xa = -5;
	}

	public void idle() {
		xa = 0;
	}

}