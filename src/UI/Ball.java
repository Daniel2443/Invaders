/**
 * 
 */
package UI;
import java.awt.Graphics2D;

public class Ball {
	int x = 0;
	int y = 0;
	int xa = 5;
	int ya = 1;
	private Game game;

	public Ball(Game game) {
		this.game= game;
	}

	void move() {
		if (x + xa < 0)
			xa = 5;
		if (x + xa > game.getWidth() - 30)
			xa = -5;

		x = x + xa;
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, 30, 30);
	}
}
