/**
 * 
 */
package Android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.Socket;
import java.nio.Buffer;

/**
 * @author Daniel Acuña Mora
 *
 */
public class Server extends Thread {

	private static ServerSocket server;
	private static Socket cliente;
	private static BufferedReader entrada;
	private static String message;

	public Server(String msg) {
		super(msg);
	}

	public void run() {
		try {
			server = new ServerSocket(44444);
			
			while (true) {
				System.out.println("Esperando...");
				cliente = server.accept();
				entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				message = entrada.readLine();
				System.out.println(message);
				cliente.close();
			}
		} catch (IOException e) {
			System.out.println("sadsd");
		}
	}
}
