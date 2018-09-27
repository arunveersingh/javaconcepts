package learningjava8.lambda;

public class Apple {
	
	private String color;
	
	private Double weight;
	
	public Apple() {
		this.color = "Green";
		this.weight = 1.2345;
	}
	
	public Apple(Double weight) {
		this.color = "Green";
		this.weight = weight;
	}

	public Apple(String color, Double weight) {
		super();
		this.color = color;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public Double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Apple with color = " + getColor() + ", weight = " + getWeight();
	}
	
	

}
