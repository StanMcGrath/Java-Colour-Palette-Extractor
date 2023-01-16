package ie.gmit.dip;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class ColourPaletteWriter {

	public void writeColourPalette(List<String> list, String saveFileName) throws Exception {

		FileWriter fw = new FileWriter(saveFileName + ".txt");
		BufferedWriter bw = new BufferedWriter(fw);

		for (int i = 0; i < list.size(); i++) {

			String colour = list.get(i);

			bw.write(colour);
			bw.newLine();

		}

		bw.close();

	}
}