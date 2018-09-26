package javasamples;

import java.lang.reflect.Parameter;
import java.util.HashMap;

/**
 * The Class InputArgumentsModification.
 */
public class InputArgumentsModification {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		HashMap<Integer, String> intStringPair = new HashMap<>();
		updatePair(intStringPair);
		if (intStringPair.size() > 0) {
			System.out.println("Size " + intStringPair.size());
		}

	}

	/**
	 * This method populate input parameter integerStringPairs ({@link HashMap}). 
	 *
	 * @param integerStringPairs
	 *            is a {@link HashMap}
	 *            <p>
	 *            integerStringPairs use {@link Integer} as key and {@link String} as value.
	 */
	private static void updatePair(HashMap<Integer, String> integerStringPairs) {
		integerStringPairs.put(1, "One");
		integerStringPairs.put(2, "Two");
	}

}
