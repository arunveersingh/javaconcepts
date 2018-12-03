package generics;

import java.util.ArrayList;
import java.util.Collection;

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
		// numbers.pushAll(new ArrayList<Integer>()); // Uncomment to verify the
		// behavior
		
		Collection<Object> objects = new ArrayList<>();
		//numbers.popAll(objects);


		StackWithBoundedWildcard<Number> numbersBounded = new UsingBoundedWildcardsToIncreaseAPIFlexibility().new StackWithBoundedWildcard<>();

		numbersBounded.pushAll(new ArrayList<Number>());

		numbersBounded.pushAll(new ArrayList<Integer>());
		
		
		// This compiles successfully because this constructor accepts ? extends E; Integer extends Number.
		new Chooser<Number>(new ArrayList<Integer>(), false);
				
		// This compiles successfully because this constructor accepts E. E is Number here.
		new Chooser<Number>(new ArrayList<Number>());
				
		// This do not compiles successfully because this constructor accepts E. E is Number here. 
		//ArrayList<Number> is not covariant to ArrayList<Integer>
		//new Chooser<Number>(new ArrayList<Integer>());

	}

	class Stack<E> {
		void push(E e) {
			// do something
		}

		void pushAll(Iterable<E> src) {
			// do something
		}

		void popAll(Collection<E> dst	) {
			while(isEmpty()) {
				dst.add(pop());
			}
		}

		private E pop() {
			// TODO Auto-generated method stub
			return null;
		}

		// Dummy DUMB method :)
		private boolean isEmpty() {
			return true;
		}

	}

	class StackWithBoundedWildcard<E> {
		void push(E e) {
			// do something
		}

		/**
		 * Usage of bounded wildcard.
		 * 
		 * @param src
		 */
		void pushAll(Iterable<? extends E> src) {
			// do something
		}

	}

}

class test<E extends Number> {

}
