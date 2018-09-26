package exceptions;

public class TestExceptions {

	public static void main(String[] args) {

	}

	/**
	 * Was verifying that if a checked exception is thrown by a method that it need
	 * to be declared as throws.
	 * <p>
	 * But nowadays Runtime exceptions mostly used. Checked exceptions used to break
	 * Open closed Principle. Use Unchecked ExceptionsThe debate is over. For years
	 * Java programmers have debated over the benefits and liabilities of checked
	 * exceptions. When checked exceptions were introduced in the first version of
	 * Java, they seemed like a great idea. The signature of every method would list
	 * all of the exceptions that it could pass to its caller. Moreover, these
	 * exceptions were part of the type of the method. Your code literally wouldn’t
	 * compile if the signature didn’t match what your code could do.
	 * @throws CustomCheckedException
	 */
	void method() throws CustomCheckedException {
		try {
			throw new CustomCheckedException();
		} catch (CustomCheckedException e) {
			// e.printStackTrace();
			throw new CustomCheckedException();
		}
	}

}
