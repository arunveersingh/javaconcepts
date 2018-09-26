package generics;

public class ClothingPair<E extends Sized & Colored> extends Pair<E> {

	public ClothingPair(E left, E right) {
		super(left, right);
	}
	
	/**
	 * See how E extends Sized and Colored.
	 * @return
	 */
	boolean matches() {
		return getLeft().getSize() == getRight().getSize() && getLeft().getColor().equals(getRight().getColor());
	}
	
	/**
	 * See how to write a generic static method.
	 * @param left
	 * @param right
	 * @return
	 */
	static <E extends Sized & Colored> boolean  match(E left, E right) {
		return left.getSize() == right.getSize() && left.getColor().equals(right.getColor());
	}

}
