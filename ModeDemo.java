package unl.cse;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Demonstration of using maps and polymorphism to compute the modes of a
 * collection of numbers. The
 * <a href="https://en.wikipedia.org/wiki/Mode_(statistics)">mode</a> is the
 * most common value in the collection. There may be multiple, non-unique modes.
 *
 */
public class ModeDemo {

	/**
	 * This method should return a map of integers x in the given list mapping to
	 * the multiplicity of x (the number of times x appears in the list).
	 * 
	 * @param list
	 * @return
	 */
	public static Map<Integer, Integer> computeMultiplicities(List<Integer> list) {
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		// for each integer x in the list...
		for (Integer x : list) {
			// find the count (the number of times we've seen x already) using the map
			Integer count = counts.get(x);
			if (count == null) {
				// if the key x is not stored in the map (.get() returns null), this is the
				// first time we've seen it, so set count to zero...
				count = 0;
			}
			// and increment it by 1...
			count++;
			// and put it back into the map
			counts.put(x, count);
		}
		return counts;
	}

	/**
	 * This method takes a map (assumed to be a list of integers mapping to their
	 * multiplicity) and returns a set of all modes.
	 * 
	 * For example, a list containing [5, 7, 3, 4, 6, 7, 9, 5] would be 
	 * represented in the map as:
	 * 
	 * 5 => 2 (since 5 appears 2 times)
	 * 7 => 2
	 * 3 => 1
	 * 4 => 1
	 * 6 => 1
	 * 9 => 1
	 * 
	 * And thus, 5 and 7 should be included in the returned set.
	 * 
	 * @param m
	 * @return
	 */
	public static Set<Integer> findModes(Map<Integer, Integer> m) {
		Set<Integer> result = new HashSet<Integer>();
		
		int max = 0;
		Integer count = 0;
		
		for(Map.Entry<Integer, Integer> map : m.entrySet()) {
			
			if(map.getValue() > max) {
				max = map.getValue();
			}
		}
		for(Map.Entry<Integer, Integer> map : m.entrySet()) {
			if(map.getValue() == max) {
				 count = map.getKey();
				 result.add(count);	
			}		
		}
		
		return result;
	}

	/**
	 * Loads a list of integers from a data file.
	 * 
	 * @return
	 */
	public static List<Integer> loadFile() {

		List<Integer> numbers = new ArrayList<Integer>();
		try (Scanner s = new Scanner(new File("data/numbers.dat"))) {
			while (s.hasNext()) {
				numbers.add(s.nextInt());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return numbers;
	}

	/**
	 * Prints the given map of numbers and their multiplicity (the number of times
	 * they appear in a collection) as indicated by the given Map.
	 * 
	 * Demonstrates how to iterate over a map in a sorted manner.
	 * 
	 * @param m
	 */
	public static void printMap(Map<Integer, Integer> m) {
		List<Integer> sortedKeys = new ArrayList<Integer>(m.keySet());
		Collections.sort(sortedKeys);
		for (Integer x : sortedKeys) {
			System.out.println(String.format("%4d appears %4d times", x, m.get(x)));
		}
	}

	public static void main(String args[]) {
		Map<Integer, Integer> m = computeMultiplicities(loadFile());
		printMap(m);
		Set<Integer> modes = findModes(m);
		System.out.println("modes: " + modes);
	}
}
