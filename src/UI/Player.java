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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

import Enemies.Recruit;
import Lists.SimpleList;

public class Player extends Frame {
	private Image imga = new Image();
	private Game game;
	BufferedImage img = imga.image("1");
	public boolean shoot = true;

	int x;
	int y = 800;
	public static int xa = 0;
	private Graphics2D g;

	ArrayList<Bala> bala;

	public Player(Game game) {
		this.game = game;
		this.x = game.getWidth() / 2;
		bala = new ArrayList<Bala>();
	}

	/**
	 * Este metodo es llamado cuando se presiona alguna de las teclas predefinidas
	 * mas abajo, checkea la posicion del jugador y usa una variable -xa- que
	 * obitene un valor, el cual ser� sumado o restado al x.
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
	 * En este metodo se usa una imagen importada para pintarla en pantalla, con las
	 * cooredenadas en "X" y en "Y".
	 * 
	 * @param g
	 */
	public void paint(Graphics2D g) {
		g.drawImage(img, x, y, 156, 144, game);
		// g.fillRect(x, 800, 60, 60);
		if (!(bala.isEmpty())) {
			for (int i = 0; i < bala.size(); i++) {
				bala.get(i).paint(g);

			}
		}

		if (bala.size() >= 10) {
			bala.remove(1);
		}
		if (hit()) {
			gameOver();

		}

	}

	/**
	 * Muestra un "popup" que dice el puntaje obtenido y al aceptar el cierra el
	 * juego. Deber�a reiniciar el juego, solo que hay errores en el metodo
	 * reiniciar y no se hace bien
	 */
	public void gameOver() {
		Sound.GAME.stop();
		game.ruuning = false;
		game.setFocusable(false);
		JOptionPane.showMessageDialog(this, "Your Score is: " + game.getScore(), "Game Over", JOptionPane.YES_NO_OPTION);
		//game.setFocusable(true);
		//.restart();

	}

	/**
	 * Detecta la colision en entre el jugador y algun otro enemigo.
	 * 
	 */
	public boolean hit() {
		if (!game.getBasic().isEmpty() || !game.getDouble().isEmpty()) {
			for (int i = 0; i < game.getBasic().size(); i++) {
				Recruit temp = game.getBasic().get(i);
				if (temp.getBounds().intersects(getBounds())) {
					temp.gethit();
					return true;
				}
			}
			for (int i = 0; i < game.getDouble().size(); i++) {
				Recruit temp = game.getDouble().get(i);
				if (temp.getBounds().intersects(getBounds())) {
					System.out.println("Peg�");
					temp.gethit();
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * cuando la variable shoot es true y hay menos de 10 balas en la lista, genera
	 * una nueva bala y reproduce un sonido.
	 */
	public void shoot() {
		if (shoot && bala.size() < 10) {
			bala.add(new Bala(game, x));
			shoot = false;
			Sound.SHOOT.play();
		}
	}

	/**
	 * Eventos de las teclas.
	 * 
	 * @param e
	 */
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
		shoot = false;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 150, 150);
	}

}