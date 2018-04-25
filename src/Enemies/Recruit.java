/**
 * 
 */
package Enemies;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import Lists.SimpleList;
import UI.Bala;
import UI.Game;

/**
 * @author Daniel Acuña Mora
 * @
 *
 */
public class Recruit{
	public Game game;
	int x = 0;
	int y = 100;
	int a = game.level;
	int xa = a;
	int ya = 1;
	int n ,m;
	int health = 2;
	public Recruit(Game game,int x,int n,int m) {
		this.x = x;
		this.game = game;
		this.n = n;
		this.m = m;
		this.xa = xa;
	}
	/**
	 * Este metodo es utilizado para determinar las posiciones y limites de
	 * cada elemento. 
	 * Por lo tanto debido a un valor de xa se edita el x que es llamado en paint
	 * 
	 */
	public void move() {
		if (x + xa < 50 + n) {
			xa = a;
			y+=100;
		}
		if (x + xa > 50+m) {
			xa = -a;
			y+=100;
			}
//		if(hit()) {
//			System.out.println("Pegó");
//		}

		x = x + xa;
	}
	/**
	 * Metodo para pintar en pantalla.
	 * @param g
	 */
	public void paint(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(this.x, y, 50, 50);
		
	}
	/**
	 * Genera un rectangulo, el cual será usado para determinar si dos cuadrados 
	 * se han intersecado.
	 * @return
	 */
	public Rectangle getBounds() {
		return new Rectangle(x,y,50,50);
	}
	/**
	 * Metodo utilizado para eliminar el objeto de la lista.
	 * Se usa el int generated para identificar que tipo de lista se debe buscar.
	 * 
	 */
	public void die() {
		//System.out.println("Morí");
		game.setScore(1);
		if(game.generated==1 ) {	

			game.getBasic().remove(this);}
		else if(game.generated==2) {
			game.getDouble().remove(this);}
	}
	/**
	 * Metodo utilizado para reducir la vida y llamar el metodo die 
	 * dependiendo del valor de la vida.
	 */
	public void gethit() {
		this.health -= 1;
		System.out.println(this.health);
		if(this.health<=0) {
			die();
		}
		
	}

}
