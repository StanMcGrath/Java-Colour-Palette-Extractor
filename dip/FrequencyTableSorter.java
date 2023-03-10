package ie.gmit.dip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

/*
 * The class FrequencyTableSorter sorts a HashMap of Colours mapped to values in descending order by value,
 * by overwriting the inbuilt comparator method. This is done by the sortFrequencyTable method.
 */

public class FrequencyTableSorter {
	
	/*
	 * The method sortFrequencyTable takes in a HashMap as parameter and sorts the HashMap in order
	 * of descending value.
	 */
	
	public List<Entry<String, Integer>> sortFrequencyTable(HashMap<String, Integer> map) {
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		
		List<Entry<String, Integer>> list = new ArrayList<>(entrySet);
		
		Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue())); 
		
		return list;
		
		}

}