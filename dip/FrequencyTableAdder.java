package ie.gmit.dip;

import java.util.HashMap;
import java.util.List;

public class FrequencyTableAdder {

	/*
	 * The method addToMap takes in as parameter a List<String>, and creates a
	 * HashMap with the keys (colours) mapped to their frequency of occurrences
	 * (values).
	*/

	@SuppressWarnings("deprecation")
	public HashMap<String, Integer> addToMap(List<String> coloursList) { // map strings to integers (O(1))
		HashMap<String, Integer> table = new HashMap<String, Integer>();
		for (String colour : coloursList) {
			String lcColour = colour;
			int frequency = 1;

			if (table.containsKey(lcColour)) { // search and see if key exists in map
				frequency = table.get(lcColour); // search and retrieve value associated with key
				frequency++;
			}
			table.put(lcColour, new Integer(frequency)); // add to map
		}

		return table;

	}

}
