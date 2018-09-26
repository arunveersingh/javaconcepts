package generics;

public class Pair<E/* extends Sized*/> {
	private E left;
	private E right;
	
	public Pair(E left, E right) {
		super();
		this.left = left;
		this.right = right;
	}

	public E getLeft() {
		return left;
	}

	public E getRight() {
		return right;
	}
	
	/*public boolean matched() {
		return this.left.getSize() == this.right.getSize();
	}*/
}
