package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Intent is to explore how super and extends work & when to use what.
 * 
 * The lesson is clear. For maximum flexibility, use wildcard types on input
 * parameters that represent producers or consumers. If an input parameter is
 * both a producer and a consumer, then wildcard types will do you no good: you
 * need an exact type match, which is what you get without any wildcards. Here
 * is a mnemonic to help you remember which wildcard type to use: PECS stands
 * for producer-extends, consumer-super.
 * 
 * (Page 162). - Excerpt from Effective Java.
 * 
 * @author <a href="mailto:arunveersingh9@gmail.com.com">Arunveer Singh</a>
 *
 */
public class SuperVsExtends {

	public static void main(String[] args) {

		/**
		 * See how extends work
		 */
		List<? extends Number> foo3 = new ArrayList<Number>(); // Number "extends" Number (in this context)
		Number oFoo3N = foo3.get(0);
		// this won't compile, only thing you can be sure is to get a Number out of it,
		// because of ? extends Number
		// Can read a Number because any of the lists that could be assigned to foo3
		// contain a Number or a subclass of Number.
		// Integer oFoo3I =foo3.get(0);

		// Won't compile, can't add a Integer because foo3 could be pointing at a
		// List<Double> :(
		// foo3.add(new Integer(0));
		// Won't compile, can't add a Number because foo3 could be pointing at a
		// List<Double> :(
		/*
		 * foo3.add(new Number() {
		 * 
		 * @Override public long longValue() { // TODO Auto-generated method stub return
		 * 0; }
		 * 
		 * @Override public int intValue() { // TODO Auto-generated method stub return
		 * 0; }
		 * 
		 * @Override public float floatValue() { // TODO Auto-generated method stub
		 * return 0; }
		 * 
		 * @Override public double doubleValue() { // TODO Auto-generated method stub
		 * return 0; } });
		 */

		List<? extends Number> foo31 = new ArrayList<Integer>(); // Integer extends Number
		Number oFoo31N = foo31.get(0);
		// this won't compile, only thing you can be sure is to get a Number out of it,
		// because of ? extends Number. Only thing you can be sure is of getting a
		// Number out of it.
		// Integer oFoo31I = foo31.get(0);

		// Won't compile
		// foo31.add(new Integer(0));

		List<? extends Number> foo32 = new ArrayList<Double>(); // Double extends Number
		Number ofoo32N = foo32.get(0);
		// this won't compile, only thing you can be sure is to get a Number out of it,
		// because of ? extends Number
		// Double ofoo32D = foo32.get(0);

		/**
		 * Now we will see super
		 */

		List<? super Integer> foo33 = new ArrayList<Integer>(); // Integer is a "superclass" of Integer (in this
																// context)

		foo33.add(new Integer(0));

		// won't compile as this can be a list of Integer or Number. And by adding the
		// Number we may break the Type consistency of the list.
		/*
		 * foo33.add(new Number() {
		 * 
		 * @Override public long longValue() { // TODO Auto-generated method stub return
		 * 0; }
		 * 
		 * @Override public int intValue() { // TODO Auto-generated method stub return
		 * 0; }
		 * 
		 * @Override public float floatValue() { // TODO Auto-generated method stub
		 * return 0; }
		 * 
		 * @Override public double doubleValue() { // TODO Auto-generated method stub
		 * return 0; } });
		 */

		List<? super Integer> foo34 = new ArrayList<Number>(); // Number is a superclass of Integer
		foo34.add(new Integer(0));

		List<? super Integer> foo35 = new ArrayList<Object>(); // Object is a superclass of Integer
		// foo35.add(new Object());

	}

	static void acceptExtends(List<? extends Number> foo3) {

	}

	static void acceptSuper(List<? extends Number> foo3) {

	}

}
