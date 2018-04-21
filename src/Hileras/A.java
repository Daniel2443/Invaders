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
	
	public void render() {
		int x=120;
		int n=0;
		int m=1020;
		while(game.getBasic().size()<5) {
			if(game.getBasic().size()!=2){
				game.getBasic().add(new Recruit(game,x,n,m));
				x+=150;
				n+=150;
				m+=150;
		}else {
			game.getBasic().add(new Boss(game,x,n,m));
				x+=150;
				n+=150;
				m+=150;}
		
	}

}}
