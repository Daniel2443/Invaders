/**
 * 
 */
package UI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import Enemies.Cadete;
import Enemies.Recruit;
import Lists.SimpleList;

/**
 * @author Daniel Acuña Mora
 *
 */
public class Bala {
	private Graphics2D g;
	private Game game;
	private int x, y;

	public Bala(Game game, int x) {
		this.game = game;
		this.x = x + 15;
		this.y = 600;

	}

	public void paint(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 15, 30);

	}

	public void move() {
		y -= 10;
//		if(hit()) {
//			
//		}
		if(hit()) {
			game.getPlayer().bala.remove(this);
		}
		if(y<=0) {
			game.getPlayer().bala.remove(this);
		}

	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, 15, 30);
	}
	public boolean hit() {
		if(!game.getBasic().isEmpty()) {
			for(int i=0;i<game.getBasic().size();i++) {
				Recruit temp = game.getBasic().get(i);
				if(temp.getBounds().intersects(getBounds())) {
					temp.lowhealth();
					return true;
				}
			}
		}
		return false;
	}

}
