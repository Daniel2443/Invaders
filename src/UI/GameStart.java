/**
 * 
 */
package UI;

import UI.InvadersGui;

/**
 * @author Daniel Acuña Mora
 *
 */
public class GameStart implements Runnable {
	private InvadersGui gui;
	private Thread thread;
	private boolean running;

	public void init() {
		gui = new InvadersGui();
	}

	public synchronized void Start() {
		if (running) {
			return;
		}
		running = true;
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public synchronized void Stop() {
		if(!running)
			return;
			running = false;

		try {
			thread.join();

		} catch (InterruptedException e) {
			e.printStackTrace();

		}

	}
	public void run() {
		init();
		// TODO Auto-generated method stub

	}

}
