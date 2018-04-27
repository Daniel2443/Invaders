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

    	game.run();
		while (true) {

			game.move();
			game.repaint();
			Thread.sleep(5);
			
		}
//    	
//    	GameWindow gw = new GameWindow();
//    	gw.init();
//    	gw.game.enemy();
//    	while(true) {
//    		gw.game.move();
//    		gw.game.repaint();
//    		
//    	}
    	
    }

}