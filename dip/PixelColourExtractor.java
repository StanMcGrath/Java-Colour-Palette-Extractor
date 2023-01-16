package ie.gmit.dip;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class PixelColourExtractor {

	public BufferedImage image;
	public List<String> listOfHexColours;

	public List<String> getPixelColours() {
		listOfHexColours = new ArrayList<String>();
		image = SourceImageReader.getImage();
		int[][] pixels = new int[image.getWidth()][image.getHeight()];
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				pixels[x][y] = image.getRGB(x, y);
				String hex = Integer.toHexString(pixels[x][y] & 0xFFFFFF);
				while (hex.length() < 6) {
					hex = "0" + hex;
				}

				listOfHexColours.add("#" + hex);

			}
		}

		return listOfHexColours;

	}

}
