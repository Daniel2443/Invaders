/**
 * 
 */
package Hileras;

import Enemies.*;
import UI.Game;

/**
 * @author Daniel Acuña Mora
 *
 */
public class A {
	private Game game;
	public A(Game game) {
		this.game = game;
	}
	/**
	 * Usando coordenadas y limites, se generan los enemigos dejando un espacio
	 * entre ellos.
	 */
	
	public void render() {
		int x=120;
		int n=0;
		int m=1020;
		int rnd = (int) (Math.random() * 5)+1;
		while(game.getBasic().size()<5) {
			if(game.getBasic().size()+1 !=rnd){
				game.getBasic().add(new Recruit(game,x,n,m,1));
				x+=170;
				n+=170;
				m+=170;
		}else {
			game.getBasic().add(new Boss(game,x,n,m,2));
				x+=170;
				n+=170;
				m+=170;}
		
	}

}}
