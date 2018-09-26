package generics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pointer3 {

	public static void main(String[] args) {

		Set<?> o = new HashSet<>();
		if (o instanceof Set) {
			Set<?> obj = o;
			System.out.println(obj);
		}

		List<String>[] arrayOfListOfTypeString = new List[] { new ArrayList<String>(), new ArrayList<Integer>() };

		// Important Note: Cannot create a generic array of List<String>
		// Reason: The second major difference between arrays and generics is that
		// arrays are reified [JLS, 4.7]. This means that arrays know and enforce their
		// element type at runtime. As noted earlier, if you try to put a String into an
		// array of Long, you’ll get an ArrayStoreException. Generics, by contrast, are
		// implemented by erasure [JLS, 4.6]. This means that they enforce their type
		// constraints only at compile time and discard (or erase) their element type
		// information at runtime. Excerpt from book - Effective Java by by Joshua Bloch
		
		// List<String>[] arrayOfListOfTypeStringX = new List<String>[] {new
		// ArrayList<String>(), new ArrayList<Integer>()};
		
		
		// :) :) Array of List of unbounded wildcard types is allowed.
		List<?>[] arrayOfListOfTypeStringY = new List<?>[] {new
				ArrayList<String>(), new ArrayList<Integer>()};

		test(arrayOfListOfTypeString);

	}

	public <T> T[] toArray(T[] a) {

		String[] ax = new String[10];
		List<? extends Object>[] list = new List[10];

		Set<String> sets = new HashSet<>();
		List<String> lists = new ArrayList<>();

		list[0] = new ArrayList<String>();
		list[1] = new ArrayList<Object>();

		int size = 0;
		T[] elements = a;
		if (a.length < size) {

			@SuppressWarnings("unchecked")
			T[] results = (T[]) Arrays.copyOf(elements, size, a.getClass());
			return results;
		}

		System.arraycopy(elements, 0, a, 0, size);

		if (a.length > size)

			a[size] = null;

		return a;

	}

	/**
	 * This method accepts an {@link Array} of {@link List<String>}.
	 * 
	 * @param array
	 */
	static void test(List<String>[] array) {
		System.out.println(array[0]);
		System.out.println(array[1]);
	}
}
