package Enemies;
/**
 * 
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import UI.Game;

/**
 * @author Daniel Acuña Mora
 *
 */
public class Boss extends Recruit {

	public Boss(Game game, int x, int n, int m) {
		super(game, x, n, m);
		super.health = 5;
		this.x = x;
		this.game = game;
		this.n = n;
		this.m = m;
	}

	//
	// @Override
	// public void move() {
	// if (x + xa < 50 + n) {
	// xa = 2;
	// y += 100;
	// }
	// if (x + xa > 50 + m) {
	// xa = -2;
	// y += 100;
	// }
	// // if(hit()) {
	// // System.out.println("Pegó");
	// // }
	//
	// x = x + xa;
	// }
	public void die() {
		System.out.println("Morí");
		game.setScore(2);
		if (game.generated == 1) {

			game.getBasic().remove(this);
		} else if (game.generated == 2) {
			game.getDouble().remove(this);
		}
	}

	/**
	 * El metodo que pinta, no se usa el heredado, por errores no econtrados aun.
	 * 
	 * @param g
	 */
	public void paint(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(this.x, y - 20, 70, 70);

	}

	/**
	 * Genera un rectangulo, el cual será usado para determinar si dos cuadrados se
	 * han intersecado.
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y - 20, 70, 70);
	}

}
