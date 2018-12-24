package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Type Erasure: Java allows Raw Types, e.g. List, so for the backward
 * compatibility (migration compatibility to be exact).
 * {@link ArrayList<Object>} and {@link ArrayList<String>} both are
 * {@link ArrayList} after type erasion. Although {@link ArrayListes}
 * 
 * @author Arunveer Singh
 *
 */
public class Pointer1 {

    public static void main(String[] args) {

	List<Object> objList = new ArrayList<>();
	objList.add(new String());
	objList.add(new ArrayList<Object>());
	test(objList);

	// List<String> objList2 = new ArrayList();
	test(objList);
	test(new ArrayList<String>());

    }

    static void test(List<Object> arrayList) {
	System.out.println("List<Object> arrayList");
    }

    /*
     * static void test(ArrayList<String> arrayList) {
     * 
     * }
     */

    static void test(Object object) {
	System.out.println("Object");

    }

}
