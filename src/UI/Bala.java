/**
 * 
 */
package UI;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * @author Daniel Acuña Mora
 *
 */
public class Bala {
	private Graphics2D g;
	private Game game;
	private int x,y;
	
	public Bala(Game game,int x) {
		this.game = game;
		this.x = x+15;
		this.y = 600;
		
	}
	public void paint(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, 30, 30);
		
	}
	public void move() {
			y-=5;
		
	}

}
