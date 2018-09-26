package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pointer3 {

	public static void main(String[] args) {

		Set<?> o = new HashSet<>();
		//args[0]=1;
		if (o instanceof Set) {
			Set<?> obj = o;
			System.out.println(obj);
		}
		
		test(new List[] {new ArrayList<String>(), new ArrayList<Integer>()});

	}

	public <T> T[] toArray(T[] a) {

		String [] ax = new String[10];
		//ax[1] = 1;

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
	
	
	static void test(List<String>[] array) {
		System.out.println(array[0]);
		System.out.println(array[1]);
	}
}
