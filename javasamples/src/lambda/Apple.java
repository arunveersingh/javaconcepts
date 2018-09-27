package lambda;

public class Apple {
	
	private int weight;
	private String color;
	
	boolean tested;
	
	public Apple(int weight, String color) {
		this.weight = weight;
		this.color = color;
	}
	
	public int getWeight() {
		return weight;
	}
	public String getColor() {
		return color;
	}

	public boolean isTested() {
		return tested;
	}

	public void setTested(boolean tested) {
		this.tested = tested;
	}

	@Override
	public String toString() {
		return "Apple [weight=" + weight + ", color=" + color + ", tested=" + tested + "]";
	}
	
	

}
