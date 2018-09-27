package learningjava8.lambda;

public class Banana {
	
	private String color;
	
	private Double weight;

	public Banana(String color, Double weight) {
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
		return "Banana with color =" + getColor() + ", weight =" + getWeight();
	}
	
	

}
