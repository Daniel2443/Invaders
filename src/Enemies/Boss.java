package Enemies;
import java.awt.Color;
import java.awt.Graphics2D;

///**
// * 
// */
//package Objects;
//
//import java.awt.Color;
//import java.awt.Graphics2D;
//import java.awt.Rectangle;
//
import UI.Game;
//
///**
// * @author Daniel Acuña Mora
// *
// */
public class Boss extends Recruit {
	public Boss(Game game,int x,int n,int m) {
			super(game,x,n,m);
			this.x = x;
			this.game = game;
			this.n = n;
			this.m = m;
			this.health = 5;
		}
	@Override
	public void paint(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(this.x, y-10, 70, 70);

	}}


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

//
//	// public boolean hit() {
//	// return
//	//
//	// }
//	public Rectangle getBounds() {
//		return new Rectangle(x, y, 50, 50);
//	}
//
//	public void mori() {
//		System.out.println("Morí");
//		game.getBasic().remove(this);
//		game.getB().remove(this);
//	}
//
//	public void bajarvida() {
//			this.health -= 1;
//			System.out.println(this.health);
//			if(this.health==0) {
//				mori();
//			}
//			
//		}}
