package ie.gmit.dip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeSet;

public class SimilarColourRemover {
	
	// threshold of colour similarity
	int threshold;
	
	public void setThreshold(int thresh) {
		threshold = thresh;
	}
	
	// create treeset of all colours
	
	public List<String> createNewColoursListFromMap(List<Entry<String, Integer>> listToCheck) {
	
		List<String> newColoursList = new ArrayList<String>();
		
		for (int i = 0; i < listToCheck.size(); i++) {
		String colour = listToCheck.get(i).getKey();
		newColoursList.add(colour);
		}
		
		return newColoursList;
		
		
	}


public TreeSet<String> createColoursTreeSet(List<Entry<String, Integer>> sortedList) {
		
		TreeSet<String> ColoursTreeSet = new TreeSet<String>();

		return ColoursTreeSet;
	
	}

	// create new list of colours by checking old list against treeset of that old list, and if colours are too similar they are not added to the new list.

public List<String> removeSimilarColours(List<String> list, TreeSet<String> treeSet) {
	
	 List<String> updatedList = new ArrayList<String>();
	    for (String color : list) {
	        boolean isSimilar = false;
	        for (String tColor : treeSet) {
	            if (isTooSimilar(color, tColor)) {
	                isSimilar = true;
	                break;
	            }
	        }
	        if (!isSimilar) {
	            updatedList.add(color);
	            treeSet.add(color);
	        }
	    }
	
	return updatedList;
	
}

private boolean isTooSimilar(String color1, String color2) {
    int r1 = Integer.valueOf( color1.substring( 1, 3 ), 16 );
    int g1 = Integer.valueOf( color1.substring( 3, 5 ), 16 );
    int b1 = Integer.valueOf( color1.substring( 5, 7 ), 16 );
    int r2 = Integer.valueOf( color2.substring( 1, 3 ), 16 );
    int g2 = Integer.valueOf( color2.substring( 3, 5 ), 16 );
    int b2 = Integer.valueOf( color2.substring( 5, 7 ), 16 );
    int diff = (int) Math.sqrt((r1-r2)*(r1-r2) + (g1-g2)*(g1-g2) + (b1-b2)*(b1-b2));
    
	return diff < threshold;
}
	
	
}
