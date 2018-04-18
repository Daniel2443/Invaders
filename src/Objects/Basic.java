/**
 * 
 */
package Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import Lists.SimpleList;
import UI.Bala;
import UI.Game;

/**
 * @author Daniel Acuña Mora
 *
 */
public class Basic extends Enemy {
	public Game game;
	int x = 0;
	int y = 50;
	int xa = 5;
	int ya = 1;
	
	public Basic(Game game,int x) {
		this.x = x;
		this.game = game;
	}
	@Override
	public void move() {
		if (x + xa < 0)
			xa = 3;
		if (x + xa > game.getWidth() - 30)
			xa = -3;
//		if(hit()) {
//			System.out.println("Pegó");
//		}

		x = x + xa;
	}
	public void paint(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillOval(this.x, y, 30, 30);
		
	}
//	public boolean hit() {
//		return 
//		
//	}
	public Rectangle getBounds() {
		return new Rectangle(x,y,30,30);
	}
	public void mori() {
		System.out.println("Morí");
		game.getBasic().remove(this);
	}
	

}
