/**
 * 
 */
package Hileras;

import UI.*;
import Enemies.*;

/**
 * @author Daniel Acuña Mora
 *
 */
public class Basic {
	private Game game;
	
	public Basic(Game game) {
		this.game = game;
	}

	/**
	 * Usando coordenadas y limites, se generan los enemigos dejando un espacio
	 * entre ellos.
	 */
	public void paint() {
		int x=120;
		int n=0;
		int m=1020;
		while(game.getBasic().size()<5) {
			game.getBasic().add(new Recruit(game,x,n,m,1));
			x+=170;
			n+=170;
			m+=170;
		}
	}
}
