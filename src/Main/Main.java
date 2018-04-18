/**
 * 
 */
package Main;

import Android.Server;

/**
 * @author Daniel Acuña Mora
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main implements Comparable{
	private static int D = 2;
	private static int G = 20;
	private static int h = 2;

	
    public static void main(String[] args) {
    	Thread server = new Server("PROCESO");
    	server.start();
    	System.out.println(D.compareTo(G));
    	System.out.println(D.compareTo(h));

    	
    }

}