/**
 * 
 */
package UI;

import java.awt.Graphics2D;

import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;

public class Racquet {
	private Game game;

	int x;
	int xa = 0;
	private Graphics2D g;

	ArrayList<Bala> bala;

	public Racquet(Game game) {
		this.game = game;
		this.x = game.getWidth() / 2;
		bala = new ArrayList<Bala>();
	}

	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - 60)
			x = x + xa;
		if (!(bala.isEmpty())) {
			for (int i = 0; i < bala.size(); i++) {
				bala.get(i).move();
			}

		}

	}

	public void paint(Graphics2D g) {
		g.fillRect(x, 550, 60, 60);
		if (!(bala.isEmpty())) {
			for (int i = 0; i < bala.size(); i++) {
				bala.get(i).paint(g);
			
			}
		}
		if(bala.size()>=50) {
			bala.remove(1);
		}
	
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	private void shoot() {
		bala.add(new Bala(game, x));
		System.out.println(bala.size());
		
	}
	

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -10;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 10;
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			shoot();
	}
}