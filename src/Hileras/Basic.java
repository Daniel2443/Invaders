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
	public void paint() {
		int x=120;
		int n=0;
		int m=1100;
		while(game.getBasic().size()<5) {
			game.getBasic().add(new Recruit(game,x,n,m));
			x+=150;
			n+=150;
			m+=150;
		}
	}
}
