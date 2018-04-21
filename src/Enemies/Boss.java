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
	public Game game;
	int x = 0;
	int y = 50;
	int xa = 3;
	int ya = 1;
	int n, m;
	int health = 3;

	public Boss(Game game,int x,int n,int m) {
			super(game,x,n,m);
			this.x = x;
			this.game = game;
			this.n = n;
			this.m = m;
		}}
//
//	@Override
//	public void move() {
//		if (x + xa < 50 + n) {
//			xa = 3;
//			y += 10;
//		}
//		if (x + xa > 50 + m) {
//			xa = -3;
//			y += 10;
//		}
//		// if(hit()) {
//		// System.out.println("Pegó");
//		// }
//
//		x = x + xa;
//	}
//
//	public void paint(Graphics2D g) {
//		g.setColor(Color.BLUE);
//		g.fillRect(this.x, y, 50, 50);
//
//	}
//
//	// public boolean hit() {
//	// return
//	//
//	// }
//	public Rectangle getBounds() {
//		return new Rectangle(x, y, 50, 50);
//	}
//
////	public void mori() {
////		System.out.println("Morí");
////		game.getBasic().remove(this);
////	}
////
////	public void bajarvida() {
////			this.health -= 1;
////			System.out.println(this.health);
////			if(this.health==0) {
////				mori();
////			}
////			
////		}}
