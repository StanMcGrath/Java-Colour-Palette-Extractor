package ie.gmit.dip;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class SourceImageReader {

	private File imageFile;
	private static BufferedImage image;

	public void getFile(String userPath) throws Exception {

		File f = new File(userPath);

		if (f.exists()) {
			imageFile = f;
		} else {
			throw new Exception("[ERROR] Invalid file path...! Please try again with a valid file path!" + userPath);
			
		}
	}

	public void readImage() throws Exception {

		image = ImageIO.read(imageFile);

	}

	public static BufferedImage getImage() {
		return image;
	}

}
