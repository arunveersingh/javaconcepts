package generics;

import java.util.HashSet;
import java.util.Set;

public class Pointer2 {

	public static void main(String[] args) {

		Set set1 = new HashSet<>();
		set1.add(new Pointer1());
		set1.add("test");
		set1.add(1);
		set1.add(2);

		Set set2 = new HashSet<>();
		set2.add(new Pointer1());
		set2.add("test");
		set2.add(1);
		set2.add(2);

		numElementsInCommon(set1, set2);

	}

	/**
	 * Note: When generic {@link Set<E>} is used as an argument it do not allow to
	 * add anything in it to make the Collection type invariant.
	 * 
	 * Compiler has done its job, preventing you from corrupting the collection’s
	 * type invariant, whatever its element type may be. Not only can’t you put any
	 * element (other than null) into a Collection<?>, but you can’t assume anything
	 * about the type of the objects that you get out. Excerpt from Effective Java.
	 * 
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	static int numElementsInCommon(Set<?> s1, Set<?> s2) {
		
		

		// s1.add(new Pointer1());
		int result = 0;
		for (Object o1 : s1)
		//
			
			
			
		{
			s1.remove(o1);
			if (s2.contains(o1)) {
				System.out.println(s2);
				result++;
			}
		}
		return result;
	}

}
