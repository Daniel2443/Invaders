/**
 * 
 */
package UI;

import java.awt.Graphics2D;

import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;

import Lists.SimpleList;

public class Player {
	private Game game;

	int x;
	int xa = 0;
	private Graphics2D g;

	ArrayList<Bala> bala;

	public Player(Game game) {
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
		if(bala.size()>=10) {
			bala.remove(1);
		}
	
	}
	public boolean shoot= true;
	public void shoot() {
		if(shoot) {
			bala.add(new Bala(game, x));
			shoot=false;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()== KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT ) {
			xa = 0;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			shoot=true;
		}
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -3;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 3;
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			shoot();
	}
	
	public void moveRight() {
		xa = 3;	}
	
	public void moveLeft() {
		xa = -3;
	}
	
	public void idle() {
		xa = 0;
	}

}