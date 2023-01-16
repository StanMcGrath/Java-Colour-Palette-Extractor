package ie.gmit.dip;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

public class ColourPaletteDrawer {

	public void drawColourPalette(List<String> list, String saveFileName) throws Exception {

		int width = 900;
		int height = 700;

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, width, height);
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("Arial", Font.PLAIN, 20));
		int x = 20;
		int y = 30;

		for (int i = 0; i < list.size(); i++) {

			String colour = list.get(i);

			if (colour.length() < 6) {

				while (colour.length() < 6) {
					colour = "0" + colour;
				}
			}

			if (colour.charAt(0) == '#') {
				colour = colour.substring(1);
			}

			g2d.setColor(Color.decode("#" + colour));
			g2d.fillRect(x, y, 20, 20);
			g2d.drawString(colour, x + 25, y + 15);
			y += 30;

			if (y > height - 30) {
				y = 30;
				x += 150;
			}

		}

		g2d.dispose();

		// Save the image
		ImageIO.write(image, "png", new File(saveFileName + ".png"));

	}
}
