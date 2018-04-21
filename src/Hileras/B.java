/**
 * 
 */
package Hileras;

import Enemies.Boss;
import Enemies.Recruit;
import UI.Game;

/**
 * @author Daniel Acuña Mora
 *
 */
public class B {
	private Game game;

	public B(Game game) {
		this.game = game;

	}

	public void render() {
		int x = 120;
		int n = 0;
		int m = 1020;
		while (game.getDouble().size() < 5) {
			if (game.getDouble().size() != 3) {
				game.getDouble().add(new Recruit(game, x, n, m));
				x += 150;
				n += 150;
				m += 150;
			} else {
				game.getDouble().add(new Boss(game, x, n, m));
				x += 150;
				n += 150;
				m += 150;
			}

		}
	}
}
