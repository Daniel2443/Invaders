/**
 * 
 */
package UI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Daniel Acuña Mora
 *
 */
public class Image {
	BufferedImage img;

	public BufferedImage image(String name) {
		try {
			img = ImageIO.read(this.getClass().getResource("/media/"+name+".png"));
		} catch (IOException ex) {
		}
		return img;
	}
}
