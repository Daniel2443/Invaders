/**
 * 
 */
package UI;

import java.awt.*;
import java.awt.image.BufferStrategy;

import UI.InvadersGui;

/**
 * @author Daniel Acuña Mora
 *
 */
public class GameStart implements Runnable {
	private InvadersGui gui;
	private Thread thread;
	private boolean running;
	private BufferStrategy buffer;
	private Graphics g;
	

	public void init() {
		gui = new InvadersGui();
	}

	public synchronized void Start() {
		if (running) 
		  return;
		running = true;
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}

	public synchronized void Stop() {
		if(!(running))
			return;
			running = false;

		try {
			thread.join();

		} catch (InterruptedException e) {
			e.printStackTrace();

		}

	}
	public void tick() {
		
	}
	public void render() {

		g.clearRect(0, 0, 1000, 700);
		//draw
		g.fillRect(0, 0, 60, 60);
		
		buffer.show();
		g.dispose();
	}
	public void run() {
		init();
		// TODO Auto-generated method stub

	}

}
