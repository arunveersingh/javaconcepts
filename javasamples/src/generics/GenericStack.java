package generics;

import java.awt.image.ColorConvertOp;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Intent of this class is to convert {@link NonGenericStack} into a generic
 * class {@link GenericStack}.
 * 
 * @author arunveersingh
 *
 * @param <E>
 */
public class GenericStack<E> {

	private E[] elements;

	private int size = 0;

	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	public GenericStack() {

		// elements = new Object[DEFAULT_INITIAL_CAPACITY]; // Compilation issue
		// elements = new E[DEFAULT_INITIAL_CAPACITY]; // Compilation issue

		// It will compile and it will work, but it gives a warning. Type safety:
		// Unchecked cast from Object[] to E[]
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];

		// Way 2:
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public E pop() {
		if (size == 0)
			throw new EmptyStackException();

		E result = elements[--size];
		elements[size] = null;
		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}

}
