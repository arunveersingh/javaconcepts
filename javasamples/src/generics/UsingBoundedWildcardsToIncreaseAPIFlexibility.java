package generics;

import java.util.ArrayList;

/**
 * 
 * @author arunveersingh9@gmail.com
 *
 */
public class UsingBoundedWildcardsToIncreaseAPIFlexibility {

	public static void main(String[] args) {

		Stack<Number> numbers = new UsingBoundedWildcardsToIncreaseAPIFlexibility().new Stack<>();

		numbers.push(new Number() {

			@Override
			public long longValue() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int intValue() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public float floatValue() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public double doubleValue() {
				// TODO Auto-generated method stub
				return 0;
			}
		});

		numbers.pushAll(new ArrayList<Number>());

		/**
		 * The method pushAll(Iterable<Number>) in the type
		 * UsingBoundedWildcardsToIncreaseAPIFlexibility.Stack<Number> is not applicable
		 * for the arguments (ArrayList<Integer>). It is because new
		 * ArrayList<Integer>() cannot be casted to new ArrayList<Number>()
		 */
		//numbers.pushAll(new ArrayList<Integer>()); // Uncomment to verify the behavior

		StackWithBoundedWildcard<Number> numbersBounded = new UsingBoundedWildcardsToIncreaseAPIFlexibility().new StackWithBoundedWildcard<>();

		numbersBounded.pushAll(new ArrayList<Number>());

		numbersBounded.pushAll(new ArrayList<Integer>());

	}

	class Stack<E> {
		void push(E e) {
			// do something
		}

		void pushAll(Iterable<E> src) {
			// do something
		}
	}

	class StackWithBoundedWildcard<E> {
		void push(E e) {
			// do something
		}

		/**
		 * Usage of bounded wildcard.
		 * @param src
		 */
		void pushAll(Iterable<? extends E> src) {
			// do something
		}

	}

}

class test<E extends Number> {

}
