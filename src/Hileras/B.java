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
		int id = 1;
//		game.index.add(1, 2);
//		game.index.add(2, 2);
//		game.index.add(3, 2);
//		game.index.add(4, 2);

		/**
		 * Usando coordenadas y limites, se generan los enemigos dejando un espacio
		 * entre ellos.
		 */

		while (game.getDouble().size() < 5) {
			if (game.getDouble().size() + 1 != 3) {
				game.getDouble().add(new Recruit(game, x, n, m, id), id);
				x += 170;
				n += 170;
				m += 170;
				id++;
			} else {
				game.getDouble().add(new Boss(game, x, n, m, 0), 0);
				x += 170;
				n += 170;
				m += 170;
			}

		}
	}
}
