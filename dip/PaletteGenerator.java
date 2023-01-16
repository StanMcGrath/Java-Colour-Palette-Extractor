package ie.gmit.dip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;


public class PaletteGenerator {
	
	private String filePath;
	private String saveFileName;
	
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public void generatePalette(int thresholdChoice) throws Exception {
		
		// call sir class to read image and make list of colours from it.
		
		SourceImageReader sir = new SourceImageReader();
		sir.getFile(filePath);
		sir.readImage();
		PixelColourExtractor pce = new PixelColourExtractor();
		List<String> listOfColours = new ArrayList<String>();
		listOfColours = pce.getPixelColours();
		
		FrequencyTableAdder addToFrequencyTable = new FrequencyTableAdder();
		HashMap<String, Integer> frequencyMap = new HashMap<String, Integer>();
		frequencyMap = addToFrequencyTable.addToMap(listOfColours);
		FrequencyTableSorter sortMap = new FrequencyTableSorter();
		
		ColourPaletteDrawer drawColourPalette = new ColourPaletteDrawer();
		ColourPaletteWriter writeColourPalette = new ColourPaletteWriter();
		
		List<Map.Entry<String,Integer>> sortedList = sortMap.sortFrequencyTable(frequencyMap);
		
		SimilarColourRemover scr = new SimilarColourRemover();
		scr.setThreshold(thresholdChoice);
		
		
		 TreeSet<String> checkTree = scr.createColoursTreeSet(sortedList);
		 List<String> checkList = scr.createNewColoursListFromMap(sortedList);
		 List<String> finalList = scr.removeSimilarColours(checkList, checkTree);
		
		try {
		
			drawColourPalette.drawColourPalette(finalList, saveFileName);
			writeColourPalette.writeColourPalette(finalList, saveFileName);
			
			System.out.println("");
			System.out.println("[SUCCESS!] Colour Palette generated in two files- a .png image and a .txt file.");
			System.out.println("[SUCCESS!] They can be found in the same directory as the .jar file.");
			System.out.println("(e.g. on your desktop if the .jar file was there).");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("");
				System.out.println("Invalid File Path Entered. Please Try Again.");
		}
		
		
	}

	
	

}
