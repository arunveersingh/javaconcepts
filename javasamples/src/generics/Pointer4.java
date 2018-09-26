package generics;

import java.util.ArrayList;
import java.util.List;

public class Pointer4 {
	
	// Arrays are covariant and reified; generics are invariant and erased. 

	public static void main(String[] args) {

		
		// Why generic array creation is illegal - won't compile!

		//List<String>[] stringLists = new List<String>[1];  // (1)

		//List<Integer> intList = List.of(42);               // (2)

		//Object[] objects = stringLists;                    // (3)

		//objects[0] = intList;                              // (4)

		//String s = stringLists[0].get(0);                  // (5)
		
		
		
		List<String> ls = new ArrayList<>();
		List[] strLs = new List[1];
		Object[] objArray = strLs;
	}

}
