package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

public class ExtendsVsSuperInComparableAndComparator {

	public static void main(String[] args) {

		List<ScheduledFuture<?>> scheduledFutures = new ArrayList<ScheduledFuture<?>>();

		max(scheduledFutures);

		/**
		 * This won't compile.
		 */
		// min(scheduledFutures);

	}

	/**
	 * public static <T extends Comparable<T>> T max(List<T> list) is transformed to
	 * public static <T extends Comparable<? super T>> T max(List<? extends T>
	 * list). Reason: Applying PECS (Producer Extends Consumer Super) heuristics,
	 * list is a producer in this method therefore <code>list</code> {@link List<E>}
	 * is modified to {@link List<? extends T>}. Comparable is a consumer so
	 * {@link Comparable<T>} is modified to {@link Comparable<? super T>}.
	 * 
	 * @param list
	 * @return
	 */
	public static <T extends Comparable<? super T>> T max(List<? extends T> list) {

		return null;

	}

	public static <T extends Comparable<T>> T min(List<T> list) {

		return null;

	}

	/**
	 * if a type parameter appears only once in a method declaration, replace it with a wildcard. - Effective Java (Page 165). 
	 * @param list
	 * @param i
	 * @param j
	 */
	public static void swap(List<?> list, int i, int j) {
		swapHelper(list, i, j);
	}

	// Private helper method for wildcard capture
	private static <E> void swapHelper(List<E> list, int i, int j) {
		list.set(i, list.set(j, list.get(i)));
	}

}
