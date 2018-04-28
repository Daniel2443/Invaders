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

	/**
	 * Este metodo es el que inicializa el server, usando el puerto 44444, y
	 * esperando los datos enviados por el cliente
	 */
	public void run() {

		try {
			server = new ServerSocket(44444);

			while (true) {
				// System.out.println("Esperando...");
				cliente = server.accept();
				entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				message = entrada.readLine();
				// System.out.println(message);
				if (message.equals("D")) {
					game.getPlayer().xa = 5;
					;
				} else if (message.equals("I")) {
					game.getPlayer().xa = -5;
				} else if (message.equals("F")) {
					// game.getPlayer().fire = true;
					game.getPlayer().shoot();
					game.getPlayer().shoot = true;
				} else {
					game.getPlayer().xa = 0;

				}
				cliente.close();
			}
		} catch (IOException e) {
			System.out.println("Error");
		}
	}
}
