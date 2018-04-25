/**
 * 
 */
package Main;

import Android.Server;
import Hileras.*;
import UI.*;

/**
 * @author Daniel Acuña Mora
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main{

	
    public static void main(String[] args) throws InterruptedException {
    	Game game = new Game();
    	Menu menu = new Menu(game);
    	menu.run();
		while (true) {
			game.move();
			game.repaint();
			Thread.sleep(10);
		}
    	
    	
    }

}