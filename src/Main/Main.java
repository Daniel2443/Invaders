/**
 * 
 */
package Main;

import Android.Server;
import Hileras.B;

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

	
    public static void main(String[] args) {
    	ListaDoble b = new ListaDoble<>();
    	b.add(8);
    	b.add(9);
    	b.add(6);
    	b.add(7);
    	b.add(9);
    	b.add(5);
    	b.printList();
    	
    }

}