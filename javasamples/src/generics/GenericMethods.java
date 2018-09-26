package generics;

import java.util.HashSet;
import java.util.Set;

public class GenericMethods {

	static Set<Car> carSetX = new HashSet<>();

	public static void main(String[] args) {

		Set<Car> carSet1 = new HashSet<>();
		Set<Car> carSet2 = new HashSet<>();

		/**
		 * carSet1 and carSet2 are used to infer the type of <E>
		 */
		union(carSet1, carSet2);

		// Way to infer the type in case there is no
		Set<Car> carSetAny = GenericMethods.<Car>anySet();
		System.out.println(carSetAny);

	}

	// This is a non generic method. Uncomment and see the code.
	/*
	 * public static Set union(Set s1, Set s2) { Set result = new HashSet(s1);
	 * result.addAll(s2); return result; }
	 */

	// This is the same method but with generics.
	// Arguments Type is used to infer the type of <E> defined the E used in method
	// signature.
	// This is a static method so class level can't be used for inferencing the
	// right thing. That's why method level inferencing mechanism is required.
	public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
		Set<E> result = new HashSet<>(s1);
		result.addAll(s2);
		return result;
	}

	// Here no arguments are received so how the type of E will be inferred. See the
	// calling code from main method.
	public static <E extends Car> Set<E> anySet() {
		Set<E> result = new HashSet<>();

		return result;
	}

}
