package Enemies;
/**
 * 
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import UI.Game;
import UI.Image;

/**
 * @author Daniel Acuña Mora
 *
 */
public class Boss extends Recruit {
	private Image imga = new Image();
	private Game game;
	BufferedImage img = imga.image("boss");
	public Boss(Game game, int x, int n, int m,int id) {
		super(game, x, n, m,id);
		super.health = 5;
		this.x = x;
		this.game = game;
		this.n = n;
		this.m = m;
		this.Id = id;
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
		if (game.generated == 1) {
			if(game.getBasic().size()>=2) {
				game.setScore(4);
				//game.reArrange();

			}else {
				game.setScore(2);
				//game.reArrange();

			}
			game.getBasic().clear();

		} else if (game.generated == 2) {
			game.getDouble().remove(this);
			//game.reArrange();

		}
		game.reArrange();

	}

	/**
	 * El metodo que pinta, no se usa el heredado, por errores no econtrados aun.
	 * 
	 * @param g
	 */
	public void paint(Graphics2D g) {
		g.drawImage(img,x, y-10, 156, 144, game);
//		g.setColor(Color.RED);
//		g.fillRect(this.x, y - 20, 70, 70);

	}

	/**
	 * Genera un rectangulo, el cual será usado para determinar si dos cuadrados se
	 * han intersecado.
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y,120, 20);
	}

}
