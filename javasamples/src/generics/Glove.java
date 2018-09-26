package generics;

public class Glove implements Colored, Sized {
	private String color;
	private int size;

	public Glove(String color, int size) {
		this.color = color;
		this.size = size;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public int getSize() {
		return size;
	}

}
