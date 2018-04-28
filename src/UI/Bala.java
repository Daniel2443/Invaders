/**
 * 
 */
package UI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Enemies.*;

/**
 * @author Daniel Acu�a Mora
 *
 */
public class Bala {
	private Graphics2D g;
	private Game game;
	private int x, y;

	public Bala(Game game, int x) {
		this.game = game;
		this.x = x + 65;
		this.y = 800;

	}

	public void paint(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 15, 30);

	}

	/**
	 * Se encarga de mover la bala, y al llegar al limite de arriba, se elimina de
	 * la lista para hacerla m�s eficiente.
	 */
	public void move() {
		y -= 15;
		// if(hit()) {
		//
		// }
		if (hit()) {
			game.getPlayer().bala.remove(this);
		}
		if (y <= 0) {
			game.getPlayer().bala.remove(this);
		}

	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 15, 30);
	}

	/**
	 * Este metodo es utilizado para detectar si los limites obtenidos por getbounds
	 * de cada elemento interseca por el getbounds de esta clase, retorna true o
	 * false dependiento si colisionan o no.
	 * 
	 * Si la lista no est� vac�a procede a ejecutar el c�digo.
	 * 
	 * @return
	 */
	public boolean hit() {
		if (!game.getBasic().isEmpty() || !game.getDouble().isEmpty()) {
			for (int i = 0; i < game.getBasic().size(); i++) {
				Recruit temp = game.getBasic().get(i);
				if (temp.getBounds().intersects(getBounds())) {
					temp.gethit();
					return true;
				}
			}
			for (int i = 0; i < game.getDouble().size(); i++) {
				Recruit temp = game.getDouble().get(i);
				if (temp.getBounds().intersects(getBounds())) {
					// System.out.println("Peg�");
					temp.gethit();
					return true;
				}
			}
		}
		return false;
	}

}
