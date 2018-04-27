/**
 * 
 */
package UI;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Sound {

		public static final AudioClip GAME = Applet.newAudioClip(Sound.class.getResource("/media/game.wav"));
		public static final AudioClip SHOOT = Applet.newAudioClip(Sound.class.getResource("/media/shoot.wav"));
		
}