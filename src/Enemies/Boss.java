package Enemies;
/**
 * 
 */

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import UI.Game;

/**
 * @author Daniel Acu�a Mora
 *
 */
public class Boss extends Recruit {
	public Game game;
	int x = 0;
	int y = 50;
	int xa = 3;
	int ya = 1;
	int n, m;
	int health = 50;

	public Boss(Game game,int x,int n,int m) {
			super(game,x,n,m);
			super.health=5;
			this.x = x;
			this.game = game;
			this.n = n;
			this.m = m;
		}
//
	@Override
	public void move() {
		if (x + xa < 50 + n) {
			xa = 3;
			y += 100;
		}
		if (x + xa > 50 + m) {
			xa = -3;
			y += 100;
		}
		// if(hit()) {
		// System.out.println("Peg�");
		// }

		x = x + xa;
	}
//
	public void paint(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(this.x, y-20, 70, 70);

	}
//
//	// public boolean hit() {
//	// return
//	//
//	// }

	public Rectangle getBounds() {
		return new Rectangle(x, y-20, 70, 70);
	}    
	
//
////	public void mori() {
////		System.out.println("Mor�");
////		game.getBasic().remove(this);
////	}
////
//	public void bajarvida() {
//			this.health -= 1;
//			System.out.println(this.health);
//			if(this.health==0) {
//				mori();
//			}
//			
//		}
}
