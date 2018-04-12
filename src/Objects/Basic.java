/**
 * 
 */
package Objects;

import java.awt.Color;
import java.awt.Graphics2D;

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
	public Basic(Game game) {
		this.game = game;
	}
	@Override
	public void move() {
		if (x + xa < 0)
			xa = 3;
		if (x + xa > game.getWidth() - 30)
			xa = -3;
		

		x = x + xa;
	}
	public void paint(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillOval(x, 50, 30, 30);
		
	}
	

}
