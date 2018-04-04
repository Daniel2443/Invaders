/**
 * 
 */
package Main;
import Objects.*; 
import Lists.*;
import UI.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author Daniel Acuña Mora
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Enemy f = new EnemyFactory().make("boss");
		f.move();
		Enemy f1 = new EnemyFactory().make("basic");
		
		DoubleList<Enemy> lista1 = new DoubleList();
		InvadersGui in = new InvadersGui();
		
		

	

	}

}
