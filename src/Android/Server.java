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

import UI.Game;

/**
 * @author Daniel Acuña Mora
 *
 */
public class Server extends Thread {

	private static ServerSocket server;
	private static Socket cliente;
	private static BufferedReader entrada;
	private static String message;
	private Game game;

	public Server(String msg, Game game) {
		super(msg);
		this.game = game;

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
				if (message.equals("D")) {
					game.getPlayer().moveRight();
				} else if (message.equals("I")) {
					game.getPlayer().moveLeft();
				} else {
					game.getPlayer().idle();

				}
				cliente.close();
			}
		} catch (IOException e) {
			System.out.println("sadsd");
		}
	}
}
