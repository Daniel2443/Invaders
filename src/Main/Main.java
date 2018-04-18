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

public class Main {

    public static void main(String[] args) {
    	Thread server = new Server("PROCESO");
    	server.start();
    }

}