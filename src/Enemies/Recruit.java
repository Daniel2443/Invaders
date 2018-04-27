/**
 * 
 */
package Enemies;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Lists.SimpleList;
import UI.Bala;
import UI.Game;
import UI.Image;

/**
 * @author Daniel Acuña Mora @
 *
 */
public class Recruit {
	public static int ID = 0;

	private Image imgi = new Image();

	public Game game;
	public int x = 0;
	int y = 100;
	int a = game.level;
	int xa = a;
	int ya = 1;
	public int n, m;
	int health = 2;
	BufferedImage img = imgi.image("basic");

	public Recruit(Game game, int x, int n, int m, int id) {
		this.x = x;
		this.game = game;
		this.n = n;
		this.m = m;
		this.xa = xa;
		this.ID= id;
	}

	/**
	 * Este metodo es utilizado para determinar las posiciones y limites de cada
	 * elemento. Por lo tanto debido a un valor de xa se edita el x que es llamado
	 * en paint
	 * 
	 */
	public void setCoordenates(int n, int m,int x) {
		this.x = x;
		this.n = n;
		this.m = m;

	}

	public void move() {
		if (x + xa < 50 + n) {
			xa = a;
			y += 50;
		}
		if (x + xa > 50 + m) {
			xa = -a;
			y += 50;
		}
		// if(hit()) {
		// System.out.println("Pegó");
		// }

		x = x + xa;
	}

	/**
	 * Metodo para pintar en pantalla.
	 * 
	 * @param g
	 */
	public void paint(Graphics2D g) {
		g.drawImage(img, x, y, 117, 108, game);
		// g.setColor(Color.BLUE);
		// g.fillRect(this.x, y, 50, 50);

	}

	/**
	 * Genera un rectangulo, el cual será usado para determinar si dos cuadrados se
	 * han intersecado.
	 * 
	 * @return
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, 95, 115);
	}

	/**
	 * Metodo utilizado para eliminar el objeto de la lista. Se usa el int generated
	 * para identificar que tipo de lista se debe buscar.
	 * 
	 */
	public void die() {
		// System.out.println("Morí");
		game.setScore(1);
		if (game.generated == 1) {
			
			if (this.getId() == 2) {
				game.getBasic().clear();

			} else {
				game.getBasic().remove(this);
			}

		}

		else if (game.generated == 2) {
			game.getDouble().remove(this);
		}
		game.reArrange();

	}

	public int getId() {
		return ID;
	}

	/**
	 * Metodo utilizado para reducir la vida y llamar el metodo die dependiendo del
	 * valor de la vida.
	 */
	public void gethit() {
		this.health -= 1;
		//System.out.println(this.health);
		if (this.health <= 0) {
			die();
		}

	}

}
